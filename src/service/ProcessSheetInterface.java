/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

/**
 *
 * @author tanet-t
 */
public interface ProcessSheetInterface {
     public void processEachRecord(int row,int coloumn,String value);
     public void rowCompleted();
}
