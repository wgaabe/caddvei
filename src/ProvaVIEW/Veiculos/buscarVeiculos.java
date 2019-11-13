/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProvaVIEW.Veiculos;

import ProvaDAO.VeiculosDAO;
import ProvaMODEL.CadVeicMODEL;
import ProvaPOJO.VeiculosPOJO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LabNTE 9
 */
public class buscarVeiculos extends javax.swing.JFrame {

    /**
     * Creates new form buscarVeiculos
     */
    public buscarVeiculos() {
        initComponents();
    }
    
    public void limparTabela()
    {
        if(TTableBuscarVeiculos.getRowCount()>0)
        {
            for(int i=TTableBuscarVeiculos.getRowCount()-1; i>=0;i--)
            {
                ((DefaultTableModel) TTableBuscarVeiculos.getModel()).removeRow(0);
            }
        }
    }
    
    public void buscarveiculo()
    {

        VeiculosDAO vd = new VeiculosDAO();
        List list = vd.read(tplaca.getText());
        int num=TTableBuscarVeiculos.getSelectedRowCount();
        DefaultTableModel dtm = (DefaultTableModel)TTableBuscarVeiculos.getModel();
        limparTabela();
        

        for(int i = 0; i<list.size(); i++){
            VeiculosPOJO vp = (VeiculosPOJO)list.get(i);
            dtm.addRow(new Object[]{vp.getPlaca(), vp.getRenavan(), vp.getChassi(), vp.getMarca(), vp.getModelo(), vp.getCor(), });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tplaca = new javax.swing.JTextField();
        BBuscarVeiculo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TTableBuscarVeiculos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BAlterarVeiculo = new javax.swing.JButton();
        BExcluir = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tplaca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tplacaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tplacaMouseEntered(evt);
            }
        });
        tplaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tplacaActionPerformed(evt);
            }
        });

        BBuscarVeiculo.setText("Buscar");
        BBuscarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBuscarVeiculoActionPerformed(evt);
            }
        });

        TTableBuscarVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Placa", "Renavan", "Chassi", "Marca", "Modelo", "Cor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TTableBuscarVeiculos);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Buscar Veiculo");

        jLabel2.setText("Placa");

        BAlterarVeiculo.setText("Alterar");
        BAlterarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAlterarVeiculoActionPerformed(evt);
            }
        });

        BExcluir.setText("Excluir");
        BExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tplaca, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BBuscarVeiculo)
                        .addGap(26, 26, 26)
                        .addComponent(BExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BAlterarVeiculo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(131, 131, 131))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tplaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BAlterarVeiculo)
                    .addComponent(BBuscarVeiculo)
                    .addComponent(BExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tplacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tplacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tplacaActionPerformed

    private void tplacaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tplacaMouseEntered

     
        // TODO add your handling code here:
    }//GEN-LAST:event_tplacaMouseEntered

    private void tplacaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tplacaMouseClicked
       // TODO add your handling code here:
    }//GEN-LAST:event_tplacaMouseClicked

    private void BBuscarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBuscarVeiculoActionPerformed
      buscarveiculo();
    }//GEN-LAST:event_BBuscarVeiculoActionPerformed

    private void BAlterarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAlterarVeiculoActionPerformed
        
        String placa =""+TTableBuscarVeiculos.getValueAt(TTableBuscarVeiculos.getSelectedRow(), 0);
        alterarVeiculo av = new alterarVeiculo(placa, this);
        CadVeicMODEL cvm = new CadVeicMODEL();
        av.setVisible(true);
        limparTabela();
        buscarveiculo();
    }//GEN-LAST:event_BAlterarVeiculoActionPerformed

    private void BExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BExcluirActionPerformed
       if(TTableBuscarVeiculos.getSelectedRow()>=0){
            if(JOptionPane.showConfirmDialog(this, "Deseja realmente Excluir ?")==0){
                VeiculosDAO vd = new VeiculosDAO();
                vd.excluir_veiculo(""+(TTableBuscarVeiculos.getValueAt(TTableBuscarVeiculos.getSelectedRow(), 0 )));
                limparTabela();
                buscarveiculo();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um Produto");
        }
    }//GEN-LAST:event_BExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(buscarVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buscarVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buscarVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buscarVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new buscarVeiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAlterarVeiculo;
    private javax.swing.JButton BBuscarVeiculo;
    private javax.swing.JToggleButton BExcluir;
    private javax.swing.JTable TTableBuscarVeiculos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tplaca;
    // End of variables declaration//GEN-END:variables
}
