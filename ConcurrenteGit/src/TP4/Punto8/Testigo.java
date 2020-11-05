/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto8;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Testigo {
    private Semaphore sem1;
    private Semaphore sem2;
    private Semaphore sem3;
    private Semaphore sem4;

    public Testigo() {
        sem1= new Semaphore(1);
        sem2= new Semaphore(0);
        sem3= new Semaphore(0);
        sem4= new Semaphore(0);
    }
    
    public void correUno(double tiempo){
        double ti=0;
        try {
            sem1.acquire();
            ti= System.currentTimeMillis();
        } catch (InterruptedException ex) {
            Logger.getLogger(Testigo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Comienza a correr "+Thread.currentThread().getName());
        try {
            Thread.sleep((long) (tiempo*1000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Testigo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(Thread.currentThread().getName()+" termina su recorrido."
                + " Tardó: "+(System.currentTimeMillis()-ti)/1000+" segundos");
        System.out.println("Le da el testigo al corredor 2.");
        
        sem2.release();
    }
    public void correDos(double tiempo){
        double ti=0;
        try {
            sem2.acquire();
            ti= System.currentTimeMillis();
        } catch (InterruptedException ex) {
            Logger.getLogger(Testigo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Comienza a correr "+Thread.currentThread().getName());
        try {
            Thread.sleep((long) (tiempo*1000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Testigo.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.println(Thread.currentThread().getName()+" termina su recorrido."
                + " Tardó: "+(System.currentTimeMillis()-ti)/1000+" segundos");
        System.out.println("Le da el testigo al corredor 3.");
        
        sem3.release();
    }
    public void correTres(double tiempo){
        double ti=0;
        try {
            sem3.acquire();
            ti= System.currentTimeMillis();
        } catch (InterruptedException ex) {
            Logger.getLogger(Testigo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Comienza a correr "+Thread.currentThread().getName());
        try {
            Thread.sleep((long) (tiempo*1000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Testigo.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.println(Thread.currentThread().getName()+" termina su recorrido."
                + " Tardó: "+(System.currentTimeMillis()-ti)/1000+" segundos");
        System.out.println("Le da el testigo al corredor 4.");
        
        sem4.release();
    }
    public void correCuatro(double tiempo){
        double ti= 0;
        try {
            sem4.acquire();
            ti= System.currentTimeMillis();
        } catch (InterruptedException ex) {
            Logger.getLogger(Testigo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Comienza a correr "+Thread.currentThread().getName());
        try {
            Thread.sleep((long)  (tiempo*1000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Testigo.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.println(Thread.currentThread().getName()+" termina su recorrido."
                + " Tardó: "+(System.currentTimeMillis()-ti)/1000+" segundos");
        System.out.println("TERMINAN LA CARRERA.");
        sem1.release();
    }
}
