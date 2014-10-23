/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connector;
import Data.Data;
/**
 *
 * @author Илья Рыжов
 */
public interface IConnector {
    void addNewDataListener(IDataListener listener);
    void SendData(Data data);
}
