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
    public static void main(String []args) throws InterruptedException{
    PingPong p1= new PingPong(33,"PING"), p2= new PingPong(10,"PONG");
    PingPong p3= new PingPong(52,"PUNG"), p4= new PingPong(6,"PANG");
    p1.start();
    p2.start();
    p3.start();
    p4.start();
    /*for(int i=1;i <100;i++){
        Thread.sleep(27);
        System.out.println(i);
    }*/
    try{
        Thread.sleep(5000);}
    catch(InterruptedException e){
    
    }
    
}}
