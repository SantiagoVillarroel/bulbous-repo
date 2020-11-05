/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5_3;


import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class Estacion {
    private Semaphore semTren, semComprarPasaje, semVendedor, semArrancar, semTicketListo, semAsientos;
    private ReentrantLock lockAsientos;
    private int cantAsientosTren;
    final private int asientos;
    public Estacion(int cantAsientos){
        semTren = new Semaphore(0);
        semComprarPasaje = new Semaphore(1, true); //True para simular cola
        semVendedor = new Semaphore(0); //Inicializo todos los Sem
        semTicketListo= new Semaphore(0);
        cantAsientosTren=cantAsientos; //Variable que cuenta ASIENTOS LIBRES
        asientos=cantAsientos; //Constante (se utiliza en liberarAsiento())
        semAsientos = new Semaphore(cantAsientos); //GENÉRICO
        semArrancar = new Semaphore(0);
        lockAsientos = new ReentrantLock();
    }
    public void parar() throws InterruptedException{
        System.out.println("Tren llegó a destino.");
        semTren.release(asientos); //release() para que se baje el primer pasajero.
    }
    public void arrancar() throws InterruptedException{
        semArrancar.acquire(); //Espera el release() del último ocuparAsiento()
        System.out.println("Tren está lleno. Tren está en marcha");
        Thread.sleep(5000);
        parar();
    }
    
    public void comprarPasaje(String nombre) throws InterruptedException{
        System.out.println(nombre+"está haciendo la cola para comprar un pasaje.\n");
        semComprarPasaje.acquire();
        semVendedor.release(); //release() para que venderPasaje() siga con su ejecución.
        System.out.println(nombre+" está comprando un pasaje.\n");
        semTicketListo.acquire(); //Espera el release() ejecutado por venderPasaje()
        semComprarPasaje.release();
    }
    public void bajarDeTren(String nombre) throws InterruptedException{
        semTren.acquire(); //Espera el release() de parar() o del pasajero anterior.
        liberarAsiento();
        System.out.println(nombre+" se bajó del tren.");
    }
    public boolean ocuparAsiento() throws InterruptedException{
        boolean flag=false;
        this.semAsientos.acquire();
        this.lockAsientos.lock();
        this.cantAsientosTren--; //Resto 1 a ASIENTOS DISPONIBLES
        this.lockAsientos.unlock();
        flag=true;
        if(this.cantAsientosTren==0){ //Si es el último pasajero en subirse
            semArrancar.release(); //release() para que arrancar() siga con su ejecución.            
        }
        return flag;
    }
    public void liberarAsiento() throws InterruptedException{
        this.semAsientos.release();
        this.lockAsientos.lock();
        this.cantAsientosTren++;
        this.lockAsientos.unlock();
    }
    public void venderPasaje() throws InterruptedException{
        System.out.println("Vendedor está en la caja esperando a que llegue un cliente.\n");
        semVendedor.acquire();
        System.out.println("Vendedor está vendiendo un pasaje\n");
        Thread.sleep(1000);
        semTicketListo.release();
    }
}
