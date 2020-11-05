/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Punto3;

/**
 *
 * @author Faustino
 */
public class VendedorTickets implements Runnable {
    private ControlTren ct;
    private String color;
    public VendedorTickets(ControlTren ct, String color) {
        this.ct = ct;
        this.color=color;
    }
    
    public void run(){
        while(true){
            ct.venderTicket(this.color);
        }
    }
    
}
