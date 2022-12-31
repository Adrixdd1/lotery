/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pryloteria;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victo
 */
public class JuegoEnProceso extends Thread{
    private boolean loteria;
    private int[] mazo;
    private int conteo;
    private CartonTablero[] jugadores;
    private int numeroJugadores;
    
    public JuegoEnProceso(CartonTablero[] jugadores) {
        loteria=false;
        mazo=new int[54];
        conteo=0;
        this.jugadores=jugadores;
        numeroJugadores=jugadores.length;
    }

    public boolean isLoteria() {
        return loteria;
    }

    public void setLoteria(boolean loteria) {
        this.loteria = loteria;
    }
    
    @Override
    public void run(){
        
        while (!loteria){
            //gritarCarta();
            int valor =gritarCarta();
            for(CartonTablero jugadores1 : jugadores){
                jugadores1.ponerFrijol(new Cartas (valor));
                if(jugadores1.loteria()){
                    System.out.println("ya gano alguien");
                    this.loteria=true;
                    System.out.println("gano : "+jugadores1.getNombre());
                }
            }
            System.out.println(NombreDeCarta.getNombre(valor));
            
            try {
               sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(JuegoEnProceso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private int gritarCarta(){
        int valor=Aleatorios.sacarCarta();
        while(Aleatorios.existe(valor, mazo)){
           valor=Aleatorios.sacarCarta();
        }
        mazo[conteo]=valor;
        conteo++;
        
        return valor;
        
    }
}
