/*  |
 *  To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4_14;

import java.util.Random;
import java.util.concurrent.Semaphore;;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;


/**
 *
 * @author Santiago
 */
public class Confiteria{
    private Semaphore semMozo, semCocinero, semComer, semBeber;
    private ReentrantLock lockSillas;
    private int cantSillas;
    private boolean flag;
    public Confiteria(){
        cantSillas=2;
        lockSillas=new ReentrantLock();
        semMozo=new Semaphore(0);
        semCocinero=new Semaphore(0);
        semBeber=new Semaphore(0);
        semComer= new Semaphore(0);
        flag=true;
    }
    public boolean ocuparAsiento(String nombre){
        boolean flag=false;
        lockSillas.lock();
        if(cantSillas>0){
            flag=true;
            cantSillas--;
        }
        lockSillas.unlock();
        return flag;
    }
    public void liberarSilla(){
        lockSillas.lock();
        cantSillas++;
        lockSillas.unlock();
    }
    public void ordenarBebida(String nombre) throws InterruptedException{
        semMozo.release();
        semBeber.acquire();
        System.out.println(nombre+" recibió su bebida. Está tomando.\n");
        Thread.sleep(2000);
    }
    public void ordenarComida(String nombre) throws InterruptedException{
        semCocinero.release();
        semComer.acquire();
        System.out.println(nombre+" recibió su comida. Está comiendo.\n");
        Thread.sleep(2000);
    }
    public void atender(String nombre) throws InterruptedException{
        while(true){
            System.out.println(nombre+" está inventando nuevas recetas de pollo.\n");
            semMozo.acquire();
            System.out.println(nombre+" anotó el pedido del cliente.");
            System.out.println("Está buscando la bebida\n");
            Thread.sleep(3000);
            System.out.println("bebida está lista. "+nombre+" la está llevando a la mesa\n");
            Thread.sleep(1000);
            semBeber.release();
        }
    }
    public void cocinar(String nombre) throws InterruptedException{
        while(true){
            System.out.println(nombre+" está ordenando su cocina y probando nuevas recetas.\n");
            semCocinero.acquire();
            System.out.println(nombre+" recibió el pedido. Está cocinando.\n");
            Thread.sleep(4000);
            System.out.println(nombre+" terminó el pedido. Se lo lleva al cliente.\n");
            Thread.sleep(1000);
            semComer.release();
        }
    }
}
