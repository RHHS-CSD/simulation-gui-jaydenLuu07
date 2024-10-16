/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatastarter;

import utils.CardSwitcher;
import java.awt.CardLayout;
import java.awt.Dimension;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JPanel;
import utils.Constants;

/**
 *
 * @author michael.roy-diclemen
 */
public class InfoPanel extends javax.swing.JPanel {
    public static final String CARD_NAME = "info";
    CardSwitcher switcher = null;
    /**
     * Creates new form IntroPanel
     */
    
    public InfoPanel(CardSwitcher p) {
        initComponents();
        setPreferredSize(new Dimension(Constants.WIDTH,Constants.HEIGHT));
        switcher = p;
        jTextArea1.setText("How to Play:  Toggle the rows and columns sliders to adjust the grid size \n(it was a choice to not have it always update with sliders, it messed with consistency things).\n You may input any number of ants (with a max of 100) and give each of them any amount of max health.\n You may choose to add sugar to the game (one for each ant), which gives ants a winning objective and/or a boot to the game, which will kill ants (chooses a tile to squash in a 3x3 area around a random ant).\nYou an also not select either of these options, and just see the interesting patterns of the ants.\nThis program can run automatically or manually (using the checkbox and the button respectivley).\n  Speed of the program can be adjusted with its slider.\nOnce your row, columns, number of ants, number of health, sugar, and boots are selected, press start/reset to begin.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(backButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton)
                .addGap(163, 163, 163))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        switcher.switchToCard(IntroPanel.CARD_NAME);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
