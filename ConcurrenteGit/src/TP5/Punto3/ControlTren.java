/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Punto3;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class ControlTren {

    private Semaphore venta= new Semaphore(0,true);
    private Semaphore asientos;
    private Semaphore subir= new Semaphore(1,true);
    private Semaphore atencion= new Semaphore(1,true), finRecorrido= new Semaphore(0,true);
    private Semaphore pasarAEsperar= new Semaphore(0,true);
    private int cant;
    public void comprarTicket(String color){
        try {
            System.out.println(color+"Cliente llega a la cabina de compra de tickets");
            atencion.acquire();
            venta.release();
            pasarAEsperar.acquire();
            atencion.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(ControlTren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ControlTren(int cant) {
        this.cant = cant;
        asientos= new Semaphore(0,true);
    }
    
    
    
    public void venderTicket(String color){
        try {
            System.out.println(color+"Cabinero no tiene clientes.");
            venta.acquire();
            System.out.println(color+"Vendedor atiende cliente.");
            Thread.sleep(2000);
            System.out.println(color+"Pasaje vendido.");
            pasarAEsperar.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(ControlTren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void subirseAlTren(String color){
        try {
            subir.acquire(1);
            System.out.println(color+"Pasajero sube al tren.");
            asientos.release(1);
            subir.release();
            finRecorrido.acquire(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControlTren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hacerpaseo(String color){
        try {
            System.out.println(color+"TREN ESPERA A LLENARSE.");
            asientos.acquire(this.cant);
            System.out.println(asientos.availablePermits());
            System.out.println(color+"~~~~~~~~~~~TREN LLENO.");
            subir.acquire();
            System.out.println(color+"---------------------------- TREN PASEANDO");
            Thread.sleep(20000);
            System.out.println(color+"++++++++++++++++LLEGA EL TREN.");
            finRecorrido.release(this.cant);
            subir.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(ControlTren.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
