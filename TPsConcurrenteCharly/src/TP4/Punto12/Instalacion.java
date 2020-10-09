/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto12;

import java.util.concurrent.locks.ReentrantLock;
import TP2.Punto6.Contador;
/**
 *
 * @author Faustino
 */
public class Instalacion {
    private int segs;
    private String nombre;
    private Contador cuenta;
    private ReentrantLock rlock= new ReentrantLock(true);
    public Instalacion(int segs,String nombre) {
        this.segs = segs;
        cuenta= new Contador();
        this.nombre=nombre;
    }
    public void usar(String color) throws InterruptedException{
        System.out.println(color+Thread.currentThread().getName()+" quiere usar "+color+nombre);
        cuenta.sumar();
        rlock.lock();
        try {
            System.out.println(color+Thread.currentThread().getName()+" usando "+color+nombre);
            Thread.sleep(segs*1000);
        } finally {
            rlock.unlock();
            cuenta.restar();
        }
        System.out.println(color+Thread.currentThread().getName()+" libera "+color+nombre);
    }
    public boolean disponibilidad(){
        return cuenta.getI()==0;
    }

    public int getSegs() {
        return segs;
    }
    public int getCant(){
        return cuenta.getI();
    }
    public void setSegs(int segs) {
        this.segs = segs;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Contador getCuenta() {
        return cuenta;
    }

    public void setCuenta(Contador cuenta) {
        this.cuenta = cuenta;
    }

    public ReentrantLock getRlock() {
        return rlock;
    }

    public void setRlock(ReentrantLock rlock) {
        this.rlock = rlock;
    }
    
}
