/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maggioni_FAI2705.Punto2;

/**
 *
 * @author Faustino
 */
public class Cruce {
    public static void main (String[]args){
        GestorCruce gc= new GestorCruce();
        Auto[]autos= new Auto[4];
        for(int i=0;i<=3;i++){
            autos[i]= new Auto(gc);
        }
        
        Thread[]hilos=new Thread[5];
        for(int i=0;i<=3;i++){
            hilos[i]=new Thread(autos[i],"Auto "+i);
        }
        hilos[4]= new Thread(new HiloControl(gc));
        for(int i=0;i<=4;i++){
            hilos[i].start();
        }
    }
}
