/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Players;

/**
 *
 * @author Ирина Рыжова
 */
public interface IPlayer {
    
   void addThinkListener(IPlayerListener listener);
   void removeThinkListener(IPlayerListener listener);
   int getColor();
   int getId();
   int getScore();
   Boolean isHuman();
   void setColor(int color);
   void setId(int id);
   void setTurn(Boolean turn);
   void giveScore();
   int getX();
   int getY();
   void setPozition(int x,int y);
    
}
