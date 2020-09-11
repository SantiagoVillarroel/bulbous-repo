/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Punto6;

public class Main {
    public static void main(String[]args){
        int[]nros= new int[5000];
        for(int i=0;i <= 4999; i++){
            nros[i]= (int)(Math.random()*11);
        }
        Suma n= new Suma(0);
        Thread[] hilos= new Thread[50];
        int j=0;
        for(int x=0; x<=49;x++){
            hilos[x]= new Thread(new ContadorArreglo(j,j+100,nros,n));
            j++;
        }
        for(int x=0; x<=49;x++){
            hilos[x].start();
        }
        
        System.out.println("Suma: "+n.getValor());
        
        
    }
}
