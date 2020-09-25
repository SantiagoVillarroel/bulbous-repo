/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto7;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Impresora {
    Semaphore sem;
    private Lista espera;
    private Cola esp;

    public Impresora() {
        this.sem= new Semaphore(1);
        espera= new Lista();
    }

    public Semaphore getSem() {
        return sem;
    }

    public void setSem(Semaphore sem) {
        this.sem = sem;
    }
    public void imprimir(String color, String t){
        System.out.println(color+Thread.currentThread().getName()+" pide impresora");
        espera.insertar(1, espera.longitud()+1);
        esp.poner(t);
        try {
            sem.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Impresora.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(color+Thread.currentThread().getName()+" consigue"
                + " impresora // Imprimiendo");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Impresora.class.getName()).log(Level.SEVERE, null, ex);
        }
        String tex=(String)esp.obtenerFrente();
        System.out.println(tex+" *texto a imprimir* ");
        esp.sacar();
        espera.eliminar(1);
        sem.release();
        
    }
    
    public int getTamañoLista(){
        return this.espera.longitud();
    }
    
    
}
