/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto12;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Jaula {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    public static void main(String[]args){
        int cant= 6;
        Instalacion[] aparatos= new Instalacion[]{ 
            new Rueda((int) (Math.random()*9)+8,"Rueda"), 
            new Plato((int) (Math.random()*9)+2,"Plato"), 
            new Hamaca((int) (Math.random()*9)+11,"Hamaca")
            };
        AdminJaula aj= new AdminJaula(aparatos);
        Thread[] hamsters= new Thread[cant];
        String[] colores= new String[]{ANSI_RED,ANSI_GREEN,ANSI_BLACK,ANSI_BLUE,ANSI_PURPLE,ANSI_CYAN};
        for(int i=0; i<=cant-1;i++){
            hamsters[i]= new Thread(new Hamster(aparatos,colores[i],aj),"Hamster "+i);
        }
        for(int i=0;i<=cant-1;i++){
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(Jaula.class.getName()).log(Level.SEVERE, null, ex);
            }
            hamsters[i].start();
        }
        }
        
    }
    
    

