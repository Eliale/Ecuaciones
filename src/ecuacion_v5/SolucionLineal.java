/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecuacion_v5;


/**
 *
 * @author Multivac
 */
public class SolucionLineal implements Solucion {

    double[] cof;

    public SolucionLineal(double[] coeficientes) {
        this.cof = coeficientes;
    }

    @Override
    public double[] solucion() {
        double m, b, x = 0;
        double res[] = new double[1];
        // Coeficiente de X
        if (cof.length == 2) {
            m = cof[0];
            b = cof[1];
            if (m == 0) {
                System.err.println("No es una ecuacion");
            } else {
                x = -b / m;

               // System.out.println("x = " + x);
            }
        } else {
            System.out.println("Reescribe la ecuacion a la forma mx+b");
        }
        res[0] = x;
        return res;
    }

}
