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
public class Productor implements Runnable{
    private Buffer buffer;
    private String nombre;
    public Productor(Buffer buffer, String n){
        this.buffer=buffer;
        this.nombre=n;
    }
    public void run(){
        try {
            int random = (int)(Math.random()*5)+1;
            this.buffer.producir(random);
            System.out.println(nombre+" produjo "+random);
        } catch (InterruptedException ex) {
            Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
