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
public class PruebaThread {
    public static void main(String []args){
    PingPong p1= new PingPong("PING",33), p2= new PingPong("PONG",10);
    p1.start();
    p2.start();
    
    try{
        Thread.sleep(5000);}
    catch(InterruptedException e){
        
    }
    }
}
