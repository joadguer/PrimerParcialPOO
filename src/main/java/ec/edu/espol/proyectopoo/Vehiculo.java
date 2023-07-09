/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

/**
 *
 * @author JOSUE
 */
public class Vehiculo {
    protected String placa;
    protected String marca;
    protected String modelo;
    protected String tipoMotor;
    protected String color;
    protected String tipoCombustible;
    protected int año;
    protected int recorrido;
    protected double precio;

    public Vehiculo(String placa, String marca, String modelo, String tipoMotor, String color, String tipoCombustible, int año, int recorrido, double precio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMotor = tipoMotor;
        this.color = color;
        this.tipoCombustible = tipoCombustible;
        this.año = año;
        this.recorrido = recorrido;
        this.precio = precio;
    }
    
    
}
