/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6_2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class MedidorTemp implements Runnable{
    private GestorSala sala;
    private int hora=0;
    public MedidorTemp(GestorSala sala){
        this.sala=sala;
    }
    public void run(){
        while(true){
            if(hora%3 ==0){ //Cada 3 horas revisa la temp
                sala.notifTemp();
            }
            sala.actualizarTemp(); //En cada hora se actualiza la temp
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MedidorTemp.class.getName()).log(Level.SEVERE, null, ex);
            }
            hora=hora+1;
        }
    }
}
