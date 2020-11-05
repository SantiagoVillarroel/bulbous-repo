/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Punto6;

public class Main {
    public static void main(String[]args) throws InterruptedException{
        int cant=6000;
        int[]nros= new int[cant];
        for(int i=0;i <= cant-1; i++){ //Creo arreglo de nros
            nros[i]= 1;//(int)(Math.random()*11);
        }
        Suma n= new Suma(0);
        Thread[] hilos= new Thread[cant/100];
        int j=0;
        for(int x=0; x<=(cant/100)-1;x++){ //Creo hilos 
            hilos[x]= new Thread(new ContadorArreglo(j,j+99,nros,n));
            j=j+100;
        }
        for(int x=0; x<=(cant/100)-1;x++){ //Corro hilos
            hilos[x].start();
        }
        
        for(int x=0; x<= (cant/100)-1; x++){
            hilos[x].join();
        }
        
        System.out.println("Suma: "+n.getValor());
        
        
    }
}
