/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6_1;

import java.util.Random;

/**
 *
 * @author Santiago
 */
public class Main {
    public static void main(String[] args){
        SalaFumadores sala = new SalaFumadores();
        
        Agente ag = new Agente(sala);
        
        Thread[] fumadores = new Thread[3];
        Thread agente = new Thread(ag);
        agente.start();
        
        for(int i=0; i<3; i++){
            fumadores[i] = new Thread(new Fumador((i+1), sala));
            fumadores[i].start();
        }
        
    }
}
