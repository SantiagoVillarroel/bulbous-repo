/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6_7;

/**
 *
 * @author Santiago
 */
public class Main {
    public static void main(String[] args){
        Mostrador mostrador = new Mostrador(5);
        
        Thread horno = new Thread(new Horno(1, 2, 3, mostrador));
        Thread brazo = new Thread(new Brazo(mostrador));
        Thread robot = new Thread(new Empaquetador(mostrador));
        
        horno.start();
        brazo.start();
        robot.start();
    }
}
