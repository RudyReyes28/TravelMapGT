/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.rudyreyes.travelmapgt;

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
        /*
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
"F|G|10|20|5|3|30";*/
        //grado minimo del Arbol B es t=3
        //Cada nodo soporta 2t hijos y 2t-1 claves
        int t = 3;
        //Se crea el arbol B segun t
        ArbolB arbolB = new ArbolB(t);
        List <String> rutas = new ArrayList<>();
        rutas.add("A->B->C->D");
        rutas.add("A->C->C->D");
        rutas.add("A->D->C->D");
        rutas.add("A->E->C->D");
        rutas.add("A->F->C->D");
        rutas.add("A->G->C->D");
        rutas.add("A->H->C->D");
        rutas.add("A->I->C->D");
        rutas.add("A->J->C->D");
        rutas.add("A->K->C->D");
        
        //Valores a ingresar primera ronda
        int[] valoresUno = {20, 10, 50, 30, 40, 100, 200, 150, 151, 152, 153, 154, 155, 156,157,158,159,160,161,162,163};
        System.out.println("-- INICIO --");
        System.out.println("INSERTANDO VALORES AL ARBOL B");
        for(int i=0; i<10; i++) {
            System.out.println("Insertando... valor " + valoresUno[i]);
            arbolB.insertar(i);
        }
        
        //Mostrando arbol B por pantalla en preorder
        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");
        
        
        System.out.println("");
        System.out.println("-- FIN --");
        
        
        String dotFilePath = "arbol.dot";
        generarDOT(dotFilePath, arbolB.root, rutas);
        generarImagenGrafo(dotFilePath, "arbol.png");
        
      }
    
    public static void generarDOT(String archivoDot, NodoArbolB root, List<String> rutas) {
    try (FileWriter writer = new FileWriter(archivoDot)) {
        writer.write("digraph G {\n");

        // Llamar al método para generar el DOT del árbol
        bucarPaginas(root, writer, rutas);

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
    private static void bucarPaginas(NodoArbolB n, FileWriter writer, List<String> rutas) throws IOException {
        // Generar el DOT del nodo actual
        String nodoDOT = "\"" + n.imprimirRutas(rutas) + "\" [label=\"" + n.imprimirRutas(rutas) + "\"];\n";
        writer.write(nodoDOT);

        // Si no es hoja, generar los enlaces con los hijos
        if (!n.leaf) {
            for (int j = 0; j <= n.n; j++) {
                if (n.child[j] != null) {
                    // Generar el DOT del enlace con el hijo
                    String enlaceDOT = "\"" + n.imprimirRutas(rutas) + "\" -> \"" + n.child[j].imprimirRutas(rutas) + "\";\n";
                    writer.write(enlaceDOT);

                    // Llamar recursivamente al método para el hijo
                    bucarPaginas(n.child[j], writer, rutas);
                }
            }
        }
    }

}
