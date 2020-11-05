package TP5_1;





public class Animal  {
    protected String nombre;
    protected char especie;
    protected Comedor comedor;
    public Animal(String nombre, char especie, Comedor comedor){
        this.nombre=nombre;
        this.especie=especie;
        this.comedor=comedor;
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
