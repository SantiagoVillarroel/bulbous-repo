/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProdCons;


/**
 *
 * @author Santiago
 */
class Nodo {
    private Object elem;
    private Nodo enlace;
    public Nodo(Object elem, Nodo enlace){
        this.elem=elem;
        this.enlace=enlace;
    }
    public void setElem(Object elem){
        this.elem=elem;
    }
    public void setEnlace(Nodo enlace){
        this.enlace=enlace;
    }
    public Object getElem(){
        return elem;
    }
    public Nodo getEnlace(){
        return enlace;
    }
}
