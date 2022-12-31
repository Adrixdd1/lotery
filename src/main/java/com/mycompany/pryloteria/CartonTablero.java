/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pryloteria;

/**
 *
 * @author victo
 */
public class CartonTablero {
   
    private Cartas[] tablero=new Cartas[9];
    private String nombre;
    public CartonTablero(Cartas[] tablero, String nombre) {
        this.nombre=nombre;
        this.tablero = tablero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Cartas[] getTablero() {
        return tablero;
    }

    public void setTablero(Cartas[] tablero) {
        this.tablero = tablero;
    }
    
    public boolean ponerFrijol(Cartas carta){
        for (Cartas tablero1 : tablero) {
            if (tablero1.getValor() == carta.getValor()) {
                tablero1.setValor(0);
                return true;
            }
        }
        return false;
    }
    public static CartonTablero crearTablero(int[] valores){
        Cartas[] tabla=new Cartas[9];
        for(int i=0;i<valores.length;i++){
            tabla[i] = new Cartas(valores[i]);
        }
        CartonTablero c = new CartonTablero(tabla ,"hola");
        return c;
    }
    public boolean loteria(){
        int contador = 0;
        for(Cartas tablero1 : tablero){
            if(tablero1.getValor()==0){
                contador++;
            }
        }
        return contador==9;
    }
    public void imprimirTablero(){
        Cartas[] arreglo = getTablero();
        for(Cartas arreglo1 : arreglo){
            System.out.print(" | " + arreglo1.getNombre()+" | ");
        }
    }
}
