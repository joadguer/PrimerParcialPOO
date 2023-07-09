/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

/**
 *
 * @author JOSUE
 */
public class Auto extends Vehiculo{
    private int vidrio;
    private String transmision;

    public Auto(String placa, String marca, String modelo, String tipoMotor, String color, String tipoCombustible, int año, int recorrido, double precio, int vidrios, String transmision) {
        super(placa, marca, modelo, tipoMotor, color, tipoCombustible, año, recorrido, precio);
        this.vidrio = vidrios;
        this.transmision = transmision; 
        
    }
    
    
}
