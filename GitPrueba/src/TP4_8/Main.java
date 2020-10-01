/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4_8;

/**
 *
 * @author Santiago
 */
public class Main {
    public static void main(String[] args){
        Testigo testigo = new Testigo();
        
        Thread[] atletas = new Thread[4];
        for(int i=0; i<4; i++){
            atletas[i]=new Thread(new Atleta((i+1), testigo), "Atleta "+(i+1));
            atletas[i].start();
        }
    }
}
