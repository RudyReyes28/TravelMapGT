/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rudyreyes.travelmapgt.modelo.grafo;

/**
 *
 * @author rudyo
 */
public class MejoresRutasTrafico {
    
    private String mejorGasolina;
    private String peorGasolina;
    private String mejorDistancia;
    private String peorDistancia;
    private String mejorPromGasD;
    private String peorPromGasD ;
    private String mejorRapidez;
    private String peorRapidez;

    public MejoresRutasTrafico() {
    }

    
    
    public String getMejorGasolina() {
        return mejorGasolina;
    }

    public void setMejorGasolina(String mejorGasolina) {
        this.mejorGasolina = mejorGasolina;
    }

    public String getPeorGasolina() {
        return peorGasolina;
    }

    public void setPeorGasolina(String peorGasolina) {
        this.peorGasolina = peorGasolina;
    }

    public String getMejorDistancia() {
        return mejorDistancia;
    }

    public void setMejorDistancia(String mejorDistancia) {
        this.mejorDistancia = mejorDistancia;
    }

    public String getPeorDistancia() {
        return peorDistancia;
    }

    public void setPeorDistancia(String peorDistancia) {
        this.peorDistancia = peorDistancia;
    }

    public String getMejorPromGasD() {
        return mejorPromGasD;
    }

    public void setMejorPromGasD(String mejorPromGasD) {
        this.mejorPromGasD = mejorPromGasD;
    }

    public String getPeorPromGasD() {
        return peorPromGasD;
    }

    public void setPeorPromGasD(String peorPromGasD) {
        this.peorPromGasD = peorPromGasD;
    }

    public String getMejorRapidez() {
        return mejorRapidez;
    }

    public void setMejorRapidez(String mejorRapidez) {
        this.mejorRapidez = mejorRapidez;
    }

    public String getPeorRapidez() {
        return peorRapidez;
    }

    public void setPeorRapidez(String peorRapidez) {
        this.peorRapidez = peorRapidez;
    }
    
    public void rutasIniciales(String rutaInicial, int distancia, int gasolina, double gasdis, double velocidad){
        mejorGasolina = rutaInicial + " Gasolina Total: "+gasolina ;
        peorGasolina = rutaInicial + " Gasolina Total: "+gasolina;
        mejorDistancia = rutaInicial + " Distancia total: "+distancia;
        peorDistancia = rutaInicial + " Distancia total: "+distancia;
        mejorPromGasD = rutaInicial +" Promedio Distancia/Gas:"+ String.format("%.4f", gasdis);
        peorPromGasD = rutaInicial +" Promedio Distancia/Gas:"+ String.format("%.4f", gasdis);
        mejorRapidez = rutaInicial +" Promedio Velocidad:"+ String.format("%.4f", velocidad);
        peorRapidez = rutaInicial +" Promedio Velocidad:"+ String.format("%.4f", velocidad);
    }
    
    
    public String imprimirRutas(){
        String rutas = "";
        rutas += "---------- MEJORES RUTAS ------------\n";
        rutas += "Mejor ruta en base a la gasolina: \n\t"+mejorGasolina;
        rutas += "\nMejor ruta en base a la distancia:  \n\t"+mejorDistancia;
        rutas += "\nMejor ruta en base a la gasolina y la distancia:  \n\t"+mejorPromGasD;
        rutas += "\nRuta mas rapida:  \n\t"+mejorRapidez;
        rutas += "\n---------- PEORES RUTAS ------------\n";
        
        rutas += "Peor ruta en base a la gasolina: \n\t"+peorGasolina;
        rutas += "\nPeor ruta en base a la distancia:  \n\t"+peorDistancia;
        rutas += "\nPeor ruta en base a la gasolina y la distancia:  \n\t"+peorPromGasD;
        rutas += "\nRuta menos rapida:  \n\t"+peorRapidez;
        return rutas;
    }
}
