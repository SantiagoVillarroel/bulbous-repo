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

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[]{2, 2, 1, 5,
            2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1, 3, 5, 1,
            1});
        long initialTime = System.currentTimeMillis();
        CajeraThread c1 = new CajeraThread("Cajera 1", cliente1, initialTime);
        CajeraThread c2 = new CajeraThread("Cajera2", cliente2, initialTime);
        Thread t1 = new Thread(c1, "Cajera 1");
        Thread t2 = new Thread(c2, "Cajera 2");
        t1.start();
        t2.start();
        CajeraThread[] cjs = new CajeraThread[6];
        for (int i = 0; i < 6; i++) {
            cjs[i] = new CajeraThread("Cajera" + i, new Cliente("Cliente " + i, new int[]{i + 1, (i + 1) * 2, i, 7 - i}), initialTime);
        }
        Thread[] misHilos = new Thread[6];
        for (int i = 0; i < 6; i++) {
            misHilos[i] = new Thread(cjs[i], "Cajera " + i);

        }

        for (int i = 0; i < 6; i++) {
            misHilos[i].start();
        }

        try {
            metodo1();
        } catch (ArithmeticException e) {
            System.out.println("Div 0");
        } finally {
            System.out.println("Finally 1");
        }
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
