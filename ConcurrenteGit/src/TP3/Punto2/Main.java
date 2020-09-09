/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Punto2;

/**
 *
 * @author Faustino
 */
public class Main {
    public static void main(String[]args) throws InterruptedException{
        Vida v= new Vida();
        Personaje o= new Personaje(-3,"Orco",v);
        Personaje e= new Personaje(3,"Elfo",v);
        Thread orco= new Thread(o,"ORCO");
        Thread elfo= new Thread(e,"ELFO");
        orco.start();
        elfo.start();
        
        System.out.println("FIN");
    }
}
