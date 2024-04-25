/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.rudyreyes.travelmapgt;

import com.rudyreyes.travelmapgt.modelo.grafo.Arista;
import com.rudyreyes.travelmapgt.modelo.grafo.Grafo;
import com.rudyreyes.travelmapgt.modelo.grafo.Nodo;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author rudyo
 */
public class TravelMapGT {

    public static void main(String[] args) {
        
        Grafo grafos = new Grafo();
        String datos = "A|B|10|20|5|3|30\n" +
"B|C|15|25|6|4|40\n" +
"C|D|12|22|4|2|25\n" +
"D|E|8|18|3|2|20\n" +
"E|F|10|20|5|3|30\n" +
"F|G|15|25|6|4|40\n" +
"G|H|12|22|4|2|25\n" +
"H|A|8|18|3|2|20";
        
        cargarDatos(datos, grafos);
        
        
        //grafos.imprimirNodos();
        
        
       // Generar el archivo DOT
        String dotFilePath = "graph.dot";
        generarArchivoDOT(dotFilePath, grafos);

        // Generar la imagen del grafo usando Graphviz
        String outputFormat = "png"; // Puedes cambiar el formato de salida aquí
        generarImagenGraphviz(dotFilePath, outputFormat);
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
            
            
            writer.write(archivo);
            writer.write("}\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generarImagenGraphviz(String dotFilePath, String outputFormat) {
        String command = "dot -T" + outputFormat + " " + dotFilePath + " -o graph." + outputFormat;
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
        
    
    
}
