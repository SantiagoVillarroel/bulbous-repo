/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4_11;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Santiago
 */
public class Turno {
    ReentrantLock lock;
    public Turno(){
        lock=new ReentrantLock();
    }
    public ReentrantLock getTurno(){
        return this.lock;
    }
}
