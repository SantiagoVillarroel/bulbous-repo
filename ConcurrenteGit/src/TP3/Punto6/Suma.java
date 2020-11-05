/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Punto6;

/**
 *
 * @author Faustino
 */
public class Suma {
    private int valor;

    public Suma(int valor) {
        this.valor = valor;
    }
    public synchronized void sumar(int valor){
        this.valor=this.valor+valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
