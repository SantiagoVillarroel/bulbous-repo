/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4_8;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Santiago
 */
public class Testigo {
    private Semaphore sem;
    public Testigo(){
        this.sem=new Semaphore(1);
    }
    public Semaphore getSem(){
        return this.sem;
    }
}
