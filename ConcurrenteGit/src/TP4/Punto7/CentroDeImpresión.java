/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto7;

public class CentroDeImpresión {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static void main (String[]args){
        
        Impresora[] impresoras= new Impresora[4];
        for(int i=0; i<=1;i++){
            impresoras[i]= new ImpresoraA();
        }
        for(int i=2; i<=3;i++){
            impresoras[i]= new ImpresoraB();
        }
        Thread[] hilos= new Thread[10];
        for(int i=0; i<=9; i++){
            Trabajo t = null;
            int dec= (int)(Math.random()*3);
            switch(dec){
                case 0:
                    Impresora esa= impresoras[0];
                    for(int x=0; x<=3; x++){
                        if(x>0){
                            if(impresoras[x].getTamañoLista() < esa.getTamañoLista()){
                                esa= impresoras[x];
                            }
                        }
                    }
                    t= new Trabajo(esa, "Trabajo "+i, ANSI_RED);
                    break;
                case 1:
                    Impresora esaA= impresoras[0];
                    for(int x=0; x<=1; x++){
                        if(x>0){
                            if(impresoras[x].getTamañoLista() < esaA.getTamañoLista()){
                                esaA= impresoras[x];
                            }
                        }
                    }
                    t= new TrabajoA((ImpresoraA)esaA, "Trabajo "+i, ANSI_PURPLE);
                    break;
                case 2:
                    Impresora esaB= impresoras[2];
                    for(int x=2; x<=3; x++){
                        if(x>2){
                            if(impresoras[x].getTamañoLista() < esaB.getTamañoLista()){
                                esaB= impresoras[x];
                            }
                        }
                    }
                    t= new TrabajoB((ImpresoraB)esaB, "Trabajo "+i, ANSI_BLUE);
                    break;
            }
            
            hilos[i]= new Thread(t,"Trabajo "+i);
            
        }
        
        
        for(int i=0; i<=9; i++){
            hilos[i].start();
        }
    }
}
