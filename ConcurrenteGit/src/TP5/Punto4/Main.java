/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Punto4;
import Colores.Colores;
/**
 *
 * @author Faustino
 */
public class Main {
    public static void main(String[] args){
        String[]colores= Colores.colores();
        Pista p= new Pista();
        TorreDeControl tc= new TorreDeControl(p);
        Thread[]aviones= new Thread[6];
        for(int i=0;i<aviones.length;i++){
            aviones[i]= new Thread(new Avion(tc,colores[i]));
        }
        for(int i=0;i<aviones.length;i++){
            aviones[i].start();
        }
        
    }
}
