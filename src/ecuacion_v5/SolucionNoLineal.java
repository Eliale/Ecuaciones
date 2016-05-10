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
class SolucionNoLineal implements Solucion {

    double[] coef;

    public SolucionNoLineal(double[] coeficientes) {
        coef = coeficientes;
    }

    @Override
    public double[] solucion() {
        /**
         * Aqui se hace el proceso iterativo para aproximar la raiz
         *
         * @param x0.- valor inicial
         * @param Er.- error de paro
         * @param MaxIt.- Maximo de iteracion que realiza
         * @return raiz aproximada.
         */
        double x0 = 0;
        double Er = 0.0001;
        int MaxIt = 100;
        double[] res = new double[1];
        double raiz = 0, delta = 0.0001, Error = 1, raize = 0;

        for (int i = 1; i <= MaxIt; i++) {
            raiz = x0 - Funcion(x0) / DerivadaFuncion(x0, delta);
            Error = Math.abs((raiz - x0) / raiz);
            if (Error <= Er) {
                raize = raiz;
                break;
            }
            x0 = raiz;
            System.out.println("Iteracion: " + i + " \tEa = " + Error + " \t Raiz = " + raiz);
        }
        //  System.out.println("x" + (coeficientes.length - 1 + " = ") + (float)raize);
        res[0] = raize;
        return res;
    }

    public double Funcion(double x) {
        int potencia = coef.length - 1;
        double suma = 0;
        for (int i = 0; i < coef.length; i++) {
            suma += coef[i] * Math.pow(x, potencia);
            potencia -= 1;
        }
        return suma;

    }

    /**
     * Aqui se calcula la derivada, haciendo uso de la definicion de limite es
     * decir usando una diferencia finita
     *
     * @param x: valor donde se evalua la derivada
     * @param delta: espacio de evaluacion
     * @return derivada evaluada en x
     */
    public double DerivadaFuncion(double x, double delta) {
        return (Funcion(x + delta) - Funcion(x)) / delta;
    }

}
