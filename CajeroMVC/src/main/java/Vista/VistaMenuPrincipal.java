/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.Controlador;
import Modelo.IModelo;
import Modelo.TipoEvento;
import javax.swing.JPanel;

/**
 *
 * @author Sebastian Moreno
 */
public class VistaMenuPrincipal extends javax.swing.JFrame implements Observador {

    /**
     * Creates new form VistaMenuPrincipal
     */
    Controlador control;

    //Pantallas Sistema
    PantallaRetiro pantallaRetiro;

    public VistaMenuPrincipal(Controlador control) {
        this.control = control;
        this.setTitle("Banco de México (Caso de uso retirar)");
        this.setSize(1200, 1500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        initComponents();
    }

    @Override
    public void actualiza(IModelo modelo, TipoEvento evento) {
        switch (evento) {
            case INCIALIZAR_DATOS:
                cargarNombre(modelo);
                break;
            case INICIAR_TRANSACCION:
                pantallaRetiro = new PantallaRetiro(modelo,control);
                cambiarPantalla(pantallaRetiro);
                break;
            case CALCULOS_REALIZADOS:
                pantallaRetiro.mostrarDetalleRetiro();
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPrincipal = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        btnTransferir = new Vista.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        btnDepositar = new Vista.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        btnMiCuenta = new Vista.PanelRound();
        jLabel6 = new javax.swing.JLabel();
        btnRetirar = new Vista.PanelRound();
        lblRetirar = new javax.swing.JLabel();
        subHeader = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuPrincipal.setBackground(new java.awt.Color(16, 12, 203));
        menuPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Inter", 0, 60)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Banco de México");
        menuPrincipal.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1200, -1));

        btnTransferir.setBackground(new java.awt.Color(54, 80, 246));
        btnTransferir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnTransferir.setRoundBottomLeft(20);
        btnTransferir.setRoundBottomRight(20);
        btnTransferir.setRoundTopLeft(20);
        btnTransferir.setRoundTopRight(20);

        jLabel5.setFont(new java.awt.Font("Inter", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Transferir");
        jLabel5.setEnabled(false);

        javax.swing.GroupLayout btnTransferirLayout = new javax.swing.GroupLayout(btnTransferir);
        btnTransferir.setLayout(btnTransferirLayout);
        btnTransferirLayout.setHorizontalGroup(
            btnTransferirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTransferirLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnTransferirLayout.setVerticalGroup(
            btnTransferirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTransferirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuPrincipal.add(btnTransferir, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, 370, -1));

        btnDepositar.setBackground(new java.awt.Color(54, 80, 246));
        btnDepositar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnDepositar.setRoundBottomLeft(20);
        btnDepositar.setRoundBottomRight(20);
        btnDepositar.setRoundTopLeft(20);
        btnDepositar.setRoundTopRight(20);

        jLabel4.setFont(new java.awt.Font("Inter", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Depositar");
        jLabel4.setEnabled(false);

        javax.swing.GroupLayout btnDepositarLayout = new javax.swing.GroupLayout(btnDepositar);
        btnDepositar.setLayout(btnDepositarLayout);
        btnDepositarLayout.setHorizontalGroup(
            btnDepositarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnDepositarLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnDepositarLayout.setVerticalGroup(
            btnDepositarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDepositarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuPrincipal.add(btnDepositar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 370, -1));

        btnMiCuenta.setBackground(new java.awt.Color(54, 80, 246));
        btnMiCuenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnMiCuenta.setRoundBottomLeft(20);
        btnMiCuenta.setRoundBottomRight(20);
        btnMiCuenta.setRoundTopLeft(20);
        btnMiCuenta.setRoundTopRight(20);

        jLabel6.setFont(new java.awt.Font("Inter", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Mi cuenta");
        jLabel6.setEnabled(false);

        javax.swing.GroupLayout btnMiCuentaLayout = new javax.swing.GroupLayout(btnMiCuenta);
        btnMiCuenta.setLayout(btnMiCuentaLayout);
        btnMiCuentaLayout.setHorizontalGroup(
            btnMiCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnMiCuentaLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnMiCuentaLayout.setVerticalGroup(
            btnMiCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnMiCuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuPrincipal.add(btnMiCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 530, -1, -1));

        btnRetirar.setBackground(new java.awt.Color(54, 80, 246));
        btnRetirar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnRetirar.setRoundBottomLeft(20);
        btnRetirar.setRoundBottomRight(20);
        btnRetirar.setRoundTopLeft(20);
        btnRetirar.setRoundTopRight(20);

        lblRetirar.setFont(new java.awt.Font("Inter", 0, 24)); // NOI18N
        lblRetirar.setForeground(new java.awt.Color(255, 255, 255));
        lblRetirar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRetirar.setText("Retirar");
        lblRetirar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRetirar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRetirarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnRetirarLayout = new javax.swing.GroupLayout(btnRetirar);
        btnRetirar.setLayout(btnRetirarLayout);
        btnRetirarLayout.setHorizontalGroup(
            btnRetirarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRetirarLayout.createSequentialGroup()
                .addComponent(lblRetirar, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnRetirarLayout.setVerticalGroup(
            btnRetirarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRetirarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRetirar, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuPrincipal.add(btnRetirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, 370, -1));

        subHeader.setFont(new java.awt.Font("Inter", 0, 28)); // NOI18N
        subHeader.setForeground(new java.awt.Color(255, 255, 255));
        subHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subHeader.setText("¡Bienvenido nombreCliente!");
        menuPrincipal.add(subHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 1200, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblRetirarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRetirarMouseClicked
        control.iniciarTransaccion();
    }//GEN-LAST:event_lblRetirarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.PanelRound btnDepositar;
    private Vista.PanelRound btnMiCuenta;
    private Vista.PanelRound btnRetirar;
    private Vista.PanelRound btnTransferir;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblRetirar;
    private javax.swing.JPanel menuPrincipal;
    private javax.swing.JLabel subHeader;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

    public void cargarNombre(IModelo modelo) {
        subHeader.setText("¡Bienvenido " + modelo.getCliente().getNombres() + "!");
        revalidate();
        repaint();
    }

    private void cambiarPantalla(JPanel nuevaPantalla) {
        getContentPane().removeAll();
        getContentPane().add(nuevaPantalla);
        nuevaPantalla.setSize(this.getSize());
        nuevaPantalla.setVisible(true);

        // Actualizar interfaz
        getContentPane().revalidate();
        getContentPane().repaint();
    }
}
