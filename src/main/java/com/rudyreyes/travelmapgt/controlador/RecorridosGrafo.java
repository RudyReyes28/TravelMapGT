/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rudyreyes.travelmapgt.controlador;

import com.rudyreyes.travelmapgt.modelo.grafo.Arista;
import com.rudyreyes.travelmapgt.modelo.grafo.MejoresRutasTrafico;
import com.rudyreyes.travelmapgt.modelo.grafo.Nodo;
import com.rudyreyes.travelmapgt.modelo.grafo.Trafico;
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
        
        //A->B->C->D
        for(int i=0; i<camino.size(); i++){
            if(i==camino.size()-1){
                ruta += camino.get(i).getNombreOrigen();
            }else{
                ruta += camino.get(i).getNombreOrigen()+" ->";
            }
            
            
        }
        
       
        
        return ruta;
    }
    
    public static String imprimirRutasVehiculo(List<List<Nodo>> todasLasRutas, int hora) {
        //String rutas = "";
        MejoresRutasTrafico rutas = new MejoresRutasTrafico();

        int mejorGas = 0;
        int peorGas = 0;
        int mejorDistancia = 0;
        int peorDistancia = 0;
        double mejorPromGasD = 0;
        double peorPromGasD = 0;
        double mejorRap = 0;
        double peorRap = 0;
        int iteracion = 0;
        for (List<Nodo> camino : todasLasRutas) {
            //RUTAS ESPECIFICAS
            
            
            // Trabajar con cada ruta aquí
            int horaT = hora;
            List<Double> velocidades = new ArrayList<>();
            String ruta = "";

            int distancia = 0;
            int gasolina = 0;
            //A->B->C->D
            for (int i = 0; i < camino.size(); i++) {
                ruta += camino.get(i).getNombreOrigen() + " ->";
                //System.out.println("Ruta"+ ruta);
                if (i + 1 < camino.size()) {
                    int distanciaC = camino.get(i).getDestino(camino.get(i + 1).getNombreOrigen()).getDistancia();
                    distancia += distanciaC;
                    gasolina += camino.get(i).getDestino(camino.get(i + 1).getNombreOrigen()).getConsumoGas();

                    int tiempo = camino.get(i).getDestino(camino.get(i + 1).getNombreOrigen()).getTiempoVehiculo();
                    double probabilidad = obtenerProbabilidad(camino.get(i).getDestino(camino.get(i + 1).getNombreOrigen()), horaT);
                    //System.out.println("Tiempo: "+tiempo+" Hora: "+horaT+" Probabilidad: "+probabilidad);

                    double rapidez = distanciaC / (tiempo * (1 + probabilidad));
                    
                    //System.out.println("Rapidez" + rapidez);
                    velocidades.add(rapidez);

                    horaT += tiempo;
                    if (horaT >= 24) {
                        horaT = 0 + tiempo - 1;
                    }
                }
            }

            double sumaVelocidades = 0.0;
            for (double velocidad : velocidades) {
                sumaVelocidades += velocidad;
            }

            double promedioVelocidades = sumaVelocidades / velocidades.size();

            double promGasDis = (double) distancia / gasolina;
            /*ruta += "\n   distancia total: " + distancia;
            ruta += " gasolina total: " + gasolina;
            ruta += " promedio gasolina distancia: " + (double) distancia / gasolina;
            ruta += " rapidez: " + promedioVelocidades;*/

            //PARA DISTANCIA
            if(iteracion == 0){
                mejorDistancia = distancia;
                peorDistancia = distancia;
                mejorGas = gasolina;
                peorGas = gasolina;
                mejorPromGasD = promGasDis;
                peorPromGasD = promGasDis;
                mejorRap = promedioVelocidades;
                peorRap = promedioVelocidades;
                
                rutas.rutasIniciales(ruta);
            }else{
                //DISTANCIA
                if(distancia<=mejorDistancia){
                    rutas.setMejorDistancia(ruta);
                    mejorDistancia = distancia;
                }else if(distancia>=peorDistancia){
                    rutas.setPeorDistancia(ruta);
                    peorDistancia = distancia;
                }
                
                //GASOLINA
                if(gasolina<= mejorGas){
                    rutas.setMejorGasolina(ruta);
                    mejorGas =gasolina;
                }else if(gasolina >= peorGas){
                    rutas.setPeorGasolina(ruta);
                    peorGas=gasolina;
                }
                
                //DISTANCIA/GAS
                if(promGasDis<= mejorPromGasD){
                    rutas.setMejorPromGasD(ruta);
                    mejorPromGasD = promGasDis;
                }else if(promGasDis >= peorPromGasD){
                    rutas.setPeorPromGasD(ruta);
                    peorPromGasD = promGasDis;
                }
                
                //RAPIDEZ
                if(promedioVelocidades>= mejorRap){
                    rutas.setMejorRapidez(ruta);
                    mejorRap = promedioVelocidades;
                }else if(promedioVelocidades <= peorRap){
                    rutas.setPeorRapidez(ruta);
                    peorRap = promedioVelocidades;
                }
                
            }
            
            iteracion ++;
        }
        
        return rutas.imprimirRutas();
    }
    
    private static double obtenerProbabilidad(Arista destino, int hora){
        
        for (Trafico t : destino.getTrafico()) {
            //System.out.println("Hora Inicial : "+t.getHoraInicial()+ " hora final "+ t.getHoraFinal());
            if (hora >= t.getHoraInicial() && hora <= t.getHoraFinal()) {
                return t.getProbabilidad() / 100f;
            } 
        }
        
        return 0;
        
        
    } 
}
