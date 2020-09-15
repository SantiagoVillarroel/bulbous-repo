/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teoria;

public class EstacionamientoAutos {
    private int cantActual;
    private int cantMaxima;
    public EstacionamientoAutos(int cantMaxima) {
        this.cantActual = 0;
        this.cantMaxima = cantMaxima;
        
    }

    public int getCantActual() {
        return cantActual;
    }

    public void setCantActual(int cantActual) {
        this.cantActual = cantActual;
    }

    public int getCantMaxima() {
        return cantMaxima;
    }

    public void setCantMaxima(int cantMaxima) {
        this.cantMaxima = cantMaxima;
    }

    public synchronized boolean ingresarAuto() throws InterruptedException{
        boolean res= cantActual < cantMaxima;
        if(res){
            System.out.println("Auto estacionando...");
            Thread.sleep(111);
            this.cantActual++;
            System.out.println("Listo. "+Thread.currentThread().getName());
        }else{
            Thread.sleep(80);
            System.out.println("No queda lugar para más autos.");
        }
        return res;
    }
    
   
    
    public synchronized boolean retirarAuto() throws InterruptedException{
        boolean res= this.cantActual>0;
        if(res){
            System.out.println("Se está yendo un auto...");
            Thread.sleep(50);
            this.cantActual--;
            System.out.println("Listo. "+Thread.currentThread().getName());
        }else{
            Thread.sleep(80);
            System.out.println("No hay autos, es imposible que salga alguno,");
        }
        return res;
    }
}
    

