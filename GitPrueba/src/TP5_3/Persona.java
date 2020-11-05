/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5_3;



/**
 *
 * @author Santiago
 */
public class Persona {
    protected String nombre;
    protected Estacion estacion;
    public Persona(String nombre, Estacion est){
        this.nombre=nombre;
        this.estacion=est;
    }
}
