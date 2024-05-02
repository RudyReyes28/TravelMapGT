/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rudyreyes.travelmapgt.controlador;

import com.rudyreyes.travelmapgt.modelo.grafo.Arista;
import com.rudyreyes.travelmapgt.modelo.grafo.Nodo;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author rudyo
 */
public class RecorridosGrafo {
    
    
    public static void encontrarCaminosVehiculo(Nodo nodoActual, Nodo nodoDestino, Set<Nodo> visitados, ArrayList<Nodo> caminoActual, int distanciaTotal, List<List<Nodo>> todasLasRutas) {
        // Marcar el nodo actual como visitado
        visitados.add(nodoActual);

        // Agregar el nodo actual al camino actual
        caminoActual.add(nodoActual);
        

        // Si el nodo actual es el nodo destino, imprimir el camino actual
        if (nodoActual.equals(nodoDestino)) {
            todasLasRutas.add(new ArrayList<>(caminoActual));
            imprimirCamino(caminoActual);
            System.out.println("Distancia total: " + distanciaTotal);
        } else {
            // Recorrer todos los destinos del nodo actual
            for (Arista arista : nodoActual.getDestinos()) {
                Nodo siguienteNodo = arista.getDestino();
                int peso = arista.getDistancia();
                // Si el siguiente nodo no ha sido visitado aún, continuar explorando desde él
                if (!visitados.contains(siguienteNodo)) {
                    encontrarCaminosVehiculo(siguienteNodo, nodoDestino, visitados, caminoActual, distanciaTotal+peso, todasLasRutas);
                }
            }
        }

        // Desmarcar el nodo actual como visitado y eliminarlo del camino actual
        visitados.remove(nodoActual);
        caminoActual.remove(nodoActual);
    }
    
    // Método para imprimir un camino
    public static void imprimirCamino(ArrayList<Nodo> camino) {
        for (Nodo nodo : camino) {
            System.out.print(nodo.getNombreOrigen() + " -> ");
        }
        System.out.println();
    }
    
    
    public static String imprimirRuta(List<Nodo> camino){
        String ruta = "";
        //String nodoOrigen = camino.get(0).getNombreOrigen();
        //String destino=null;
        
        int distancia = 0;
        //A->B->C->D
        for(int i=0; i<camino.size(); i++){
            ruta += camino.get(i).getNombreOrigen()+" ->";
            if(i+1<camino.size()){
                distancia += camino.get(i).getDestino(camino.get(i+1).getNombreOrigen()).getDistancia();
            }
        }
        
        ruta += "   distancia total"+distancia;
        
        /*
        for (Nodo nodo : camino) {
            ruta += nodo.getNombreOrigen() + " -> ";
            
        }*/
        
        return ruta;
    }
}
