/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2.Punto6;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CajeraThread {

    private String nombre;
    private double initialTime;
    private Donacion don;
    private ReentrantLock rlock;
    private Contador cant;
// Constructor, y métodos de acceso

    public void atender(Cliente cliente,boolean t) {
        cant.sumar();
        if(!t)
        rlock.lock();
        try {
            int precioTotal=0;
            System.out.println("La cajera " + this.nombre
                    + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                    + cliente.getNombre() + " EN EL TIEMPO: "
                    + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
            this.atenderCliente(precioTotal,cliente);
            
        } finally {
            rlock.unlock();
        }
        cant.restar();
    }
    public boolean disponibilidad(){
        return rlock.tryLock();
    }
    
    public int getCant(){
        return this.cant.getI();
    }
    private void atenderCliente(int precioTotal,Cliente cliente){
            for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            try {
                this.esperarXsegundos(cliente.getCarroCompra()[i].getTiempo());
                System.out.println("Procesado el producto " + (i + 1) + "del cliente " 
               + cliente.getNombre() + "->Tiempo: " + (System.currentTimeMillis()
                       - this.initialTime) / 1000 + "seg");
                precioTotal=precioTotal+cliente.getCarroCompra()[i].getPrecio();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(CajeraThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            System.out.println("La cajera" + this.nombre + "HA TERMINADO DE PROCESAR " + cliente.getNombre() + " EN EL TIEMPO: "
                    + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg. Fue una compra por: "+precioTotal);
            don.sumar((double)precioTotal/100);
}
    public CajeraThread(String nombre,double initialTime, Donacion d) {
        this.nombre = nombre;
        this.initialTime = initialTime;
        this.don=d;
        cant= new Contador();
        this.rlock= new ReentrantLock(true);
    }

    public static void esperarXsegundos(int i) throws InterruptedException {
        Thread.sleep(i * 10);
    }
}
