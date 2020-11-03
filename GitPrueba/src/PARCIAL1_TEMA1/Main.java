/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL1_TEMA1;

/**
 *
 * @author Santiago
 */
public class Main {
    public static void main(String[] args){
        Comedor comedor = new Comedor(5);
        
        Thread[] perros = new Thread[12];
        Thread[] gatos = new Thread[12];
        
        for(int i=0; i<12; i++){
            perros[i]=new Thread(new Perro("Perro "+(i+1), 'p', comedor));
            gatos[i]=new Thread(new Gato("Gato "+(i+1), 'g', comedor));
            perros[i].start();
            gatos[i].start();
        }
    }
}
