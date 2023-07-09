/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

import java.util.ArrayList;
import java.util.Scanner;

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
    
    
    
    public void registrarVendedor(ArrayList<Vendedor> vendedores){
        //obteniendo datos del nuevo vendedor
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
        
        //agregando el vendedor a la lista
        Vendedor v1 = new Vendedor(nombre, apellidos, organizacion, correoElectronico, clave);
        vendedores.add(v1);
    }
    public void registrarVehiculo(ArrayList<Vehiculo> vehiculos){
        //Obtener el tipo de vehiculo
        Scanner sc = new Scanner(System.in);        
        StringBuilder sbv = new StringBuilder();
        String menuTipoVehiculo = "Ingrese el tipo de vehicula:\n";
        String opv1 = "1. Moto\n";
        String opv2 = "2. Camion\n";
        String opv3 = "3. Auto\n";
        sbv.append(menuTipoVehiculo).append(opv1).append(opv2).append(opv3);
        int tipoVehiculo = sc.nextInt();
        sc.nextLine();
        
        //Faltar hacer la validacion de que se debe pedir dependiendo del tipo de vehiculo
        
        System.out.println("Ingrese la placa:");
        String placa = sc.nextLine();
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
        double precio = sc.nextDouble();
        sc.next();
        if(tipoVehiculo == 1){
            Vehiculo moto = new Vehiculo(placa, marca,  modelo,  tipoMotor,  color,  tipoCombustible, año, recorrido,  precio);
            vehiculos.add(moto);
        }else if(tipoVehiculo == 2){
            System.out.println("Ingrese el número de vidrios:");
            int vidrios = sc.nextInt();
            sc.next();
            System.out.println("Ingrese la transmision:");
            String transmision = sc.nextLine();
            
            Vehiculo auto = new Vehiculo(placa, marca,  modelo,  tipoMotor,  color,  tipoCombustible, año, recorrido,  precio);
            vehiculos.add(auto);
        }
        
    }
           
    
}
