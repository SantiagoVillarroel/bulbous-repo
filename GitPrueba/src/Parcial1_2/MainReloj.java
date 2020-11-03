/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial1_2;

/**
 *
 * @author Santiago
 */
public class MainReloj {

    public static void main(String[] args) {
        Reloj reloj = new Reloj(5); //Creo reloj con 5 (cantidad de hilos durmientes)
        Thread controlReloj = new Thread(new ControlReloj(reloj)); //Creo hilo control

        Thread[] durmientes = new Thread[5]; //Creo arreglo de hilos durmientes.
        
        controlReloj.start(); //Ejecuto hilo control

        for (int i = 0; i < 5; i++) {
            durmientes[i]=new Thread(new Durmiente("Durmiente "+(i+1), reloj, (i+1)*5)); //Creo hilos durmientes y ejecuto
            durmientes[i].start();
        }
    }
}
