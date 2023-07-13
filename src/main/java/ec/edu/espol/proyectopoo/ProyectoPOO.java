/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.proyectopoo;

import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 *
 * @author JOSUE
 */
public class ProyectoPOO {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        
        Scanner sc = new Scanner(System.in); 
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        Vendedor v1 = new Vendedor( "nombre", "apellidos", "String organizacion", "String correoElectronico", "String clave");
        
        //menu opciones 
        StringBuilder sb = new StringBuilder();
        String menu = "Menu de Opciones:\n";
        String op1 = "1. Vendedor\n";
        String op2 = "2. Comprador\n";
        String op3 = "3. Salir";// no es necesario agregar \n porque ya lo tiene el println
        sb.append(menu).append(op1).append(op2).append(op3);
        
        //menu opciones de vendedor
        StringBuilder sbv = new StringBuilder();
        String menuVendedor = "Menu de Opciones Vendedor:\n";
        String opv1 = "1. Registrar un nuevo vendedor\n";
        String opv2 = "2. Registrar un nuevo vehículo\n";
        String opv3 = "3. Aceptar oferta\n";
        String opv4 = "4. Regresar";
        sbv.append(menuVendedor).append(opv1).append(opv2).append(opv3).append(opv4);        
        
        //menu opciones de Comprador
        StringBuilder sbc = new StringBuilder();
        String menuComprador = "Menu de Opciones Vendedor:\n";
        String opc1 = "1. Registrar un nuevo comprador\n";
        String opc2 = "2. Ofertar por un vehículo\n";
        String opc3 = "3. Regresar";
        sbc.append(menuComprador).append(opc1).append(opc2).append(opc3);
        int opcion;
        do{
            System.out.println(sb);
            opcion = sc.nextInt();
            sc.nextLine();
        }while(opcion !=1 && opcion !=2 && opcion!=3); 
        if(opcion == 1){
            int opcionVendedor;
            do{
                System.out.println(sbv);      
                opcionVendedor = sc.nextInt();
                sc.nextLine();
            }while(opcionVendedor !=1 && opcionVendedor !=2 && opcionVendedor !=3 && opcionVendedor !=4);
            
            switch(opcionVendedor){
                    case 1: 
                        //registrar un nuevo vendedor
                        v1.registrarVendedor("vendedores.txt");
                        
                        break;
                    case 2:
                        //Registrar un nuevo vehiculo
                        v1.registrarVehiculo("vendedores.txt", "vehiculos.txt");
                        break;
                    case 3:
                        v1.aceptarOferta("vendedores.txt", "vehiculos.txt","ofertas.txt");
                        
                        //falta mostrar por pantalla las ofertas

                        //aceptar oferta
                        break;

                    case 4:
                        //regresar
                        break;
                    default: 
                        break;
            }    

             
            
        }else if(opcion == 2){
            System.out.println(sbc);
            
        }else{
            System.out.println("Gracias por usar nuestro servicio");
        }

    }

}
