/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL1_TEMA1;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Santiago
 */
public class Comedor {
    final private int espaciosComedero; //Constante
    private int espaciosLibres; //Contador de espacios libres
    private char especieActual='x'; //Inicializo en x, lo modifica la primera especie que llegue.
    private ReentrantLock lockEspacios;
    private boolean otraEspecieEspera, noMismaEspecie; //Flags
    public Comedor(int espacios){
        this.espaciosComedero=espacios;
        this.espaciosLibres=espacios;
        lockEspacios = new ReentrantLock();
        otraEspecieEspera=false;
        this.noMismaEspecie=false;
    }
    public void comer(String nombre, char especie) throws InterruptedException{
        boolean flag=true;
        while(flag){
            if(ocuparEspacio(especie)){ //Si logra ocupar un espacio
                flag=false;
                System.out.println(nombre+" entró a un comedero. Está comiendo\n");
                Thread.sleep(1000);
                System.out.println(nombre+" salió del comedero.");
                this.liberarEspacio();
            }else{
                System.out.println("Comedero está lleno o no coincide la especie. Animal vuelve a intentar en un rato\n");
                Thread.sleep(5000);
            }
        }
    }
    public boolean ocuparEspacio(char especie){
        boolean flag=false;
        lockEspacios.lock();
        if(this.especieActual=='x'){ //Si todavía no llegó ninguna especie...
            this.especieActual=especie;
        }
        if(this.espaciosLibres>0 && this.especieActual==especie && !noMismaEspecie){ //Si hay espacios libres y coincide la especie
            this.espaciosLibres--;
            flag=true;
            if(this.espaciosLibres==0 && this.otraEspecieEspera){ //Si se llenó el comedero y ahí animales de otra especie esperando
                this.noMismaEspecie=true;
            }
        }
        if(this.especieActual!=especie){ //Si en el comedor hay animales de otra especie
            this.otraEspecieEspera=true;
        }
        lockEspacios.unlock();
        return flag;
    }
    public void liberarEspacio(){
        lockEspacios.lock();
        this.espaciosLibres++;
        if(this.espaciosLibres==this.espaciosComedero && noMismaEspecie){ //Si el animal es el último en irse, y hay de otra especie esperando
            this.cambiarEspecie();
            this.otraEspecieEspera=false;
            this.noMismaEspecie=false;
        }
        lockEspacios.unlock();
    }
    public void cambiarEspecie(){
        if(this.especieActual=='p'){
            this.especieActual='g';
        }else{
            this.especieActual='p';
        }
    }
}
