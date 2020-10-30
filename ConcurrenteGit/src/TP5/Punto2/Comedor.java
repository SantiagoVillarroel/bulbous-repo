/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Punto2;

import TP5.Punto1.*;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Comedor {

    private Semaphore comederos;
    private Semaphore semGatos= new Semaphore(1,true);
    private Semaphore semPerros= new Semaphore(0,true);
    private Semaphore vacio= new Semaphore(0,true);
    private int cant;
    private char raza;

    public Comedor(int cant) {
        this.cant=cant;
        this.raza='g';
        comederos= new Semaphore(cant,true);
    }
    
    public void comeGato(String color){
        try {
            semGatos.acquire();
            semGatos.release();
            comederos.acquire();
            System.out.println(color+ " gato comiendo");
            Thread.sleep(2000);
            comederos.release();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void comePerro(String color){
        try {
            semPerros.acquire();
            semPerros.release();
            if(comederos.tryAcquire(2)){
            System.out.println(color+ " perro comiendo 2 platos de una vez.");
            Thread.sleep(4000);
            comederos.release(2);
            }else{
                System.out.println(color+"perro come 2 platos de a tandas");
                comederos.acquire();
                Thread.sleep(2000);
                comederos.release();
                comederos.acquire();
                Thread.sleep(2000);
                comederos.release();
            } 
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getTodosComederos(){
        try {
            comederos.acquire(cant);
            this.cambiarRaza();
            comederos.release(cant);
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cambiarRaza(){
        System.out.println("C A M B I O");
        if(this.raza=='g'){
            try {
                semGatos.acquire();
                semPerros.release();
                this.raza='p';
            } catch (InterruptedException ex) {
                Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                semPerros.acquire();
                semGatos.release();
                this.raza='g';
            } catch (InterruptedException ex) {
                Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    
    
    
    


}
