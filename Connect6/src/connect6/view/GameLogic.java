/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connect6.view;

import Connector.IConnector;
import Connector.IDataListener;
import Data.Data;
import Players.IPlayer;
import Players.IPlayerListener;

/**
 *
 * @author Артём Земсков
 */
public class GameLogic implements IDataListener,IPlayerListener,ButtonEvent {

    private IPlace place;
    private IPlayer player1;
    private IPlayer player2;
    private IConnector connector;
    private IPlayer turn;
    
    public GameLogic(IConnector connector,IPlace place,IPlayer player1,IPlayer player2) {
        
        this.place=place;
        this.player1=player1;
        this.player2=player2;
        this.connector=connector;
        this.connector.addNewDataListener(this);
        this.player1.addThinkListener(this);
        this.player2.addThinkListener(this);
        this.place.addButtonEventListener(this);
        
    }
    
    
    @Override
    public void onStartThinkListener(IPlayer player) {
        if(player.isHuman())
        {
            this.place.setActive(Boolean.TRUE);
        }else
        {
            this.place.setActive(Boolean.FALSE);
        }
        
        turn=player;
    }
    
    
    @Override
    public void onEndThinkListener(IPlayer player) {
        if(!player.isHuman())
        {
            this.place.setActive(Boolean.TRUE);
            this.place.setPlayer(player.getX(), player.getY(), player);
        }else
        {
            this.place.setActive(Boolean.FALSE);
            Data data=new Data();
            data.setIdPlayer(player.getId());
            data.setIdComand(2);
            data.setColor(player.getColor());
            data.setXCell(player.getX());
            data.setYCell(player.getY());
            connector.SendData(data);
        }
    }
    
    
    @Override
    public void onClick(ButtonPoint button) {
        button.setPlayer(turn);
        turn.setPozition(button.posX, button.posY);
    }

    @Override
    public void onChange(ButtonPoint button) {
        
    }
    

    
    

    @Override
    public void onData(Data data) {
        
    }

    

    
    
    
}
