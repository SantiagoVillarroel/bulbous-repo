/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto9;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Calle {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static void main(String[]args){
        AdminSem as= new AdminSem();
        AdminSem as2= new AdminSem();
        Taxi tx= new Taxi(as,ANSI_BLACK);
        Thread[] hilos= new Thread[6];
        hilos[0]= new Thread(tx,"Taxi");
        for(int i=1;i<=4;i++){
            switch(i){
                case 1:
                hilos[i]= new Thread(new Pasajero(ANSI_RED,as,as2),"Pasajero "+i);
                break;
                case 2:
                hilos[i]= new Thread(new Pasajero(ANSI_GREEN,as,as2),"Pasajero "+i);
                break;
                case 3:
                hilos[i]= new Thread(new Pasajero(ANSI_BLUE,as,as2),"Pasajero "+i);
                break;
                case 4:
                hilos[i]= new Thread(new Pasajero(ANSI_CYAN,as,as2),"Pasajero "+i);
                break;
            
            
                   
            }
        }
        hilos[5]= new Thread(new Taxi(as2,ANSI_PURPLE),"Taxi 2");
        hilos[0].start();
        hilos[5].start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Calle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=1; i<=4;i++){
            hilos[i].start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Calle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
