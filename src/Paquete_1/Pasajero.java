/*
 ESTA ES LA CLASE CON LA QUE EMPEZAMOS A HACER EL PROYECTO 
 */
package Paquete_1;
public class Pasajero {
//attributos globales de mi clase
//aplicamos el encapsulamiento al poner los atributos en private
    private String nombre;
    private String pasaporte;
    private String nacionalidad;        
//metodo constructor 
    public Pasajero(String nombre , String pasaporte , String nacionalidad){
        this.nombre=nombre;
        this.pasaporte=pasaporte;
        this.nacionalidad=nacionalidad;
    }
    //METODOS GETTERS
    public String getNombre(){// nos retornará el nombre
        return nombre;   
    }
    public String getPasaporte(){
        return pasaporte;// nos retornará el pasaporte
    }
    public String getNacionalidad(){
        return nacionalidad; // nos retornará la nacionalidad
    }
}
