/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espol.proyectopoo;

<<<<<<< HEAD
import ec.espol.edu.util.Util;
=======
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
>>>>>>> f99c3f38b47602017df680b1bda77368ade7cc75
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
    private String correo;
    private String clave;
    private int IdComprador;
    private ArrayList<Oferta> ofertas;
    

<<<<<<< HEAD
    public Comprador(int id, String nombre, String apellido, String organizacion, String correoElectronico, String clave) {
        this.IdComprador=id;
=======


    public Comprador(String nombre, String apellido, String organizacion, String correoElectronico, String clave) {
>>>>>>> f99c3f38b47602017df680b1bda77368ade7cc75
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
        
    }

<<<<<<< HEAD
    public static List<Comprador> getCompradoresRegistrados() {
        return compradoresRegistrados;
    }

    public static void setCompradoresRegistrados(List<Comprador> compradoresRegistrados) {
        Comprador.compradoresRegistrados = compradoresRegistrados;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
=======
    public void ofertarxVehiculo(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un modelo de vehiculo que desee buscar");
        String busqueda = sc.nextLine();

        
        

    }

>>>>>>> f99c3f38b47602017df680b1bda77368ade7cc75
   
  }

