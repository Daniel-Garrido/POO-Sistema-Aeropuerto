package Paquete_1;
import java.util.Scanner;
/*ESTA ES LA CLASE PRINCIPAL DEL PROGRAMA*/
public class Principal {
    static Scanner entrada = new Scanner(System.in);
    final static int num  = 4;// numero de aeropuertos
    static Aeorpuerto aeropuertos[ ] = new Aeorpuerto[num];
    
    public static void main(String[] args) {
        //insertar datos de los aeropuertos   
        insertarDatosDelAeropuerto(aeropuertos);
        menu();
    }
    
    public static void menu() {
        int opcion;
        String nombreAeropuerto, nombreCompañia, origen, destino;
        Aeorpuerto aeropuerto;
        Compañia compañia;
        do {
            System.out.println("\tMENU");
            System.out.println("1. Ver aeropuertos (Publicos o Privados)");
            System.out.println("2. Mostrar empresas(Privados) o subvencion(Publicos) - Aeropuertos");
            System.out.println("3. Mostrar compañias de un determinado aeropuerto");
            System.out.println("4. Listar los vuelos de una compañia");
            System.out.println("5. Mostrar los vuelos de origen a destino");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");
            opcion = entrada.nextInt();
            //
            switch (opcion) {

                case 1:
                    System.out.println(" ");//ver los aeropuertos
                    mostrarDatosAeropuertos(aeropuertos);
                    break;
                case 2:// ver el tipo de empresa (privada o publica)
                    System.out.println("");
                    mostrarPatrocinio(aeropuertos);
                    break;
                case 3:// listas de las compañias de un aeropuerto
                    entrada.nextLine();
                    System.out.print("\n digite el nombre del Aeropuerto");
                    nombreAeropuerto = entrada.nextLine();
                    aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                    if (aeropuerto == null) {
                        System.out.println(" el aeropuerto no existe");
                    } else {
                        mostrarCompañia(aeropuerto);
                    }
                    break;
                case 4://lista de vuelo por compañia
                    entrada.nextLine();
                    System.out.println("digite el nomre del aeropuerto");
                    nombreAeropuerto = entrada.nextLine();
                    aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                    if (aeropuerto == null) {
                        System.out.println("El aeropuerto no existe");
                    } else {
                        System.out.println("digite el nombre de la compañia");
                        nombreCompañia = entrada.nextLine();
                        compañia = aeropuerto.getCompañia(nombreCompañia);
                        if (compañia == null) {
                            System.out.println(" la compañia no existe");
                        } else {
                            mostrarVuelos(compañia);
                        }
                    }
                    break;
                case 5: //llenar los posibles vuelos de origen a destino 
                    entrada.nextLine();
                    System.out.println("digite la cidudad de origen");
                    origen = entrada.nextLine();
                    System.out.println(" Digite la ciudad de destino ");
                    destino = entrada.nextLine();
                    mostrarVueloOrigenDestino(origen, destino, aeropuertos);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Error! se confundio de opcion de menu");
            }
            System.out.println("");
        } while (opcion != 6);
    }
    
    //llenamos los datos de los aeropuertos 
    public static void insertarDatosDelAeropuerto(Aeorpuerto aero[]){
        aero[0] = new Aeropuerto_Publico(80000000, "Jorge Chavez", "Lima", "Peru");
        aero[0].insertarCompañia(new Compañia("Iberia"));
        aero[0].insertarCompañia(new Compañia("Lufthansa"));
        aero[0].getCompañia("Iberia").insertarVuelo(new Vuelos("IB2022","Lima","Londres",287.50,150));
        aero[0].getCompañia("Iberia").getVuelo("IB2022").insertarPasajero(new Pasajero("Emilio","384794GH","Española"));
        aero[0].getCompañia("Iberia").getVuelo("IB2022").insertarPasajero(new Pasajero("Arturo","77999EE","Peruana"));
        
        aero[1] = new Aeropuerto_Privado("Central Ciudad Real","Ciudad Real","España");
        aero[1].insertarCompañia(new Compañia("AirEuropa"));
        String empresas[] = {"Cobresol","Anguila34"};
        ((Aeropuerto_Privado)aero[1]).insertarEmpresas(empresas);
        aero[1].getCompañia("AirEuropa").insertarVuelo(new Vuelos("AE025","Madrid","Buenos Aires",150.50,120));
        aero[1].getCompañia("AirEuropa").getVuelo("AE025").insertarPasajero(new Pasajero("Juan Pablo","EA384794","Mexicana"));
        
        aero[2] = new Aeropuerto_Publico(20000000,"Aeropuerto Bogota","Bogota","Colombia");
        aero[2].insertarCompañia(new Compañia("AirAmerica"));
        aero[2].insertarCompañia(new Compañia("VuelaBogota"));
        aero[2].getCompañia("AirAmerica").insertarVuelo(new Vuelos("AE030","Bogota","Lima",130.90,110));
        aero[2].getCompañia("AirAmerica").getVuelo("AE030").insertarPasajero(new Pasajero("Damaris","000AA4G5","Colombiana"));
        
        aero[3] = new Aeropuerto_Publico(40000000,"Aeropuerto Mexico","Mexico","Mexico");
        aero[3].insertarCompañia(new Compañia("AeroMexico"));
        aero[3].getCompañia("AeroMexico").insertarVuelo(new Vuelos("IB2040","Mexico","Nueva York",130.90,140));
        aero[3].getCompañia("AeroMexico").insertarVuelo(new Vuelos("IB2042","Mexico","Lima",100.80,150));
        aero[3].getCompañia("AeroMexico").getVuelo("IB2040").insertarPasajero(new Pasajero("Maria","AA4794H","Inglesa"));
    }
    
