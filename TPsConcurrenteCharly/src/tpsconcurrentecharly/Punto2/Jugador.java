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
class Jugador {
    private int vida=10;

    public Jugador() {
    }
    
    public synchronized int getVida() {
        return vida;
    }
     
    public synchronized void setVida(int vida) {
        this.vida = vida;
    }
    
    public void recibeAtaque(int menos){
        this.vida=this.vida-menos;
    }
    
    public synchronized void recibeCura(int mas){
        this.vida=this.vida+(mas);
    }
}
