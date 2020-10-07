/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto14;

import TP4.Punto13.*;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import TP2.Punto6.Contador;

/**
 *
 * @author Faustino
 */
public class ConfiteriaPequeña {
    String[]opciones= new String[]{"tostado","Pancho","Lomo"};
    String[]bebidas= new String[]{"agua","jugo","sprite"};
    Semaphore mozo= new Semaphore(0,true);
    Semaphore elegir= new Semaphore(0,true);
    Semaphore eleccion= new Semaphore(0,true);
    Semaphore elegirComida= new Semaphore(0,true);
    Semaphore eleccionComida= new Semaphore(0,true);
    Semaphore comer= new Semaphore(0,true);
    Semaphore beber= new Semaphore(0,true);
    Semaphore cocinero= new Semaphore(0,true);
    Contador csillas= new Contador();
    
    

    public ConfiteriaPequeña() {
        
    }
    
    
    public void llevarBebidaAEmpleado(String color) throws InterruptedException{ //Trabajo del mozp
        while(true){
        System.out.println("soy el "+color+Thread.currentThread().getName()+" no hay empleados, asi que pienso en nuevas versiones de pollo.");
        Thread.sleep(200);
        mozo.acquire(); //Se libera cuando alguien pide bebida
        System.out.println(color+"Que va elegir? Tenemos estas opciones: "+Arrays.toString(bebidas));
        elegir.release();//Lo deja elegir al cliente
        eleccion.acquire();//Terminó su elección el cliente
        System.out.println(color+"soy el mozo ya le traigo la bebida...");
        this.buscarBebida();
        System.out.println(color+" soy el mozo, acá está su pedido. Nos vemos!");
        beber.release();//Le avisa al cliente que está la comida y asi puede empezar a comer
        
        }
    }
    public void llevarComidaAEmpleado(String color){ //Trabajo del cocinero
        while(true){
            try {
                System.out.println(color+"soy el "+color+Thread.currentThread().getName()+" no hay empleados, así que limpio la cocina y pienso nuevas recetas.");
                Thread.sleep(200);
                cocinero.acquire(); //Se libera cuando alguien pide comida
                System.out.println(color+"Que va elegir? Tenemos estas opciones: "+Arrays.toString(opciones));
                elegirComida.release();//Lo deja elegir al cliente
                eleccionComida.acquire();//Terminó su elección el cliente
                System.out.println(color+"soy"+Thread.currentThread().getName()+" ya le traigo su comida");
                this.cocinarYTraerComida(color);
                System.out.println(color+" soy el cocinero acá está su pedido. Nos vemos!");
                comer.release();//Le avisa al cliente que está la comida y asi puede empezar a comer
            } catch (InterruptedException ex) {
                Logger.getLogger(ConfiteriaPequeña.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void cocinarYTraerComida(String color){
        try {
            System.out.println(color+" soy el cocinero, estoy cocinando para el empleado.");
            Thread.sleep(600);
            System.out.println(color+" el plato está listoppp.");
        } catch (InterruptedException ex) {
            Logger.getLogger(ConfiteriaPequeña.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean comerOTomarAlgo(String color) throws InterruptedException{
        
        boolean si= csillas.getI()<2; //Si hay sillas disponibles puede entrar, si no no.
        if(si){
        csillas.sumar(); //Actualiza la ocupación
        this.comerOBeber(color);
        csillas.restar(); //Se va, asi q libera una silla
        }else{
            System.out.println(color+Thread.currentThread().getName()+" UH, están ocupadas las sillas! voy a llorar unos milisegundos y  vuelvo a trabajar");
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
        private void comerOBeber(String color){
        
            System.out.println("soy el "+color+Thread.currentThread().getName()+" y voy a pedir algo");
            int opcion= (int)(Math.random()*3);
            switch(opcion){
                case 0:
                    //pedir bebida
                    System.out.println(color+Thread.currentThread().getName()+"------ Pedí una bebida.");
                    this.servicioBebida(color);
                    break;
                case 1:
                    //pedir comida
                    System.out.println(color+Thread.currentThread().getName()+"------ ------Pedí una comida.");
                    this.servicioComida(color);
                    break;
                case 2:
                    System.out.println(color+Thread.currentThread().getName()+"------ ------------Pedí una bebida y una comida.");
                    this.servicioBebida(color);
                    this.servicioComida(color);
                    //ambas
                    break;
            }

        }
        
        
        private void beber() throws InterruptedException{
            Thread.sleep(200);
        }
        
        private void servicioBebida(String color){
        try {
            mozo.release(); // Le avisa al mozo q llegó
            elegir.acquire(); //Intenta pedir hasta q el mozo libera este semáforo
            int i= (int)(Math.random()*2);
            System.out.println(color+Thread.currentThread().getName()+" Mmmmmm, que pido???");
            Thread.sleep(160);
            System.out.println(color+" Voy a pedir el "+bebidas[i]);
            eleccion.release(); //Avisa q terminó de elegir
            beber.acquire(); //Intenta tomar hasta q mozo avisa q llegó con la bebida
            System.out.println(color+"Gracias. Ahora voy a beber esto.");
            this.beber();
        } catch (InterruptedException ex) {
            Logger.getLogger(ConfiteriaPequeña.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        private void servicioComida(String color){
        try { //Mismo razonamiento q en servicio bebida pero con comida y cocinero.
            cocinero.release();
            elegirComida.acquire();
            int i= (int)(Math.random()*2);
            System.out.println(color+Thread.currentThread().getName()+" Mmmmmm, que pido???");
            Thread.sleep(160);
            System.out.println(color+" Voy a pedir el "+opciones[i]);
            eleccionComida.release();
            comer.acquire();
            System.out.println(color+"Gracias. Ahora voy a beber esto.");
            this.comer();
        } catch (InterruptedException ex) {
            Logger.getLogger(ConfiteriaPequeña.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        
    
    private void buscarBebida(){
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
