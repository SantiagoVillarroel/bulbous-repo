/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto14;


import java.util.logging.Level;
import java.util.logging.Logger;




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
        ConfiteriaPequeña cp= new ConfiteriaPequeña();
        Mozo mz= new Mozo("Julian",cp,ANSI_RED);
        Cocinero coc= new Cocinero("faus",cp,ANSI_BLACK);
        Thread[]hilos= new Thread[8];
        String[] colores= new String[]{ANSI_RED,ANSI_GREEN,ANSI_BLACK,ANSI_BLUE,ANSI_PURPLE,ANSI_CYAN};
        hilos[0]= new Thread(mz,"Mozo Julián.");
        hilos[7]= new Thread(coc,"Cocinero Faus.");
        
        for(int i=1; i<=6;i++){
            hilos[i]= new Thread(new Empleado("Empleado "+i,cp,colores[i-1]),"Empleado "+i);
        }
        hilos[7].start();
        for(int i=0;i<=6;i++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            hilos[i].start();
        }
    }
}
