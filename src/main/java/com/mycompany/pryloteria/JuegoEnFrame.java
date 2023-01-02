/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pryloteria;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author victo
 */
public class JuegoEnFrame extends Thread{
    private boolean loteria;
    private int[] mazo;
    private int conteo;
    private CartonTablero[] jugadores;
    private int numeroJugadores;
    private int jugador;
    private JLabel[] label;
    private JLabel cantada;
    
    public JuegoEnFrame(CartonTablero[] jugadores,JLabel[] label, int jugador,JLabel cantada) {
        loteria=false;
        mazo=new int[54];
        conteo=0;
        this.jugadores=jugadores;
        numeroJugadores=jugadores.length;
        this.label=label;
        this.jugador=jugador-1;
        this.cantada=cantada;
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
            Cartas[] jugando = jugadores[jugador].getTablero();
            for(int i=0;i<label.length;i++){
                if(jugando[i].getValor()!=0){
                    label[i].setText(jugando[i].getNombre());
                }else{
                    label[i].setText(jugando[i].getNombre()+"*");
                }
                
            }
            //gritarCarta();
            int valor =gritarCarta();
            cantada.setText(NombreDeCarta.getNombre(valor));
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
                Logger.getLogger(JuegoEnFrame.class.getName()).log(Level.SEVERE, null, ex);
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
