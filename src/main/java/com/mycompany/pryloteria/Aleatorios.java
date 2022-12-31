/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pryloteria;

/**
 *
 * @author victo
 */
public class Aleatorios {
    
    public static int sacarCarta(){
        float numero = (float) (Math.random()*54+1);
        return (int) numero;
    }
    public static int[] crearTablero(){
        int contador = 0;
        int[] tablero=new int[9];
        while(contador < 9){
            int valor = sacarCarta();
            if(!existe(valor,tablero)){
                tablero[contador]=valor;
                contador++;
            } 
        }
        return tablero;
    }
    public static boolean existe(int n , int[] arreglo){
        for(int n1:arreglo){
            if(n1==n){
                return true;
            }
        }
        return false;
    }
}
