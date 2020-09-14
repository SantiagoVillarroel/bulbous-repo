/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Punto4;

public class Surtidor {
    private int cantidad;

    public Surtidor() {
        cantidad=2500;
    }
        
    public synchronized boolean cargarNafta(Auto auto, int carga) throws InterruptedException{
        boolean res= (this.cantidad-carga)>=0;
        if(res){
        System.out.println(Thread.currentThread().getName()+" cargando nafta...");
        Thread.sleep(carga*100);
        auto.setCarga(carga);
        System.out.println(Thread.currentThread().getName()+" terminó de cargar! Esperó "+(carga)+" segundos.");
        }else{
            System.out.println("No queda nafta en el surtidor.");
        }
        return res;
    }
}
