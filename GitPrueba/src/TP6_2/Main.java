/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6_2;


/**
 *
 * @author Santiago
 */
public class Main {
    public static void main(String args[]){
        GestorSala gestor = new GestorSala(50, 35, 30);
        MedidorTemp medidor = new MedidorTemp(gestor);
        
        Thread[] personas = new Thread[100];
        Thread[] jubilados = new Thread[25];
        
        for(int i=0; i<100; i++){
            personas[i] = new Thread(new Persona("Persona "+(i+1), gestor));
            personas[i].start();
            if(i<25){
                jubilados[i] = new Thread(new Jubilado("Jubilado "+(i+1), gestor));
                jubilados[i].start();
            }
        }
    }
}
