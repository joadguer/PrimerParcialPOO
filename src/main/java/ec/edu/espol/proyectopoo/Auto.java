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
public class Auto extends Vehiculo{
    private int vidrio;
    private String transmision;

    public Auto(int id, String placa, String marca, String modelo, String tipoMotor, String color, String tipoCombustible, int año, int recorrido, double precio, int vidrios, String transmision) {
        super(id, placa, marca, modelo, tipoMotor, color, tipoCombustible, año, recorrido, precio);
        this.vidrio = vidrios;
        this.transmision = transmision; 
        
    }

    public int getVidrio() {
        return vidrio;
    }

    public void setVidrio(int vidrio) {
        this.vidrio = vidrio;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }
    
    

    
}
