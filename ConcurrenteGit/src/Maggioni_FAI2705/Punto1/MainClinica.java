/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maggioni_FAI2705;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class MainClinica {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    public static void main(String[]args){
        String[]colores= new String[]{ANSI_BLACK,ANSI_RED,ANSI_GREEN,ANSI_YELLOW,ANSI_BLUE,ANSI_PURPLE,ANSI_CYAN};
        int cantidaddesillas= 2;
        Clinica clinic= new Clinica(cantidaddesillas);
        Donante[] donantes= new Donante[4];
        for(int i=0; i<= 3; i++){
            donantes[i]= new Donante("Donante "+i,clinic,colores[i]);
        }

        Thread[]hilos= new Thread[7];
        for(int i=0;i<=3;i++){
            hilos[i]=new Thread(donantes[i],"Donante "+i);
        }
        Persona[]personas= new Persona[3];
        personas[0]= new Recepcionista("Pam",clinic,colores[4]);
        personas[1]= new Especialista("Especialista",clinic,colores[5]);
        personas[2]= new Extraccionista("Extraccionista",clinic,colores[6]);
        hilos[4]= new Thread((Runnable) personas[0],"Pam");
        hilos[5]= new Thread((Runnable) personas[1],"Especialista");
        hilos[6]= new Thread((Runnable) personas[2],"Extraccionista");
        
        for(int i=0; i<=6; i++){
            try {
                if(i<=3)
                    Thread.sleep(300);
                hilos[i].start();
            } catch (InterruptedException ex) {
                Logger.getLogger(MainClinica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
