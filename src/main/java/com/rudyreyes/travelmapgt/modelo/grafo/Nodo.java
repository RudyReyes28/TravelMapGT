/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rudyreyes.travelmapgt.modelo.grafo;

import java.util.ArrayList;

/**
 *
 * @author rudyo
 */
public class Nodo {
    private String nombreOrigen;
    private ArrayList<Arista> destinos;

    public Nodo(String nombreOrigen, ArrayList<Arista> destinos) {
        this.nombreOrigen = nombreOrigen;
        this.destinos = destinos;
    }

    public Nodo() {
        destinos = new ArrayList<>();
    }

    public Nodo(String nombreOrigen) {
        this.nombreOrigen = nombreOrigen;
        destinos = new ArrayList<>();
    }

    public String getNombreOrigen() {
        return nombreOrigen;
    }

    public void setNombreOrigen(String nombreOrigen) {
        this.nombreOrigen = nombreOrigen;
    }

    public ArrayList<Arista> getDestinos() {
        return destinos;
    }
    
    public Arista getDestino(String nombreDestino){
        for(Arista arista: destinos){
            if(arista.getDestino().getNombreOrigen().equals(nombreDestino)){
                return arista;
            }
        }
        
        return null;
    }

    public void setDestinos(ArrayList<Arista> destinos) {
        this.destinos = destinos;
    }
    
    public void setDestino(Arista destino){
        this.destinos.add(destino);
    }
    
    public void imprimirDatos(){
        System.out.println("Origen "+nombreOrigen);
        for(Arista destino: destinos){
            System.out.println(destino.toString());
            
        }
    }
}
