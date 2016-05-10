/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecuacion_v5;

/**
 *
 * @author Eli Salinas
 */
public abstract class Ecuacion {

    // Coeficientes contiene coeficientes(par) y potencias(impar) 
    double[] coeficientes;
    double[] simplificado;
    Solucion solucion;

    public Ecuacion(double[] coeficientes) {
        this.coeficientes = coeficientes;
        simplificado = simplificar();

    }

    public abstract void fijar_solucion();

    public void mostrar_simplificado() {
        String cadena = new String();
        int potencia = simplificado.length - 1;

        for (int i = 0; i < simplificado.length; i++) {
            String signo = "";
            if (simplificado[i] >= 0) {
                signo = "+";
            }
            if (potencia >= 2) {
                cadena += signo + (int) simplificado[i] + "x" + "^" + potencia;
            }
            if (potencia == 1) {
                cadena += signo + (int) simplificado[i] + "x";
            }
            if (potencia == 0) {
                cadena += signo + (int) simplificado[i];
            }
            potencia -= 1;
        }
        System.out.println("Ecuacion Simplificada: " + cadena.substring(1));
    }

    public void mostrar() {
        String cadena = new String();
        for (int i = 0; i < coeficientes.length; i += 2) {
            String signo = "";
            if (coeficientes[i] >= 0) {
                signo = "+";
            }
            if (coeficientes[i + 1] >= 2) {
                cadena += signo + (int) coeficientes[i] + "x" + "^" + (int) coeficientes[i + 1];
            }
            if (coeficientes[i + 1] == 1) {
                cadena += signo + (int) coeficientes[i] + "x";
            }
            if (coeficientes[i + 1] == 0) {
                cadena += signo + (int) coeficientes[i];
            }

        }
        System.out.println("Ecuacion a solucionar: " + cadena.substring(1));

    }

    public void mostrar_solucion() {
        double sol[] = solucion.solucion();
        // System.out.println("En muestra solucion:" + Arrays.toString(sol));

        for (int i = 0; i < sol.length; i++) {
            System.out.println("x" + (i + 1) + "= " + sol[i]);

        }
    }

    private int calcula_nuevo_tamanio() {
        // Verifica la potencia maxima en el arreglo esto definira el tamaño nuevo del arreglo ya que sera esta potencia + 1
        int max = 0;
        for (int i = 1; i < coeficientes.length; i += 2) {
            if (coeficientes[i] > max) {
                max = (int) coeficientes[i];
            }
        }
        return max + 1;
    }

    private double[] simplificar() {
        // Calcular el tamaño ordenado del arreglo
        int tamanio_ordenado = calcula_nuevo_tamanio();
        int potencia_maxima = tamanio_ordenado - 1;
        double[] ord = new double[tamanio_ordenado];
//        Sumar los elementos en el arreglo que tengan la misma potencia xD empezar desde potencia maxima esto es 
//        tamanio_ordenado -1
//      Llenar ord desde 0 teniendo en 0 la suma de las potencias maximas, en 1 la suma de potencia maxima -1 y asi sucesivamente
        for (int i = 0; i < ord.length; i++) {
            // Inicia suma en cero por si no ponen coeficientes de alguna potencia si 2x²+3 inifiere que es: 2x²+0x+3
            int suma = 0;
            for (int j = 0; j < coeficientes.length; j += 2) {
                // Suma todos los coeficientes pertenecientes a una misma potencia 
                if (coeficientes[j + 1] == potencia_maxima) {
                    suma += coeficientes[j];
                }
            }
            ord[i] = suma;
            
            potencia_maxima--;
        }
        return ord;

    }

}
