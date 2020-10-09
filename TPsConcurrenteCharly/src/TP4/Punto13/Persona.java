/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto13;

public class Persona {
    String nombre;
    ConfiteriaPequeña confi;
    String color;

    public Persona(String nombre, ConfiteriaPequeña confi, String color) {
        this.nombre = nombre;
        this.confi = confi;
        this.color = color;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
