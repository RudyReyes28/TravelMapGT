/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rudyreyes.travelmapgt.modelo.grafo;

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
    private int tHoraInicio;
    private int tHoraFinal;
    private int tProbabilidad;

    public Arista(Nodo destino, int tiempoVehiculo, int tiempoPie, int consumoGas, int desgastePersona, int distancia) {
        this.destino = destino;
        this.tiempoVehiculo = tiempoVehiculo;
        this.tiempoPie = tiempoPie;
        this.consumoGas = consumoGas;
        this.desgastePersona = desgastePersona;
        this.distancia = distancia;
    }

    public Arista() {
    }

    public Arista(Nodo destino, int tiempoVehiculo, int tiempoPie, int consumoGas, int desgastePersona, int distancia, int tHoraInicio, int tHoraFinal, int tProbabilidad) {
        this.destino = destino;
        this.tiempoVehiculo = tiempoVehiculo;
        this.tiempoPie = tiempoPie;
        this.consumoGas = consumoGas;
        this.desgastePersona = desgastePersona;
        this.distancia = distancia;
        this.tHoraInicio = tHoraInicio;
        this.tHoraFinal = tHoraFinal;
        this.tProbabilidad = tProbabilidad;
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

    public int gettHoraInicio() {
        return tHoraInicio;
    }

    public void settHoraInicio(int tHoraInicio) {
        this.tHoraInicio = tHoraInicio;
    }

    public int gettHoraFinal() {
        return tHoraFinal;
    }

    public void settHoraFinal(int tHoraFinal) {
        this.tHoraFinal = tHoraFinal;
    }

    public int gettProbabilidad() {
        return tProbabilidad;
    }

    public void settProbabilidad(int tProbabilidad) {
        this.tProbabilidad = tProbabilidad;
    }

    @Override
    public String toString() {
        return "Arista{" + "destino=" + destino.getNombreOrigen() + ", \ntiempoVehiculo=" + tiempoVehiculo + ", \ntiempoPie=" + tiempoPie + ", \nconsumoGas=" + consumoGas + ", \ndesgastePersona=" + desgastePersona + ", \ndistancia=" + distancia + ", \ntHoraInicio=" + tHoraInicio + ", \ntHoraFinal=" + tHoraFinal + ", \ntProbabilidad=" + tProbabilidad + '}';
    }
    
    
}