    public static void mostrarDatosAeropuertos(Aeorpuerto aeropuertos[]){
        for(int i =0; i < aeropuertos.length; i++){
            if(aeropuertos[i] instanceof Aeropuerto_Privado){
                System.out.println("AEROPUERTO PRIVADO ");
                System.out.println(" Nombre "+aeropuertos[i].getNombre());
                System.out.println(" Ciudad"+aeropuertos[i].getCiudad());
                System.out.println(" pais"+aeropuertos[i].getPais());
         
            }
            else {
                System.out.println("AEROPUERTO PUBLICO ");
                System.out.println(" Nombre "+aeropuertos[i].getNombre());
                System.out.println(" Ciudad"+aeropuertos[i].getCiudad());
                System.out.println(" pais"+aeropuertos[i].getPais());
                
            }
            System.out.println(" ");
        
       }
        
    }
    
    public static void mostrarPatrocinio(Aeorpuerto aeropuertos []){
        String empresas[];
        for(int i  =0; i<aeropuertos.length; i++){
            if(aeropuertos [i] instanceof Aeropuerto_Privado){
                System.out.println("Aeropuerto privado " +aeropuertos[i].getNombre());
                empresas = ((Aeropuerto_Privado) aeropuertos[i]).getListaEmpresas();
                System.out.println("EMPRESAS");
                for(int j =0; j<empresas.length; j++){
                    System.out.println(empresas[j]);
                }
            }
            else{
                System.out.println("Aeropuerto public :" + aeropuertos[i].getNombre());
                System.out.println("Subvencion: "+((Aeropuerto_Publico)aeropuertos[i]).getSubvencion());
                
            }
            System.out.println(" ");
        }
    }
    public static Aeorpuerto buscarAeropuerto(String nombre, Aeorpuerto aeropuertos []){
        boolean encontrado = false;
        int i =0;
        Aeorpuerto aero = null;
        while((!encontrado) && (i<aeropuertos.length)){
            if(nombre.equals(aeropuertos[i].getNombre())){
               encontrado = true;
               aero = aeropuertos[i];
            }
            i++;
        }
        return aero;
    }
    
    public static void mostrarCompañia(Aeorpuerto aeropuerto){
        System.out.println(" las compañias del aeropuerto" +aeropuerto.getNombre());
        for( int i =0; i<aeropuerto.getNumCompañia(); i++){
            System.out.println(aeropuerto.getCompañia(i).getNombre());
        }
    }
    
    public static void mostrarVuelos(Compañia compañia){
        Vuelos vuelo;
        System.out.println(" los vuelos de la compañia :" + compañia.getNombre());
        for(int i =0; i<compañia.getNumVuelo(); i++){
            vuelo = compañia.getVuelo(i);
            System.out.println("identificador :"+vuelo.getIdentificadorVuelo());
            System.out.println(" ciudad de origen :"+vuelo.getCiudadOrigen());
            System.out.println(" ciudad de destino :"+vuelo.getCiudadDestino());
            System.out.println("");
            
        }
    }
    public static Vuelos[] buscarVuelosOrigenDestino(String origen, String destino ,Aeorpuerto aeropuertos[]){
        Vuelos vuelo;
        Vuelos listaVuelos[];
        int contador =0;
        for( int i =0; i<aeropuertos.length; i++){
            for(int j =0; j<aeropuertos[i].getNumCompañia(); j++){
                 for(int k=0;k<aeropuertos[i].getCompañia(j).getNumVuelo();k++){
                 vuelo = aeropuertos[i].getCompañia(j).getVuelo(k);
                 if(origen.equals(vuelo.getCiudadOrigen()) && destino.equals(vuelo.getCiudadDestino())){
                        contador++;
                    } 
                }
            }
        }
        listaVuelos = new Vuelos[contador];
        int q =0;
        
        for(int i=0;i<aeropuertos.length;i++){
            for(int j=0;j<aeropuertos[i].getNumCompañia();j++){
                for(int k=0;k<aeropuertos[i].getCompañia(j).getNumVuelo();k++){
                    vuelo = aeropuertos[i].getCompañia(j).getVuelo(k);
                    if(origen.equals(vuelo.getCiudadOrigen()) && destino.equals(vuelo.getCiudadDestino())){
                        listaVuelos[q] = vuelo;
                        q++;
                    }
                }
            }
        }
        
        return listaVuelos;
    }
    
    public static void mostrarVueloOrigenDestino(String origen, String destino ,Aeorpuerto aeropuertos[]){
        Vuelos vuelos[];
        vuelos = buscarVuelosOrigenDestino(origen, destino, aeropuertos);
        if(vuelos.length == 0){
            System.out.println("No existen vuelos");
        }
        else{
            System.out.println("\nVuelos Encontrados:");
            for(int i=0;i<vuelos.length;i++){
                System.out.println("Identificador: "+vuelos[i].getIdentificadorVuelo());
                System.out.println("Ciudad Origen: "+vuelos[i].getCiudadOrigen());
                System.out.println("Ciudad Destino: "+vuelos[i].getCiudadDestino());
                System.out.println("Precio: $"+vuelos[i].getPrecio());
            }
        }
        
    }
}
