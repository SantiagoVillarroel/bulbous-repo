/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Punto3;
import Colores.Colores;
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
    public static void main (String[]args){
        String[] colores= Colores.colores();
        int cant=4;
        ControlTren ct= new ControlTren(cant);
        Thread[]hilos= new Thread[6];
        hilos[0]= new Thread(new Tren(ct,ANSI_BLACK));
        hilos[1]= new Thread(new VendedorTickets(ct,ANSI_BLACK));
        for(int i=2;i<=hilos.length-1;i++){
            hilos[i]= new Thread(new Pasajero(ct,colores[i-2]));
        }
        for(int i=0;i<=hilos.length-1;i++){
            hilos[i].start();
        }
    }
}
