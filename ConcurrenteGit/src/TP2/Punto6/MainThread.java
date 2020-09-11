/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2.Punto6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipException;

/**
 *
 * @author Faustino
 */
public class MainThread {

    public static void main(String[] args) throws InterruptedException {
        Cliente[] clientes= new Cliente[6];
        Donacion don= new Donacion();
        for(int i=0;i<=5;i++){
            clientes[i]= new Cliente("Cliente "+i, new Producto[]{new Producto(4,(i+3)*2),new Producto(4,11),new Producto(4,(i+2)*6)});
        }
       
        long initialTime = System.currentTimeMillis();
        CajeraThread[] cjs= new CajeraThread[6];
        for(int i=0;i <=5; i++){
            cjs[i]= new CajeraThread("Cajera "+i,clientes[i],initialTime,don);
        }
        Thread[] misHilos = new Thread[6];
        for(int i=0;i<6;i++){
            misHilos[i]= new Thread(cjs[i],"Cajera "+i);
        }

        for (int i = 0; i < 6; i++) {
            misHilos[i].start();
        }
        for (int i = 0; i < 6; i++) {
            misHilos[i].join();
        }
        System.out.println("Donacion: "+don.getValor());

        
    }

    public static void metodo1() {
        try {
            metodo2();
        } catch (NullPointerException a) {
            System.out.println("catch 1");
        } finally {
            System.out.println("Finally 2");
        }
    }

    public static void metodo2() {
        try {
            System.out.println(3 / 0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("catch 2");
        } finally {
            System.out.println("Finally 3");
        }
    }

}
