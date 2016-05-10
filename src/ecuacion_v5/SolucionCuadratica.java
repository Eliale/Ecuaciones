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
class SolucionCuadratica implements Solucion {
     double[] cof;
    public SolucionCuadratica(double[] coeficientes) {
         this.cof = coeficientes;
    }

    @Override
    public double[] solucion() {
        double[] res = new double[2];
        if (cof.length == 3) {
            double a, b, c, discriminante, x1, x2, x3;
           
            a = cof[0];
            b = cof[1];
            c = cof[2];

            discriminante = (float) (Math.pow(b, 2) - (4 * a * c));

            if (discriminante == 0) {
                x3 = -b / (2 * a);
                System.out.println("Solo existe una solucion" + x3);
                res[0]=x3;
                res[1]=Double.NaN;
            }
            if (discriminante > 0) {
                x1 = ((-b + (Math.sqrt(Math.pow(b, 2) - (4 * a * c)))) / (2 * a));
                x2 = ((-b - (Math.sqrt(Math.pow(b, 2) - (4 * a * c)))) / (2 * a));
                res[0]=x1;
                res[1]=x2;

            } else {
                System.out.println("Raices imaginarias");
                res[0]=Double.NaN;
                res[1]=Double.NaN;
            }
            
        } else {
            System.out.println("Reescriba la ecuacion a la forma ax²+bx+c");
        }
        return res;
    }
    }
    

