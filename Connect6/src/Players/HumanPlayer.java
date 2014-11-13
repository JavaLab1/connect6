/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Players;

import Connector.IConnector;
import Connector.IDataListener;
import Data.Data;

/**
 *
 * @author Артём Земсков
 */
public class HumanPlayer extends APlayer implements IDataListener {

    public HumanPlayer(IConnector connector) {
        super(connector);
    }

    @Override
    public void Connect() {
        connector.SendData(new Data());
        connector.addNewDataListener(this);
       /* connector.addNewDataListener(new IDataListener() {

            @Override
            public void onData(Data data) {
                connector.removeNewDataListener(this);
                HumanPlayer.this._id=data.getIdPlayer();
                HumanPlayer.this._color=data.getColor();
                
            }
        });*/
    }

    @Override
    public Boolean isHuman() {
        return true;
    }

    @Override
    public void setTurn(Boolean turn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onData(Data data) {
        switch(data.getIdComand())
        {
             
            case -1:
            {
                HumanPlayer.this._id=data.getIdPlayer();
                HumanPlayer.this._color=data.getColor();
                break;
            }
            
            
            case 1:
            {
                if(data.getIdPlayer()==this._id)
                    this.onStartThink();
                break;
            }
            
            
            case 3:
            {
                if(data.getIdPlayer()==this._id)
                {
                    this.giveScore();
                }
                break;
            }
            
            case 5:
            {
                if(data.getIdPlayer()==this._id)
                {
                    this.onStartThink();
                }
                break;
            }
        }
    }
    
    
    @Override
    public void setPozition(int x,int y)
    {
        super.setPozition(x, y);
        this.onEndThink();
    }
    
    
    
}
