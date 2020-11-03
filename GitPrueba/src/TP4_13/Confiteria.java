/*  |
 *  To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4_13;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Santiago
 */
public class Confiteria{
    private Semaphore semAsiento, semMozo, semPedido;
    public Confiteria(){ //Inicializo semáforos
        semAsiento=new Semaphore(1, true); //Fairness:true para simular una cola
        semMozo=new Semaphore(0);
        semPedido=new Semaphore(0);
    }
    public void ocuparAsiento(String nombre) throws InterruptedException{
        semAsiento.acquire(); 
        System.out.println(nombre+" ocupó el asiento.");
        System.out.println(nombre+" está eligiendo del menú...\n");
        Thread.sleep(3000);
        System.out.println(nombre+" ya eligió y ordenó. Está esperando su pedido\n");
        semMozo.release(); //Release para que el método atender() siga con su ejecución
        semPedido.acquire(); //Este acquire espera el release ejecutado por el método atender()
        System.out.println(nombre+" recibió su pedido. Está comiendo.\n");
        Thread.sleep(3000);
        System.out.println(nombre+" terminó de comer. Vuelve a trabajar");
        System.out.println(nombre+" se está levantando de la silla.\n");
        Thread.sleep(1000);
        semAsiento.release(); //Libero semáforo del asiento
    }
    public void atender(String nombre) throws InterruptedException{
        while(true){
            System.out.println(nombre+" está inventando nuevas recetas de pollo.\n");
            semMozo.acquire(); //Este acquire espera el release ejecutado en el método ocuparAsiento()
            System.out.println(nombre+" anotó el pedido del cliente y se lo comunicó al cocinero.");
            System.out.println("El pedido está siendo preparado\n");
            Thread.sleep(4000);
            System.out.println("Pedido está listo. "+nombre+" lo está llevando a la mesa\n");
            Thread.sleep(1000);
            semPedido.release(); //Este release permite que ocuparAsiento() siga con la ejecución
        }
    }
}
