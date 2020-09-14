/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Punto8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Hamster implements Runnable{
    char turno;
    Instalacion[] inst;

    public Hamster(char turno, Instalacion[] i) {
        this.turno = turno;
        this.inst=i;
    }
    
    public void run(){
        for(int i=1; i<=20;i++){
        switch(turno){
            //Caso Plato
            case 'p':
        {
            try {
                inst[0].usar();
            } catch (InterruptedException ex) {
                Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   turno='r';
                break;
                //Caso Rueda
                case 'r':
        {
            try {
                inst[1].usar();
            } catch (InterruptedException ex) {
                Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
            }
        }turno='h';
                break;
                //Caso Hamaca
                case 'h':
        {
            try {
                inst[2].usar();
            } catch (InterruptedException ex) {
                Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
            }
        }turno='p';
                break;
        }
    }}
}
