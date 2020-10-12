/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4_14;


/**
 *
 * @author Santiago
 */
public class Trabajador {
    protected Confiteria confiteria;
    protected String nombre;
    public Trabajador(String nombre, Confiteria conf){
        this.nombre=nombre;
        this.confiteria=conf;
    }
    protected Confiteria getConf(){
        return this.confiteria;
    }
}
