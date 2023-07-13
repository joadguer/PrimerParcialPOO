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

/**
 *
 * @author JOSUE
 */
public class Oferta {
    private String correo;
    private double precio;
    private Vehiculo vehiculo;
    private Comprador comprador;
    private int idOferta;
    private int idComprador;
    private int idVehiculo;
    private static ArrayList<Oferta> ofertas = new ArrayList<>();


    public Oferta(int idO, int idC, int idVe, String correo, double precio, Vehiculo vehiculo, Comprador comprador) {
        this.idOferta = idO;
        this.idComprador = idC;
        this.idVehiculo = idVe;
        this.correo = correo;
        this.precio = precio;
        this.vehiculo = vehiculo;
        this.comprador = comprador;
    }

    public Oferta(int idOferta, int idComprador, int idVehiculo,String correo, double precio) {
        this.correo = correo;
        this.precio = precio;
        this.idOferta = idOferta;
        this.idComprador = idComprador;
        this.idVehiculo = idVehiculo;
    }
    
    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public int getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public static ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    public static void setOfertas(ArrayList<Oferta> ofertas) {
        Oferta.ofertas = ofertas;
    }

    
    
    @Override
    public String toString() {
        return "Oferta{" + "correo=" + correo + ", precio=" + precio + ", vehiculo=" + vehiculo + ", comprador=" + comprador + '}';
    }
    
    
    
    
    public void saveFile(String nameFile){
//public Oferta(int idO, int idC, int idVe, String correo, double precio, Vehiculo vehiculo, Comprador comprador)        
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nameFile),true))){
            pw.println(this.idOferta+"-"+this.idComprador+"-"+this.idVehiculo+"-"+this.correo+"-"+this.precio); //no es necesario colocar el vehiculo ni el comprador porque el id ya incluye esa información para vincular a ambos
            Oferta.ofertas.add(this);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }	
        }
    
    public static void saveFile(ArrayList<Oferta> ofertas, String nameFile){
	try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nameFile), true ))){
            for(Oferta o: ofertas){
                pw.println(o.idOferta+"-"+o.idComprador+"-"+o.idVehiculo+"-"+o.correo+"-"+o.precio); //el getSHA hace que la clave se coloque en el documento como hash code
                Oferta.ofertas.add(o);
        }
        }catch(Exception e){
            System.out.println(e.getMessage());    
        }	
    }
    public static void saveFile(ArrayList<Oferta> ofertas, String nameFile, boolean append){
	try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nameFile), append ))){
            for(Oferta o: ofertas){
                pw.println(o.idOferta+"-"+o.idComprador+"-"+o.idVehiculo+"-"+o.correo+"-"+o.precio); //el getSHA hace que la clave se coloque en el documento como hash code
                Oferta.ofertas.add(o);
        }
        }catch(Exception e){
            System.out.println(e.getMessage());    
        }	
    }    
    
    //la excepcion es util porque se esta leyendo el archivo y por tanto si no existe el archivo se genera una excepcion    
    public static ArrayList<Oferta> readFile(String nameFile){
	ArrayList<Oferta> ofertas = new ArrayList<>();
	try(Scanner sc = new Scanner(new File(nameFile))){
                while(sc.hasNextLine()){
                String linea  = sc.nextLine();
                String[] ofer = linea.split("-");
                Oferta of = new Oferta(Integer.parseInt(ofer[0]),Integer.parseInt(ofer[1]),Integer.parseInt(ofer[2]),ofer[3],Double.parseDouble(ofer[4]));
//    public Oferta(int idOferta, int idComprador, int idVehiculo,String correo, double precio) {
                
                ofertas.add(of);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }	
        return ofertas;
        //retorna la lista de vendedores
    }    
    
    public static void link(ArrayList<Comprador> compradores, ArrayList<Oferta> ofertas ,ArrayList<Vehiculo> vehiculos){
        for(Oferta o: ofertas)
        {
            //debes implementar el metodo searchById
            Comprador c = Comprador.searchById(compradores, o.getIdComprador());
            Vehiculo v = Vehiculo.searchById(vehiculos, o.getIdVehiculo());
            c.getOfertas().add(o);
            v.getOfertas().add(o);
            o.setComprador(c);
            o.setVehiculo(v);
        }
    }
    
    
    
}
