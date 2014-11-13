package Connector;

import Data.Data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Илья Рыжов
 */
public class Connector implements IConnector{

    protected ArrayList<IDataListener> dataListeners;
    protected ArrayList<Data> data;
    private Socket socket=null;
    DataInputStream in;
    DataOutputStream out;
   
    private Connector()
    {
        try {
            data=new ArrayList<>();
            dataListeners=new ArrayList<>();
            socket=new Socket("127.0.0.1", (1254));
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            Thread outTh=new Thread(new OutThread(), "out");
            
            Thread inTh=new Thread(new InThread(), "in");
            outTh.start();
            inTh.start();
        } catch (IOException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static Connector getConnector(){
        return ConnectorHolder.instance;
    }
    
    protected void onNewData(Data data)
    {
        int n=dataListeners.size();
        
        for(int i=0;i<n;i++)
        {
            
            IDataListener listener=dataListeners.get(i);
            if(listener!=null)
                listener.onData(data);
        }
       
    }
    
     
    
    @Override
    public void addNewDataListener(IDataListener listener) {
        dataListeners.add(listener);
    }
    
    @Override
    public void removeNewDataListener(IDataListener listener) {
        dataListeners.remove(listener);
    }

    @Override
    public void SendData(Data data) {
        this.data.add(data);
    }

   
    
    private static class ConnectorHolder{
        public static final Connector instance=new Connector();
    }
    
    
    private class OutThread implements Runnable
    {
        
        public OutThread()
        {
        }

        @Override
        public void run() {
            while(true)
            {
                if(data!=null)
                {
                    try {
                        if((!data.isEmpty())&&(data.size()>0)&&(data.get(0)!=null)&&(out!=null))
                        {
                            out.writeUTF(data.get(0).toString());
                            out.flush();
                            Data remove = data.remove(0);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
    }
    
    
    
    
    private class InThread implements Runnable
    {
        
        public InThread()
        {
        }

        @Override
        public void run() {
             while(true)
            {
                if(data!=null)
                {
                    try {
                       
                       String sIn= in.readUTF();
                       Data sData=new Data(sIn);
                       onNewData(sData);
                    } catch (IOException | ParseException ex) {
                        Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
    }
    
}
