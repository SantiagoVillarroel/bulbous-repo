/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Punto4;
import TP2.Punto6.Contador;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
public class TorreDeControl {
    private Semaphore admin= new Semaphore(0,true);
    private Cola aterrizajes= new Cola();
    private Contador cont= new Contador();
    private Pista pis;

    public TorreDeControl(Pista pis) {
        this.pis = pis;
    }
    
    
    public void manejarPista(String uso,String color){
        this.verificarCola();
        if(uso.equals("aterrizaje")){
            aterrizajes.poner(1);
            pis.aterrizar(color);
            cont.sumar();
            aterrizajes.sacar();
            this.verificarCola();
        }else{
            System.out.println(color+" ||||||||QUIERE USAR LA PISTA para DESPEGAR|||||||");
            this.solicitarDespegue(color);
        }
    }
    private void verificarCola(){
        if(aterrizajes.esVacia()){
            admin.release();
        }
    }
    private void solicitarDespegue(String color){
        if(cont.getI()==10){
            cont.setI(0);
        }else{
            try {
                admin.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(TorreDeControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        pis.despegar(color);
        
    }
}
