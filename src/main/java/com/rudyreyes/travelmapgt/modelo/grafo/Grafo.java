/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rudyreyes.travelmapgt.modelo.grafo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rudyo
 */
public class Grafo {
    private HashMap<String, Nodo> nodosOrigen;
    
    public Grafo() {
        this.nodosOrigen = new HashMap<>();
    }
    
    public void agregarNodo(Nodo nodo){
        
        if (!nodosOrigen.containsKey(nodo.getNombreOrigen())) {
            nodosOrigen.put(nodo.getNombreOrigen(), nodo);
        }
        
        
    }
    
    public Nodo buscarNodo(String nombreLugar){
        return nodosOrigen.get(nombreLugar);
    }
   
    public boolean verificarNodo(String nombreLugar) {
        if (!nodosOrigen.containsKey(nombreLugar)) {
            return true; //no existe
        } else {
            // Manejar caso de nodo ya existente, por ejemplo, lanzar una excepción o ignorar la inserción
            return false; // existe
        }
    }
    
    public void imprimirNodos(){
        for (Map.Entry<String, Nodo> entry : nodosOrigen.entrySet()) {
            Nodo nodo = entry.getValue();
            nodo.imprimirDatos(); // Suponiendo que Nodo tiene un método imprimirDatos()
            System.out.println("\n\n");
        }
    }
    
    public String imprimirGrafo(){
        //[label="5"];
        String grafo = "";
        for (Map.Entry<String, Nodo> entry : nodosOrigen.entrySet()) {
            Nodo nodo = entry.getValue();
            
            if(!nodo.getDestinos().isEmpty()){
                for(Arista arista: nodo.getDestinos()){
                    grafo +=nodo.getNombreOrigen()+"->"+arista.getDestino().getNombreOrigen()+"[label=\""+arista.getDistancia()+"\"];"+"\n";
                }
            }
           
        }
        
        return grafo;
    }
}
