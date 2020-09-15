/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Punto8;

/**
 *
 * @author Faustino
 */
public class Jaula {
    
    
    public static void main(String[]args){
        int segs= (int) (Math.random()*9);
        Instalacion[] aparatos= new Instalacion[]{ new Rueda(segs), new Plato(segs), new Hamaca(segs)};
        Thread[] hamsters= new Thread[]{ new Thread(new Hamster('r',aparatos),"Hamster 1"),new Thread(new Hamster('p',aparatos),"Hamster 2"), new Thread(
                new Hamster('h',aparatos),"Hamster 3")};
        for(int i=0;i<=2;i++){
            hamsters[i].start();
        }
        }
        
    }
    
    

