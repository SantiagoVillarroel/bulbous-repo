/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teoria;

/**
 *
 * @author Faustino
 */
public class EstacionamientoMotos {
    private int cantMaxima;
    private int cantActual;

    public EstacionamientoMotos(int cantMaxima) {
        this.cantActual = 0;
        this.cantMaxima = cantMaxima;
    }
    
     public synchronized boolean ingresarMoto() throws InterruptedException{
        boolean res= cantActual < cantMaxima;
        if(res){
            System.out.println("Moto estacionando...");
            Thread.sleep(80);
            this.cantActual++;
            System.out.println("Listo. "+Thread.currentThread().getName());
        }else{
            Thread.sleep(80);
            System.out.println("No queda lugar para más motos.");
        }
        return res;
    }
     public synchronized boolean retirarMoto() throws InterruptedException{
        boolean res= cantActual>0;
        if(res){
            System.out.println("Moto saliendo...");
            Thread.sleep(80);
            this.cantActual--;
            System.out.println("Listo. "+Thread.currentThread().getName());
        }else{
            Thread.sleep(80);
            System.out.println("No quedan motos. Imposible que se retire una.");
        }
        return res;
    }
}
