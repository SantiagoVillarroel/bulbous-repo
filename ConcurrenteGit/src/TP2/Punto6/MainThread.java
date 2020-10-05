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
        Thread[]hilos= new Thread[6];
        Donacion don= new Donacion();
        CajeraThread[] cj= new CajeraThread[2];
        double initialTime = System.currentTimeMillis();
        cj[0]= new CajeraThread("Sofia",initialTime,don);
        cj[1]= new CajeraThread("Faustino",initialTime,don);
        Atencion at= new Atencion(cj);
        for(int i=0; i<=clientes.length-1;i++){
            Producto[]aux= new Producto[i+1];
            for(int j=0;j<=i;j++){
                aux[j]= new Producto(j+100, (j+1)*80);
            }
            hilos[i]= new Thread(new Cliente("Cliente "+i,aux,at));
        }
        for(int i=0; i<=hilos.length-1;i++){
            Thread.sleep(200);
            hilos[i].start();
        }
        for(int i=0; i<=hilos.length-1;i++){
            hilos[i].join();
        }
        System.out.println("tiempo "+(System.currentTimeMillis()-initialTime)/1000);
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
