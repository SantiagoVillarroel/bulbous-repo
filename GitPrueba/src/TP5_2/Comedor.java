package TP5_2;

import TP5_1.*;
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


    public boolean entrarComer(char especie, int comederosAOcupar) throws InterruptedException {
        lock.lock();
        
        boolean flag=false;
        if((especie==flagEspecie || flagEspecie=='x') && comederos.tryAcquire(comederosAOcupar) && !otraEspecieEspera){
            if(flagEspecie=='x'){
                flagEspecie=especie;           
            }
            flag=true;
            this.comederosLibres = this.comederosLibres - comederosAOcupar;
        }else{
            if(especie== flagEspecie ){
                mismaEspecieEspera=true;
            }
            if(especie!= flagEspecie && this.comederosLibres==0 ){
                otraEspecieEspera=true;
            }   
        } 
        lock.unlock();
        return flag;
    }
   

    
    public void salirComedero(int comederosALiberar) throws InterruptedException {
        lock.lock();
        comederos.release(comederosALiberar);
        this.comederosLibres = this.comederosLibres+ comederosALiberar;
        if(this.comederosLibres==totalComederos && (otraEspecieEspera || !mismaEspecieEspera)){
            
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
