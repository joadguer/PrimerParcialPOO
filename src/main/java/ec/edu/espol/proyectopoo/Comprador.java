/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espol.proyectopoo;

import ec.espol.edu.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JOSUE
 */
public class Comprador{
    private static List<Comprador> compradoresRegistrados = new ArrayList<>();
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String organizacion;
    private String correo;
    private String clave;
    private int IdComprador;
    private ArrayList<Oferta> ofertas;
    

    public Comprador(int id, String nombre, String apellido, String organizacion, String correoElectronico, String clave) {
        this.IdComprador=id;
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
        
        
        System.out.println("Ingrese el Correo Electronico");
        String correoElectronico= sc.nextLine();
        
        System.out.println("Ingrese la Clave");
        String clave = sc.nextLine();
        
       
        Comprador  c1 = new Comprador(Util.nextID("compradores.txt"),nombre, apellidos, organizacion, correoElectronico, clave);
        compradores.add(c1);
    }

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
   
  }
    

