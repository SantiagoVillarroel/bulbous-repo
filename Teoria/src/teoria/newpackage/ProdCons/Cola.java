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
public class Cola {
    private Nodo frente;
    private Nodo fin;
    public Cola(){
        //Constructor vacío de cola.
        this.frente=null;
        this.fin=null;
    }
    public boolean poner(Object elem){
        //Método para poner un elemento.
        boolean res=true;
        Nodo nuevo= new Nodo(elem, null);
        if(this.esVacia()){
            this.frente=nuevo;
        }
        else{           
            this.fin.setEnlace(nuevo);
        }
        this.fin=nuevo;
        return res;
    }
    public boolean sacar(){
        //Método para sacar un elemento.
        boolean res=true;
        if(this.frente==null){
            res=false;
        }
        else{
            this.frente=this.frente.getEnlace();
            if(this.frente==null){
                this.fin=null;
            }
        }
        return res;
    }
    public Object obtenerFrente(){
        //Método para obtener el frente de la cola.
        Object elem=null;
        if(!this.esVacia()){
            elem=this.frente.getElem();
        }
        return elem;
    }
    public boolean esVacia(){
        //Método para verificar si la cola es vacía.
        boolean res=false;
        if(this.frente==null){
            res=true;
        }
        return res;
    }
    public void vaciar(){
        //Método para vaciar la cola.
        this.frente=null;
    }
    public Cola clone(){
        //Método que devuelve un clon de la cola.
        Cola clon = new Cola();
        Nodo aux1=this.frente;
        clon.frente=new Nodo(aux1.getElem(), null);
        aux1=aux1.getEnlace();
        Nodo aux2=clon.frente;
        while(aux1!=null){
            aux2.setEnlace(new Nodo(aux1.getElem(), null));
            aux2=aux2.getEnlace();
            aux1=aux1.getEnlace();
        }
        clon.fin=aux2;
        return clon;
    }
    public String toString(){
        //Método que devuelve una cadena con los elementos de la cola.
        String s="";
        if(this.esVacia()){
            s="Cola vacía";
        }
        else{
            Nodo aux = this.frente;
            while(aux!=null){
                s=s+aux.getElem();
                aux=aux.getEnlace();
                if(aux!=null){
                    s+=", ";
                }
            }
        }
        return s;
    }
}
