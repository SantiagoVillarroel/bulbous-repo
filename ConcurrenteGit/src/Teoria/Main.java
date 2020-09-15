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
public class Main {
    public static void main(String[] args){
        EstacionamientoAutos lugarAutos= new EstacionamientoAutos(10);
        EstacionamientoMotos lugarMotos= new EstacionamientoMotos(5);
        Thread entradaNorte= new Thread(new EntradaAutos(lugarAutos),"Entrada Norte");
        Thread entradaSur= new Thread(new EntradaAutos(lugarAutos),"Entrada Sur");
        Thread[] entradasySalidas= new Thread[5];
        entradasySalidas[0]= entradaNorte;
        entradasySalidas[1]= entradaSur;
        entradasySalidas[2]= new Thread(new EntradaMotos(lugarMotos),"Entrada Motos");
        entradasySalidas[3]= new Thread(new SalidaAutos(lugarAutos),"Salida Autos");
        entradasySalidas[4]= new Thread(new SalidaMotos(lugarMotos),"Salida Motos");
        
        for(int i=0; i<=4; i++){
            entradasySalidas[i].start();
        }
        
    }
}
