/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto6;

import TP3.Punto3.*;

/**
 *
 * @author Faustino
 */
public class ABC {
    public static void main(String[]args){
        Variable i= new Variable(5);
        ClaseA a= new ClaseA(i,1);
        ClaseB b= new ClaseB(i,2);
        ClaseC c= new ClaseC(i,3);
        Thread[] ts= new Thread[3];
        ts[0]= new Thread(a);
        ts[1]= new Thread(b);
        ts[2]= new Thread(c);
        for(int x=0;x<=2;x++){
            ts[x].start();
        }
    }
}
