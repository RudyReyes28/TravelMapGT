/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.rudyreyes.travelmapgt;

import com.rudyreyes.travelmapgt.modelo.grafo.Arista;
import com.rudyreyes.travelmapgt.modelo.grafo.Grafo;
import com.rudyreyes.travelmapgt.modelo.grafo.Nodo;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author rudyo
 */
public class TravelMapGT {

    public static void main(String[] args) {
        
        Grafo grafos = new Grafo();
        String datos = "A|B|10|20|5|3|30\n" +
"A|F|15|25|6|4|40\n" +
"B|C|12|22|4|2|25\n" +
"B|G|8|18|3|2|20\n" +
"B|D|10|20|5|3|30\n" +
"B|E|15|25|6|4|40\n" +
"C|F|10|20|5|3|30\n" +
"D|C|15|25|6|4|40\n" +
"D|G|12|22|4|2|25\n" +
"D|E|8|18|3|2|20\n" +
"E|B|8|18|3|2|20\n" +
"E|F|10|20|5|3|30\n" +
"F|D|15|25|6|4|40\n" +
"F|G|10|20|5|3|30";
        
        cargarDatos(datos, grafos);
        
        
        //grafos.imprimirNodos();
        
        
       // Generar el archivo DOT
       String dotFilePath = "graph.dot";
        generarArchivoDOT(dotFilePath, grafos);

        // Generar la imagen del grafo usando Graphviz
        String outputFormat = "png"; // Puedes cambiar el formato de salida aquí
        generarImagenGraphviz(dotFilePath, outputFormat);
       int distanciaTotal = 0;
        encontrarCaminos(grafos.buscarNodo("A"), grafos.buscarNodo("G"), new HashSet<>(), new ArrayList<>(), distanciaTotal);
    }
    
    public static void cargarDatos(String datosArchivo, Grafo grafo) {
        try {
            //File file = new File(archivo);
            Scanner scanner = new Scanner(datosArchivo);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    String[] datos = line.split("\\|");

                    String origen = datos[0];
                    String destino = datos[1];
                    int tiempoVehiculo = Integer.parseInt(datos[2]);
                    int tiempoPie = Integer.parseInt(datos[3]);
                    int consumoGas = Integer.parseInt(datos[4]);
                    int desgastePersona = Integer.parseInt(datos[5]);
                    int distancia = Integer.parseInt(datos[6]);

                    // Crear nodo destino si no existe
                    Nodo nodoDestino;
                    if (grafo.buscarNodo(destino) != null) {
                        nodoDestino = grafo.buscarNodo(destino);
                    } else {
                        nodoDestino = new Nodo(destino);
                        grafo.agregarNodo(nodoDestino);
                    }

                    // Crear arista
                    Arista arista = new Arista(nodoDestino, tiempoVehiculo, tiempoPie, consumoGas, desgastePersona, distancia);

                    // Asignar arista al nodo origen
                    Nodo nodoOrigen = grafo.buscarNodo(origen);
                    if (nodoOrigen == null) {
                        nodoOrigen = new Nodo(origen);
                        grafo.agregarNodo(nodoOrigen);
                    }
                    nodoOrigen.setDestino(arista);
                }

            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public static void generarArchivoDOT(String dotFilePath, Grafo grafo) {
        try (FileWriter writer = new FileWriter(dotFilePath)) {
            writer.write("digraph G {\n");
            String archivo = grafo.imprimirGrafo();
            writer.write("size=\"8,8\";\n");
            writer.write(archivo);
            writer.write("}\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generarImagenGraphviz(String dotFilePath, String outputFormat) {
        String command = "dot -T" + outputFormat + " -Gratio=fill -o graph." + outputFormat + " " + dotFilePath;
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
        
    public static void encontrarCaminos(Nodo nodoActual, Nodo nodoDestino, Set<Nodo> visitados, ArrayList<Nodo> caminoActual, int distanciaTotal) {
        // Marcar el nodo actual como visitado
        visitados.add(nodoActual);

        // Agregar el nodo actual al camino actual
        caminoActual.add(nodoActual);
        

        // Si el nodo actual es el nodo destino, imprimir el camino actual
        if (nodoActual.equals(nodoDestino)) {
            imprimirCamino(caminoActual);
            System.out.println("Distancia total: " + distanciaTotal);
        } else {
            // Recorrer todos los destinos del nodo actual
            for (Arista arista : nodoActual.getDestinos()) {
                Nodo siguienteNodo = arista.getDestino();
                int peso = arista.getDistancia();
                // Si el siguiente nodo no ha sido visitado aún, continuar explorando desde él
                if (!visitados.contains(siguienteNodo)) {
                    encontrarCaminos(siguienteNodo, nodoDestino, visitados, caminoActual, distanciaTotal+peso);
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
    
}
