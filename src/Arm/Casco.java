/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arm;

import java.util.Scanner;

/**
 *
 * @author Cristian
 */
public class Casco {
    Scanner leer = new Scanner(System.in);
    
    public void consola(){
        System.out.println("Escriba el mensaje por consola");
        String texto= String.valueOf(leer.next());
        System.out.println(texto);
    }
    
    public void sintetizador(){
        System.out.println("Mensaje por sintetizador");
        String audio= String.valueOf(leer.next());
        System.out.println(audio);
    }
}
