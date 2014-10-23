/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Players;

import java.util.EventListener;

/**
 *
 * @author Ирина Рыжова
 */
public interface IPlayerListener extends EventListener{
    void onEndThinkListener(IPlayer player);
    void onStartThinkListener(IPlayer player);
}
