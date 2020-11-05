/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teoria.BarberoDormilon;

/**
 *
 * @author Faustino
 */
public class Pila {

    private Object[] arreglo;
    private int tope;
    private static final int tamaño = 10;

    //Constructores
    public Pila() {
        this.arreglo = new Object[tamaño];
        this.tope = -1;
    }

    //Modificadores
    public boolean apilar(Object nuevo) {
        boolean exit;
        if (this.tope + 1 >= this.tamaño) {
            //Pila Llena
            exit = false;
        } else {
            this.tope++;
            this.arreglo[tope] = nuevo;
            exit = true;
        }
        return exit;
    }

    //Modificadores
    public boolean desapilar() {
        boolean exit;
        if (this.tope < 0) {
            //No hay nada
            exit = false;
        } else {
            this.arreglo[tope] = null;//Preguntar
            this.tope--;
            exit = true;
        }
        return exit;
    }

    public void vaciar() {
        for (int i = 0; i <= this.tope; i++) {
            this.arreglo[i] = null;

        }
        this.tope = -1;
    }

    //Observadores
    public Object obtenerTope() {
        Object o;
        if (this.tope == -1) {
            o = null;
        } else {
            o = this.arreglo[this.tope];
        }
        return o;
    }

    @Override
    public String toString() {
        String txt = "";
        for (int i = 0; i <= tope; i++) {
            txt = txt + "," + this.arreglo[i].toString();
        }
        return txt;
    }

    public boolean esVacia() {
        boolean res;
        res = this.tope == -1;
        return res;
    }

    //Propias del Tipo
    @Override
    public Pila clone() {
        Pila p = new Pila();
        p.tope = this.tope;
        p.arreglo = this.arreglo.clone();

        return p;

    }

    public boolean equals(Pila p) {
        boolean res = true;
        int i = 0;
        res = p.arreglo.length == this.arreglo.length;
        while (i <= p.tope && res) {
            if(this.arreglo[i] != null){
                res = this.arreglo[i].equals(p.arreglo[i]);
            } else {
                res = false;
            }
            i++;
        }

        return res;
    }

}
