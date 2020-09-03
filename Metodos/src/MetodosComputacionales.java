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

    public static void getError() {
        System.out.println("Ingrese valor aproximado");
        double valorAprox = TecladoIn.readLineDouble();
        System.out.println("Ingrese valor real");
        double valorReal = TecladoIn.readLineDouble();
        double errorAbs = Math.abs(valorReal - valorAprox);
        System.out.println("Error absoluto: " + errorAbs);
        double errorRel = errorAbs / valorReal;
        System.out.println("Error relativo: " + errorRel);
        System.out.println("Error porcentual: " + errorRel * 100 + "%");
    }

    public static void derivadaCentral() {
        System.out.println("Ingrese x0");
        double x0 = TecladoIn.readLineDouble();
        System.out.println("Ingrese h");
        double h = TecladoIn.readLineDouble();
        System.out.println("La derivada aproximada en " + x0 + " es: " + (f(x0 + h) - f(x0 - h)) / 2 * h);
    }

    public static void derivadaAdelante() {
        System.out.println("Ingrese x0");
        double x0 = TecladoIn.readLineDouble();
        System.out.println("Ingrese h");
        double h = TecladoIn.readLineDouble();
        System.out.println("La derivada aproximada en " + x0 + " es: " + (f(x0 + h) - f(x0)) / 2 * h);
    }

    public static void derivadaAtras() {
        System.out.println("Ingrese x0");
        double x0 = TecladoIn.readLineDouble();
        System.out.println("Ingrese h");
        double h = TecladoIn.readLineDouble();
        System.out.println("La derivada aproximada en " + x0 + " es: " + (f(x0) - f(x0 - h)) / 2 * h);
    }

    public static void areaTrapecio() { // Preguntar
        System.out.println("Escribir valor de a: ");
        double a = TecladoIn.readLineDouble();
        System.out.println("Ingrese valor de b: ");
        double b = TecladoIn.readLineDouble();
        System.out.println("Ingrese la cantidad de intervalos");
        int n = TecladoIn.readLineInt();
        double h = Math.abs((b - a) / n);
        double areaAux = 0;
        for (int i = 1; i <= n - 1; i++) {

            areaAux = areaAux + f(a + h * i);

        }
        System.out.println("El area aproximada es: " + (h / 2) * (f(a) + f(b) + 2 * areaAux));
    }

    public static void areaSimpson() { //Agregar y preguntar por condiciones
        System.out.println("Escribir valor de a: ");
        double a = TecladoIn.readLineDouble();
        System.out.println("Ingrese valor de b: ");
        double b = TecladoIn.readLineDouble();
        System.out.println("Ingrese la cantidad de intervalos");
        int n = TecladoIn.readLineInt();
        if (n >= 2 && n % 2 == 0) {
            double h = Math.abs((b - a) / n);
            double areaAuxPar = 0;
            double areaAuxImpar = 0;
            for (int i = 1; i <= n - 1; i++) {
                if (i % 2 != 0) {
                    areaAuxImpar = areaAuxImpar + f(a + h * i);

                } else {
                    areaAuxPar = areaAuxPar + f(a + h * i);
                }

            }
            System.out.println("El área aproximada es: " + (h / 3) * (f(a) + f(b) + 4 * areaAuxImpar + 2 * areaAuxPar));
        } else {
            System.out.println("ERROR. n no es par o mayor-igual a 2");
        }
    }

    /*public static double f(double x){
        return 2*Math.sin(x+1);
    }*/
    public static double f(double x) {
        return Math.pow(x, 3) - 2 * x - 1;
    }

    public static double df(double x) {
        return 3 * Math.pow(x, 2) - 2;
    }

    public static void interpolacion() {
        System.out.println("Ingrese punto a aproximar");
        double punto = TecladoIn.readLineDouble();
        System.out.println("De qué grado será el polinomio?");
        int n = TecladoIn.readLineInt();
        int[] x = new int[n+1];
        double[] fx = new double[n+1];

        for (int i = 0; i <= n; i++) {
            System.out.println("Ingrese x" + i);
            int xi = TecladoIn.readLineInt();
            x[i] = xi;
            System.out.println("Ingrese f(x)");
            double fi = TecladoIn.readLineDouble();
            fx[i] = fi;
        }
        double valorAprox=0;
        switch (n) {
            case 1:
                valorAprox= fx[0]+((punto-x[0])*fCorch(0,1,x,fx));
                System.out.println("Valor aprox: \n"+
                        + valorAprox);
                break;
            case 2:
                System.out.println(x[2]-x[0]);
                double valor1=(punto - x[0]) * fCorch(0, 1, x, fx);
                double valor2= (punto - x[0])
                        * (punto - x[1]) ;
                double valor3=(fCorch(1, 2, x, fx)- fCorch(0, 1, x, fx));
                double valor4=x[2] - x[0];
                valorAprox= fx[0] + valor1 + (valor2 * ( valor3 / valor4 ));
                System.out.println("Valor aprox: \n"
                        +valorAprox);
                break;
            case 3:
                System.out.println("Valor aprox: \n"
                        + x[0] + (punto - x[0]) * fCorch(0, 1, x, fx));
                break;
            case 4:
                System.out.println("Valor aprox: \n"
                        + x[0] + (punto - x[0]) * fCorch(0, 1, x, fx));
                break;
            case 5:
                System.out.println("Valor aprox: \n"
                        + x[0] + (punto - x[0]) * fCorch(0, 1, x, fx));
                break;

        }

    }

    public static double fCorch(int pos1, int pos2, int[] a, double[] b) {
        double deno= b[pos2]-b[pos1];
        double num= a[pos2]-a[pos1];
        return deno / num;
    }

    public static void biseccion() {
        System.out.println("Escribir valor de a: ");
        double a = TecladoIn.readLineDouble();
        System.out.println("Ingrese valor de b: ");
        double b = TecladoIn.readLineDouble();
        System.out.println("Ingrese el valor del error E: ");
        double E = TecladoIn.readLineDouble();
        double r = 0;
        if (f(a) * f(b) < 0) {
            while (r == 0 || Math.abs(f(r)) > E) {
                r = (a + b) / 2;
                System.out.println("r: " + r);
                if (f(a) * f(r) < 0) {
                    b = r;
                } else {
                    a = r;
                }
            }
            System.out.println("Raiz aproximada: " + r);
        } else {
            System.out.println("No se cumple la condición inicial f(a)*f(b)<0");
        }
    }

    public static void newtonR() {
        System.out.println("Ingrese x0");
        double x0 = TecladoIn.readLineDouble();
        double x1 = x0;
        System.out.println("Ingrese error E");
        double E = TecladoIn.readLineDouble();
        double valor = 0;
        boolean error = false;
        int i = 0;
        while ((valor > E || valor == 0) && i <= 300) {
            System.out.println("x0: " + x0);
            System.out.println("f(x0): " + f(x0));
            double deriv = df(x0);
            System.out.println("df(x0): " + deriv);
            if (deriv != 0) {
                x1 = x0 - (f(x0) / df(x0));
                System.out.println("x1: " + x1);
                x0 = x1;
                valor = Math.abs(f(x1));
            } else {
                System.out.println("División por cero! ERROR");
                valor = E + 1;
                error = true;
            }
            i++;
        }
        if (!error && i < 300) {
            System.out.println("Raiz aproximada: " + x1);
        } else {
            System.out.println("No se pudo encontrar raíz.");
        }
    }

    public static void main(String[] args) {
        //biseccion();
        //newtonR();
        //areaTrapecio();
        //areaSimpson();
        //getError();
        interpolacion();
    }

}
