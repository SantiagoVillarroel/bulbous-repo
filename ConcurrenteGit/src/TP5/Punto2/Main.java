/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Punto2;


/**
 *
 * @author Faustino
 */
public class Main {

    public static void main(String[] args) {
        int cantgatos = 5, cantperros = 7;
        Thread[] gatos = new Thread[cantgatos];
        Thread[] perros = new Thread[cantperros];
        Comedor com = new Comedor(4);
        AdminComedor ac = new AdminComedor(com, cantgatos, cantperros);
        int max = Math.max(cantgatos, cantperros);
        for (int i = 0; i <= max - 1; i++) {
            if (i <= cantgatos - 1) {
                gatos[i] = new Thread(new Gato(ac));
            }
            if (i <= cantperros - 1) {
                perros[i] = new Thread(new Perro(ac));
            }
        }

        for (int i = 0; i <= max - 1; i++) {
            if (i <= cantgatos - 1) {
                gatos[i].start();
            }
            if (i <= cantperros - 1) {
                perros[i].start();
            }
        }

    }
}
