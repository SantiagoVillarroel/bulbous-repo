/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Punto2;

public class Orco implements Runnable{
    Jugador jug;

    public Orco(Jugador jug) {
        this.jug = jug;
    }

    
    
    public void run(){
        int i=1;
        int cant= jug.getVida();
        jug.setVida(cant-3);
    }
}
