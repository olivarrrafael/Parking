/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingSoft;

/**
 *
 * @author alumno
 */
public class Inicio extends javax.swing.JPanel {

   IngresarVehiculo panelIngresarVehiculo;
   RetirarVehiculo panelRetirarVehiculo;
   PanelListarVehiculos panelListarVehiculos;
    public Inicio() {
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

        jLabel1 = new javax.swing.JLabel();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();
        button5 = new java.awt.Button();

        setBackground(new java.awt.Color(153, 153, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("ParkingSoft");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 84, 161, 46));

        button2.setBackground(new java.awt.Color(0, 0, 204));
        button2.setLabel("Retirar Vehiculo");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 233, 105, 63));

        button3.setBackground(new java.awt.Color(0, 0, 204));
        button3.setLabel("Listar Vehiculos");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 365, 105, 63));

        button4.setBackground(new java.awt.Color(0, 0, 204));
        button4.setLabel("Salir");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 365, 105, 63));

        button5.setBackground(new java.awt.Color(0, 0, 204));
        button5.setLabel("Igresar Vehiculo");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 233, -1, 63));
    }// </editor-fold>//GEN-END:initComponents

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button4ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
      panelIngresarVehiculo.setVisible(true);
      
    }//GEN-LAST:event_button5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private java.awt.Button button5;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}