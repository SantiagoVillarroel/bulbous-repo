package TP5.Punto1;

import java.util.concurrent.locks.ReentrantLock;

public class AdminComedor {

    private Comedor com;
    private int gatostotales;
    private int perrostotales;
    private Contador cantG;
    private Contador cantP;
    private ReentrantLock rlock = new ReentrantLock();

    public AdminComedor(Comedor com, int gatos, int perros) {
        this.com = com;
        this.gatostotales = gatos;
        this.perrostotales = perros;
        cantG = new Contador();
        cantP = new Contador();
    }

    public void comer(String animal, String color) {
        if (animal.equals("Gato")) {
            cantG.sumar();
            com.comeGato(color);
        } else {
            cantP.sumar();
            com.comePerro(color);
        }
        boolean cambio= this.verificarCant();
        if(!cambio){
            System.out.println("~~~~~~~~~~~CANT DISPONIBLE");
        int x= (int)(Math.random()*1);
        if(x==1){
            System.out.println("---RANDOM---");
            com.getTodosComederos();
        }
        }
        
    }

    private boolean verificarCant() {
        boolean res=false;
        rlock.lock();
        try {
            if (cantG.getI() == gatostotales || cantP.getI() == perrostotales) {
                res=true;
                System.out.println("++++++++++++++++++CANT LLENA");
                com.getTodosComederos();
                if (cantG.getI() == gatostotales) {
                    cantG.setI(0);
                } else {
                    cantP.setI(0);
                }
            }
        } finally {
            rlock.unlock();
        }
        return res;
    }

}
