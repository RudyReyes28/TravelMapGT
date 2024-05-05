/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rudyreyes.travelmapgt.modelo.grafo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author rudyo
 */
public class Grafo {
    private HashMap<String, Nodo> nodosOrigen;
    private HashMap<String, Nodo> nodosOrigenNoDirigido;
    
    public Grafo() {
        this.nodosOrigen = new HashMap<>();
        this.nodosOrigenNoDirigido = new HashMap<>();
    }
    
    public void agregarNodo(Nodo nodo){
        
        if (!nodosOrigen.containsKey(nodo.getNombreOrigen())) {
            nodosOrigen.put(nodo.getNombreOrigen(), nodo);
        }
        
    }
    
    public void agregarNodoNoDirigido(Nodo nodo){
        if (!nodosOrigenNoDirigido.containsKey(nodo.getNombreOrigen())) {
            nodosOrigenNoDirigido.put(nodo.getNombreOrigen(), nodo);
        }
    }
    
    public Nodo buscarNodo(String nombreLugar){
        return nodosOrigen.get(nombreLugar);
    }
    
    
    public Nodo buscarNodoNoDirigio(String nombreLugar){
        return nodosOrigenNoDirigido.get(nombreLugar);
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
    
    public void imprimirNodosNoDirigido(){
        for (Map.Entry<String, Nodo> entry : nodosOrigenNoDirigido.entrySet()) {
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
    
    public String imprimirGrafoNoDirigido(){
        String grafo = "";
        Set<String> conexionesAgregadas = new HashSet<>(); // Conjunto para almacenar las conexiones ya agregadas

        for (Map.Entry<String, Nodo> entry : nodosOrigenNoDirigido.entrySet()) {
            Nodo nodo = entry.getValue();

            if (!nodo.getDestinos().isEmpty()) {
                for (Arista arista : nodo.getDestinos()) {
                    // Construir la representación de la conexión de forma ordenada
                    String conexion = nodo.getNombreOrigen().compareTo(arista.getDestino().getNombreOrigen()) < 0
                            ? nodo.getNombreOrigen() + "--" + arista.getDestino().getNombreOrigen()
                            : arista.getDestino().getNombreOrigen() + "--" + nodo.getNombreOrigen();

                    // Verificar si la conexión ya ha sido agregada
                    if (!conexionesAgregadas.contains(conexion)) {
                        grafo += conexion + "[label=\"" + arista.getDistancia() + "\"];\n";
                        conexionesAgregadas.add(conexion); // Agregar la conexión al conjunto de conexiones agregadas
                    }
                }
            }
        }

        return grafo;
    }

    public HashMap<String, Nodo> getNodosOrigen() {
        return nodosOrigen;
    }
    
    public HashMap<String, Nodo> getNodosOrigenNoDirigido() {
        return nodosOrigenNoDirigido;
    }
}
