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
public class Vida {
    private int vida=10;
    public Vida(){
        this.vida=10;
    }
    public void modif(int x){
        this.vida=vida+x;
    }
    public int getVida(){
        return this.vida;
    }
}
