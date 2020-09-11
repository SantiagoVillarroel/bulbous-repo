/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPSinc3;

/**
 *
 * @author Santiago
 */
public class Hilo implements Runnable{
    private Variable cont;
    private String cadena;
    private int turno;
    public Hilo(Variable cont, String s, int turno){
        this.cont=cont;
        this.cadena=s;
        this.turno=turno;
    }
    public void run(){
        for(int i=0; i<10; i++){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("sleep falló");
            }
            if(cont.getCont()==this.turno){
                System.out.print(cadena);
                cont.setCont((this.turno+1)%3);
                if(cont.getCont()==0){
                    System.out.println(" ");
                }
            }
        }
    }
}
