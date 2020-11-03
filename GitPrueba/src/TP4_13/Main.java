/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4_13;

/**
 *
 * @author Santiago
 */
public class Main {
    public static void main(String[] args) {
        Confiteria conf = new Confiteria();
        
        Thread[] empleados = new Thread[6];
        Thread mozo = new Thread(new Mozo("Mozo", conf));
        
        mozo.start();
        
        for(int i=0; i<6; i++){
            empleados[i]=new Thread(new Empleado("Empleado "+(i+1), conf));
            empleados[i].start();
        }
    }
}
