/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teoria.BarberoDormilon;

import TP4.Punto7.Cola;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Barberia {

    private Semaphore semSillon = new Semaphore(1, true);
    private Semaphore semSalida = new Semaphore(0, true);
    private Semaphore semBarbero;
    private Semaphore semSillas = new Semaphore(1,true);
    private CantSillas csillas;

    public Barberia() {
        csillas= new CantSillas(2);
        this.semBarbero = new Semaphore(0, true);
    }
    
    public void afeitar(String color) throws InterruptedException {
        System.out.println(color + Thread.currentThread().getName() + " ------- ZZZ duerme...");
        semBarbero.acquire();
        System.out.println(color + Thread.currentThread().getName() + " !!!-------------- se despierta. Y empieza a cortar el pelo");
        Thread.sleep(2500);
        System.out.println(color + Thread.currentThread().getName() + " TERMINA DE CORTAR PELO");
        semSalida.release();
    }
    
    public boolean serAtendido(String color) throws InterruptedException {
        System.out.println(color + Thread.currentThread().getName() + " llega a la barberìa.");
        boolean res = semSillon.tryAcquire();
        if (res) {
            this.atenderse(color,'n');
        } else {
            res= sillasDeEspera(color);
            if(res)
                this.atenderse(color, 's');
        }
        return res;        
    }   
    
    
    private boolean sillasDeEspera(String color){
        boolean res= csillas.ocupar();
        if(res){
            System.out.println(color + Thread.currentThread().getName() + " ++++ se sienta en una SILLA DE ESPERA.");
        }
        return res;
        }
    private void liberarSilladeEspera(){
        csillas.liberar();
    }
            
    private void atenderse(String color, char s) {
        semBarbero.release();
        System.out.println(color + Thread.currentThread().getName() + " se sienta en el sillòn.");
        System.out.println(color + Thread.currentThread().getName() + " es atendido.");
        if(s=='s'){
            liberarSilladeEspera();
        }
        try {
            semSalida.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Barberia.class.getName()).log(Level.SEVERE, null, ex);
        }
        semSillon.release();
        System.out.println(color + Thread.currentThread().getName() + " se va con un corte nuevo.");
    }
    
}
