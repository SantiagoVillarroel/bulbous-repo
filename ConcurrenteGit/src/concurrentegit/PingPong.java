/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrentegit;

/**
 *
 * @author Faustino
 */
public class PingPong extends Thread {
    private String cadena;
    private int tiempo;

    public PingPong(String cadena, int tiempo) {
        this.cadena = cadena;
        this.tiempo = tiempo;
    }
    
    @Override
    public void run(){
        for(int i=1; i<tiempo*10;i++){
            System.out.println(cadena+" ");
            try{
                Thread.sleep(tiempo);}
            catch(InterruptedException e){
                   
            }
    }
    }
    
}
