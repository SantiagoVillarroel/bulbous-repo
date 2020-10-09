/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4_11;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Santiago
 */
public class Cajera {

    private String nombre;
    private long initialTime;

    public Cajera(String nombre, long time) {
        this.nombre = nombre;
        this.initialTime = time;
    }
    public void procesarCompra(String cliente, int[] carro){
        for(int i=0; i<carro.length; i++){ //For para la cantidad de items en el carro
            System.out.println("\n"+this.nombre+" está procesando el item "+ (i+1)+" del cliente "+cliente);
            try {
                Thread.sleep(carro[i]*1000); //Sleep con la cantidad de segundos indicada en el arreglo
            } catch (InterruptedException ex) {
                Logger.getLogger(Cajera.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("\n"+this.nombre+" terminó de procesar el item "+(i+1)+" del cliente "+cliente);
        }
        System.out.println("\n"+this.nombre+" lleva "+(System.currentTimeMillis()-initialTime)/1000+" segundos trabajando");
    }
}
