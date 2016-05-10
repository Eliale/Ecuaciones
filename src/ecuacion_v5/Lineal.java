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
public class Lineal extends Ecuacion {

    public Lineal(double[] coeficientes) {
        super(coeficientes);
        fijar_solucion();
    }

   
    
    @Override
    public void fijar_solucion() {
        solucion = new SolucionLineal(simplificado);
    }
    
}
