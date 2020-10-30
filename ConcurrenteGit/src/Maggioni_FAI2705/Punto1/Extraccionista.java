/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maggioni_FAI2705;

/**
 *
 * @author Faustino
 */
public class Extraccionista extends Persona implements Runnable {

    public Extraccionista(String nombre, Clinica clinica,String color) {
        super(nombre, clinica,color);
    }

    
    
    public void run(){
        this.clinica.extraccion(color);
    }
    
}
