/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rudyreyes.travelmapgt.controlador;

import com.rudyreyes.travelmapgt.modelo.grafo.Grafo;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author rudyo
 */
public class Graficas {
    
    
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

    public static void generarImagenGrafo(String dotFilePath, String outputFormat) {
        String command = "dot -T" + outputFormat + " -Gratio=fill -o grafoP." + outputFormat + " " + dotFilePath;
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
