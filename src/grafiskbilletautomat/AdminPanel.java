/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafiskbilletautomat;

/**
 *
 * @author Adam
 */
public class AdminPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminPanel
     */
    public AdminPanel() {
        initComponents();
        lblVoksenPris.setText(String.valueOf(billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.VOKSEN)));
        lblBørnePris.setText(String.valueOf(billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.BARN)));
        lblCykelPris.setText(String.valueOf(billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.CYKEL)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblVoksenPris = new javax.swing.JLabel();
        lblBørnePris = new javax.swing.JLabel();
        lblCykelPris = new javax.swing.JLabel();
        btnVoksenOp = new javax.swing.JButton();
        btnVoksenNed = new javax.swing.JButton();
        btnBarnOp = new javax.swing.JButton();
        btnCykelNed = new javax.swing.JButton();
        btnBarnNed = new javax.swing.JButton();
        btnCykelOp = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vis alt", "Byttepenge", "Byttepenge over 500kr", "Beløb", "Annullerede Billetter", "Tid", "Dato", "Voksen Billet", "Børne Billet", "Cykel Billet" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Automat Log");

        lblVoksenPris.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblVoksenPris.setText("jLabel2");

        lblBørnePris.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBørnePris.setText("jLabel3");

        lblCykelPris.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCykelPris.setText("jLabel4");

        btnVoksenOp.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnVoksenOp.setText("↑");
        btnVoksenOp.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnVoksenOpActionPerformed(evt);
            }
        });

        btnVoksenNed.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnVoksenNed.setText("↓");
        btnVoksenNed.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnVoksenNedActionPerformed(evt);
            }
        });

        btnBarnOp.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnBarnOp.setText("↑");
        btnBarnOp.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBarnOpActionPerformed(evt);
            }
        });

        btnCykelNed.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnCykelNed.setText("↓");
        btnCykelNed.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCykelNedActionPerformed(evt);
            }
        });

        btnBarnNed.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnBarnNed.setText("↓");
        btnBarnNed.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBarnNedActionPerformed(evt);
            }
        });

        btnCykelOp.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnCykelOp.setText("↑");
        btnCykelOp.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCykelOpActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Opsætning af priser");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Børne Billet");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Cykel Billet");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Voksen Billet");

        jList1.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, 0, 232, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVoksenOp, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVoksenPris))
                        .addComponent(btnVoksenNed, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnBarnOp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBørnePris)
                        .addComponent(btnBarnNed, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCykelPris)
                    .addComponent(btnCykelOp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCykelNed, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCykelOp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnVoksenOp)
                        .addComponent(btnBarnOp)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVoksenPris)
                    .addComponent(lblBørnePris)
                    .addComponent(lblCykelPris))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBarnNed)
                    .addComponent(btnCykelNed)
                    .addComponent(btnVoksenNed))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

  private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
      // TODO add your handling code here:
      switch (jComboBox1.getSelectedIndex()){
          case 0:
          
          break;
          case 1:
          
          break;
          case 2:
          
          break;
      } 
  }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnVoksenOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoksenOpActionPerformed
        double pris = billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.VOKSEN);
        billetAutomatKlasse.setBilletpris(billetKlasse.ticketType.VOKSEN, pris + 0.5);
        
        lblVoksenPris.setText(String.valueOf(billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.VOKSEN)));
    }//GEN-LAST:event_btnVoksenOpActionPerformed

    private void btnVoksenNedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoksenNedActionPerformed
        double pris = billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.VOKSEN);
        billetAutomatKlasse.setBilletpris(billetKlasse.ticketType.VOKSEN, pris - 0.5);
        
        lblVoksenPris.setText(String.valueOf(billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.VOKSEN)));
    }//GEN-LAST:event_btnVoksenNedActionPerformed

    private void btnBarnOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarnOpActionPerformed
        double pris = billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.BARN);
        billetAutomatKlasse.setBilletpris(billetKlasse.ticketType.BARN, pris + 0.5);
        
        lblBørnePris.setText(String.valueOf(billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.BARN)));
    }//GEN-LAST:event_btnBarnOpActionPerformed

    private void btnCykelNedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCykelNedActionPerformed
        double pris = billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.CYKEL);
        billetAutomatKlasse.setBilletpris(billetKlasse.ticketType.CYKEL, pris - 0.5);
        
        lblCykelPris.setText(String.valueOf(billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.CYKEL)));
    }//GEN-LAST:event_btnCykelNedActionPerformed

    private void btnBarnNedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarnNedActionPerformed
        double pris = billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.BARN);
        billetAutomatKlasse.setBilletpris(billetKlasse.ticketType.BARN, pris - 0.5);
        
        lblBørnePris.setText(String.valueOf(billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.BARN)));
    }//GEN-LAST:event_btnBarnNedActionPerformed

    private void btnCykelOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCykelOpActionPerformed
        double pris = billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.CYKEL);
        billetAutomatKlasse.setBilletpris(billetKlasse.ticketType.CYKEL, pris + 0.5);
        
        lblCykelPris.setText(String.valueOf(billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.CYKEL)));
    }//GEN-LAST:event_btnCykelOpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBarnNed;
    private javax.swing.JButton btnBarnOp;
    private javax.swing.JButton btnCykelNed;
    private javax.swing.JButton btnCykelOp;
    private javax.swing.JButton btnVoksenNed;
    private javax.swing.JButton btnVoksenOp;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBørnePris;
    private javax.swing.JLabel lblCykelPris;
    private javax.swing.JLabel lblVoksenPris;
    // End of variables declaration//GEN-END:variables
}
