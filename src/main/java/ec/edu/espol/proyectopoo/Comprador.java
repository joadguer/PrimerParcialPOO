/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

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
    private String correo;
    private String clave;



    public Comprador(String nombre, String apellido, String organizacion, String correoElectronico, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.organizacion = organizacion;
        this.clave = clave;
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
        
       
        Comprador  c1 = new Comprador(nombre, apellidos, organizacion, correoElectronico, clave);
        compradores.add(c1);
        
        System.out.println("Comprador registrado");
        
    }

    public void ofertarxVehiculo(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un modelo de vehiculo que desee buscar");
        String busqueda = sc.nextLine();

        
        

    }

   
  }

