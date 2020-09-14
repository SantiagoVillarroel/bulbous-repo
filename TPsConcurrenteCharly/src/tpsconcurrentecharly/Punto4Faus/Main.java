/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpsconcurrentecharly.Punto4Faus;

import tpsconcurrentecharly.*;

/**
 *
 * @author Faustino
 */
public class Main {
    public static void main(String[]args){
        Thread[] autos= new Thread[5];
        Surtidor surt= new Surtidor();
        for(int i=0;i<=4;i++){
            autos[i]= new Thread(new Auto((i+1)*110,(i+1)*55,surt),"Auto "+i);
        }
        for(int i=0; i<=4;i++){
            autos[i].start();
        }
    }
}
