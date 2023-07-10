/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

/**
 *
 * @author JOSUE
 */
public class Oferta {
    private String correo;
    private double precio;
    private Vehiculo vehiculo;
    private Comprador comprador;

    public Oferta(String correo, double precio, Vehiculo vehiculo, Comprador comprador) {
        this.correo = correo;
        this.precio = precio;
        this.vehiculo = vehiculo;
        this.comprador = comprador;
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

    @Override
    public String toString() {
        return "Oferta{" + "correo=" + correo + ", precio=" + precio + ", vehiculo=" + vehiculo + ", comprador=" + comprador + '}';
    }
    
    
    
    
}
