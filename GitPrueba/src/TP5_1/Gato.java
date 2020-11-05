package TP5_1;



public class Gato extends Animal implements Runnable {
    public Gato(String nombre, Comedor comedor) {
        super(nombre, 'g', comedor);
    }

    public void comer() throws InterruptedException {
        boolean comio = false;
        while (!comio) { //Mientras no haya podido entrar a comer
            if (this.getComedor().entrarComer(this.getEspecie())) {
                System.out.println(this.nombre + " logro ENTRAR a COMER!");
                Thread.sleep(5000); //Comiendo
                System.out.println(this.nombre + " terminó de comer y SALIO del comedero!");
                this.getComedor().salirComedero();
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
