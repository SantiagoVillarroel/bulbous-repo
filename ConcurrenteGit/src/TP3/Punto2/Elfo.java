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
public class Elfo implements Runnable {
    Vida vida;

    public Elfo(Vida vida) {
        this.vida = vida;
    }
    
    public void run(){
        while(vida.getVida()>0){
            vida.sumar(3,"ELFO");
            System.out.println("get vida elfo: "+vida.getVida());
        }
    }
}
