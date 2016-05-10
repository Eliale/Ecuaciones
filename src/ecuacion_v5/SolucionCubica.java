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
public class SolucionCubica implements Solucion {

    double[] coef;

    public SolucionCubica(double[] coeficientes) {
        coef = coeficientes;
    }

    @Override
    public double[] solucion() {
        double[] res = new double[3];
        res[0] = Double.NaN;
        res[1] = Double.NaN;
        res[2] = Double.NaN;
        double a, b, c, d, Q, R, S, S1, T, D, x1, x2, x3, thetha;
        double un_tercio = 0.3333333333;
        a = coef[0];
        b = coef[1];
        c = coef[2];
        d = coef[3];

        // Calcular Q,R,S,T,D
        Q = ((3 * c) - (Math.pow(b, 2))) / 9;
        R = ((9 * b * c) - (27 * d) - (2 * Math.pow(b, 3))) / 54;
        S1 = Math.sqrt(Math.pow(Q, 3.0) + Math.pow(R, 2.0));
        S = Math.cbrt(R + S1 );
        T = Math.cbrt(R - S1);
        D = (Math.pow(Q, 3.0) + Math.pow(R, 2.0));

        if (D < 0) {
            // Raices reales y diferentes xD usar trigonometria 
           
            thetha = R / Math.sqrt(-Math.pow(Q, 3));
            x1 = (2 * Math.sqrt(-Q) * Math.cos((un_tercio) + thetha) * ((un_tercio) * b));
            x2 = (2 * Math.sqrt(-Q) * Math.cos(((un_tercio) + thetha) + Math.toRadians(120)) * ((un_tercio) * b));
            x3 = (2 * Math.sqrt(-Q) * Math.cos(((un_tercio) + thetha) + Math.toRadians(249)) * ((un_tercio) * b));
     
            res[0] = x1;
            res[1] = x2;
            res[2] = x3;

        } else {
  
            x1 = (S + T) - (un_tercio * b);
            x2 = -(1 / 2) * (S + T) - (1 / 3) * b;
            x3 = -(1 / 2) * (S + T) - (1 / 3) * b;

            res[0] = x1;
            res[1] = x2;
            res[2] = x3;
        }
        return res;
    }

}
