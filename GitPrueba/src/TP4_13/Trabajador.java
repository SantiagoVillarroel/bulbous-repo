/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4_13;

/**
 *
 * @author Santiago
 */
public class Trabajador { //Clase padre de Empleado y Mozo
    protected Confiteria confiteria;
    protected String nombre;
    public Trabajador(String nombre, Confiteria conf){
        this.nombre=nombre;
        this.confiteria=conf;
    }
}
