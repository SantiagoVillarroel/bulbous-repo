/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProdCons;

/**
 *
 * @author Santiago
 */
public class Main {
    public static void main(String[] args){
        Buffer buffer = new Buffer();
        
        Thread[] productores = new Thread[30];
        Thread[] consumidores = new Thread[100];
        
        for(int i=0; i<100; i++){
            consumidores[i] = new Thread(new Consumidor(buffer, "cons"+(i+1)));
            consumidores[i].start();
            if(i<30){
                productores[i] = new Thread(new Productor(buffer, "prod"+(i+1)));
                productores[i].start();
            }
        }
    }
}
