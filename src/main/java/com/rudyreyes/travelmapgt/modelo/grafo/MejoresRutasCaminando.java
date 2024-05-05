/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rudyreyes.travelmapgt.modelo.grafo;

/**
 *
 * @author rudyo
 */
public class MejoresRutasCaminando {
    private String mejorDesgaste;
    private String peorDesgaste;
    private String mejorDistancia;
    private String peorDistancia;
    private String mejorPromFisicoD;
    private String peorPromFisicoD ;
    private String mejorRapidez;
    private String peorRapidez;

    public MejoresRutasCaminando() {
    }

    public String getMejorDesgaste() {
        return mejorDesgaste;
    }

    public void setMejorDesgaste(String mejorDesgaste) {
        this.mejorDesgaste = mejorDesgaste;
    }

    public String getPeorDesgaste() {
        return peorDesgaste;
    }

    public void setPeorDesgaste(String peorDesgaste) {
        this.peorDesgaste = peorDesgaste;
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

    public String getMejorPromFisicoD() {
        return mejorPromFisicoD;
    }

    public void setMejorPromFisicoD(String mejorPromFisicoD) {
        this.mejorPromFisicoD = mejorPromFisicoD;
    }

    public String getPeorPromFisicoD() {
        return peorPromFisicoD;
    }

    public void setPeorPromFisicoD(String peorPromFisicoD) {
        this.peorPromFisicoD = peorPromFisicoD;
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
    
    
    public void rutasIniciales(String rutaInicial, int distancia, int desgaste, double fisicoDis, double velocidad){
        mejorDesgaste = rutaInicial + " Desgaste Total: "+desgaste ;
        peorDesgaste = rutaInicial + " Desgaste Total: "+desgaste;
        mejorDistancia = rutaInicial + " Distancia total: "+distancia;
        peorDistancia = rutaInicial + " Distancia total: "+distancia;
        mejorPromFisicoD = rutaInicial +" Promedio Distancia/Desgaste: "+ String.format("%.4f", fisicoDis);
        peorPromFisicoD = rutaInicial +" Promedio Distancia/Desgaste: "+ String.format("%.4f", fisicoDis);
        mejorRapidez = rutaInicial +" Promedio Velocidad:"+ String.format("%.4f", velocidad);
        peorRapidez = rutaInicial +" Promedio Velocidad:"+ String.format("%.4f", velocidad);
    }
    
    public String imprimirRutas(){
        String rutas = "";
        rutas += "---------- MEJORES RUTAS ------------\n";
        rutas += "Mejor ruta en base al desgaste fisico: \n\t"+mejorDesgaste;
        rutas += "\nMejor ruta en base a la distancia:  \n\t"+mejorDistancia;
        rutas += "\nMejor ruta en base al desgaste y la distancia:  \n\t"+mejorPromFisicoD;
        rutas += "\nRuta mas rapida:  \n\t"+mejorRapidez;
        rutas += "\n---------- PEORES RUTAS ------------\n";
        
        rutas += "Peor ruta en base al desgaste fisico: \n\t"+peorDesgaste;
        rutas += "\nPeor ruta en base a la distancia:  \n\t"+peorDistancia;
        rutas += "\nPeor ruta en base al desgaste y la distancia:  \n\t"+peorPromFisicoD;
        rutas += "\nRuta menos rapida:  \n\t"+peorRapidez;
        return rutas;
    }
}
