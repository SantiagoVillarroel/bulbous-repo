/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpsconcurrentecharly.Punto2;

/**
 *
 * @author Faustino
 */
public class Main {
    public static void main(String[]args) throws InterruptedException{
        Jugador jugador= new Jugador();
        Orco orcoObjeto= new Orco(jugador);
        Elfo elfoObjeto= new Elfo(jugador);
        Thread orco= new Thread(orcoObjeto,"ORCO");
        Thread elfo= new Thread(elfoObjeto,"ELFO");
        orco.start();
        elfo.start();
        elfo.join();
        orco.join();
        
        System.out.println("Vida del jugador: "+jugador.getVida());
    }
}
