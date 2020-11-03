/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProdCons;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class Consumidor implements Runnable{
    private String nombre;
    private Buffer buffer;
    public Consumidor(Buffer buffer, String n){
        this.buffer=buffer;
        this.nombre=n;
    }
    public void run(){
        try {
            if(this.buffer.consumir()){
                System.out.println(nombre+" pudo consumir");
            }else{
                System.out.println(nombre+" no pudo consumir");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
