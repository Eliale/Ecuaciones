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
public class Main {

    public static void main(String[] args) {
        // Par Coeficiente Impar Potencia
        System.out.println("----------------ECUACION LINEAL------------------------");
        double[] coef = {2, 1, 3, 1, 4, 1, 2, 0, 1, 0, 3, 1};
        Ecuacion lineal = new Lineal(coef);
        lineal.mostrar();
        lineal.mostrar_simplificado();
        lineal.mostrar_solucion();

        System.out.println("----------------ECUACION CUADRATICA------------------------");
        double[] coef2 = {2, 2, -5, 0, 3 , 2, 6 , 0};
        Ecuacion cuadrada = new Cuadratica(coef2);
        cuadrada.mostrar();
        cuadrada.mostrar_simplificado();
        cuadrada.mostrar_solucion();

//        System.out.println("----------------ECUACION CUBICA------------------------");
//        double[] coef3 = {10, 5, 2, 3};
//        Ecuacion cubica = new Cubica(coef3);
//        cubica.mostrar();
//        cubica.mostrar_solucion();
        System.out.println("----------------ECUACION NO LINEAL------------------------");
        double[] coef4 = {2, 3, 3, 2, 4, 1, 7, 0, 9, 3, 5, 1, 7, 0};
        Ecuacion nolineal = new NoLineal(coef4);
        nolineal.mostrar();
        nolineal.mostrar_simplificado();
        nolineal.mostrar_solucion();
    }
}
