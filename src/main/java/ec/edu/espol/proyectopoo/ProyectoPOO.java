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
import java.util.Scanner;

public class ProyectoPOO {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        
        Scanner sc = new Scanner(System.in);
        
        StringBuilder sb = new StringBuilder();
        String menu = "Menu de Opciones:\n";
        String op1 = "1. Vendedor\n";
        String op2 = "2. Comprador\n";
        String op3 = "3. Salir";
        sb.append(menu).append(op1).append(op2).append(op3);
        
        StringBuilder sbv = new StringBuilder();
        String menuVendedor = "Menu de Opciones Vendedor:\n";
        String opv1 = "1. Registrar un nuevo vendedor\n";
        String opv2 = "2. Registrar un nuevo vehículo\n";
        String opv3 = "3. Aceptar oferta\n";
        String opv4 = "4. Regresar";
        sbv.append(menuVendedor).append(opv1).append(opv2).append(opv3).append(opv4);        
        

        StringBuilder sbc = new StringBuilder();
        String menuComprador = "Menu de Opciones Comprador:\n";
        String opc1 = "1. Registrar un nuevo comprador\n";
        String opc2 = "2. Ofertar por un vehículo\n";
        String opc3 = "3. Regresar";
        sbc.append(menuComprador).append(opc1).append(opc2).append(opc3);
        
        int opcion;
        do {
            System.out.println(sb);
            opcion = sc.nextInt();
            sc.nextLine();
            
            if (opcion == 1) {
                int opcionVendedor;
                do {
                    System.out.println(sbv);      
                    opcionVendedor = sc.nextInt();
                    sc.nextLine();
                    
                    switch(opcionVendedor){
                        case 1: 
                            Vendedor.registrarVendedor("vendedores.txt");
                            break;
                        case 2:
                            Vendedor.registrarVehiculo("vendedores.txt", "vehiculos.txt");
                            break;
                        case 3:
                            Vendedor.aceptarOferta("vendedores.txt", "vehiculos.txt","ofertas.txt");
                            break;
                        case 4:
                            break;
                        default: 
                            break;
                    }
                    
                } while (opcionVendedor != 4);
                
            } else if (opcion == 2) {
                int opcionComprador;
                do {
                    System.out.println(sbc);      
                    opcionComprador = sc.nextInt();
                    sc.nextLine();
                    
                    switch(opcionComprador){
                        case 1: 
                            Comprador.RegistarNuevoComprador("compradores.txt");
                            break;
                        case 2:
                            Comprador.ofertarxVehiculo("compradores.txt","vehiculos.txt","ofertas.txt");
                            break;
                        case 3:
                            break;
                        default: 
                            break;
                    }
                    
                } while (opcionComprador != 3);
                
            }
        } while (opcion != 3);
        
        System.out.println("Gracias por usar nuestro servicio");
    }
}

