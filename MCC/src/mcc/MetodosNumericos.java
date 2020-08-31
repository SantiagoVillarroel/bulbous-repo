package mcc;
import Utiles.TecladoIn;
/**
 *
 * @author Faustino
 */
public class MetodosNumericos {

    /*public static double f(double x){
        return 2*Math.sin(x+1);
    }*/
    public static double f(double x){
        return Math.PI*Math.pow(x, 2)*((9-x)/3)-30;
    }
    public static double df(double x){
        return 2*Math.cos(x+1) ;
    }
    
    public static void areaTrapecio(){ // Preguntar
        System.out.println("Escribir valor de a: ");
       double a= TecladoIn.readLineDouble();
       System.out.println("Ingrese valor de b: ");
       double b= TecladoIn.readLineDouble();
       System.out.println("Ingrese la cantidad de intervalos");
       int n= TecladoIn.readLineInt();
       double h= (b-a)/n;
       double areaAux= 0;
       for(int i=1; i<=n-1;i++){
           areaAux= areaAux+f(a+h);
           h=h+h;
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
       if(n>=3 && n%2!=0){
       double h= (b-a)/n;
       double areaAuxPar= 0;
       double areaAuxImpar= 0;
       for(int i=1;i<=n-1;i++){
           if(i%2!=0){
               areaAuxImpar= areaAuxImpar + f(a+h);
               
           }else{
               areaAuxPar= areaAuxPar + f(a+h);
           }
           h=h+h;
       }
        System.out.println("El área aproximada es: "+(h/3)*(f(a)+f(b)+4*areaAuxImpar+2*areaAuxPar));
    }else{
           System.out.println("ERROR. N tiene que ser impar y mayor o igual a 3.");
       }}
    
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
       biseccion();
       //newtonR();
   }
   
   
}
