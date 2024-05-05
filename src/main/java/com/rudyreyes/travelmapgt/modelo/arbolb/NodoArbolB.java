/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rudyreyes.travelmapgt.modelo.arbolb;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rudyo
 */
public class NodoArbolB {
    
    public int n; //numero de claves almacenadas en el nodo
    public boolean leaf; //Si el nodo es hoja (nodo hoja=true; nodo interno=false)
    public int key[];  //almacena las claves en el nodo
    public NodoArbolB child[]; //arreglo con referencias a los hijos

    //Constructores
    public NodoArbolB(int t) {
        n = 0;
        leaf = true;
        key = new int[((2 * t) - 1)];
        child = new NodoArbolB[(2 * t)];
    }

    public void imprimir() {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                System.out.print(key[i] + " | ");
            } else {
                System.out.print(key[i]);
            }
        }
        System.out.print("]");
    }

    public int find(int k) {
        for (int i = 0; i < n; i++) {
            if (key[i] == k) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < n; i++) {
            sb.append(key[i]);
            if (i < n - 1) {
                sb.append(" | ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    
    public String imprimirRutas(List<String> Rutas) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < n; i++) {
            
            sb.append(Rutas.get(key[i]));
            if (i < n - 1) {
                sb.append(" | ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
