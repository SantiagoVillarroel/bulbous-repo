/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoria.Hamsters;
import Colores.Colores;
/**
 *
 * @author Faustino
 */
public class Main {
    public static void main(String []args){
        String[]colores= Colores.colores();
        Jaula jaula= new Jaula();
        Thread[]hilos= new Thread[8];
        System.out.println("_");
        for(int i=0;i<hilos.length;i++){
            hilos[i]= new Thread(new HamsterMonitor(jaula,"Hamster "+i));
            
        }
        for(int i=0;i<hilos.length;i++){
            hilos[i].start();
        }
    }
}
