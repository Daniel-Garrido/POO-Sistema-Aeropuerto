//creamos la quinta clase 
//aeropuerto privado
package Paquete_1;
public class Aeropuerto_Privado extends Aeorpuerto{//aeropuerto privado es un clase hija de aeropuerto
 //atributos globles
    private String listaEmpresas[] = new String[10];
    private int  numEmpresas;
//metodos constructores   1
    public Aeropuerto_Privado( String nombre, String ciudad, String pais){
        super(nombre, ciudad, pais);
    }
//metodo constructor 2
    public Aeropuerto_Privado(String nombre, String ciudad, String pais, Compañia[] c, String e []) {
        super(nombre, ciudad, pais, c);
        this.listaEmpresas =e;
        numEmpresas = e.length;
    }
//metodo para insertar las emoresas    
    public void insertarEmpresas(String e[]){
        this.listaEmpresas =e;
        numEmpresas =e.length;
    }
    public void insertarEmpresa(String e){
        listaEmpresas[numEmpresas]=e;
        numEmpresas++;
    }
//metodos getters
    public String[] getListaEmpresas() {
        return listaEmpresas;
    }
    public int getNumEmpresas() {
        return numEmpresas;
    }
}
