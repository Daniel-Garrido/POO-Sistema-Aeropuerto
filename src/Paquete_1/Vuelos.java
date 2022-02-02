/*ESTA ES LA SEGUNDA CLASE QUE CREAMOS DEL PROYECTO*/
package Paquete_1;
public class Vuelos {// CREAMOS LA CLASE VUELO 
/*CREAMOS NUESTROS ATRIBUTOS GLOBALES DE LA CLASE VUELO*/
private String identificadorVuelo;
private String ciudadOrigen;
private String ciudadDestino;
private double precio;
private int numMaxPasajeros;
private int numActualPasajeros;
//creamos el arreglo para la lista de los pasajeros
private Pasajero Listapasajeros[]; 
//metodo constructor de mi clase 
  

    public Vuelos(String identificador, String ciudadOrigen, String ciudadDestino, double precio, int numMaxPasajeros) {
        this.identificadorVuelo = identificador;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.precio = precio;
        this.numMaxPasajeros = numMaxPasajeros;
        this.numActualPasajeros = 0;
        this.Listapasajeros = new Pasajero[numMaxPasajeros];
    }
   
    // creamos el metodo para insertar la cantidad de pasajeros
    public void insertarPasajero(Pasajero pasajero){
        Listapasajeros[numActualPasajeros]=pasajero;
        numActualPasajeros++;   
    }
    //construimos metodos getters
    public String getIdentificadorVuelo() {
        return identificadorVuelo;
    }
    public String getCiudadOrigen() {
        return ciudadOrigen;
    }
    public String getCiudadDestino() {
        return ciudadDestino;
    }
    public double getPrecio() {
        return precio;
    }
    public int getNumMaxPasajeros() {
        return numMaxPasajeros;
    }
    public int getNumActualPasajeros() {
        return numActualPasajeros;
    }
    //creamos el metodo getters del arreglo de la lista de pasajeros
    public Pasajero getPasajero(int i ){
        return Listapasajeros[i];    
    }
    //creamos el metodo getters de pasajero
    public Pasajero getPasajero(String pasaporte){
      boolean encontrado = false;// lo inicalizamos con false
      int i =0;//iterador lo inicalizamos en cero
      Pasajero pas = null;
     
      while((encontrado==false)&&(i<Listapasajeros.length)){
         if(pasaporte.equals(Listapasajeros[i].getPasaporte())){
             encontrado=true;
             pas = Listapasajeros[i];// guardamos los datos del pasajero en la lista
         }
         i++;
     }
     return pas;//retornamos el pasajero
    }
}
