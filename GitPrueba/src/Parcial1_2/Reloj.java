/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial1_2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Santiago
 */
public class Reloj {
    private Semaphore semDespertar; //
    private ReentrantLock lockDurmientes;
    private int hora, contDespertados, cantDurmientes;
    
    public Reloj(int cantDurmientes){
        hora=1; //Contador de reloj empieza en 1
        semDespertar= new Semaphore(0, true); 
        contDespertados=0;
        this.cantDurmientes=cantDurmientes;
        lockDurmientes= new ReentrantLock();
    }
    public void sumarHora(){
        this.hora++;
    }
    public int getHora(){
        return this.hora;
    }
    public void despertar(String nombre, int hora) throws InterruptedException{
        boolean flag=true;
        while(flag){
            this.semDespertar.acquire(); //Se despierta
            this.sumarDurmiente(); //Sumo 1 al contador de hilos despertados.
            System.out.println(nombre+" se despertó. Va a despertar a su vecino.");
            if(this.getCantDespertados()<=(cantDurmientes-1)){ //Si quedan vecinos por despertar
                this.semDespertar.release(); //Despierta a vecino
            }else{
                this.setCantDespertados(0); //Se reinicia el contador de hilos despertados.
            }
            if(this.getHora()==(hora+1)){ //Si la hora actual coincide con la de ir a trabajar
                System.out.println(nombre+" SE VA A TRABAJAR.");
                flag=false;
                Thread.sleep(10000); //Sleep y después vuelve a dormir.
            }else{
                System.out.println(nombre+" sigue durmiendo.");
            }
        }
        
    }
    public void sonarAlarma(){
        this.semDespertar.release();
    }
    public void sumarDurmiente(){ //Sumo 1 al contador de hilos despertados
        lockDurmientes.lock();
        contDespertados++;
        lockDurmientes.unlock();
    }
    public int getCantDespertados(){
        return this.contDespertados;
    }
    public void setCantDespertados(int cant){ //Lo uso para reiniciar el contador de hilos despertados.
        lockDurmientes.lock();
        this.contDespertados=cant;
        lockDurmientes.unlock();
    }

}


