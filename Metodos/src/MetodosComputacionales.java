/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Faustino
*/
import Utiles.TecladoIn;
public class MetodosComputacionales {
    public static void getError(){
        System.out.println("Ingrese valor aproximado");
        double valorAprox= TecladoIn.readLineDouble();
        System.out.println("Ingrese valor real");
        double valorReal= TecladoIn.readLineDouble();
        double errorAbs=Math.abs(valorReal-valorAprox);
        System.out.println("Error absoluto: "+errorAbs);
        double errorRel= errorAbs/valorReal;
        System.out.println("Error relativo: "+errorRel);
        System.out.println("Error porcentual: "+errorRel*100+"%");
    }
    public static void derivadaCentral(){
        System.out.println("Ingrese x0");
        double x0= TecladoIn.readLineDouble();
        System.out.println("Ingrese h");
        double h= TecladoIn.readLineDouble();
        System.out.println("La derivada aproximada en "+x0+" es: "+(f(x0+h)-f(x0-h))/2*h);
    }
    public static void derivadaAdelante(){
        System.out.println("Ingrese x0");
        double x0= TecladoIn.readLineDouble();
        System.out.println("Ingrese h");
        double h= TecladoIn.readLineDouble();
        System.out.println("La derivada aproximada en "+x0+" es: "+(f(x0+h)-f(x0))/2*h);
    }
    public static void derivadaAtras(){
        System.out.println("Ingrese x0");
        double x0= TecladoIn.readLineDouble();
        System.out.println("Ingrese h");
        double h= TecladoIn.readLineDouble();
        System.out.println("La derivada aproximada en "+x0+" es: "+(f(x0)-f(x0-h))/2*h);
    }
    
    public static void areaTrapecio(){ // Preguntar
        System.out.println("Escribir valor de a: ");
       double a= TecladoIn.readLineDouble();
       System.out.println("Ingrese valor de b: ");
       double b= TecladoIn.readLineDouble();
       System.out.println("Ingrese la cantidad de intervalos");
       int n= TecladoIn.readLineInt();
       double h= Math.abs((b-a)/n);
       double areaAux= 0;
       for(int i=1; i<=n-1;i++){
           
           areaAux= areaAux+f(a+h*i);
           
       }
        System.out.println("El area aproximada es: "+(h/2)*(f(a)+f(b)+2*areaAux));
    }
    
    public static void areaSimpson(){ //Agregar y preguntar por condiciones
       System.out.println("Escribir valor de a: ");
       double a= TecladoIn.readLineDouble();
       System.out.println("Ingrese valor de b: ");
       double b= TecladoIn.readLineDouble();
       System.out.println("Ingrese la cantidad de intervalos");
       int n= TecladoIn.readLineInt();
       if(n>=2 && n%2==0){
       double h= Math.abs((b-a)/n);
       double areaAuxPar= 0;
       double areaAuxImpar= 0;
       for(int i=1;i<=n-1;i++){
           if(i%2!=0){
               areaAuxImpar= areaAuxImpar + f(a+h*i);
               
           }else{
               areaAuxPar= areaAuxPar + f(a+h*i);
           }
           
       }
        System.out.println("El área aproximada es: "+(h/3)*(f(a)+f(b)+4*areaAuxImpar+2*areaAuxPar));
    }else{
           System.out.println("ERROR. n no es par o mayor-igual a 2");
       }}

    /*public static double f(double x){
        return 2*Math.sin(x+1);
    }*/
    public static double f(double x){
        return Math.pow(Math.E, x);
    }
    public static double df(double x){
        return 2*Math.cos(x+1) ;
    }
    
   public static void biseccion(){
       System.out.println("Escribir valor de a: ");
       double a= TecladoIn.readLineDouble();
       System.out.println("Ingrese valor de b: ");
       double b= TecladoIn.readLineDouble();
       System.out.println("Ingrese el valor del error E: ");
       double E= TecladoIn.readLineDouble();
       double r=0;
       if( f(a)*f(b)<0){
           while(r==0 || Math.abs(f(r))>E){
               r=(a+b)/2;
               System.out.println("r: "+r);
               if(f(a)*f(r)<0){
                   b=r;
               }else{
                   a=r;
               }
           }
           System.out.println("Raiz aproximada: "+r);
       }else{
           System.out.println("No se cumple la condición inicial f(a)*f(b)<0");
       }
   }
   
   public static void newtonR(){
       System.out.println("Ingrese x0");
       double x0= TecladoIn.readLineDouble();
       double x1=x0;
       System.out.println("Ingrese error E");
       double E= TecladoIn.readLineDouble();
       while(Math.abs(f(x1))>E){
           System.out.println("x0: "+x0);
           System.out.println("f(x0): "+f(x0));
           System.out.println("df(x0): "+df(x0));
           x1= x0-(f(x0)/df(x0));
           System.out.println("x1: "+x1);
           x0=x1;
       }
       System.out.println("Raiz aproximada: "+x1);
   }
   public static void main(String[]args){
       //biseccion();
       //newtonR();
       //areaTrapecio();
       //areaSimpson();
       getError()
   }
   
   
}
