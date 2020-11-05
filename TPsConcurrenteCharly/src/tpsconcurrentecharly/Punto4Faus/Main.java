/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpsconcurrentecharly.Punto4Faus;

import tpsconcurrentecharly.*;

/**
 *
 * @author Faustino
 */
public class Main {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static void main(String[]args){
        Thread[] autos= new Thread[5];
        Surtidor surt= new Surtidor();
        for(int i=0;i<=4;i++){
            String color=ANSI_WHITE;
            switch(i){
                case 0:
                    color= ANSI_RED;
                    break;
                case 1:
                    color= ANSI_BLUE;
                    break;
                case 2:
                    color= ANSI_BLACK;
                    break;
                case 3:
                    color= ANSI_PURPLE;
                    break;
                case 4:
                    color= ANSI_GREEN;
                    break;
                    
            }
            autos[i]= new Thread(new Auto((i+1)*110,(i+1)*55,surt,color),"Auto "+i);
        }
        for(int i=0; i<=4;i++){
            autos[i].start();
        }
    }
}
