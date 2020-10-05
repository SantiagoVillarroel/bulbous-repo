/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teoria.BarberoDormilon;

import TP4.Punto6.*;
import TP3.Punto3.*;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Variable {
    private int valor;
    private Semaphore semA= new Semaphore(1);
    private Semaphore semB= new Semaphore(0);
    private Semaphore semC= new Semaphore(0);

    public Variable(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public void imprimirA(int veces){
        try {
            semA.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Variable.class.getName()).log(Level.SEVERE, null, ex);
        }
        imprimir("A",veces);
        semB.release();
    }
    
    public void imprimirB(int veces){
        try {
            semB.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Variable.class.getName()).log(Level.SEVERE, null, ex);
        }
        imprimir("B",veces);
        semC.release();
    }
    
    public void imprimirC(int veces){
        try {
            semC.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Variable.class.getName()).log(Level.SEVERE, null, ex);
        }
        imprimir("C",veces);
        semA.release();

}
    
    public void imprimir(String t, int cant){
        for(int i=1; i<= cant; i++){
        System.out.print(t);
        }
    }
           
    
}
