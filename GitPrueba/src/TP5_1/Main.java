package TP5_1;



public class Main {
    public static void main(String[] args) {
        
        int cantPerros=6;
        int cantGatos=6;
        
        Comedor comedor=new Comedor(3);
        Thread[] gatos=new Thread[cantGatos];
        Thread[] perros=new Thread[cantPerros];
        
        for(int i=0;i<cantPerros;i++){
            perros[i]=new Thread(new Perro("Perro "+(i+1),comedor));  
            perros[i].start();
        }
        for(int i=0;i<cantGatos;i++){
            gatos[i]=new Thread(new Gato("Gato "+(i+1), comedor));
            gatos[i].start();
        }
        
    }
}
