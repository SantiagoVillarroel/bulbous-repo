package TP3;

public class CuentaBanco {

    private int balance = 50;

    public CuentaBanco() {
        
    }
    
    public int getBalance() {
        return balance;
    }

    public void retiroBancario(int retiro) {
        balance = balance - retiro;
    }
     synchronized void HacerRetiro(int cantidad) throws InterruptedException {
        if (this.getBalance() >= cantidad) {
            System.out.println(Thread.currentThread().getName()
                    + "está realizando un retiro de: " + cantidad + ".");

            Thread.sleep(1000);
            this.retiroBancario(cantidad);
            System.out.println(Thread.currentThread().getName() + ":Retiro realizado.");
            System.out.println(Thread.currentThread().getName() + ": Losfondos son de: " + this.getBalance());

        } else {
            System.out.println("No hay suficiente dinero en la cuenta para realizar el retiro Sr."
                    + Thread.currentThread().getName()
            );
            System.out.println("Su saldo actual es de"
                    + this.getBalance());
            Thread.sleep(1000);
        }
    }
    
}
