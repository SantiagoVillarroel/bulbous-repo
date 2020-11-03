/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL1_TEMA1;

/**
 *
 * @author Santiago
 */
public class Animal { //
    protected String nombre;
    protected char especie;
    protected Comedor comedor;
    public Animal(String nombre, char especie, Comedor com){
        this.nombre=nombre;
        this.especie=especie;
        this.comedor=com;
    }
}
