
package com.mycompany.programa2futoshiki;

import static com.mycompany.programa2futoshiki.GUIFutoshiki.configFutoshiki; //por los datos

//Documentar en PDF Timer
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.SwingUtilities;


import javax.swing.JFrame;

/**
 *
 * @author Kendall Ariel Rojas Cartin
 */

public class GUIJugar extends javax.swing.JFrame {
    
    Configuracion configJuego = configFutoshiki;
    Timer timerGlobal = new Timer(); //para guardar el timer actual
    
    public GUIJugar() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoPanel = new javax.swing.JPanel();
        tituloPanel = new javax.swing.JPanel();
        tituloLabel = new javax.swing.JLabel();
        numerosPanel = new javax.swing.JPanel();
        numero1Button = new javax.swing.JButton();
        numero2Button = new javax.swing.JButton();
        numero3Button = new javax.swing.JButton();
        numero4Button = new javax.swing.JButton();
        numero5Button = new javax.swing.JButton();
        nivelLabel = new javax.swing.JLabel();
        nombreJugadorPanel = new javax.swing.JPanel();
        nombreJugadorLabel = new javax.swing.JLabel();
        nombreJugadorField = new javax.swing.JTextField();
        juegoPanel = new javax.swing.JPanel();
        guardarJuegoButton = new javax.swing.JButton();
        borrarJuegoButton = new javax.swing.JButton();
        borrarJugadaButton = new javax.swing.JButton();
        rehacerJugadaButton = new javax.swing.JButton();
        terminarJuegoButton = new javax.swing.JButton();
        cargarJuegoButton = new javax.swing.JButton();
        relojPanel = new javax.swing.JPanel();
        tiempoSegundosLabel = new javax.swing.JLabel();
        segundosLabel = new javax.swing.JLabel();
        minutosLabel = new javax.swing.JLabel();
        horasLabel = new javax.swing.JLabel();
        tiempoHorasLabel = new javax.swing.JLabel();
        tiempoMinutosLabel = new javax.swing.JLabel();
        iniciarJuegoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondoPanel.setBackground(new java.awt.Color(255, 255, 255));

        tituloPanel.setBackground(new java.awt.Color(204, 0, 51));

        tituloLabel.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        tituloLabel.setForeground(new java.awt.Color(255, 255, 255));
        tituloLabel.setText("FUTOSHIKI");

