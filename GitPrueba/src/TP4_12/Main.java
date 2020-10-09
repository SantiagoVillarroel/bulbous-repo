/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4_12;

/**
 *
 * @author Santiago
 */
public class Main {
    public static void main(String[] args) {
        Thread[] hamsters=new Thread[5];
        Turno turno = new Turno();
        for(int i=0; i<5; i++){
            hamsters[i]=new Thread(new Hamster("Hamster "+(i+1), turno));
            hamsters[i].start();
        }
    }
}
