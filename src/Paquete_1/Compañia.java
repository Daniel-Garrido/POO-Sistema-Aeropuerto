/*
ESTE ES LA TERCERA CLASE QUE SE DEBE DE HACER EN EL PROYECTO 
 */
package Paquete_1;
public class Compañia {
//ATRIBUTOS GLOBALES
    private String nombre;//nombre de la compañia
    private Vuelos listaVuelos[] = new Vuelos[10];// la cantidad de vuelos que pueden tener 
    private int numVuelo =0; // los numeros de vuelos que pueden tener 
 
//creamos el metodo constructor de la clase compañia
    public Compañia(String nombre){
        this.nombre = nombre;
    }
    public Compañia(String nombre, Vuelos v[]){
        this.nombre=nombre;
        listaVuelos=v;//aca se guarda el numero de la lista de vuelos
        numVuelo =v.length;//me debe de decir la cantidad de vuelos        
    }
    //metodo para insertar los vuelos
    public void insertarVuelo(Vuelos vuelo){
        listaVuelos[numVuelo]=vuelo;
        numVuelo++;
    }

    //METODOS GETTERS**************************
    public String getNombre() {
        return nombre;
    }
    public int getNumVuelo() {
        return numVuelo;
    }
    //este es el metodo getter de la lista de vuelos usando el arreglo
    public Vuelos getVuelo(int i ){
        return listaVuelos[i];    
    }
    //creamos el metodo para verificar los vuelos
    //-------------------------------------------------------------------------
    public Vuelos getVuelo(String id ){
        boolean encontrado = false;
        int i =0;
        Vuelos v = null;
        
        while((!encontrado)&&(i<listaVuelos.length)){
            if(id.equals(listaVuelos[i].getIdentificadorVuelo())){
                encontrado = true;
                v = listaVuelos[i];
            }
            i++;            
        }
        return v;
    }
}
