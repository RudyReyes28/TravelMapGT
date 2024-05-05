/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.rudyreyes.travelmapgt;

import com.rudyreyes.travelmapgt.controlador.CargarDatos;
import com.rudyreyes.travelmapgt.controlador.Graficas;
import com.rudyreyes.travelmapgt.controlador.RecorridosGrafo;
import com.rudyreyes.travelmapgt.modelo.arbolb.ArbolB;
import com.rudyreyes.travelmapgt.modelo.arbolb.NodoArbolB;
import com.rudyreyes.travelmapgt.modelo.grafo.Arista;
import com.rudyreyes.travelmapgt.modelo.grafo.Grafo;
import com.rudyreyes.travelmapgt.modelo.grafo.Nodo;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        
        
        CargarDatos.cargarDatosRutas(datos, grafos);
        
        //grafos.imprimirNodosNoDirigido();
        
        List<List<Nodo>> todasLasRutas = new ArrayList<>();
            int distanciaTotal = 0;
            RecorridosGrafo.encontrarCaminosNoDirigido(grafos.buscarNodoNoDirigio("B"), grafos.buscarNodoNoDirigio("A"), new HashSet<>(), new ArrayList<>(), distanciaTotal, todasLasRutas);
            
        for (List<Nodo> ruta : todasLasRutas) {
            // Trabajar con cada ruta aquí
            String rutaA = RecorridosGrafo.imprimirRuta(ruta);
            System.out.println(rutaA);
        }
      }
    
    

}
