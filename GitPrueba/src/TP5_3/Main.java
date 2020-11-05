/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5_3;


/**
 *
 * @author Santiago
 */
public class Main {
    public static void main(String[] args){
        Estacion estacion= new Estacion(3);
        
        Thread[] pasajeros = new Thread[7];

        Thread tren=new Thread(new ControlTren(estacion)), vendedor=new Thread(new VendedorTickets("Vendedor",estacion));
        
        tren.start();
        vendedor.start();
        
        for(int i=0; i<7; i++){
            pasajeros[i]=new Thread(new Pasajero("Pasajero "+(i+1), estacion));
            pasajeros[i].start();
        }
    }   
}
