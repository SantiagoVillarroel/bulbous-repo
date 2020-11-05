/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2.Punto6;

/**
 *
 * @author Faustino
 */
public class Donacion {
    private double valor;

    public Donacion() {
        this.valor=0;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public synchronized void sumar(double s){
        this.valor=this.valor+s;
    }
    
}
