/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rudyreyes.travelmapgt.controlador;

import com.rudyreyes.travelmapgt.modelo.grafo.Arista;
import com.rudyreyes.travelmapgt.modelo.grafo.Grafo;
import com.rudyreyes.travelmapgt.modelo.grafo.Nodo;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author rudyo
 */
public class Graficas {
    
    
    public static void generarArchivoDOT(String dotFilePath, Grafo grafo) {
        try (FileWriter writer = new FileWriter(dotFilePath)) {
            writer.write("digraph G {\n");
            String archivo = grafo.imprimirGrafo();
            //writer.write("size=\"8,8\";\n");
            writer.write(archivo);
            writer.write("}\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void generarArchivoDOTNoDirigido(String dotFilePath, Grafo grafo) {
        try (FileWriter writer = new FileWriter(dotFilePath)) {
            writer.write("graph G {\n");
            String archivo = grafo.imprimirGrafoNoDirigido();
            //writer.write("size=\"8,8\";\n");
            writer.write(archivo);
            writer.write("}\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generarImagenGrafo(String dotFilePath, String nombreImagen) {
        String command = "dot -T png -Gratio=fill -o " + nombreImagen + " " + dotFilePath;
        try {
            Process process = Runtime.getRuntime().exec(command);
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Imagen generada con éxito.");
            } else {
                System.out.println("Ocurrió un error al generar la imagen.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void generarArchivoDOTRutasSeleccionadas(String dotFilePath, Grafo grafo, List<List<Nodo>> todasLasRutas, String destino) {
        Set<String> rutasSeleccionadas = rutasSeleccionadas(todasLasRutas);
        try (FileWriter writer = new FileWriter(dotFilePath)) {
            writer.write("digraph G {\n");
            
            HashMap<String, Nodo> nodosOrigen = grafo.getNodosOrigen();
            
            String grafoD = "";
            for (Map.Entry<String, Nodo> entry : nodosOrigen.entrySet()) {
                Nodo nodo = entry.getValue();

                if (!nodo.getDestinos().isEmpty()) {
                    for (Arista arista : nodo.getDestinos()) {
                        String flechas = nodo.getNombreOrigen() + "->" + arista.getDestino().getNombreOrigen();
                        if (rutaEncontrada(rutasSeleccionadas, flechas)) {

                            grafoD += nodo.getNombreOrigen() + "[style=filled, fillcolor=blue];\n";
                            grafoD += flechas + "[color=green]" + "[label=\"" + arista.getDistancia() + "\"];" + "\n";
                        } else {
                            grafoD += flechas + "[label=\"" + arista.getDistancia() + "\"];" + "\n";
                        }
                    }
                }

            }
            grafoD += destino +"[style=filled, fillcolor=red];\n";
            //writer.write("size=\"8,8\";\n");
            writer.write(grafoD);
            writer.write("}\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     public static void generarArchivoDOTRutasCaminando(String dotFilePath, Grafo grafo, List<List<Nodo>> todasLasRutas, String destino) {
         Set<String> rutasSeleccionadas = rutasSeleccionadas(todasLasRutas);
         Set<String> conexionesAgregadas = new HashSet<>();
         try (FileWriter writer = new FileWriter(dotFilePath)) {
            writer.write("graph G {\n");
            
            HashMap<String, Nodo> nodosOrigen = grafo.getNodosOrigenNoDirigido();
            
            String grafoD = "";
            for (Map.Entry<String, Nodo> entry : nodosOrigen.entrySet()) {
                Nodo nodo = entry.getValue();

                if (!nodo.getDestinos().isEmpty()) {
                    for (Arista arista : nodo.getDestinos()) {
                        
                        String conexion = nodo.getNombreOrigen().compareTo(arista.getDestino().getNombreOrigen()) < 0
                            ? nodo.getNombreOrigen() + "--" + arista.getDestino().getNombreOrigen()
                            : arista.getDestino().getNombreOrigen() + "--" + nodo.getNombreOrigen();
                        
                        if (!conexionesAgregadas.contains(conexion)) {
                           String flechas = nodo.getNombreOrigen() + "->" + arista.getDestino().getNombreOrigen();
                            if (rutaEncontrada(rutasSeleccionadas, flechas)) {

                                grafoD += nodo.getNombreOrigen() + "[style=filled, fillcolor=blue];\n";
                                grafoD += conexion + "[color=green]" + "[label=\"" + arista.getDistancia() + "\"];" + "\n";
                            } else {
                                grafoD += conexion + "[label=\"" + arista.getDistancia() + "\"];" + "\n";
                            }
                            conexionesAgregadas.add(conexion); // Agregar la conexión al conjunto de conexiones agregadas
                        }
                        
                    }
                }

            }
            grafoD += destino +"[style=filled, fillcolor=red];\n";
            //writer.write("size=\"8,8\";\n");
            writer.write(grafoD);
            writer.write("}\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
    
    private static boolean rutaEncontrada(Set<String> rutas, String ruta){
        //System.out.println(ruta);
        for(String flecha: rutas){
            //System.out.println("Set: "+flecha);
            if(flecha.equalsIgnoreCase(ruta)){
                return true;
            }
        }
        
        return false;
    }
    
    private static Set<String> rutasSeleccionadas(List<List<Nodo>> todasLasRutas){
        List<String> rutasGrap = new ArrayList<>();
        for (List<Nodo> ruta : todasLasRutas) {
                
            for(int i=0; i<ruta.size(); i++){
                if (i + 1 < ruta.size()) {
                    Nodo nodoActual = ruta.get(i);
                    Nodo nodoSiguiente = ruta.get(i + 1);
                    String conexiones = nodoActual.getNombreOrigen()+"->"+nodoSiguiente.getNombreOrigen();
                    rutasGrap.add(conexiones);
                }
                
            }
                
        }
        
        Set<String> conjuntoElementos = new HashSet<>(rutasGrap);
        
        return conjuntoElementos;
    }
}
