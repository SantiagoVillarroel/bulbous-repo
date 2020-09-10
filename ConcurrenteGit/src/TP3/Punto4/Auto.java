/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Punto4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Auto extends Vehiculo implements Runnable {
    int carga;

    public Auto(int kmParaAndar, int c) {
        super(kmParaAndar);
        carga= c;
    }
    
    public void run(){
        for(int i=0; i<= 2;i++){
            System.out.println(Thread.currentThread().getName()+" comienza a andar.");
            int km= this.kmParaAndar;
            for(int j=km; j>0; j--){
                this.kmParaAndar--;
            }
            System.out.println(Thread.currentThread().getName()+" se quedó sin nafta. Recorrió "+km+" kilometros");
            try {
                cargarNafta();
            } catch (InterruptedException ex) {
                Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public synchronized void cargarNafta() throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" cargando nafta...");
        Thread.sleep(carga*100);
        this.kmParaAndar=carga;
        System.out.println(Thread.currentThread().getName()+" terminó de cargar! Esperó "+(carga)+" segundos.");
    }

    
}
