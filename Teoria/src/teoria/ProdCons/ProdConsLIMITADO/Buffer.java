/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teoria.ProdCons.ProdConsLIMITADO;

import ProdCons.*;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Santiago
 */
public class Buffer { //Buffer LIMITADO
    private Cola cola;
    private Semaphore mutex, cant;
    public Buffer(int num){
        this.cola=new Cola();
        mutex = new Semaphore(1, true);
        cant = new Semaphore(num, true);
    }
    public boolean consumir() throws InterruptedException{
        boolean flag;
        mutex.acquire();
        Thread.sleep(1000);
        flag =this.cola.sacar(); //Si hay un elemento para consumir -> libero permiso
        if(flag){
            cant.release();
        }
        mutex.release();
        return flag;
    }
    public boolean producir(String nombre) throws InterruptedException{
        boolean flag;
        mutex.acquire();
        System.out.println(nombre+" quiere producir ");
        flag=(cant.tryAcquire()); //Intenta adquirir num cantidad de permisos (adquirir num permisos)
        if(flag){ 
                this.cola.poner(new Producto());
        }
        mutex.release();
        return flag;
    }
}
