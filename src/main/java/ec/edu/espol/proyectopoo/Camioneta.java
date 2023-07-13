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

    public Camioneta(int id,String placa, String marca, String modelo, String tipoMotor, String color, String tipoCombustible, int año, int recorrido, double precio, int numVidrios, String transmision, String traccion) {
        super(id, placa, marca, modelo, tipoMotor, color, tipoCombustible, año, recorrido, precio);
        this.numVidrios = numVidrios;
        this.transmision = transmision;
        this.traccion =traccion;
    }

    public int getNumVidrios() {
        return numVidrios;
    }

    public void setNumVidrios(int numVidrios) {
        this.numVidrios = numVidrios;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }
   
    
    
}
