package TP3.Punto1;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        VerificarCuenta vc = new VerificarCuenta();
        Thread Luis = new Thread(vc, "Luis");
        Thread Manuel = new Thread(vc, "Manuel");
        Luis.start();
        Manuel.start();
       
    }
}
