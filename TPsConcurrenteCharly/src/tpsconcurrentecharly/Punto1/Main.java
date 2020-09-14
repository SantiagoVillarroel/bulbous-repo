package tpsconcurrentecharly.Punto1;

import tpsconcurrentecharly.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        VerificarCuenta vc = new VerificarCuenta();
        Thread Luis = new Thread(vc, "Luis");
        Thread Manuel = new Thread(vc, "Manuel");
        Luis.start();
        Manuel.start();
       
    }
}
