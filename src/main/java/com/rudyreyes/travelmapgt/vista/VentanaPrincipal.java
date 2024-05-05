/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.rudyreyes.travelmapgt.vista;

import com.rudyreyes.travelmapgt.controlador.CargarDatos;
import com.rudyreyes.travelmapgt.controlador.Graficas;
import com.rudyreyes.travelmapgt.controlador.GraficasArbolB;
import com.rudyreyes.travelmapgt.controlador.RecorridosGrafo;
import com.rudyreyes.travelmapgt.controlador.Reloj;
import com.rudyreyes.travelmapgt.modelo.arbolb.ArbolB;
import com.rudyreyes.travelmapgt.modelo.grafo.Arista;
import com.rudyreyes.travelmapgt.modelo.grafo.Grafo;
import com.rudyreyes.travelmapgt.modelo.grafo.Nodo;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author rudyo
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    private Reloj reloj;
    private Grafo grafos;
    private List<List<Nodo>> todasLasRutas;
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        grafos = new Grafo();
        initComponents();
        
        reloj = new Reloj(areaReloj);
        reloj.start();
        //activarScroll();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cargarRutas = new javax.swing.JButton();
        cargarTrafico = new javax.swing.JButton();
        jcomboTipoViaje = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        posActual = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sigPosicion = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaDeRutas = new javax.swing.JTextArea();
        botonEmpezarViaje = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        areaReloj = new javax.swing.JTextField();
        botonPararHora = new javax.swing.JButton();
        botonAvanzar = new javax.swing.JButton();
        comboOrigen = new javax.swing.JComboBox<>();
        comboDestino = new javax.swing.JComboBox<>();
        scrollGrafo = new javax.swing.JScrollPane();
        etiquetaGrafoImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TravelMap GT");

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Travel Map GT");

        cargarRutas.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        cargarRutas.setText("Archivo de Rutas");
        cargarRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarRutasActionPerformed(evt);
            }
        });

        cargarTrafico.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        cargarTrafico.setText("Cargar Trafico");
        cargarTrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarTraficoActionPerformed(evt);
            }
        });

        jcomboTipoViaje.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jcomboTipoViaje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vehiculo", "Caminando" }));

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("Opcion de Viaje: ");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setText("Origen:");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setText("Destino:");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel5.setText("Realizar Movimientos:");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setText("Posicion Actual:");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel7.setText("Opciones del Viaje");

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel8.setText("Siguiente Posicion:");

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel9.setText("Rutas Posibles:");

        areaDeRutas.setColumns(20);
        areaDeRutas.setRows(5);
        jScrollPane1.setViewportView(areaDeRutas);

        botonEmpezarViaje.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        botonEmpezarViaje.setText("Empezar Viaje");
        botonEmpezarViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEmpezarViajeActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel10.setText("Hora:");

        areaReloj.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        areaReloj.setText("18:44");

        botonPararHora.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        botonPararHora.setText("Parar");
        botonPararHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPararHoraActionPerformed(evt);
            }
        });

        botonAvanzar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        botonAvanzar.setText("Avanzar");
        botonAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAvanzarActionPerformed(evt);
            }
        });

        scrollGrafo.setViewportView(etiquetaGrafoImagen);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(35, 35, 35)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel3))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(comboOrigen, 0, 173, Short.MAX_VALUE)
                                                    .addComponent(comboDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jcomboTipoViaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(jLabel7))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addComponent(botonEmpezarViaje))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(jLabel5))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(posActual, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(32, 32, 32)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(sigPosicion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGap(18, 18, 18)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(scrollGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 10, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(cargarRutas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cargarTrafico))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(areaReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonPararHora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(botonAvanzar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cargarRutas)
                    .addComponent(cargarTrafico)
                    .addComponent(jLabel10)
                    .addComponent(areaReloj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonPararHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(21, 21, 21)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jcomboTipoViaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(comboOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(comboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addComponent(botonEmpezarViaje)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel8)))
                        .addComponent(scrollGrafo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(posActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sigPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonAvanzar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(66, 66, 66))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void activarScroll(){
        scrollGrafo.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (e.isControlDown()) { // Verifica si se mantiene presionada la tecla Ctrl
                    double scale = 1.0;
                    int notches = e.getWheelRotation();
                    if (notches < 0) {
                        scale *= 1.1; // Zoom in
                    } else {
                        scale /= 1.1; // Zoom out
                    }
                    ImageIcon icon = new ImageIcon("grafoP.png");
                    Image originalImage = icon.getImage();
                    int newWidth = (int) (icon.getIconWidth() * scale);
                    int newHeight = (int) (icon.getIconHeight() * scale);

                    Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

                    // Crear un ImageIcon con la imagen escalada
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);

                    // Y finalmente, establecer la nueva imagen redimensionada en la etiqueta
                    etiquetaGrafoImagen.setIcon(scaledIcon);
                    etiquetaGrafoImagen.revalidate();

                    scrollGrafo.revalidate();
                }
            }
        });
    }
    private void cargarRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarRutasActionPerformed
        // TODO add your handling code here:
        //Necesito obtener un string
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (*.txt, *.py, *.xml, *.csv)", "txt", "py", "xml", "csv");
        fc.setFileFilter(filtro);

        int seleccion = fc.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fc.getSelectedFile();

            try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
                StringBuilder contenido = new StringBuilder();
                String linea;
                while ((linea = br.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }
                //System.out.println(contenido.toString());
                CargarDatos.cargarDatosRutas(contenido.toString(), grafos);
                generarGrafoPrincipal();
                
                HashMap<String, Nodo> nodosOrigen = grafos.getNodosOrigen();
                for (Map.Entry<String, Nodo> entry : nodosOrigen.entrySet()) {
                    Nodo nodo = entry.getValue();
                    comboOrigen.addItem(nodo.getNombreOrigen());
                    comboDestino.addItem(nodo.getNombreOrigen());
                }
                
                //grafos.imprimirNodos();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }//GEN-LAST:event_cargarRutasActionPerformed

    private void botonEmpezarViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEmpezarViajeActionPerformed
        // TODO add your handling code here:
        //String origen = nodoOrigen.getText();
        //String destino = nodoDestino.getText();
        String origen = (String) comboOrigen.getSelectedItem();
        String destino = (String) comboDestino.getSelectedItem();
        recorrerViaje(origen, destino);
        posActual.setText(origen);
        
        generarGrafoPrincipal();
        generarGrafoRutas();
        generarArbolB();
    }//GEN-LAST:event_botonEmpezarViajeActionPerformed

    private void cargarTraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarTraficoActionPerformed
        // TODO add your handling code here:
        
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (*.txt, *.py, *.xml, *.csv)", "txt", "py", "xml","csv");
        fc.setFileFilter(filtro);

        int seleccion = fc.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fc.getSelectedFile();

            try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
                StringBuilder contenido = new StringBuilder();
                String linea;
                while ((linea = br.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }
                //System.out.println(contenido.toString());
                CargarDatos.cargarDatosTrafico(contenido.toString(), grafos);
                System.out.println("\n\n");
                grafos.imprimirNodos();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }//GEN-LAST:event_cargarTraficoActionPerformed

    private int obtenerHora(){
        String horarioActual = areaReloj.getText();
            String[] partes = horarioActual.split(":");
            String horaStr = partes[0]; // La parte antes de ":"

            // Convertir las partes a enteros si es necesario
            return Integer.parseInt(horaStr);
    }
    
    private void generarArbolB() {
        ArbolB arbolB = new ArbolB(3);

        List<String> rutas = new ArrayList<>();
        for (List<Nodo> ruta : todasLasRutas) {
            // Trabajar con cada ruta aquí
            String rutaA = RecorridosGrafo.imprimirRuta(ruta);
            rutas.add(rutaA);
        }

        for (int i = 0; i < rutas.size(); i++) {
            arbolB.insertar(i);
        }

        String dotFilePath = "arbolB.dot";
        String outputFormat = "arbolB.png";
        GraficasArbolB.generarDOT(dotFilePath, arbolB.root, rutas);
        GraficasArbolB.generarImagenGrafo(dotFilePath,outputFormat );
        //System.out.println(rutas);
        try {
            String imagePath;
            File imageFile = new File(outputFormat);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void recorrerViaje(String origen, String destino){
        String tipoDeViaje = (String) jcomboTipoViaje.getSelectedItem();
        if (tipoDeViaje.equalsIgnoreCase("Vehiculo")) {
            todasLasRutas = new ArrayList<>();
            int distanciaTotal = 0;
            RecorridosGrafo.encontrarCaminosVehiculo(grafos.buscarNodo(origen), grafos.buscarNodo(destino), new HashSet<>(), new ArrayList<>(), distanciaTotal, todasLasRutas);
            
            
            areaDeRutas.setText(RecorridosGrafo.imprimirRutasVehiculo(todasLasRutas, obtenerHora()));

        }else{
            //AQUI SI ES CAMINANDO
            todasLasRutas = new ArrayList<>();
            int distanciaTotal = 0;
            RecorridosGrafo.encontrarCaminosNoDirigido(grafos.buscarNodoNoDirigio(origen), grafos.buscarNodoNoDirigio(destino), new HashSet<>(), new ArrayList<>(), distanciaTotal, todasLasRutas);
            
            areaDeRutas.setText(RecorridosGrafo.imprimirRutasCaminando(todasLasRutas));
        }
        sigPosicion.removeAllItems();
        
        if(posActual.getText()==null){
            posActual.setText((String) comboOrigen.getSelectedItem());
        }
        List<String> elementos = new ArrayList<>();
        
        
        for (List<Nodo> ruta : todasLasRutas) {
                if(1<ruta.size()){
                    elementos.add(ruta.get(1).getNombreOrigen());
                }
                
        }
        Set<String> conjuntoElementos = new HashSet<>(elementos);
        
        if(conjuntoElementos.isEmpty()){
            JOptionPane.showMessageDialog(null, "FELICIDADES LLEGÓ A SU DESTINO");
        }
        for (String elemento : conjuntoElementos) {
            sigPosicion.addItem(elemento);
        }
    }
    
    private void botonPararHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPararHoraActionPerformed
        boolean detenido = reloj.isRunning();
        //System.out.println("Estado "+detenido);
        if(detenido){
            reloj.setRunning(false);
            botonPararHora.setText("Reanudar");
        }else{
            //detenido
            String horarioActual = areaReloj.getText();
            String[] partes = horarioActual.split(":");
            String horaStr = partes[0]; // La parte antes de ":"
            String minutoStr = partes[1]; // La parte después de ":"

            // Convertir las partes a enteros si es necesario
            int hora = Integer.parseInt(horaStr);
            int minuto = Integer.parseInt(minutoStr);
            //System.out.println("Hora: " + hora);
            //System.out.println("Minuto: " + minuto);
            
            // Detener el reloj actual si ya está en funcionamiento
            if (reloj.isAlive()) {
                reloj.setRunning(false);
                try {
                    reloj.join(); // Esperar a que el hilo de reloj termine
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Crear un nuevo hilo de reloj con la hora y los minutos actualizados
            reloj = new Reloj(areaReloj);
            reloj.setHora(hora);
            reloj.setMinutos(minuto);
            reloj.start(); // Iniciar el nuevo hilo de reloj
            botonPararHora.setText("Parar");
        }
    }//GEN-LAST:event_botonPararHoraActionPerformed

    private void botonAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAvanzarActionPerformed
        
        String origen = (String) sigPosicion.getSelectedItem();
        String destino = (String) comboDestino.getSelectedItem();
        //String destino = nodoDestino.getText();
        
        recorrerViaje(origen, destino);
        
        generarGrafoRutas();
        generarArbolB();
        posActual.setText(origen);
        
        
        
    }//GEN-LAST:event_botonAvanzarActionPerformed

    private void generarGrafoPrincipal(){
        String dotFilePath = "grafoP.dot";
        
        String tipoDeViaje = (String) jcomboTipoViaje.getSelectedItem();
        if (tipoDeViaje.equalsIgnoreCase("Vehiculo")) {
            Graficas.generarArchivoDOT(dotFilePath, grafos);
        }else{
            Graficas.generarArchivoDOTNoDirigido(dotFilePath, grafos);
        }
        

        // Generar la imagen del grafo usando Graphviz
        String outputFormat = "grafoP.png"; // Puedes cambiar el formato de salida aquí
        
        Graficas.generarImagenGrafo(dotFilePath, outputFormat);
        
        try{
            ImageIcon originalIcon = new ImageIcon("grafoP.png");
            Image originalImage = originalIcon.getImage();

            // Obtener el tamaño del JLabel
            int labelWidth = etiquetaGrafoImagen.getWidth();
            int labelHeight = etiquetaGrafoImagen.getHeight();

            // Escalar la imagen para que coincida con el tamaño del JLabel
            Image scaledImage = originalImage.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);

            // Crear un ImageIcon con la imagen escalada
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            // Establecer el icono en el JLabel
            etiquetaGrafoImagen.setIcon(scaledIcon);
        }catch(Exception e){
            System.out.println(e);
        }

        
    }
    
    private void generarGrafoRutas(){
        String dotFilePath = "grafoRutas.dot";
         String tipoDeViaje = (String) jcomboTipoViaje.getSelectedItem();
        if (tipoDeViaje.equalsIgnoreCase("Vehiculo")) {
            Graficas.generarArchivoDOTRutasSeleccionadas(dotFilePath, grafos, todasLasRutas, (String) comboDestino.getSelectedItem());
        }else{
            Graficas.generarArchivoDOTRutasCaminando(dotFilePath, grafos, todasLasRutas, (String) comboDestino.getSelectedItem());
        }
        
        // Generar la imagen del grafo usando Graphviz
        String outputFormat = "grafoRutas.png"; // Puedes cambiar el formato de salida aquí
        Graficas.generarImagenGrafo(dotFilePath, outputFormat);
        
        try {
            String imagePath;
            File imageFile = new File(outputFormat);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDeRutas;
    private javax.swing.JTextField areaReloj;
    private javax.swing.JButton botonAvanzar;
    private javax.swing.JButton botonEmpezarViaje;
    private javax.swing.JButton botonPararHora;
    private javax.swing.JButton cargarRutas;
    private javax.swing.JButton cargarTrafico;
    private javax.swing.JComboBox<String> comboDestino;
    private javax.swing.JComboBox<String> comboOrigen;
    private javax.swing.JLabel etiquetaGrafoImagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> jcomboTipoViaje;
    private javax.swing.JTextField posActual;
    private javax.swing.JScrollPane scrollGrafo;
    private javax.swing.JComboBox<String> sigPosicion;
    // End of variables declaration//GEN-END:variables
}
