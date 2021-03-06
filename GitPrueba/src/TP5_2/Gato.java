package TP5_2;

import TP5_1.*;

public class Gato extends Animal implements Runnable {
    public Gato(String nombre, Comedor comedor, int com) {
        super(nombre, 'g', comedor, com);
    }

    public void comer() throws InterruptedException {
        boolean comio = false;
        while (!comio) {
            if (this.getComedor().entrarComer(this.getEspecie(), this.comederosAOcupar)) {
                System.out.println(this.nombre + " logro ENTRAR a COMER!");
                Thread.sleep(5000);
                System.out.println(this.nombre + " terminó de comer y SALIO del comedero!");
                this.getComedor().salirComedero(this.comederosAOcupar);
                comio = true;
            } else {
                System.out.println(this.nombre + " no puede entrar AUN!");
                Thread.sleep(7000);
            }
        }
    }

    @Override
    public void run() {
        try {
            comer();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
