/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Punto6;

/**
 *
 * @author Faustino
 */
public class ContadorArreglo implements Runnable {
    private int indiceInf;
    private int indiceSup;
    private int[] nros;
    private Suma suma;

    public ContadorArreglo(int indiceInf, int indiceSup, int[] nros, Suma s) {
        this.indiceInf = indiceInf;
        this.indiceSup = indiceSup;
        this.nros = nros;
        this.suma=s;
    }

   
    
    public void run(){
        int sumaAux=0;
        for(int i=indiceInf; i<=indiceSup; i++){
            sumaAux=sumaAux+nros[i];
        }
        this.suma.sumar(sumaAux);
    }
}
