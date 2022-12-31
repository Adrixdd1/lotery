/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pryloteria;

/**
 *
 * @author victo
 */
public class Cartas {
    private int valor;
    private String nombre;
    
    public Cartas(int valor){
        this.valor=valor;
        this.nombre=NombreDeCarta.getNombre(valor);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }    
}
