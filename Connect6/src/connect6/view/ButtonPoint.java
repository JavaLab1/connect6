/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connect6.view;

import Players.IPlayer;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;



/**
 *
 * @author Артём Земсков
 */
public class ButtonPoint extends JButton{
    
    public int posX;
    public int posY;
    private ArrayList<ButtonEvent> events;
    private IPlayer player;
    public ButtonPoint()
    {
        super();
        events=new ArrayList<>();
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                onClick(ButtonPoint.this);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
               
            }
        });
    }
    
    
    public void setPlayer(IPlayer player)
    {
        if(this.player==null)
        {
            this.player=player;
            this.setBackground(new Color(player.getColor()));
            onChange(this);
        }
    }
    
    
    public IPlayer getPlayer()
    {
        return player;
    }
    
    public ButtonPoint(String label)
    {
        super(label);
    }
    
    private void onClick(ButtonPoint button)
    {
        int n=events.size();
        for(int i=0;i<n;i++)
        {
            events.get(i).onClick(button);
        }
    }
    private void onChange(ButtonPoint button)
    {
        int n=events.size();
        for(int i=0;i<n;i++)
        {
            events.get(i).onChange(button);
        }
    }
    
    
    public void addButtonEventListener(ButtonEvent listener)
    {
        events.add(listener);
    }
    
    public void removeButtonEventListener(ButtonEvent listener)
    {
        events.remove(listener);
    }
   
}
