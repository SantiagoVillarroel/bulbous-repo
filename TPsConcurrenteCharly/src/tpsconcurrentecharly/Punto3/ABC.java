/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpsconcurrentecharly.Punto3;

/**
 *
 * @author Faustino
 */
public class ABC {
    public static void main(String[]args){
        Variable i= new Variable(0);
        ClaseA a= new ClaseA(i);
        ClaseB b= new ClaseB(i);
        ClaseC c= new ClaseC(i);
        Thread[] ts= new Thread[3];
        ts[0]= new Thread(a);
        ts[1]= new Thread(b);
        ts[2]= new Thread(c);
        for(int x=0;x<=2;x++){
            ts[x].start();
        }
    }
}
