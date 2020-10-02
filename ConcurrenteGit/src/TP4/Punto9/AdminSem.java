/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto9;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class AdminSem {
    private Semaphore semManejar;
    private Semaphore semSubir;
    private Semaphore semBajar;
    private Semaphore semDormir;

    public AdminSem() {
        semManejar= new Semaphore(0);
        semSubir= new Semaphore(1);
        semBajar= new Semaphore(1);
    }
    
    public void taxi(String color){
        while(true){
            System.out.println(color+Thread.currentThread().getName()+" durmiendo...");
            
        try {
            semManejar.acquire();
            System.out.println(color+Thread.currentThread().getName()+" se despierta y maneja");
        } catch (InterruptedException ex) {
            Logger.getLogger(AdminSem.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.manejar(color);
            System.out.println(color+Thread.currentThread().getName()+" termina el recorrido.");
        semBajar.release();
        }
    
    }
    public void manejar(String color){
        System.out.println(color+Thread.currentThread().getName()+
                " lleva a pasajero...");
        try {
            Thread.sleep(800);
        } catch (InterruptedException ex) {
            Logger.getLogger(AdminSem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean pasajero(String color){
        boolean res= semSubir.tryAcquire();
        if(res){
        System.out.println(color+Thread.currentThread().getName()+" para taxi.");
        semManejar.release();
        try {
            semBajar.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(AdminSem.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(color+Thread.currentThread().getName()+" se baja del taxi.");
        semSubir.release();
        }
        return res;
}
}