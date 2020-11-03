/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4_11;


/**
 *
 * @author Santiago
 */
public class Main {
    public static void main(String[] args) {
        Turno turno = new Turno();
        long initialTime=System.currentTimeMillis();
        
        Cajera cajera=new Cajera("Cajera 1", initialTime); //Cajera es estático
        
        Cliente c1=new Cliente("Cliente 1", new int[]{2, 3, 5}, turno, cajera), c2=new Cliente("Cliente 2", new int[]{3, 5, 1}, turno, cajera);
        
        Thread threadCliente1=new Thread(c1, "Cliente 1"), threadCliente2=new Thread(c2, "Cliente 2");
        
        threadCliente1.start();
        threadCliente2.start();
    }
}