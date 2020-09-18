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
public class ClaseA implements Runnable{
    private Variable i;

    public ClaseA(Variable i) {
        this.i = i;
    }
    public void run(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(ClaseA.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int x=0;x<=3000;x++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClaseA.class.getName()).log(Level.SEVERE, null, ex);
            }
        if(i.getValor()==0){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ClaseA.class.getName()).log(Level.SEVERE, null, ex);
                }
            System.out.print("A");
            i.setValor(1);
        }}
    }
}
