/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rudyreyes.travelmapgt.controlador;

import com.rudyreyes.travelmapgt.modelo.grafo.*;
import java.util.Scanner;

/**
 *
 * @author rudyo
 */
public class CargarDatos {
    
    public static void cargarDatosRutas(String datosArchivo, Grafo grafo) {
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
    
    public static void cargarDatosTrafico(String datosArchivo, Grafo grafo) {
        try {
            //File file = new File(archivo);
            Scanner scanner = new Scanner(datosArchivo);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    String[] datos = line.split("\\|");

                    String origen = datos[0];
                    String destino = datos[1];
                    int horaInicio = Integer.parseInt(datos[2]);
                    int horaFinal = Integer.parseInt(datos[3]);
                    int probTrafico = Integer.parseInt(datos[4]);

                    Nodo nodoOrigen = grafo.buscarNodo(origen);
                    if (nodoOrigen != null) {
                        Arista arista = nodoOrigen.getDestino(destino);
                        
                        if(arista!=null){
                            
                            arista.setTrafico(new Trafico(horaInicio, horaFinal, probTrafico));
                        }
                    }
                }

            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
