/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rudyreyes.travelmapgt.controlador;

import java.time.LocalTime;
import javax.swing.JTextField;

/**
 *
 * @author rudyo
 */
public class Reloj extends Thread {
    
    private int hora;
    private int minutos;
    private int segundos;
    private boolean running;
    private JTextField areaHora;

    public Reloj(JTextField areaHora) {
        
        LocalTime horaActual = LocalTime.now();

        // Obtener la hora y el minuto actual
        int hora = horaActual.getHour(); // en formato de 24 horas
        int minuto = horaActual.getMinute();
        
        this.hora = hora;
        this.minutos = minuto;
        this.areaHora = areaHora;
        this.running = true;
    }

    @Override
    public void run() {
         
        while (running) {
            try {
                Thread.sleep(1000);
                segundos++;
                if (segundos == 60) {
                    minutos ++;
                    segundos =0;
                    if(minutos==60){
                        hora++;
                        if(hora==24){
                            hora = 0;
                        }
                        minutos=0;
                    }
                }
                // Actualiza el JTextField con la hora y los minutos formateados
                areaHora.setText(String.format("%02d:%02d:%02d", hora, minutos,segundos));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void detener() {
        running = false;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
    
    
    
}
