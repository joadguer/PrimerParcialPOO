/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import ec.espol.edu.util.Util;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author JOSUE
 */
public class Vendedor {
    private String nombre;
    private String apellidos;
    private String organizacion;
    private String correoElectronico;
    private String clave;

    
    public Vendedor(String nombre, String apellidos, String organizacion, String correoElectronico, String clave) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.organizacion = organizacion;
        this.correoElectronico = correoElectronico;
        this.clave = clave;
    }
    
       @Override
    public String toString() {
        try {
            return this.nombre+"-"+this.apellidos+"-"+this.organizacion+"-"+this.correoElectronico+"-"+Arrays.toString(GFG2.getSHA(this.clave));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    } 
    
    
    public void saveFile(String nameFile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nameFile),true))){
            pw.println(this.nombre+"-"+this.apellidos+"-"+this.organizacion+"-"+this.correoElectronico+"-"+GFG2.toHexString(GFG2.getSHA(this.clave)));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }	
        }
    
    public static void saveFile(ArrayList<Vendedor> vendedores, String nameFile){
	try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nameFile), true ))){
            for(Vendedor v: vendedores){
                pw.println(v.nombre+"-"+v.apellidos+"-"+v.organizacion+"-"+v.correoElectronico+"-"+GFG2.toHexString(GFG2.getSHA(v.clave))); 
        }
        }catch(Exception e){
            System.out.println(e.getMessage());    
        }	
    }
    
        public static void saveFile(ArrayList<Vendedor> vendedores, String nameFile,boolean append){
	try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nameFile), append ))){
            for(Vendedor v: vendedores){
                pw.println(v.nombre+"-"+v.apellidos+"-"+v.organizacion+"-"+v.correoElectronico+"-"+GFG2.toHexString(GFG2.getSHA(v.clave))); 
        }
        }catch(Exception e){
            System.out.println(e.getMessage());    
        }	
    }
    
    public static ArrayList<Vendedor> readFile(String nameFile){
	ArrayList<Vendedor> vendedores = new ArrayList<>();
	try(Scanner sc = new Scanner(new File(nameFile))){
                while(sc.hasNextLine()){
                String linea  = sc.nextLine();
                String[] ven = linea.split("-");
                Vendedor va = new Vendedor(ven[0],ven[1],ven[2],ven[3],ven[4]);
                vendedores.add(va);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }	
        return vendedores;
       
    }
 
    public static void registrarVendedor(String vendedoresArchivo){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el Nombre:");
        String nombreIn = sc.nextLine();
        
        System.out.println("Ingrese los Apellidos");
        String apellidosIn = sc.nextLine();
        
        System.out.println("Ingrese la organización");
        String organizacionIn = sc.nextLine();
        
        
        Vendedor.saveFile(new ArrayList<>(), vendedoresArchivo);
       
        ArrayList<Vendedor> vendedores = Vendedor.readFile(vendedoresArchivo);
        ArrayList<String> correos = new ArrayList<>();
        for(Vendedor ven: vendedores){
            String c1 = ven.correoElectronico;
            correos.add(c1);
        }
        boolean seguirEjecutando = false;
        String correoElectronicoIn;
        do{
        System.out.println("Ingrese el Correo Electronico");
        correoElectronicoIn= sc.nextLine();
        for(String cor: correos){
            if(cor.equals(correoElectronicoIn)){
                System.out.println("El correo ya existe");
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
                if (!claveIn.isBlank()) {  
                    byte[] claveAlmacenar = GFG2.getSHA(claveIn);
                } else {
                    System.out.println("La clave no puede estar vacía.");
                }
            } catch (NoSuchAlgorithmException e) {
                claveIn = null; 
                System.out.println("Error Clave no se puede Generar");
            }   
        }while(claveIn.isBlank());
        
        Vendedor vAgregar = new Vendedor(nombreIn, apellidosIn, organizacionIn, correoElectronicoIn, claveIn);
        
        vAgregar.saveFile(vendedoresArchivo);
    }
    
        
    public static void registrarVehiculo(String archivoVendedores,String archivoVehiculos) throws NoSuchAlgorithmException{


        Scanner sc = new Scanner(System.in);     
        ArrayList<Vendedor> vendedores = Vendedor.readFile(archivoVendedores);
        
        
        ArrayList<String> correos = new ArrayList<>();
        for(Vendedor v: vendedores){
            String c1 = v.correoElectronico;
            correos.add(c1);
        }      
        boolean seguirEjecutando = false;
        String correoElectronicoIn;
        Vendedor vRevisarClave = null;
        do{
            System.out.println("Ingrese el Correo Electronico");
            correoElectronicoIn= sc.nextLine();
            
            for(int i =0; i<correos.size();i++){
                if(!(correos.get(i).equals(correoElectronicoIn))){
                    seguirEjecutando = true;
                }else{
                    seguirEjecutando = false; 
                    vRevisarClave = vendedores.get(i);                
                    break; 
                } 
            }
            if(seguirEjecutando)
                System.out.println("Correo ingresado no existe");
        }while(seguirEjecutando);
        String claveVerificar;
        do {
            System.out.println("Ingrese la clave:");
            claveVerificar = sc.nextLine(); 
            claveVerificar = GFG2.toHexString(GFG2.getSHA(claveVerificar));
            if(!claveVerificar.equals(vRevisarClave.clave)){
                System.out.println("Clave Ingresada es incorrecta");
                seguirEjecutando = true;
            }else
                seguirEjecutando = false;
            
        }while(seguirEjecutando);        
        StringBuilder sbv = new StringBuilder();
        String menuTipoVehiculo = "Ingrese el tipo de vehicula:\n";
        String opv1 = "1. Moto\n";
        String opv2 = "2. Camion\n";
        String opv3 = "3. Auto";
        sbv.append(menuTipoVehiculo).append(opv1).append(opv2).append(opv3);
        int tipoVehiculo;
        do{
            System.out.println(sbv);
            tipoVehiculo = sc.nextInt();
            sc.nextLine();
        }while(tipoVehiculo !=1 && tipoVehiculo !=2 && tipoVehiculo !=3 );
        
        

        Vehiculo.saveFile(new ArrayList<>(), archivoVehiculos);          
        ArrayList<Vehiculo> vehiculos = Vehiculo.readFile(archivoVehiculos);
        ArrayList<String> placas = new ArrayList<>();
        
        for(Vehiculo veh: vehiculos){
            String p1 = veh.placa;
            placas.add(p1);
        }
        seguirEjecutando = false;
        String placa;
        do{
            System.out.println("Ingrese la placa:");
            placa = sc.nextLine();
            for(String placaRevisar: placas){
                if(placaRevisar.equals(placa)){
                    System.out.println("La placa ya existe");
                    seguirEjecutando = true;
                    break;
                }
                seguirEjecutando = false; 
            }
        }while(seguirEjecutando);
        
        
        
        System.out.println("Ingrese la marca:");
        String marca = sc.nextLine();
        
        System.out.println("Ingrese el modelo:");
        String modelo = sc.nextLine();
        
        System.out.println("Ingrese el tipo de motor:");
        String tipoMotor = sc.nextLine();
        
        System.out.println("Ingrese el año:");
        int año = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Ingrese el recorrido:");
        int recorrido = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Ingrese el color:");
        String color = sc.nextLine();
        
        System.out.println("Ingrese el tipo de combustible:");
        String tipoCombustible = sc.nextLine();
        
        System.out.println("Ingrese el precio");
        double precio = sc.nextDouble();
        sc.nextLine();
        
        switch (tipoVehiculo) {
            case 1 ->                 {
                    int id = Util.nextID(archivoVehiculos);
                    Vehiculo moto = new Vehiculo(id, placa, marca,  modelo,  tipoMotor,  color,  tipoCombustible, año, recorrido,  precio);
                    moto.saveFile(archivoVehiculos);
                }
            case 2 ->                 {
                    System.out.println("Ingrese el número de vidrios:");
                    int vidrios = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese la transmision:");
                    String transmision = sc.nextLine();
                    int id = Util.nextID(archivoVehiculos);
                    Vehiculo auto = new Auto(id,placa, marca, modelo, tipoMotor, color, tipoCombustible, año, recorrido, precio, vidrios, transmision);
                    
                    auto.saveFile(archivoVehiculos);
                    
                }
            case 3 ->                 {
                    System.out.println("Ingrese el número de vidrios:");
                    int vidrios = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese la transmision:");
                    String transmision = sc.nextLine(); 
                    System.out.println("Ingrese la traccion: ");
                    String traccion = sc.nextLine();
                    int id = Util.nextID(archivoVehiculos);                    
                    Vehiculo camioneta = new Camioneta(id,placa, marca, modelo,  tipoMotor,  color,  tipoCombustible, año,  recorrido, precio, vidrios,  transmision, traccion);
                    camioneta.saveFile(archivoVehiculos);
                }
            default -> {
            }
            
        }
        
    }
    
    public static boolean aceptarOferta(String archivoVendedores, String archivoVehiculos,String archivoOfertas) throws NoSuchAlgorithmException{
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Vendedor> vendedores = Vendedor.readFile(archivoVendedores);
        ArrayList<Vehiculo> vehiculos = Vehiculo.readFile(archivoVehiculos);
        ArrayList<Oferta> ofertas = Oferta.readFile(archivoOfertas);
        
        ArrayList<String> correos = new ArrayList<>();
        for(Vendedor v: vendedores){
            String c1 = v.correoElectronico;
            correos.add(c1);
        }
        
        boolean seguirEjecutando = false;
        String correoElectronicoIn; 
        Vendedor vRevisarClave = null;
        
        do{
            System.out.println("Ingrese el Correo Electronico");
            correoElectronicoIn= sc.nextLine();
            
            for(int i =0; i<correos.size();i++){
                if(!(correos.get(i).equals(correoElectronicoIn))){
                    seguirEjecutando = true;
                }else{
                    seguirEjecutando = false; 
                    vRevisarClave = vendedores.get(i);                
                    break; 
                } 
            }
            if(seguirEjecutando)
                System.out.println("Correo ingresado no existe");
        }while(seguirEjecutando);
        
        String claveVerificar;
        
        do {
            System.out.println("Ingrese la clave:");
            claveVerificar = sc.nextLine(); 
            claveVerificar = GFG2.toHexString(GFG2.getSHA(claveVerificar));
            if(!claveVerificar.equals(vRevisarClave.clave)){
                System.out.println("Clave Ingresada es incorrecta");
                seguirEjecutando = true;
            }else
                seguirEjecutando = false;
            
        }while(seguirEjecutando);
        
        
       String placaBuscar;
       Vehiculo vehiculoPlaca = null;
        do{ 
            System.out.println("Ingrese la placa del vehiculo:");
            placaBuscar = sc.nextLine();
            for(Vehiculo v: vehiculos){
                if(v.getPlaca().equals(placaBuscar))
                {
                    vehiculoPlaca = v;              
                    break;
                }
            }   
            if(vehiculoPlaca == null){
                System.out.println("Placa no encontrada");
            }    
        }while(vehiculoPlaca == null);
        
                
                ArrayList<Oferta> ofertasVehiculo = new ArrayList<>(); 
                    for (Oferta offer : ofertas) {
                        if (offer.getIdVehiculo() == vehiculoPlaca.getIdVehiculo()) {
                            ofertasVehiculo.add(offer); 
                            
                        }
                    }
                    vehiculoPlaca.setOfertas(ofertasVehiculo);
                    System.out.println(vehiculoPlaca);
                
                
                System.out.println(vehiculoPlaca.marca+" "+vehiculoPlaca.modelo+" "+vehiculoPlaca.tipoMotor+" Precio: "+vehiculoPlaca.precio);
                                
            
                if(vehiculoPlaca.ofertas.isEmpty()){
                    System.out.println("no se han realizado orfertas");
                } 
                else if(vehiculoPlaca.ofertas.size() == 1){
                    System.out.println("Se ha realizado "+ vehiculoPlaca.ofertas.size()+" oferta");
                    System.out.println("""
                                       Oferta 1
                                       correo: """+vehiculoPlaca.getOfertas().get(0).getCorreo()  + "\nprecio ofertado: " +vehiculoPlaca.getOfertas().get(0).getPrecio());
                    System.out.println("1. Aceptar oferta");
                    System.out.println("2. Salir");
                    int aceptar = sc.nextInt();
                    sc.nextLine();
                    if(aceptar == 1){
                        for(Vehiculo v: vehiculos){
                            if(v.getPlaca().equals(placaBuscar))
                            {
                                Vendedor.enviarConGMail(vehiculoPlaca.getOfertas().get(0).getCorreo() , "Su Oferta ha sido aceptada", "El vendedor ha aceptado su oferta");                                
                                vehiculos.remove(v);    
                                break;
                            }
                        }   
                        Vehiculo.saveFile(vehiculos, archivoVehiculos,false);
                        return true;
                    }
                    else
                        return false; 
                }
                else{
                    int opcion;
                    System.out.println("Se han realizadao "+ vehiculoPlaca.getOfertas().size()+" ofertas");

                    for(int i = 1; i <= vehiculoPlaca.ofertas.size(); i++){
                        System.out.println("Oferta "+i +"\ncorreo: "+vehiculoPlaca.ofertas.get(i-1).getCorreo()  + "\nprecio ofertado: "+ vehiculoPlaca.getOfertas().get(i-1).getPrecio());
                        if(i == 1){
                            do{
                                System.out.println("1. Aceptar oferta");    
                                System.out.println("2. Siguiente oferta");
                                opcion = sc.nextInt();
                                sc.nextLine();                                
                             }while(opcion !=1 && opcion != 2);
                                switch (opcion){
                
                                    case 1:
                                        for(Vehiculo v: vehiculos){
                                            if(v.getPlaca().equals(placaBuscar))
                                            {
                                                Vendedor.enviarConGMail(vehiculoPlaca.getOfertas().get(i-1).getCorreo() , "Su Oferta ha sido aceptada", "El vendedor ha aceptado su oferta");                                                                                
                                                vehiculos.remove(v);              
                                                break;
                                            }
                                        }   
                                        Vehiculo.saveFile(vehiculos, archivoVehiculos,false);
                                        return true;
                                    case 2:
                                        break;
                }
                
                }
                        else if(i == vehiculoPlaca.getOfertas().size()){
                            do{
                
                                System.out.println("1. Aceptar oferta");
                                System.out.println("2. Anterior oferta");
                                opcion = sc.nextInt();
                                sc.nextLine();                  
                            }while(opcion !=1 && opcion !=2);
                                switch (opcion){
                                    case 1:
                                        for(Vehiculo v: vehiculos){
                                            if(v.getPlaca().equals(placaBuscar))
                                            {
                                                Vendedor.enviarConGMail(vehiculoPlaca.getOfertas().get(i-1).getCorreo() , "Su Oferta ha sido aceptada", "El vendedor ha aceptado su oferta");                                                                                
                                                vehiculos.remove(v);              
                                                break;
                                            }
                                        }   
                                        Vehiculo.saveFile(vehiculos, archivoVehiculos,false);                                        
                                        return true;
                                    case 2:
                                        i -=2;
                                        break;
                                }
                            
                
                } else{
                    do{
                                System.out.println("Oferta "+i +"\ncorreo: "+vehiculoPlaca.ofertas.get(i-1).getCorreo()  + "\nprecio ofertado: "+vehiculoPlaca.ofertas.get(i-1).getPrecio());
                                System.out.println("1. Aceptar oferta");
                                System.out.println("2. Anterior oferta");
                                System.out.println("3. Siguiente Oferta");

                                opcion = sc.nextInt();
                                sc.nextLine();
                    }while(opcion != 1 && opcion !=2 && opcion!=3);

                        switch (opcion){
                            case 1:
                                for(Vehiculo v: vehiculos){
                                  if(v.getPlaca().equals(placaBuscar))
                                  {
                                      Vendedor.enviarConGMail(vehiculoPlaca.getOfertas().get(i-1).getCorreo() , "Su Oferta ha sido aceptada", "El vendedor ha aceptado su oferta");                                
                                      vehiculos.remove(v);              
                                      break;
                                  }
                              }   
                              Vehiculo.saveFile(vehiculos, archivoVehiculos,false);
                              return true;
                            case 2:
                                i -=2; 
                                break;
                            case 3:
                                break;
                        }
                    }
                }
            }
        
        return false;
    }
    

    
    
    
    
    
    private static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        
        String remitente = "josueadrianib@gmail.com";
        
        String claveemail = "kcknlcwieaxmzjvj";

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", claveemail);    
        props.put("mail.smtp.auth", "true");   
        props.put("mail.smtp.starttls.enable", "true"); 
        props.put("mail.smtp.port", "587"); 

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, claveemail);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (MessagingException me) {
            me.printStackTrace();  
        }
  }
    
    

}
