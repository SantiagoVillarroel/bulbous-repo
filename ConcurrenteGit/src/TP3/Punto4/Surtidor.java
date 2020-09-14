/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Punto4;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Surtidor {
    private int cantidad;

    public Surtidor() {
        cantidad=2500;
    }
        
    public synchronized boolean cargarNafta(Auto auto, int carga){
        boolean res= (this.cantidad-carga)>=0;
        if(res){
        this.cantidad=this.cantidad-carga;
        System.out.println(Thread.currentThread().getName()+" cargando nafta...");
            try {
                Thread.sleep(carga*10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Surtidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        auto.setKmParaAndar(carga);
        System.out.println(Thread.currentThread().getName()+" terminó de cargar! Esperó "+(carga)+" segundos.");
        System.out.println("Queda nafta para "+this.cantidad+" km");
        }else{
            System.out.println("NO QUEDA NAFTA EN EL SURTIDOR. Vuelva mañana.");
        }
        return res;
    }
}
