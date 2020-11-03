/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPSinc2;

/**
 *
 * @author Santiago
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Vida vida = new Vida();
        Entidad orco = new Entidad("Orco", vida, -3);
        Entidad curandero = new Entidad("Curandero", vida, 3);
        
        Thread t1 = new Thread(orco, "Orco");
        Thread t2 = new Thread(curandero, "Curandero");
        
        t1.start();
        t2.start();
    }
}
