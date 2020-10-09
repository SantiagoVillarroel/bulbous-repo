/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto12;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class AdminJaula {
    private Instalacion[] cjs;

    public AdminJaula(Instalacion[] cjs) {
        this.cjs = cjs;
    }
    
    
    
    public void solicitarUso(String color){
    int j= 0;
        boolean parar=false;
        while(!parar && j<=cjs.length-1){
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(AdminJaula.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(cjs[j].disponibilidad()){
            parar=true;
            try {
                cjs[j].usar(color);
            } catch (InterruptedException ex) {
                Logger.getLogger(AdminJaula.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        j++;
        }
        
        if(!parar){
           
            Instalacion aux= cjs[0];
            for(int x=0;x<=cjs.length-1;x++){
                if(cjs[x].getCant()<aux.getCant()){
                    aux=cjs[x];
                }
            }
        try {
            aux.usar(color);
        } catch (InterruptedException ex) {
            Logger.getLogger(AdminJaula.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
}
