/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPSinc3;

/**
 *
 * @author Santiago
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        String[] cadenas = {"A", "BB", "CCC"};
        Hilo[] hilos= new Hilo[3];
        Thread[] threads= new Thread[3];
        Variable cont = new Variable(0);
        for(int i=0; i<3; i++){
            hilos[i]=new Hilo(cont, cadenas[i], i);
            threads[i]=new Thread(hilos[i], "Hilo "+(i+1));
            threads[i].start();
        }
        
    }
}
