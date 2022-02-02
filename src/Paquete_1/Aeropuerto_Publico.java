/*CREAMOS LA 6TA CLASE
 * AEROPUERTO PUBLICO*/
package Paquete_1;
public class Aeropuerto_Publico extends Aeorpuerto {// ES UNA CLASE HIJA DE AEROPUERTO
    //ATRIBUTOS GLOBALES  
    private double subvencion;
//constructor 1      
    public Aeropuerto_Publico(String nombre, String ciudad, String pais){
          super(nombre, ciudad,pais);
     }
//constructor 2
    public Aeropuerto_Publico(double subvencion, String nombre, String ciudad, String pais, Compañia[] c) {
        super(nombre, ciudad, pais, c);
        this.subvencion = subvencion;
    }
//constructor 3
    public Aeropuerto_Publico(double subvencion, String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
        this.subvencion = subvencion;
    }
//metodo getters
    public double getSubvencion() {
        return subvencion;
    } 
}
