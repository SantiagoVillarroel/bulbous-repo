/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2;

public class Cliente implements Runnable {
    
    public void run() {
        System.out.println("soy" + Thread.currentThread().getName());
        Recurso.uso();
        try {
            Thread.sleep(2000);
            System.out.println("aa"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
        };

}}
