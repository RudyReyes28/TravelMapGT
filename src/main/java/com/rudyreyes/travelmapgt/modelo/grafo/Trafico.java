/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rudyreyes.travelmapgt.modelo.grafo;

/**
 *
 * @author rudyo
 */
public class Trafico {
    int horaInicial;
    int horaFinal;
    int probabilidad;

    public Trafico(int horaInicial, int horaFinal, int probabilidad) {
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.probabilidad = probabilidad;
    }

    public Trafico() {
    }

    public int getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(int horaInicial) {
        this.horaInicial = horaInicial;
    }

    public int getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(int horaFinal) {
        this.horaFinal = horaFinal;
    }

    public int getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(int probabilidad) {
        this.probabilidad = probabilidad;
    }
    
    public String imprimirTrafico(){
        return "Hora Inicio"+this.horaInicial + "Hora Final: "+this.horaFinal + " Probabilidad"+probabilidad;
    }
}
