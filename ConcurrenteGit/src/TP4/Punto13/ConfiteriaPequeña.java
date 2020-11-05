/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto13;

import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class ConfiteriaPequeña {
    String[]opciones= new String[]{"Coca cola y tostado","Pancho y sprite","Lomo con jugo de naranja"};
    Semaphore silla= new Semaphore(1,true);
    Semaphore mozo= new Semaphore(0,true);
    Semaphore elegir= new Semaphore(0,true);
    Semaphore eleccion= new Semaphore(0,true);
    Semaphore comer= new Semaphore(0,true);
    
    

    public ConfiteriaPequeña() {
        
    }
    
    
    public void atenderAEmpleado(String color) throws InterruptedException{
        while(true){
        System.out.println("soy el "+color+Thread.currentThread().getName()+" no hay empleados, asi que pienso en nuevas versiones de pollo.");
        Thread.sleep(200);
        mozo.acquire();
        System.out.println(color+"Que va elegir? Tenemos estas opciones: "+Arrays.toString(opciones));
        elegir.release();
        eleccion.acquire();
        System.out.println(color+" ya se lo traigo...");
        this.buscarComida();
        System.out.println(color+" acá está su pedido. Nos vemos!");
        comer.release();
        
        }
    }
    public boolean comerAlgo(String color) throws InterruptedException{
        
        boolean si= silla.tryAcquire();
        if(si){
        System.out.println("soy el "+color+Thread.currentThread().getName()+" y voy a pedir algo para comer");
        mozo.release();
        elegir.acquire();
        int i= (int)Math.random()*2;
        System.out.println(color+" Voy a pedir el "+opciones[i]);
        eleccion.release();
        comer.acquire();
        System.out.println(color+"Gracias. Ahora voy a comer esto.");
        this.comer();
        silla.release();
        }else{
            System.out.println(color+Thread.currentThread().getName()+" UH, está ocupado el mozo, voy a llorar unos milisegundos y  vuelvo a trabajar");
            this.llorar(color);
        }
        return si;
        
    }
    private void llorar(String color){
        try {
            System.out.println("------------"+color+Thread.currentThread().getName()+" LLORANDO");
            Thread.sleep(250);
        } catch (InterruptedException ex) {
            Logger.getLogger(ConfiteriaPequeña.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
    
    private void buscarComida(){
        try {
            Thread.sleep(400);
        } catch (InterruptedException ex) {
            Logger.getLogger(ConfiteriaPequeña.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void comer(){
        try {
            Thread.sleep(700);
        } catch (InterruptedException ex) {
            Logger.getLogger(ConfiteriaPequeña.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
