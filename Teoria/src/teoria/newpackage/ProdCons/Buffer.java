/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teoria.newpackage.ProdCons;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Santiago
 */
public class Buffer { //BUFFER ILIMITADO
    private Cola cola;
    private Semaphore mutex;
    public Buffer(){
        this.cola=new Cola();
        mutex = new Semaphore(1, true);
    }
    public boolean consumir() throws InterruptedException{
        boolean flag;
        mutex.acquire();
        Thread.sleep(1000);
        flag = this.cola.sacar();
        mutex.release();
        return flag;
    }
    public void producir(int num) throws InterruptedException{
        mutex.acquire(); //num es RANDOM //Determina la cantidad de elementos que produce
        for(int i=0; i<num; i++){
            Thread.sleep(1000);
            this.cola.poner(new Producto());
        }
        mutex.release();
    }
}
