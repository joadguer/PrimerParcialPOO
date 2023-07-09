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
        StringBuilder sb = new StringBuilder();
        String menu = "Menu de Opciones:\n";
        String op1 = "1. Vendedor\n";
        String op2 = "2. Comprado\n";
        String op3 = "3. Salir\n";
        sb.append(menu).append(op1).append(op2).append(op3);
        do{
        System.out.println(sb);
        Scanner sc = new Scanner(System.in); //poner con manejo de excepcion
        }while();
    }
}
