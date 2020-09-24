/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teoria.BarberoDormilon;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Faustino
 */
public class Sillon {
    private  Semaphore semSillon= new Semaphore(1);
    private  Semaphore semSalida= new Semaphore(0);
    private  Semaphore semBarbero= new Semaphore(0);

    public Sillon() {
    }
    
    
    
    public void afeitar(String color) throws InterruptedException{
           System.out.println(color+Thread.currentThread().getName()+ " duerme...");
           semBarbero.acquire();
           System.out.println(color+Thread.currentThread().getName()+ " se despierta. Y empieza a cortar el pelo");
           Thread.sleep(2500);
           System.out.println(color+Thread.currentThread().getName()+ " termina de cortar el pelo.");
           semSalida.release();
    }
    
    public boolean serAtendido(String color) throws InterruptedException{
        
        boolean res=semSillon.tryAcquire();
        if(res){
            System.out.println(color+Thread.currentThread().getName()+ " llega a la barberìa.");
            semBarbero.release();
            System.out.println(color+Thread.currentThread().getName()+ " se sienta en el sillòn.");
            System.out.println(color+Thread.currentThread().getName()+ " es atendido.");
            semSalida.acquire();
            semSillon.release();
            System.out.println(color+Thread.currentThread().getName()+ " se va.");
    }else{
            System.out.println(color+Thread.currentThread().getName()+" no pudo ser atendido, se fue.");
        }
        return res;
            
    
}}