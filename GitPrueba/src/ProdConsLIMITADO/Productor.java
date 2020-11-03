/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProdConsLIMITADO;

import ProdCons.*;
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
            boolean flag;
            int random = (int)(Math.random()*5)+1;
            flag=this.buffer.producir(random, nombre);
            if(flag){
                System.out.println(nombre+" produjo "+random);
            }else{
                System.out.println(nombre+" NO produjo "+random +" BUFFER LLENO");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
