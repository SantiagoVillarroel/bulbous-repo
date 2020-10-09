/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4_12;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Santiago
 */
public class Turno {
    private ReentrantLock[] arr;
    public Turno(){
        arr=new ReentrantLock[3];
        for(int i=0; i<3; i++){ //Inicializo array de Locks
            arr[i]=new ReentrantLock();
        }
    }
    public ReentrantLock getHamaca(){
        return this.arr[0];
    }
    public ReentrantLock getRueda(){
        return this.arr[1];
    }
    public ReentrantLock getPlato(){
        return this.arr[2];
    }
}
