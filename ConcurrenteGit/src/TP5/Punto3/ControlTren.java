/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Punto3;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import TP2.Punto6.Contador;

/**
 *
 * @author Faustino
 */
public class ControlTren {

    private Semaphore venta = new Semaphore(0, true);
    private Semaphore asientos;
    private Semaphore arrancar = new Semaphore(0, true);
    private Semaphore atencion = new Semaphore(1, true),
            finRecorrido = new Semaphore(0, true);
    private Semaphore pasarAEsperar = new Semaphore(0, true);
    private int cant;
    private Contador contador= new Contador();
    private Contador recorridos= new Contador();

    public void comprarTicket(String color) {
        try {
            System.out.println(color + "Cliente llega a la cabina de compra de tickets");
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
        asientos = new Semaphore(cant, true);
        recorridos.setI(1);
    }

    public void venderTicket(String color) {
        try {
            System.out.println(color + "Cabinero no tiene clientes.");
            venta.acquire();
            System.out.println(color + "Vendedor atiende cliente.");
            Thread.sleep(2000);
            System.out.println(color + "Pasaje vendido.");
            pasarAEsperar.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(ControlTren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void subirseAlTren(String color){
        try {
            asientos.acquire();
            System.out.println(color+" pasajero sube al tren.");
            contador.sumar();
            if(contador.getI()==this.cant){
                arrancar.release();
                contador.setI(0);
            }
            finRecorrido.acquire();
            asientos.release();
            System.out.println(color+" pasajero se baja del tren");
        } catch (InterruptedException ex) {
            Logger.getLogger(ControlTren.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void hacerRecorrido(String color){
        try {
            System.out.println(color+" Tren espera a llenarse");
            arrancar.acquire();
            System.out.println(color+ "Tren comienza recorrido numero "+this.recorridos.getI());
            Thread.sleep(20000);
            System.out.println(color+" Tren termina recorrido numero "+this.recorridos.getI());
            finRecorrido.release(this.cant);
            recorridos.sumar();
        } catch (InterruptedException ex) {
            Logger.getLogger(ControlTren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}