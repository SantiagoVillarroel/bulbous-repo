/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2.Punto6;

import java.util.concurrent.locks.ReentrantLock;


public class Atencion {
    private CajeraThread[] cjs;
    private Contador i;

    public Atencion(CajeraThread[] cjs) {
        this.cjs = cjs;
    }
    
    public void solicitarAtencion(Cliente cliente){
        int j= 0;
        boolean parar=false;
        while(!parar && j<=cjs.length-1){
        if(cjs[j].disponibilidad()){
            parar=true;
            cjs[j].atender(cliente,true);
        }
        j++;
        }
        
        if(!parar){
           
            CajeraThread aux= cjs[0];
            for(int x=0;x<=cjs.length-1;x++){
                if(cjs[x].getCant()<aux.getCant()){
                    aux=cjs[x];
                }
            }
            aux.atender(cliente,false);
        }
    }
            
}
