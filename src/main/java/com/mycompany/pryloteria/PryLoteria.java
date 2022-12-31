/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.pryloteria;

import java.util.Scanner;

/**
 *
 * @author victo
 */
public class PryLoteria {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        CartonTablero c1 ;
        c1 = CartonTablero.crearTablero(Aleatorios.crearTablero());
        CartonTablero c2 ;
        c2 = CartonTablero.crearTablero(Aleatorios.crearTablero());
        CartonTablero c3 ;
        c3 = CartonTablero.crearTablero(Aleatorios.crearTablero());
        CartonTablero c4 ;
        CartonTablero c5 ;
        c4 = CartonTablero.crearTablero(Aleatorios.crearTablero());
        c5 = CartonTablero.crearTablero(Aleatorios.crearTablero());
        CartonTablero[] juego;
        juego=new CartonTablero[5];
        juego[0]=c1;
        juego[1]=c2;
        juego[2]=c3;
        juego[3]=c4;
        juego[4]=c5;
        
        for(CartonTablero c6 : juego){
            c6.imprimirTablero();
            System.out.println("");
        }
        JuegoEnProceso h = new JuegoEnProceso(juego);
        
        c1.setNombre("vicho");
        c2.setNombre("gordo");
        c3.setNombre("hola");
        c4.setNombre("null");
        c5.setNombre("yanose");
        
        h.start();
        
    }
}
