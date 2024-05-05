/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rudyreyes.travelmapgt.controlador;

import com.rudyreyes.travelmapgt.modelo.arbolb.NodoArbolB;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author rudyo
 */
public class GraficasArbolB {
    
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
