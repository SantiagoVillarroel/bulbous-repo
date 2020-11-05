/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpsconcurrentecharly.Punto3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class ClaseB implements Runnable {
    Variable i;

    public ClaseB(Variable i) {
        this.i = i;
    }
    public void run(){
        try {
            Thread.sleep(150);
        } catch (InterruptedException ex) {
            Logger.getLogger(ClaseB.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int x=0;x<=3000;x++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClaseB.class.getName()).log(Level.SEVERE, null, ex);
            }
        if(i.getValor()==1){
            try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ClaseA.class.getName()).log(Level.SEVERE, null, ex);
                }
            System.out.print("BB");
            i.setValor(2);
        }
    }}
}
