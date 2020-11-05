/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto14;

/**
 *
 * @author Faustino
 */
public class Cocinero extends Persona implements Runnable{

    public Cocinero(String nombre, ConfiteriaPequeña confi, String color) {
        super(nombre, confi, color);
    }
    public void run(){
        this.confi.llevarComidaAEmpleado(color);
    }
    
}
