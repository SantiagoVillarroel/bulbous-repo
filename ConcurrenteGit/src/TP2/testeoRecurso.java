/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2;

public class testeoRecurso {

    public static void main(String[] args) throws InterruptedException {
        /*Cliente juan = new Cliente();
        juan.setName("Juan Lopez");
        Cliente ines = new Cliente();
        ines.setName("Ines Garcia");
        juan.start();
        ines.start();*/
        
        Cliente juan= new Cliente();
        Thread t1= new Thread(juan,"Juan Lopez");
        Cliente ines = new Cliente();
        Thread t2= new Thread(ines,"Inés García");
        t1.start();
        
        t2.start();
        
        
    }
}
