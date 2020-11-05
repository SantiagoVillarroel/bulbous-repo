/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maggioni_FAI2705;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Clinica {
    private Semaphore recepcionista= new Semaphore(1,true);
    private Semaphore telefono= new Semaphore(0,true);
    private Semaphore opcion= new Semaphore(0,true);
    private Semaphore terminoDeElegir= new Semaphore(0,true);
    private Semaphore entrevistaMedica= new Semaphore(1,true);
    private Semaphore salaEntrevista= new Semaphore(0,true);
    private Semaphore extraccion= new Semaphore(0,true);
    private Semaphore donacion= new Semaphore(0,true);
    private Semaphore desayuno= new Semaphore(0,true);
    private CantSillas sillasLibres;

    public Clinica(int cant) {
        sillasLibres= new CantSillas(cant);
    }
    
    
    public void pedirTurno(String color){
        try {
            System.out.println(color+Thread.currentThread().getName()+" llama al centro..");
            Thread.sleep(200);
            recepcionista.acquire(); //adquiere semaforo recepcionista para que los otros donantes que llamen tengan que esperar.
            System.out.println(color+Thread.currentThread().getName()+"~~~~ es atendido por la recepcionista.");
            telefono.release(); //Avisa a la recepcionista que tiene una llamada
            double eleccion= Math.random();
            opcion.acquire();
            if(eleccion > 0.5){
                System.out.println(color+" Donaré voluntariamente.");
            }else{
                System.out.println(color+ " Voy a donar para un particular.");
            }
            this.terminoDeElegir.release(); // avisa al recepcionista q ya hizo su elección.
            Thread.sleep(500);
            recepcionista.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Clinica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean irALaClinicaYDonar(String color){
        boolean res=this.sillasLibres.ocupar();
        System.out.println(color+Thread.currentThread().getName()+res);
        if(res){
            try {
                System.out.println(color+Thread.currentThread().getName()+" esperando a ser atendido");
                this.entrevistaMedica.acquire();
                this.sillasLibres.liberar();
                System.out.println(color+Thread.currentThread().getName()+".... se dirige a la sala para la entrevista");
                Thread.sleep(300);
                this.salaEntrevista.release();
                System.out.println(color+Thread.currentThread().getName()+"+++++++++ respondiendo preguntas");
                extraccion.acquire();
                System.out.println(color+Thread.currentThread().getName()+".. se dirige a la sala para la EXTRACCION.");
                Thread.sleep(400);
                this.donacion.release();
                desayuno.acquire();
                this.desayunar(color);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Clinica.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return res;
    }
    
    private void desayunar(String color){
        try {
            String[]opciones= new String[]{"Alfajor","Yogur","Jugo de naranja"};
            int i= (int)(Math.random()*3);
            System.out.println(color+Thread.currentThread().getName()+" voy a desayunar un "+opciones[i]);
            Thread.sleep(400);
            System.out.println(color+Thread.currentThread().getName()+" ya doné y desayuné, mañana productiva. Adiós.");
        } catch (InterruptedException ex) {
            Logger.getLogger(Clinica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void extraccion(String color){
        while(true){
        try {
            System.out.println(color+Thread.currentThread().getName()+" afilando las agujas para la proxima extraccion...");
            this.donacion.acquire();
            this.pinchazo(color);
            Thread.sleep(500);
            extraccion.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Clinica.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
    }
    
    private void pinchazo(String color){
        try {
            System.out.println(color+Thread.currentThread().getName()+" Estás listo? Respirá.");
            Thread.sleep(500);
            System.out.println(color+Thread.currentThread().getName()+" LISTO.");
             System.out.println(color+Thread.currentThread().getName()+" te entrego el CERTIFICADO, gracias por tu donación.");
            Thread.sleep(300);
            desayuno.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Clinica.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        
    }
    
    public void entrevista(String color){
        while(true){
        try {
            System.out.println(color+Thread.currentThread().getName()+" ^^esperando para entrevistar a donantes.");
            this.salaEntrevista.acquire();
            System.out.println(color+Thread.currentThread().getName()+" ........................haciendo control de signos clínicos.");
            extraccion.release();
            System.out.println(color+Thread.currentThread().getName()+" .........Listo, estás apto para donar.");
            Thread.sleep(500);
            this.entrevistaMedica.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Clinica.class.getName()).log(Level.SEVERE, null, ex);
        }}
    }
    
    public void recepcionista(String color){
        while(true){
        try {
            System.out.println(color+Thread.currentThread().getName()+" procesando y almacenando sangre en heladeras....");
            telefono.acquire(); //Cuando el donante lo libera, atiende la llamada.
            System.out.println(color+Thread.currentThread().getName()+" ---- atiende el llamado del donante.");
            System.out.println(color+ " donacion voluntaria o para un paciente en particular? ");
            opcion.release();
            this.terminoDeElegir.acquire();
            System.out.println(color+ "Genial, ya lo anoto.");
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Clinica.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
}
