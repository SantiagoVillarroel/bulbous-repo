/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4_11;


/**
 *
 * @author Santiago
 */
public class Cliente implements Runnable{
    private int[] carroCompras;
    private String nombre;
    private Turno turno;
    private Cajera cajera;
    public Cliente(String nombre, int[] carro, Turno turno, Cajera cajera){
        this.nombre=nombre;
        this.carroCompras=carro;
        this.turno=turno;
        this.cajera=cajera;
    }
    public void run(){
        turno.getTurno().lock(); //Adquiere lock -> procesa compra -> Libera lock
        cajera.procesarCompra(nombre, carroCompras); 
        turno.getTurno().unlock();
    }
}
