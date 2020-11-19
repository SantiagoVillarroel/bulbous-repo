/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6_7;

import ProdCons.Cola;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Santiago
 */
public class Mostrador {
    private Cola tortas = new Cola();
    private ReentrantLock accesoTorta, accesoCaja;
    private Condition hayTorta, hayCaja;
    private double maxPesoCaja, pesoActual=0;
    private boolean reponerCaja, cajaLista;
    public Mostrador(double maxPesoCaja){
        accesoTorta = new ReentrantLock(true);
        accesoCaja = new ReentrantLock(true);
        hayTorta = accesoTorta.newCondition();
        hayCaja = accesoCaja.newCondition();
        this.maxPesoCaja=maxPesoCaja;
        this.reponerCaja=false;
        this.cajaLista=false;
    }
    public void hornearTorta(double peso){
        this.accesoTorta.lock();
        tortas.poner(peso); //Pongo en cola un elemento (peso de la torta horneada)
        System.out.println("Torta se dejó en el mostrador");
        hayTorta.signalAll(); //signal para los robots que quedaron en wait porque no había tortas
        this.accesoTorta.unlock();
    }
    public void ponerCaja() throws InterruptedException{
        this.accesoCaja.lock();
        while(!reponerCaja){ //Si no hay caja disponible
            hayCaja.await();
        }
        System.out.println("Brazo está reponiendo caja");
        Thread.sleep(500);
        System.out.println("Se repuso caja");
        reponerCaja=false;
        cajaLista=false;
        hayCaja.signalAll(); //signal para los robots que quedaron en wait porque no habpia caja
        this.accesoCaja.unlock();
    }
    public void retirarCaja() throws InterruptedException{
        this.accesoCaja.lock();
        while(!cajaLista){ //Si la caja todavía está siendo llenada
            hayCaja.await();
        }
        System.out.println("Brazo ha retirado caja");
        reponerCaja=true;
        this.accesoCaja.unlock();
    }
    public double tomarPastel() throws InterruptedException{
        double peso;
        this.accesoTorta.lock();
        while(tortas.obtenerFrente()==null){
            hayTorta.await();
        }
        peso=(double)tortas.obtenerFrente();
        tortas.sacar();
        System.out.println("Robot está tomando un pastel (PESO: "+peso+")");
        Thread.sleep(500);
        this.accesoTorta.unlock();
        return peso;
    }
    public void soltarPastel(double peso) throws InterruptedException{
        this.accesoCaja.lock();
        while(reponerCaja || cajaLista){ //Si no hay caja o la caja está llena
            hayCaja.await();
        }
        if((pesoActual+peso)<=this.maxPesoCaja){
            System.out.println("Robot puso pastel (PESO: "+peso+") en caja");
            this.pesoActual=pesoActual+peso;
            System.out.println("PESO ACTUAL: "+pesoActual);
        }else{
            System.out.println("Caja no tiene espacio. Se despacha");
            cajaLista=true;
            this.pesoActual=0;
            hayCaja.signalAll(); //signal para que el brazo que quedó en wait reponga la caja
        }
        this.accesoCaja.unlock();
    }
}
