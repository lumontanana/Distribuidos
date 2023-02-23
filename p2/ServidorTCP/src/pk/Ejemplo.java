/*

 CLASE SERVIDOR
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class Ejemplo implements Serializable {

    int x;
    Ejemplo p1;
    Ejemplo[] p2;
    Boolean visitado = false;

    Ejemplo() {
    }

    public void Recorrido() {
        System.out.println("Entro en recorrido");

        if (!visitado) {
            System.out.println("El objeto no esta visitado aun");
            visitado = true;
            //Mostramos la variable x
            System.out.println("La variable x = " + x);
            //Mostramos referencia p1
            if (p1 != null) {
                p1.Recorrido();
            }
            //Mostramos referencia p2
            
            if(p2!=null){
                for (Ejemplo ejemplo : p2) {
                    if (ejemplo != null) {
                        ejemplo.Recorrido();
                    }

                }
                
            }
            
            
        }

        System.out.println("Saliendo de recorrido...");

    }

}

