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
public class NetPlayer extends APlayer implements IDataListener{

    public NetPlayer(IConnector connector) {
        super(connector);
       
    }

    @Override
    public void Connect() {
        this.connector.addNewDataListener(this);
    }
    
    
    @Override
    public void onData(Data data) {
        switch(data.getIdComand())
        {
            case -2:
            {
                this._id=data.getIdPlayer();
                this._color=data.getColor();
                break;
            }
            
            case 1:
            {
                if(data.getIdPlayer()==this._id)
                    this.onStartThink();
                break;
            }
            
            
            case 2:
            {
                if(data.getIdPlayer()==this._id)
                {
                    this.x=data.getXCell();
                    this.y=data.getYCell();
                    this.onEndThink();
                }
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
    public Boolean isHuman() {
        return false;
    }

    @Override
    public void setTurn(Boolean turn) {
        this.onStartThink();
    }

    
    
}
