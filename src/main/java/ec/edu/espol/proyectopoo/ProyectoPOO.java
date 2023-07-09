/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.proyectopoo;

import java.util.Scanner;

/**
 *
 * @author JOSUE
 */
public class ProyectoPOO {

    public static void main(String[] args) {
        
        //menu opciones 
        StringBuilder sb = new StringBuilder();
        String menu = "Menu de Opciones:\n";
        String op1 = "1. Vendedor\n";
        String op2 = "2. Comprado\n";
        String op3 = "3. Salir\n";
        sb.append(menu).append(op1).append(op2).append(op3);
        
        //menu opciones de vendedor
        StringBuilder sbv = new StringBuilder();
        String menuVendedor = "Menu de Opciones Vendedor:\n";
        String opv1 = "1. Registrar un nuevo vendedor\n";
        String opv2 = "2. Registrar un nuevo vehículo\n";
        String opv3 = "3. Aceptar oferta\n";
        String opv4 = "4. Regresar\n";
        sbv.append(menuVendedor).append(opv1).append(opv2).append(opv3).append(opv4);        
        
        //menu opciones de Comprador
        StringBuilder sbc = new StringBuilder();
        String menuComprador = "Menu de Opciones Vendedor:\n";
        String opc1 = "1. Registrar un nuevo comprador\n";
        String opc2 = "2. Ofertar por un vehículo\n";
        String opc3 = "3. Regresar\n";
        sbc.append(menuComprador).append(opc1).append(opc2).append(opc3);        
        
        System.out.println(sb);
        System.out.println(sbv);
        System.out.println(sbc);
/*        
        do{
        System.out.println(sb);
        Scanner sc = new Scanner(System.in); 
        int opcion = sc.nextInt();
        sc.next();
        }while(opcion>=1 && opcion<=3);
        if(opcion == 1){
            
        }
*/

    }

}
