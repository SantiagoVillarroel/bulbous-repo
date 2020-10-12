/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4_14;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class Empleado extends Trabajador implements Runnable {

    public Empleado(String nombre, Confiteria conf) {
        super(nombre, conf);
    }

    public void ordenar() throws InterruptedException {
        Random random = new Random();
        int orden = random.nextInt(3);
        System.out.println(nombre+" eligió OPCIÓN "+orden);
        switch (orden) {
            case 0: //Solo bebida
                this.getConf().ordenarBebida(nombre);
                break;
            case 1: //Solo comida
                this.getConf().ordenarComida(nombre);
                break;
            case 2: //Bebida y comida
                this.getConf().ordenarBebida(nombre);
                this.getConf().ordenarComida(nombre);
                break;
        }
    }
    public void run() {
        boolean flag = true;
        while (flag) {
            try {
                if (this.confiteria.ocuparAsiento(nombre)) {
                    flag = false;
                    System.out.println(nombre + " ocupó el asiento.");
                    System.out.println(nombre + " está eligiendo del menú...\n");
                    Thread.sleep(3000);
                    System.out.println(nombre + " ya eligió y ordenó. Está esperando su pedido\n");                    
                    ordenar();
                    System.out.println(nombre+" está satisfecho. Se retira\n");
                    this.getConf().liberarSilla();
                } else {
                    System.out.println("Asientos ocupados. " + nombre + " intentará más tarde\n");
                    Thread.sleep(7000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
