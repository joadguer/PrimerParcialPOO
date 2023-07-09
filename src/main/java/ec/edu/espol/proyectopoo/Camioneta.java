/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

/**
 *
 * @author JOSUE
 */
public class Camioneta extends Vehiculo {
    private int numVidrios;
    private String transmision;
    private String traccion;

    public Camioneta(String placa, String marca, String modelo, String tipoMotor, String color, String tipoCombustible, int año, int recorrido, double precio, int numVidrios, String transmision, String traccion) {
        super(placa, marca, modelo, tipoMotor, color, tipoCombustible, año, recorrido, precio);
        this.numVidrios = numVidrios;
        this.transmision = transmision;
        this.traccion =traccion;
    }
    
}
