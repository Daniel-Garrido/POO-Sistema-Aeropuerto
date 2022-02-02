//creamos la 4ta clase que se llama aeropuerto
package Paquete_1;
//atributos globlaes de la clase aeropuerto
public class Aeorpuerto {
    private String nombre;//nombre del aeropuerto
    private String ciudad;//cuidad del aeropuerto
    private String pais;// pais del aeropuerto
    private Compañia listaCompañia[] = new Compañia[10];// le ponemos que son 10 compañias
    private int numCompañia;// el numero de cada compañia
    
    //mcreamos el constrructor
    public Aeorpuerto(String nombre, String ciudad, String pais){
        this.nombre= nombre;
        this.ciudad =ciudad;
        this.pais =pais;
        numCompañia=0;//inicalizamos el numero de compañia en cero        
    }
    //creamos el segundo constructor
    public Aeorpuerto(String nombre, String ciudad, String pais, Compañia c[]){
        this(nombre,ciudad,pais);
        listaCompañia =c;
        numCompañia = c.length;
    }
    
    //creamos el metodo para insertar las compañias
    public void insertarCompañia(Compañia c){
        listaCompañia[numCompañia]=c;
        numCompañia++;
    }
    //creamos los metodo getters***********
    public String getNombre() {
        return nombre;
    }
    public String getCiudad() {
        return ciudad;
    }
    public String getPais() {
        return pais;
    }
    //creamos el metodot getters del arreglo de compañia
    public Compañia[] getListaCompañia() {
        return listaCompañia;
    }
    public int getNumCompañia() {
        return numCompañia;
    }
    public Compañia getCompañia(int i){
        return listaCompañia[i];
    }
    
    public Compañia getCompañia(String nombre){
        boolean encontrado = false;
        int i =0;
        Compañia c = null;
        while((!encontrado)&&(i<listaCompañia.length)){
            if(nombre.equals(listaCompañia[i].getNombre())){
                encontrado = true;
                c = listaCompañia[i];
            }
            i++;
        }
        return c;
        
    }
}
