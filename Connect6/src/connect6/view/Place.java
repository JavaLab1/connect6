/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connect6.view;

import Players.IPlayer;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Ирина Рыжова
 */
public class Place extends JPanel implements IPlace{

    ArrayList<ArrayList<ButtonPoint>> place;
     private ArrayList<ButtonEvent> events;
    public int size=19;
    private Boolean _active=true;
    public Place() {
        
        super();
        place=new ArrayList<>();
        events=new ArrayList<>();
        this.setSize(size*20, size*20);
        setLayout(new FlowLayout());
        for(int y=0;y<size;y++)
        {
            ArrayList<ButtonPoint> temp=new ArrayList<>();
            place.add(temp);
            for(int x=0;x<size;x++)
            {
                ButtonPoint button=new ButtonPoint();
                button.setSize(10, 15);
                button.setBackground(Color.GRAY);
                button.setLocation(new Point(x*15+4, y*15+4));
                button.posX=x;
                button.posY=y;
                button.addButtonEventListener(this);
                temp.add(button);
                this.add(button);
            }
        }
    }
    
    
    
    public void setPlayer(int x,int y,IPlayer player)
    {
        place.get(x).get(y).setPlayer(player);
    }
    
    


    @Override
    public void onClick(ButtonPoint button) {
        int n=events.size();
        if(_active==true)
            for(int i=0;i<n;i++)
            {
                events.get(i).onClick(button);
            }
    }

    @Override
    public void onChange(ButtonPoint button) {
        int n=events.size();
        for(int i=0;i<n;i++)
        {
            events.get(i).onChange(button);
        }
    }
    
    
    @Override
    public void addButtonEventListener(ButtonEvent listener)
    {
        events.add(listener);
    }
    
    @Override
    public void removeButtonEventListener(ButtonEvent listener)
    {
        events.remove(listener);
    }

    @Override
    public void setActive(Boolean active) {
        this._active=active;
    }
    
    
}
