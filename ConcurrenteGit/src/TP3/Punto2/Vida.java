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
class Vida {
    int vida=10;

    public Vida() {
        
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public void restar(int menos){
        this.vida=this.vida-menos;
    }
    
    public synchronized void sumar(int mas, String nombre){
        this.vida=this.vida+(mas);
    }
}
