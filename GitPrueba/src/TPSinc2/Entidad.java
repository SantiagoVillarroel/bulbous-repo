/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPSinc2;

/**
 *
 * @author Santiago
 */
public class Entidad implements Runnable{
    private String id;
    private Vida vida;
    private int poder;
    public Entidad(String id, Vida vida, int poder){
        this.id=id;
        this.vida=vida;
        this.poder=poder;
    }
    public String getId(){
        return this.id;
    }
    public void run(){
        for(int i=0; i<3; i++){
            this.vida.modif(poder);
            System.out.println(this.getId()+" modificó la vida ("+this.poder+" puntos) - Vida: "+this.vida.getVida());
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("sleep falló");
            }
        }
    }
}
