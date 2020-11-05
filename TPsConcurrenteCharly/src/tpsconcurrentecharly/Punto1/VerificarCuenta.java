package tpsconcurrentecharly.Punto1;

import tpsconcurrentecharly.*;
import tpsconcurrentecharly.Punto1.CuentaBanco;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VerificarCuenta implements Runnable {

    private CuentaBanco cb = new CuentaBanco();
   
    // de hacer retiro

    public void run() {
        for (int i = 0; i <= 3; i++) {
            try {
                cb.HacerRetiro(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(VerificarCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (cb.getBalance() < 0) {
                System.out.println("La cuenta está sobregirada.");
                
            }
        }
    }
}
