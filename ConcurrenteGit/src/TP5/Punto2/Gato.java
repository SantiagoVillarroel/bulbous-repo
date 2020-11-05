/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Punto2;

import TP5.Punto1.*;

/**
 *
 * @author Faustino
 */
public class Gato implements Runnable{
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private AdminComedor acom;

    public Gato(AdminComedor acom) {
        this.acom = acom;
    }
    
    public void run(){
        while(true){
        acom.comer("Gato",ANSI_PURPLE );
    }}
}
