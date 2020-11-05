/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2;

class ThreadTesting {

    public static void main(String[] args) throws InterruptedException {
        /*Thread miHilo = new MiEjecucion();
        miHilo.start();
        miHilo.join();
        System.out.println("En el main");*/
        MiEjecucion mi= new MiEjecucion();
        Thread miHilo= new Thread(mi);
        miHilo.start();
        System.out.println("En el main");
    }
}
