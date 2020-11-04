/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoria.Hamsters;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Plato {

    private int cantidad;
    private int comiendo;

    public Plato(int maximo) {
        cantidad = maximo;
        comiendo = 0;
    }
    
    public synchronized int getComiendo(){
        return this.comiendo;
    }



    
    public void comer(String nombre){
        this.comiendo++;
        System.out.println(comiendo);
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Plato.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(nombre+" terminó de comer");
        this.comiendo--;
    }
}
