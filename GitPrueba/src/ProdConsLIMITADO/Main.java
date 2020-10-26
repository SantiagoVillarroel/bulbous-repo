/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProdConsLIMITADO;

import ProdCons.*;

/**
 *
 * @author Santiago
 */
public class Main {
    public static void main(String[] args){
        Buffer buffer = new Buffer(10);
        
        Thread[] productores = new Thread[15];
        Thread[] consumidores = new Thread[50];
        
        for(int i=0; i<50; i++){
            consumidores[i] = new Thread(new Consumidor(buffer, "cons"+(i+1)));
            consumidores[i].start();
            if(i<15){
                productores[i] = new Thread(new Productor(buffer, "prod"+(i+1)));
                productores[i].start();
            }
        }
    }
}
