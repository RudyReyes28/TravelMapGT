/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rudyreyes.travelmapgt.modelo.grafo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rudyo
 */
public class Arista {
    private Nodo destino;
    private int tiempoVehiculo;
    private int tiempoPie;
    private int consumoGas;
    private int desgastePersona;
    private int distancia;
    private List<Trafico> trafico;

    public Arista(Nodo destino, int tiempoVehiculo, int tiempoPie, int consumoGas, int desgastePersona, int distancia) {
        this.destino = destino;
        this.tiempoVehiculo = tiempoVehiculo;
        this.tiempoPie = tiempoPie;
        this.consumoGas = consumoGas;
        this.desgastePersona = desgastePersona;
        this.distancia = distancia;
        this.trafico = new ArrayList<>();
    }

    public Arista() {
    }


    public Nodo getDestino() {
        return destino;
    }

    public void setDestino(Nodo destino) {
        this.destino = destino;
    }

    public int getTiempoVehiculo() {
        return tiempoVehiculo;
    }

    public void setTiempoVehiculo(int tiempoVehiculo) {
        this.tiempoVehiculo = tiempoVehiculo;
    }

    public int getTiempoPie() {
        return tiempoPie;
    }

    public void setTiempoPie(int tiempoPie) {
        this.tiempoPie = tiempoPie;
    }

    public int getConsumoGas() {
        return consumoGas;
    }

    public void setConsumoGas(int consumoGas) {
        this.consumoGas = consumoGas;
    }

    public int getDesgastePersona() {
        return desgastePersona;
    }

    public void setDesgastePersona(int desgastePersona) {
        this.desgastePersona = desgastePersona;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }


    public List<Trafico> getTrafico() {
        return trafico;
    }

    public void setTrafico(List<Trafico> trafico) {
        this.trafico = trafico;
    }
    
    public void setTrafico(Trafico trafico) {
        this.trafico.add(trafico);
    }
    
    @Override
    public String toString() {
        String datos = "Arista{" + "destino=" + destino.getNombreOrigen() + ", \ntiempoVehiculo=" + tiempoVehiculo + ", \ntiempoPie=" + tiempoPie + ", \nconsumoGas=" + consumoGas + ", \ndesgastePersona=" + desgastePersona + ", \ndistancia=" + distancia ;
        for(Trafico t: trafico){
            datos += "\n"+t.imprimirTrafico();
        }
        return datos;
    }
    
    
}
