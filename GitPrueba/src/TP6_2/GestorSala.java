/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6_2;

import java.util.Random;

/**
 *
 * @author Santiago
 */
public class GestorSala {
    private Random r;
    private int maxPersonas, personasUmbral, cantPersonas=0, limiteActual, tUmbral, tempActual;
    private boolean umbral=false, jubiladoEspera=false;
    public GestorSala(int max, int lim, int t){
        this.maxPersonas=max;
        this.personasUmbral=lim;
        this.tUmbral=t;
        this.tempActual=22;
        this.limiteActual=max;
    }
    public synchronized void entrarSala(String nombre) throws InterruptedException{
        while(cantPersonas > limiteActual || jubiladoEspera){
            System.out.println(nombre+" NO PUDO ENTRAR. ESPERA");
            this.wait();
        }
        System.out.println(nombre+" ENTRÓ AL MUSEO");
        this.cantPersonas++;
    }
    public synchronized void entrarSalaJubilado(String nombre) throws InterruptedException{
        this.jubiladoEspera=true;
        while(cantPersonas > limiteActual){
            System.out.println(nombre+" NO PUDO ENTRAR. ESPERA");
            this.wait();
        }
        System.out.println(nombre +" ENTRÓ AL MUSEO");
        this.jubiladoEspera=false;
        this.cantPersonas++;
    }
    public synchronized void salirSala(String nombre){
        this.cantPersonas--;
        System.out.println(nombre + " DEJÓ EL MUSEO");
        this.notifyAll();
    }
    public void notifTemp(){
        if(this.tempActual>this.tUmbral){
            umbral=true;
            limiteActual=personasUmbral;
        }else{
            umbral=false;
            limiteActual=maxPersonas;
        }
    }
    public void actualizarTemp(){
        tempActual=tempActual+(r.nextInt(10)-5);
    }
}
