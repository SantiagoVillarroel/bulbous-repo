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
    public static final String ANSI_PURPLE = "\u001B[35m";

    public AdminSem() {
        semManejar= new Semaphore(0);
        semSubir= new Semaphore(1);
        semBajar= new Semaphore(1);
    }
    
    public void taxi(){
        while(true){
            System.out.println(Thread.currentThread().getName()+" durmiendo...");
            
        try {
            semManejar.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(AdminSem.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(Thread.currentThread().getName()+
                " lleva a pasajero...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(AdminSem.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println(Thread.currentThread().getName()+" termina el recorrido.");
        semBajar.release();
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
        
    }else{
            System.out.println(color+Thread.currentThread().getName()+" taxi ocupado rey.");
        }
        return res;
}
}