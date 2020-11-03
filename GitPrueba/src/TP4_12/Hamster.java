/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4_12;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class Hamster implements Runnable{
    String nombre;
    Turno turno;
    public Hamster(String nombre, Turno turno){
        this.nombre=nombre;
        this.turno=turno;
    }
    public void run(){ //Alternativa: hamster nunca está satisfecho -> usar while(true)
        comer();    //Con esta implementación el hamster realiza las 3 actividades y termina el hilo.
        correr();
        descansar();
        System.out.println(nombre+" ya está satisfecho");
    }
    public void comer(){ //La secuencia es similar para las 3 acciones
        turno.getPlato().lock(); //Adquiere lock -> imprimo cartel con acción -> sleep -> imprimo cartel -> libero lock
        System.out.println(nombre+" tiene hambre. Ocupó el plato\n");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(nombre+" desocupó el plato\n");
        turno.getPlato().unlock();
    }
    public void correr(){
        turno.getRueda().lock();
        System.out.println(nombre+" quiere correr. Ocupó la rueda\n");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(nombre+" desocupó la rueda\n");
        turno.getRueda().unlock();
    }
    public void descansar(){
        turno.getHamaca().lock();
        System.out.println(nombre+" tiene sueño. Ocupó la hamaca\n");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(nombre+" desocupó la hamaca\n");
        turno.getHamaca().unlock();
    }
}
