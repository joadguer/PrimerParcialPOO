/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espol.proyectopoo;

import ec.espol.edu.util.Util;
import java.io.File;
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
    private static List<String> compradoresRegistrados = new ArrayList<>();
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String organizacion;
    private String clave;
    private int IdComprador;
    private ArrayList<Oferta> ofertas;
    


    public Comprador(int id, String nombre, String apellido, String organizacion, String correoElectronico, String clave) {
        this.IdComprador= id;
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
    
    
    
    public void RegistarNuevoComprador(ArrayList<Comprador> compradores){
    
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese el Nombre:");
        String nombre = sc.nextLine();
        
        System.out.println("Ingrese los Apellidos");
        String apellidos = sc.nextLine();
        
        System.out.println("Ingrese la organización");
        String organizacion = sc.nextLine();
        
        
        String correoElectronico;
        while(true){
            System.out.println("Ingrese su correoElectronico");
            correoElectronico = sc.nextLine();

            if(compradoresRegistrados.contains(correoElectronico)){
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
        try(FileWriter fw = new FileWriter("claves.txt", true);
            PrintWriter pw = new PrintWriter(fw)){
            pw.println(correoElectronico + ":" + clave);

        }catch(IOException o){
            o.printStackTrace();

        }
        
       
        Comprador  c1 = new Comprador(Util.nextID("compradores.txt"),nombre, apellidos, organizacion, correoElectronico, clave);
        compradores.add(c1);
        
        System.out.println("Comprador registrado");
        
        sc.close();
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
    
    
        
    
        public static Comprador searchById(ArrayList<Comprador> compradores, int id){
            for(Comprador c: compradores)
            {
                if(c.IdComprador == id)
                    return c;
            }
            return null;
        }

    public void ofertarxVehiculo(List<Vehiculo> vehiculos) {
        Scanner sc = new Scanner(System.in);

    
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

        
        List<Vehiculo> vehiculosFiltrados = new ArrayList<>();
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
                
                Oferta oferta = new Oferta(this.correoElectronico, precioOfertado, vehiculosFiltrados.get(i), this);
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


  }
   
 

