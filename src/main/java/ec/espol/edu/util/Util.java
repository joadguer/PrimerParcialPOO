/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espol.edu.util;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author JOSUE
 */
public class Util {
    
    private Util(){}
    
    public static int nextID(String nameFile)
    {
        int id =0;
        try(Scanner sc = new Scanner(new File(nameFile)))
        {
            while(sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] valores = linea.split("-");
                id = Integer.parseInt(valores[0]);
            }
        }
        catch(Exception e)
        {    
        }
        return id+1;
    }
}
