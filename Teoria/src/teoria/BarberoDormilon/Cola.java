
package Teoria.BarberoDormilon;

public class Cola {
    private static int TAMAÑO=10;
    private int frente=0;
    private int fin=0;
    private Object[] arreglo;
    //Constructor
    public Cola(){
        this.arreglo= new Object[this.TAMAÑO];
        this.fin=0;
        this.frente=0;
    }
    //Modificadores
    public boolean poner(Object e){
        boolean res=true;
           if(((this.fin+1)%this.TAMAÑO)==this.frente){
               res=false;
           }else{
               this.arreglo[this.fin]=e;
               this.fin=(this.fin+1)%this.TAMAÑO;
               this.arreglo[this.fin]=null;
                     
               
           }
        return res;
    }
    public boolean sacar(){
        boolean res=true;
        if(this.fin==this.frente){
            res=false;
        }else{
            this.arreglo[this.frente]=null;
            this.frente=(this.frente+1)%this.TAMAÑO;
        }
        return res;
    }
    public void vaciar(){
        boolean var=true;
        if(this.fin!=this.frente){
            while(var){
                 var= this.sacar();;
            }
        }
    }
    //Observadores
    public Object obtenerFrente(){
        Object res=null;
        if(this.frente!=this.fin){
        res= this.arreglo[this.frente];}
        return res;
    }
    public boolean esVacia(){
        return this.frente==this.fin;
    }
    //Propias del Tipo
    public Cola clone(){
        Cola x= new Cola();
        x.frente=this.frente;
        x.fin=this.fin;
        for(int i=0; i < this.TAMAÑO;i++){
            x.arreglo[i]=this.arreglo[i];
        }
        return x;
    }
    @Override
    public String toString(){
        String s="";
        int i=this.frente;
        if(this.frente!=this.fin){
            s="[";
        while(i!=this.fin){
            
            s=s+this.arreglo[i]+",";
            i++;
            i=i%TAMAÑO;
        }
        s=s+"]";
        }
        else{
            s="Cola vacia.";
        }
        return s;
    }
    public boolean equals(Cola x){
        boolean res;
        res= this.fin==x.fin&&this.frente==x.frente;
        if(res){
            int i=this.TAMAÑO-1;
             while((res)&&(i>=0)){
            res= this.arreglo[i]==x.arreglo[i];
            i--;
        }
       
} return res;}}
