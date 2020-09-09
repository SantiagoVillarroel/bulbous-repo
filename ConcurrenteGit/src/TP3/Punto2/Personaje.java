/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Punto2;

/**
 *
 * @author Faustino
 */
public class Personaje implements Runnable {
    int accion;
    String nombre;
    Vida vid;

    public Personaje(int accion, String nombre, Vida v) {
        this.accion = accion;
        this.nombre = nombre;
        this.vid=v;
    }
    
    public void run(){
        while(vid.getVida()>0){
            vid.sumar(accion, "");
            System.out.println(Thread.currentThread().getName()+" acciona, "+accion+" de vida, "+
                     "ahora tiene "+vid.getVida());
        }
    }
    
}
