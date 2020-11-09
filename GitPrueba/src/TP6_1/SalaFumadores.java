/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6_1;

/**
 *
 * @author Santiago
 */
public class SalaFumadores {
    private int ingredienteFaltante;
    private boolean rellenar=true;
    public synchronized void colocar(int r) throws InterruptedException{
        while(!rellenar){
            this.wait();
        }
        System.out.println("AGENTE COLOCA INGREDIENTES");
        this.ingredienteFaltante=r;
        this.rellenar=false;
        this.notifyAll();
    }
    public synchronized void entraAFumar(int id) throws InterruptedException{
        while(this.ingredienteFaltante != id || this.rellenar){
            System.out.println("Fumador " +id+ " espera");
            this.wait();
        }
        System.out.println("Fumador "+id+" empieza a fumar");
    }
    public synchronized void terminaDeFumar(int id){
        System.out.println("Fumador "+id+" terminó de fumar");
        this.rellenar=true;
        this.notifyAll();
    }
}