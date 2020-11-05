package TP5_1;


import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

import javax.sound.midi.Soundbank;

public class Comedor {
    private Semaphore comederos;
    private final int totalComederos;
    private int comederosLibres;
    private ReentrantLock lock;
    private char flagEspecie;
    private boolean otraEspecieEspera;//si hay otra especie intentando entrar y no pudo
    private boolean mismaEspecieEspera;//si hay de la misma especie intentado entrar y no pudo
    public Comedor(int comederos){
        this.comederos=new Semaphore(comederos);
        this.lock=new ReentrantLock();
        this.totalComederos=comederos;
        this.otraEspecieEspera=false;
        this.mismaEspecieEspera=false;
        this.flagEspecie='x';
        this.comederosLibres=comederos;
    }


    public boolean entrarComer(char especie) throws InterruptedException {
        lock.lock();
        
        boolean flag=false;
        if((especie==flagEspecie || flagEspecie=='x') && comederos.tryAcquire(1) && !otraEspecieEspera){
            //Si el turno corresponde a la especie (o no hay especie asignada) y haya espacio libre y no haya otra especie esperando
            if(flagEspecie=='x'){
                flagEspecie=especie;           
            }
            flag=true;
            this.comederosLibres--;
        }else{
            if(especie== flagEspecie ){ //Si misma especie no pudo entrar y es su turno
                mismaEspecieEspera=true;
            }
            if(especie!= flagEspecie && this.comederosLibres==0 ){
                //Si no es su turno y el comedor está lleno
                otraEspecieEspera=true;
            }   
        } 
        lock.unlock();
        return flag;
    }
   

    
    public void salirComedero() throws InterruptedException {
        lock.lock();
        comederos.release(1); //Libero permiso
        this.comederosLibres++; //Sumo 1 a contador
        if(this.comederosLibres==totalComederos && (otraEspecieEspera || !mismaEspecieEspera)){
            //Si el comedero quedó vacío y (hay otra especie esperando o no hay de la misma especie esperando)
            cambiarEspecie();
        }
        lock.unlock();
    }
    public void cambiarEspecie(){
        if(flagEspecie=='g'){
            System.out.println("Cambio TURNO: ahora entran PERROS");
            flagEspecie='p';
        }else{
            System.out.println("Cambio TURNO: ahora entran GATOS");
            flagEspecie='g';
        }
        otraEspecieEspera=false;
        mismaEspecieEspera=false;
    }
}
