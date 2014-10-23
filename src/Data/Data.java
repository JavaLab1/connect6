/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Ирина Рыжова
 */
public class Data {
    private static String ID_PLAYER="idPlayer";
    private static String ID_COMAND="idComand";
    private static String ID_OPERATION="idOperation";
    private static String X_CELL="xCell";
    private static String Y_CELL="yCell";
    private JSONObject data;
    
    public Data()
    {
        Init();
    }
    
    public Data(int idPlayer,int idComand,int idOperation,int xCell,int yCell)
    {
        Init();
        data.put(ID_PLAYER, idPlayer);
        data.put(ID_OPERATION, idComand);
        data.put(ID_COMAND, idOperation);
        data.put(X_CELL, xCell);
        data.put(Y_CELL, yCell);
    }
    
    
    public Data(JSONObject data)
    {
        this.data=data;
    }
    
    
    public Data(String JsonString) throws ParseException
    {
        JSONParser parser=new JSONParser();
        data=(JSONObject)parser.parse(JsonString);
        
    }
    
    
    
    private void Init()
    {
        data=new JSONObject();
        data.put(ID_PLAYER, -1);
        data.put(ID_OPERATION, -1);
        data.put(ID_COMAND, -1);
        data.put(X_CELL, -1);
        data.put(Y_CELL, -1);
    }
    
    public void setIdPlayer(int id)
    {
        data.put(ID_PLAYER, id);
    }
    
    
    public void setIdComand(int id)
    {
        data.put(ID_COMAND, id);
    }
    
    public void setIdOperation(int id)
    {
        data.put(ID_OPERATION, id);
    }
    
    
    public void setXCell(int x)
    {
        data.put(X_CELL, x);
    }
    
    public void setYCell(int y)
    {
        data.put(Y_CELL, y);
    }
    
    
    
    public int getIdPlayer()
    {
        return (int)data.get(ID_PLAYER);
    }
    
    
    public int getIdComand()
    {
        return (int)data.get(ID_COMAND);
    }
    
    public int getIdOperation()
    {
        return (int)data.get(ID_OPERATION);
    }
    
    
    public int getXCell()
    {
        return (int)data.get(X_CELL);
    }
    
    public int getYCell()
    {
        return (int)data.get(Y_CELL);
        
    }
    
    @Override
    public String toString()
    {
        return data.toJSONString();
    }
}
