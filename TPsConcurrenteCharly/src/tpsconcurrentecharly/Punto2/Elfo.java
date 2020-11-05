/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpsconcurrentecharly.Punto2;

/**
 *
 * @author Faustino
 */
public class Elfo implements Runnable {
    Jugador jug;

    public Elfo(Jugador jug) {
        this.jug = jug;
    }

    
    
    public void run(){
        int i=1;
        int cant= jug.getVida();
        jug.setVida(cant+3);
        }
    }

