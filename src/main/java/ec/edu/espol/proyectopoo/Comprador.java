/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espol.proyectopoo;

import ec.espol.edu.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JOSUE
 */
public class Comprador{
    private static ArrayList<Comprador> compradoresRegistrados = new ArrayList<>();
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String organizacion;
    private String clave;
    private int IdComprador;
    private ArrayList<Oferta> ofertas;
    


    public Comprador(int id, String nombre, String apellido, String organizacion, String correoElectronico, String clave) {
        this.IdComprador= id;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.organizacion = organizacion;
        this.clave = clave;
        ofertas =  new ArrayList<>();       
    }


    public Comprador(String nombre, String apellido, String organizacion, String correoElectronico, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.organizacion = organizacion;
        this.clave = clave;
        ofertas =  new ArrayList<>();
    }

    public ArrayList<Oferta> getOfertas() {
        return ofertas ;
    }

    public void setOfertas (ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
    }
    
    
    
    public static void RegistarNuevoComprador(String archivoCompradores){
    
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese el Nombre:");
        String nombre = sc.nextLine();
        
        System.out.println("Ingrese los Apellidos");
        String apellidos = sc.nextLine();
        
        System.out.println("Ingrese la organización");
        String organizacion = sc.nextLine();
      
        
        Comprador.saveFile(new ArrayList<>(), archivoCompradores);
        //VALIDACION DE CORREO
        //obteniendo todos los vendedores y almacenando sus correos en una lista
        ArrayList<Comprador> compradores = Comprador.readFile(archivoCompradores);
        ArrayList<String> correos = new ArrayList<>();
        for(Comprador ven: compradores){
            String c1 = ven.correoElectronico;
            correos.add(c1);
        }
        //validar que el correo sea unico
        boolean seguirEjecutando = false;
        //el boolean se incializa con false para que no se repita
        String correoElectronicoIn; //correoElectronico ingresado
        do{
            System.out.println("Ingrese el Correo Electronico");
            correoElectronicoIn= sc.nextLine();
        for(String cor: correos){
            if(cor.equals(correoElectronicoIn)){
                System.out.println("El email ya existe, por favor ingresar otro mail");
                seguirEjecutando = true;
                break;
            }
            seguirEjecutando = false;
        }
        }while(seguirEjecutando);

        String claveIn;
        do{
            System.out.println("Ingrese la Clave");
            claveIn = sc.nextLine();
            try {
                if (!claveIn.isBlank()) {  // Valida que la clave no esté vacía
                    byte[] claveAlmacenar = GFG2.getSHA(claveIn);
                } else {
                    System.out.println("La clave no puede estar vacía.");
                }
            } catch (NoSuchAlgorithmException e) {
                claveIn = null; //hace que la clave se pueda volcer a ingresar
                System.out.println("Error Clave no se puede Generar");
            }   
        }while(claveIn.isBlank());
        
        Comprador vAgregar = new Comprador(nombre, apellidos, organizacion, correoElectronicoIn, claveIn);//la claveIn es la clave sin hash code
        
        vAgregar.saveFile(archivoCompradores);
        
        System.out.println("Comprador registrado");
        

    
        
/*        
        ArrayList<String> correos = new ArrayList<>();
        for(Comprador comprador: Comprador.getCompradoresRegistrados()){
            String correo = comprador.getCorreoElectronico();
            correos.add(correo);
        }

        String correoElectronico;
        while(true){
            System.out.println("Ingrese su correoElectronico");
            correoElectronico = sc.nextLine();
            
            if(correos.contains(correoElectronico)){
                System.out.println("El email ya existe, por favor ingresar otro mail");
            }else{
                break;
            }
        }
        
        String clave;
        
        while(true){
            System.out.println("Ingrese clave: ");
            clave = sc.nextLine();
            
            if(clave.isEmpty()){
                System.out.println("La clave no puede estar vacia, ingrese una clave valida");

            }else{
                break;
            }
        }
        try{

            byte[] hashClave = GFG2.getSHA(clave);
            String hashedClave = GFG2.toHexString(hashClave);
            clave = hashedClave;

        } catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        try(FileWriter fw = new FileWriter(archivoCompradores, true);
            PrintWriter pw = new PrintWriter(fw)){
            pw.println(Util.nextID(archivoCompradores)+"-"+correoElectronico + "-" + clave);
             
        }catch(IOException o){
            o.printStackTrace();

        }
 




       
        Comprador  c1 = new Comprador(Util.nextID(archivoCompradores),nombre, apellidos, organizacion, correoElectronico, clave);
        Comprador.getCompradoresRegistrados().add(c1);
        
        System.out.println("Comprador registrado");
        
        sc.close();
        */


    }

//nota elimninar posiblemente    
    public static ArrayList<String> getCorreos(){
        ArrayList<String> correos = new ArrayList<>();
        for(Comprador c: Comprador.getCompradoresRegistrados()){
            String correo = c.getCorreoElectronico();
            correos.add(correo);
        }
        return correos;
               
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getIdComprador() {
        return IdComprador;
    }

    public void setIdComprador(int IdComprador) {
        this.IdComprador = IdComprador;
    }

    public static ArrayList<Comprador> getCompradoresRegistrados() {
        return compradoresRegistrados;
    }

    public static void setCompradoresRegistrados(ArrayList<Comprador> compradoresRegistrados) {
        Comprador.compradoresRegistrados = compradoresRegistrados;
    }
    
    
        
    
        public static Comprador searchById(ArrayList<Comprador> compradores, int id){
            for(Comprador c: compradores)
            {
                if(c.IdComprador == id)
                    return c;
            }
            return null;
        }

    public static void ofertarxVehiculo(String archivoCompradores, String archivoVehiculos, String archivoOfertas) throws NoSuchAlgorithmException {

        Scanner sc = new Scanner(System.in);     
        ArrayList<Comprador> compradores = Comprador.readFile(archivoCompradores);
        
        ArrayList<String> correos = new ArrayList<>();
        for(Comprador v: compradores){
            String c1 = v.getCorreoElectronico();
            correos.add(c1);
        }
        
        boolean seguirEjecutando = false;
        String correoElectronicoIn; 
        Comprador vRevisarClave = null;
        do{
            System.out.println("Ingrese el Correo Electronico");
            correoElectronicoIn= sc.nextLine();
            
            for(int i =0; i<correos.size();i++){
                if(!(correos.get(i).equals(correoElectronicoIn))){
                    seguirEjecutando = true;
                    //seguir ejecutando cambia a true para que se vuelva a pedir todo
                    //el break sirve para que seguirEjecutando no cambie a false
                }else{
                    seguirEjecutando = false; //actualiza el seguirEjecutando cuando encuentra el correo igual
                    vRevisarClave = compradores.get(i);                
                    break; //acaba con el for
                } 
            }
            if(seguirEjecutando)
                System.out.println("Correo ingresado no existe, ingrese un correo correcto");
        }while(seguirEjecutando);
        
        String claveVerificar;
        
        do {
            System.out.println("Ingrese la clave:");
            claveVerificar = sc.nextLine(); 
            claveVerificar = GFG2.toHexString(GFG2.getSHA(claveVerificar));
            if(!claveVerificar.equals(vRevisarClave.getClave())){
                System.out.println("Clave Ingresada es incorrecta, ingrese la clave correcta");
                seguirEjecutando = true;
            }else
                seguirEjecutando = false;
            
        }while(seguirEjecutando);


/*        
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese su correoElectronico:");
        String correoElectronico = sc.nextLine();
        ArrayList<String> correos = Comprador.getCorreos();
        if(!correos.contains(correoElectronico)) {
            System.out.println("Debe registrarse antes de poder hacer una oferta.");
            sc.close();
            return;
        }
*/
    

    try {
        System.out.println("Ingrese el modelo de vehículo:");
        String modelo = sc.nextLine();
        if (modelo.isEmpty()) modelo = null;

        System.out.println("Ingrese el rango de recorrido en el formato min-max:");
        String recorrido = sc.nextLine();
        double minRecorrido = 0;
        double maxRecorrido = Double.MAX_VALUE;
        if (!recorrido.isEmpty()) {
            String[] parts = recorrido.split("-");
            minRecorrido = Double.parseDouble(parts[0]);
            maxRecorrido = Double.parseDouble(parts[1]);
        }

        System.out.println("Ingrese el rango de año en el formato min-max:");
        String año = sc.nextLine();
        int minAño = Integer.MIN_VALUE;
        int maxAño = Integer.MAX_VALUE;
        if (!año.isEmpty()) {
            String[] parts = año.split("-");
            minAño = Integer.parseInt(parts[0]);
            maxAño = Integer.parseInt(parts[1]);
        }

        System.out.println("Ingrese el rango de precio en el formato min-max:");
        String precio = sc.nextLine();
        double minPrecio = 0;
        double maxPrecio = Double.MAX_VALUE;
        if (!precio.isEmpty()) {
            String[] parts = precio.split("-");
            minPrecio = Double.parseDouble(parts[0]);
            maxPrecio = Double.parseDouble(parts[1]);
        }

        ArrayList<Vehiculo> vehiculos = Vehiculo.readFile(archivoVehiculos);
        ArrayList<Vehiculo> vehiculosFiltrados = new ArrayList<>();
         for (Vehiculo v : vehiculos) {
               if ((modelo == null || v.getModelo().equals(modelo)) &&
                (v.getRecorrido() >= minRecorrido && v.getRecorrido() <= maxRecorrido) &&
                (v.getAño() >= minAño && v.getAño() <= maxAño) &&
                (v.getPrecio() >= minPrecio && v.getPrecio() <= maxPrecio)) {
                 vehiculosFiltrados.add(v);
                }
         }   


        
        for (int i = 0; i < vehiculosFiltrados.size(); i++) {
            System.out.println(vehiculosFiltrados.get(i).toString());
            
            System.out.println("¿Desea hacer una oferta por este vehículo? (s/n)");
            String respuesta = sc.nextLine();
            
            if (respuesta.equalsIgnoreCase("s")) {
                System.out.println("Ingrese el precio ofertado: ");
                double precioOfertado = Double.parseDouble(sc.nextLine());

//    public Oferta(int idOferta, int idComprador, int idVehiculo,String correo, double precio) {
                
//como obtener el id del comprador y del vehiculo
                Oferta oferta = new Oferta(Util.nextID(archivoOfertas),vRevisarClave.IdComprador,vehiculosFiltrados.get(i).getIdVehiculo(),correoElectronicoIn, precioOfertado );
                oferta.saveFile(archivoOfertas);
                vehiculosFiltrados.get(i).addOferta(oferta);
                
                System.out.println("Oferta realizada con éxito");
            } else if (respuesta.equalsIgnoreCase("n")) {
                continue;
            }
            
            System.out.println("¿Desea seguir buscando vehículos? (s/n)");
            String seguirBuscando = sc.nextLine();
            
            if (seguirBuscando.equalsIgnoreCase("n")) {
                break;
            }
        }
    } catch (NumberFormatException e) {
        System.out.println("Por favor, ingrese los números correctamente. Error: " + e.getMessage());
    } catch (Exception e) {
        System.out.println("Ha ocurrido un error inesperado. Error: " + e.getMessage());
    }
}

    
    
        public void saveFile(String nameFile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nameFile),true))){
            pw.println(Util.nextID(nameFile)+"-"+this.nombre+"-"+this.apellido+"-"+this.organizacion+"-"+this.correoElectronico+"-"+GFG2.toHexString(GFG2.getSHA(this.clave)));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }	
        }
    
    public static void saveFile(ArrayList<Comprador> compradores, String nameFile){
	try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nameFile), true ))){
            for(Comprador v: compradores){
                pw.println(Util.nextID(nameFile)+"-"+v.nombre+"-"+v.apellido+"-"+v.organizacion+"-"+v.correoElectronico+"-"+GFG2.toHexString(GFG2.getSHA(v.clave))); //el getSHA hace que la clave se coloque en el documento como hash code
        }
        }catch(Exception e){
            System.out.println(e.getMessage());    
        }	
    }
    
        public static ArrayList<Comprador> readFile(String nameFile){
	ArrayList<Comprador> compradores = new ArrayList<>();
	try(Scanner sc = new Scanner(new File(nameFile))){
                while(sc.hasNextLine()){
                String linea  = sc.nextLine();
                String[] ven = linea.split("-");
                Comprador va = new Comprador(Integer.parseInt(ven[0]),ven[1],ven[2],ven[3],ven[4],ven[5]);
                //agrega la clave como un hash pero en string
                compradores.add(va);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }	
        return compradores;
        //retorna la lista de vendedores
    }


  }
   
 

