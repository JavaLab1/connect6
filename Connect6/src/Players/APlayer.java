/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Players;

import Connector.IConnector;
import java.util.ArrayList;

/**
 *
 * @author Ирина Рыжова
 */
public abstract class APlayer implements IPlayer{

    protected ArrayList<IPlayerListener> thinkListeners;
    protected IConnector connector;
    protected int _id=-1;
    protected int _color=-1;
    protected int score=0;
    protected int x;
    protected int y;
    protected APlayer(IConnector connector)
    {
        thinkListeners=new ArrayList<>();
        this.connector=connector;
        
    }
    
    
    public abstract void Connect();
    
    
    public void onEndThink() {
        int n=this.thinkListeners.size();
        for(int i=0;i<n;i++)
        {
            thinkListeners.get(i).onEndThinkListener(this);
        }
    }


    public void onStartThink() {
        int n=this.thinkListeners.size();
        for(int i=0;i<n;i++)
        {
            thinkListeners.get(i).onStartThinkListener(this);
        }
    }
    
    @Override
    public void removeThinkListener(IPlayerListener listener) {
        thinkListeners.remove(listener);
    }
    
    
    @Override
    public void addThinkListener(IPlayerListener listener) {
        thinkListeners.add(listener);
    }

    @Override
    public int getColor() {
        return this._color;
    }

    @Override
    public int getId() {
        return this._id;
    }
    
    
    @Override
    public void setColor(int color) {
        this._color=color;
    }

    @Override
    public void setId(int id) {
        this._id=id;
    }

    @Override
    public int getScore() {
        return score;
    }
    
    
    @Override
    public void giveScore() {
        score=1;
    }
    
    
    
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
    
     @Override
     public void setPozition(int x,int y)
     {
         this.x=x;
         this.y=y;
     }

    
}
