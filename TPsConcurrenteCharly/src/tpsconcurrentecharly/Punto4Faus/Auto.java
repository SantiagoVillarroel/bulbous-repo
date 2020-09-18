/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpsconcurrentecharly.Punto4Faus;

import tpsconcurrentecharly.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Auto extends Vehiculo implements Runnable {
    private int carga;
    private Surtidor surt;
    private String color;


    public Auto(int kmParaAndar, int c,Surtidor surt, String color) {
        super(kmParaAndar);
        carga= c;
        this.surt=surt;
        this.color=color;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public int getKmParaAndar() {
        return kmParaAndar;
    }

    public void setKmParaAndar(int kmParaAndar) {
        this.kmParaAndar = kmParaAndar;
    }
    
    
    public void run(){
        boolean hay=true;
        while(hay){
            System.out.println(color+Thread.currentThread().getName()+" comienza a andar.");
            int km= this.kmParaAndar;
            for(int j=km; j>0; j--){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.kmParaAndar--;
            }
            System.out.println(color+Thread.currentThread().getName()+" se quedó sin nafta. Recorrió "+km+" kilometros");
            hay= surt.cargarNafta(this,carga,color);
                    
            
        }
    }}