/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto8;

/**
 *
 * @author Faustino
 */
public class Corredor implements Runnable {
    private int num;
    private Testigo test;
    private float tiempoI;

    public Corredor(int num, Testigo t) {
        this.num = num;
        this.test=t;
    }
    
    public void run(){
        double tiempo= 9 + Math.random()*2;
        switch(num){
            case 1:
                test.correUno(tiempo);
                break;
            case 2:
                test.correDos(tiempo);
                break;
            case 3:
                test.correTres(tiempo);
                break;
            case 4:
                test.correCuatro(tiempo);
                break;
            default:
                System.out.println("Numero no válido.");
        }
    }
    
}
