/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connect6.view;

import Players.IPlayer;

/**
 *
 * @author Ирина Рыжова
 */
public interface IPlace extends ButtonEvent {
    
    void setPlayer(int x,int y,IPlayer player);
    void setActive(Boolean active);
    void addButtonEventListener(ButtonEvent listener);
    void removeButtonEventListener(ButtonEvent listener);
    
}
