package TP5_2;

import TP5_1.*;



public class Animal  {
    protected String nombre;
    protected char especie;
    protected Comedor comedor;
    protected int comederosAOcupar;
    public Animal(String nombre, char especie, Comedor comedor, int comederosAOcupar){
        this.nombre=nombre;
        this.especie=especie;
        this.comedor=comedor;
        this.comederosAOcupar=comederosAOcupar;
    }

    public String getNombre() {
        return nombre;
    }

   

    public char getEspecie() {
        return especie;
    }

  

    public Comedor getComedor() {
        return comedor;
    }

    

    
}
