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


    public void sumarComiendo(){
        this.comiendo++;
    }
    
    public void terminarcomer(String nombre){
        this.comiendo--;
    }
}