        javax.swing.GroupLayout tituloPanelLayout = new javax.swing.GroupLayout(tituloPanel);
        tituloPanel.setLayout(tituloPanelLayout);
        tituloPanelLayout.setHorizontalGroup(
            tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(tituloLabel)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        tituloPanelLayout.setVerticalGroup(
            tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        numerosPanel.setBackground(new java.awt.Color(255, 255, 255));

        numero1Button.setBackground(new java.awt.Color(255, 255, 255));
        numero1Button.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        numero1Button.setForeground(new java.awt.Color(0, 0, 0));
        numero1Button.setText("1");

        numero2Button.setBackground(new java.awt.Color(255, 255, 255));
        numero2Button.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        numero2Button.setForeground(new java.awt.Color(0, 0, 0));
        numero2Button.setText("2");

        numero3Button.setBackground(new java.awt.Color(255, 255, 255));
        numero3Button.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        numero3Button.setForeground(new java.awt.Color(0, 0, 0));
        numero3Button.setText("3");

        numero4Button.setBackground(new java.awt.Color(255, 255, 255));
        numero4Button.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        numero4Button.setForeground(new java.awt.Color(0, 0, 0));
        numero4Button.setText("4");

        numero5Button.setBackground(new java.awt.Color(255, 255, 255));
        numero5Button.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        numero5Button.setForeground(new java.awt.Color(0, 0, 0));
        numero5Button.setText("5");

        javax.swing.GroupLayout numerosPanelLayout = new javax.swing.GroupLayout(numerosPanel);
        numerosPanel.setLayout(numerosPanelLayout);
        numerosPanelLayout.setHorizontalGroup(
            numerosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(numero1Button)
            .addComponent(numero2Button)
            .addComponent(numero3Button)
            .addComponent(numero4Button)
            .addComponent(numero5Button)
        );
        numerosPanelLayout.setVerticalGroup(
            numerosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numerosPanelLayout.createSequentialGroup()
                .addComponent(numero1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numero2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numero3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numero4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numero5Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        nivelLabel.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        nivelLabel.setForeground(new java.awt.Color(0, 0, 0));
        nivelLabel.setText("Nivel: ");

        nombreJugadorPanel.setBackground(new java.awt.Color(255, 255, 255));

        nombreJugadorLabel.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        nombreJugadorLabel.setForeground(new java.awt.Color(0, 0, 0));
        nombreJugadorLabel.setText("Nombre del jugador: ");

        nombreJugadorField.setEditable(false);
        nombreJugadorField.setBackground(new java.awt.Color(255, 255, 255));
        nombreJugadorField.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        nombreJugadorField.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout juegoPanelLayout = new javax.swing.GroupLayout(juegoPanel);
        juegoPanel.setLayout(juegoPanelLayout);
        juegoPanelLayout.setHorizontalGroup(
            juegoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
        );
        juegoPanelLayout.setVerticalGroup(
            juegoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout nombreJugadorPanelLayout = new javax.swing.GroupLayout(nombreJugadorPanel);
        nombreJugadorPanel.setLayout(nombreJugadorPanelLayout);
        nombreJugadorPanelLayout.setHorizontalGroup(
            nombreJugadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nombreJugadorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nombreJugadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nombreJugadorPanelLayout.createSequentialGroup()
                        .addComponent(nombreJugadorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreJugadorField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nombreJugadorPanelLayout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addComponent(juegoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        nombreJugadorPanelLayout.setVerticalGroup(
            nombreJugadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nombreJugadorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nombreJugadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreJugadorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombreJugadorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(juegoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        guardarJuegoButton.setBackground(new java.awt.Color(0, 153, 0));
        guardarJuegoButton.setFont(new java.awt.Font("Sitka Text", 1, 13)); // NOI18N
        guardarJuegoButton.setForeground(new java.awt.Color(0, 0, 0));
        guardarJuegoButton.setText("Guardar Juego");

        borrarJuegoButton.setBackground(new java.awt.Color(51, 204, 255));
        borrarJuegoButton.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        borrarJuegoButton.setForeground(new java.awt.Color(0, 0, 0));
        borrarJuegoButton.setText("Borrar Juego");

        borrarJugadaButton.setBackground(new java.awt.Color(0, 204, 204));
        borrarJugadaButton.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        borrarJugadaButton.setForeground(new java.awt.Color(0, 0, 0));
        borrarJugadaButton.setText("Borrar Jugada");

        rehacerJugadaButton.setBackground(new java.awt.Color(255, 204, 153));
        rehacerJugadaButton.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        rehacerJugadaButton.setForeground(new java.awt.Color(0, 0, 0));
        rehacerJugadaButton.setText("Rehacer Jugada");

        terminarJuegoButton.setBackground(new java.awt.Color(255, 255, 153));
        terminarJuegoButton.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        terminarJuegoButton.setForeground(new java.awt.Color(0, 0, 0));
        terminarJuegoButton.setText("Terminar Juego");
        terminarJuegoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarJuegoButtonActionPerformed(evt);
            }
        });

        cargarJuegoButton.setBackground(new java.awt.Color(204, 102, 0));
        cargarJuegoButton.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        cargarJuegoButton.setForeground(new java.awt.Color(0, 0, 0));
        cargarJuegoButton.setText("Cargar Juego");

        relojPanel.setBackground(new java.awt.Color(255, 255, 255));

        tiempoSegundosLabel.setBackground(new java.awt.Color(255, 255, 255));
        tiempoSegundosLabel.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        tiempoSegundosLabel.setForeground(new java.awt.Color(0, 0, 0));
        tiempoSegundosLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tiempoSegundosLabel.setText("00");
        tiempoSegundosLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        segundosLabel.setBackground(new java.awt.Color(255, 255, 255));
        segundosLabel.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        segundosLabel.setForeground(new java.awt.Color(0, 0, 0));
        segundosLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        segundosLabel.setText("Segundos");
        segundosLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        minutosLabel.setBackground(new java.awt.Color(255, 255, 255));
        minutosLabel.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        minutosLabel.setForeground(new java.awt.Color(0, 0, 0));
        minutosLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minutosLabel.setText("Minutos");
        minutosLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        horasLabel.setBackground(new java.awt.Color(255, 255, 255));
        horasLabel.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        horasLabel.setForeground(new java.awt.Color(0, 0, 0));
        horasLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        horasLabel.setText("Horas");
        horasLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tiempoHorasLabel.setBackground(new java.awt.Color(255, 255, 255));
        tiempoHorasLabel.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        tiempoHorasLabel.setForeground(new java.awt.Color(0, 0, 0));
        tiempoHorasLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tiempoHorasLabel.setText("00");
        tiempoHorasLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tiempoMinutosLabel.setBackground(new java.awt.Color(255, 255, 255));
        tiempoMinutosLabel.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        tiempoMinutosLabel.setForeground(new java.awt.Color(0, 0, 0));
        tiempoMinutosLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tiempoMinutosLabel.setText("00");
        tiempoMinutosLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout relojPanelLayout = new javax.swing.GroupLayout(relojPanel);
        relojPanel.setLayout(relojPanelLayout);
        relojPanelLayout.setHorizontalGroup(
            relojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(relojPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(relojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(relojPanelLayout.createSequentialGroup()
                        .addComponent(horasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minutosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(segundosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, relojPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tiempoHorasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tiempoMinutosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tiempoSegundosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        relojPanelLayout.setVerticalGroup(
            relojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(relojPanelLayout.createSequentialGroup()
                .addGroup(relojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(segundosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minutosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(horasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(relojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(relojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tiempoMinutosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                        .addComponent(tiempoHorasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                    .addComponent(tiempoSegundosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        iniciarJuegoButton.setBackground(new java.awt.Color(255, 0, 51));
        iniciarJuegoButton.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        iniciarJuegoButton.setForeground(new java.awt.Color(0, 0, 0));
        iniciarJuegoButton.setText("Iniciar Juego");
        iniciarJuegoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarJuegoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondoPanelLayout = new javax.swing.GroupLayout(fondoPanel);
        fondoPanel.setLayout(fondoPanelLayout);
        fondoPanelLayout.setHorizontalGroup(
            fondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoPanelLayout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(nivelLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(fondoPanelLayout.createSequentialGroup()
                .addGroup(fondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(fondoPanelLayout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(tituloPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, fondoPanelLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(iniciarJuegoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(fondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoPanelLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(relojPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(fondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rehacerJugadaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(borrarJugadaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(fondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(borrarJuegoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(terminarJuegoButton))
                                .addGap(12, 12, 12)
                                .addGroup(fondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cargarJuegoButton)
                                    .addComponent(guardarJuegoButton)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoPanelLayout.createSequentialGroup()
                                .addComponent(nombreJugadorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(numerosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        fondoPanelLayout.setVerticalGroup(
            fondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nivelLabel)
                .addGroup(fondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreJugadorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(fondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoPanelLayout.createSequentialGroup()
                                .addGroup(fondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(relojPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(fondoPanelLayout.createSequentialGroup()
                                        .addGroup(fondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(guardarJuegoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(borrarJuegoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(borrarJugadaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(fondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rehacerJugadaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(terminarJuegoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cargarJuegoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoPanelLayout.createSequentialGroup()
                                .addComponent(iniciarJuegoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))))
                    .addGroup(fondoPanelLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(numerosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarJuegoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarJuegoButtonActionPerformed
        temporizador();
    }//GEN-LAST:event_iniciarJuegoButtonActionPerformed

    private void terminarJuegoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarJuegoButtonActionPerformed
        cancelarTimer(timerGlobal);
    }//GEN-LAST:event_terminarJuegoButtonActionPerformed

    public static void setNombre(){
        nombreJugadorField.setText(GUIFutoshiki.getNombre());
    }
    
    public static void setNivel(){
        nivelLabel.setText(nivelLabel.getText() + " " + configFutoshiki.getNivel());
    }
    
    public void temporizador(){
        Timer timer = new Timer();
        TimerTask taskCronometro = new TimerTask(){
            int hora = configFutoshiki.getTemporizadorHora();
            int minuto = configFutoshiki.getTemporizadorMinuto();
            int segundo = configFutoshiki.getTemporizadorSegundo();
            
            public void run() { //correr la tarea o task

                if (segundo > 0){
                    segundo -= 1;
                }
                
                else if (segundo == 0 ) {
                    if (minuto != 0){
                        minuto -= 1;
                    }
                    segundo = 59;
                }
                
                if (segundo == 0 && minuto == 0 && hora!=0) {
                        hora -= 1;
                        minuto = 59;
                        segundo = 59;
                }
                
                if (hora == 0 && minuto == 0 && segundo == 0){
                    timer.cancel();
                }
                
                SwingUtilities.invokeLater(new Runnable() { //para actualizar el GUI desde otro hilo digamos 
                public void run() {
                    tiempoHorasLabel.setText(String.valueOf(hora));
                    tiempoMinutosLabel.setText(String.valueOf(minuto));
                    tiempoSegundosLabel.setText(String.valueOf(segundo));
                }
                });
            };
        };
        timer.scheduleAtFixedRate(taskCronometro, 0, 1000); //sin delay y actualizar cada 1000ms que son 1 segundo
        timerGlobal = timer;
    }
    
    public void cronometro(){ 
        Timer timer = new Timer();
        TimerTask taskCronometro = new TimerTask(){
            int hora = 0;
            int minuto = 0;
            int segundo = 0;
            public void run() { //correr la tarea o task
                
                segundo += 1;
                if (segundo == 60) {
                    segundo = 0;
                    minuto += 1;
                }
                if (minuto == 60) {
                    minuto = 0;
                    hora += 1;
                }
                
                SwingUtilities.invokeLater(new Runnable() { //para actualizar el GUI desde otro hilo digamos 
                public void run() {
                    tiempoHorasLabel.setText(String.valueOf(hora));
                    tiempoMinutosLabel.setText(String.valueOf(minuto));
                    tiempoSegundosLabel.setText(String.valueOf(segundo));
                }
                });
            };
        };
        timer.scheduleAtFixedRate(taskCronometro, 0, 1000); //sin delay y actualizar cada 1000ms que son 1 segundo
        timerGlobal = timer;
    }
    
    public void cancelarTimer(Timer timer){
        timer.cancel(); //termina el timer
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
            java.util.logging.Logger.getLogger(GUIJugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIJugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIJugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIJugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIJugar juego = new GUIJugar();
                juego.setVisible(true);
                juego.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //para que no se cierre todo al cerrar esta
                setNombre();
                setNivel();
                System.out.println(Configuracion.cargarConfiguracionXML().toStringConfiguracion());
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrarJuegoButton;
    private javax.swing.JButton borrarJugadaButton;
    private javax.swing.JButton cargarJuegoButton;
    private javax.swing.JPanel fondoPanel;
    private javax.swing.JButton guardarJuegoButton;
    private javax.swing.JLabel horasLabel;
    private javax.swing.JButton iniciarJuegoButton;
    private javax.swing.JPanel juegoPanel;
    private javax.swing.JLabel minutosLabel;
    private static javax.swing.JLabel nivelLabel;
    private static javax.swing.JTextField nombreJugadorField;
    private javax.swing.JLabel nombreJugadorLabel;
    private javax.swing.JPanel nombreJugadorPanel;
    private javax.swing.JButton numero1Button;
    private javax.swing.JButton numero2Button;
    private javax.swing.JButton numero3Button;
    private javax.swing.JButton numero4Button;
    private javax.swing.JButton numero5Button;
    private javax.swing.JPanel numerosPanel;
    private javax.swing.JButton rehacerJugadaButton;
    private javax.swing.JPanel relojPanel;
    private javax.swing.JLabel segundosLabel;
    private javax.swing.JButton terminarJuegoButton;
    private javax.swing.JLabel tiempoHorasLabel;
    private javax.swing.JLabel tiempoMinutosLabel;
    private javax.swing.JLabel tiempoSegundosLabel;
    private javax.swing.JLabel tituloLabel;
    private javax.swing.JPanel tituloPanel;
    // End of variables declaration//GEN-END:variables
}
