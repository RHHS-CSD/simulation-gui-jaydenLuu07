/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatastarter;

import utils.CardSwitcher;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JPanel;
import utils.ImageUtil;
import utils.Constants;

/**
 *
 * @author michael.roy-diclemen
 */
public class IntroPanel extends javax.swing.JPanel {
    BufferedImage img1;
    int x = 0;
    int y = 0;
    
        public static final String CARD_NAME = "intro";
    CardSwitcher switcher = null;
    /**
     * Creates new form IntroPanel
     */
    public IntroPanel(CardSwitcher p) {
        initComponents();
        setPreferredSize(new Dimension (Constants.WIDTH,Constants.HEIGHT));
        img1 = ImageUtil.loadAndResizeImage("ant2.jpg", Constants.WIDTH, Constants.HEIGHT);
        switcher = p;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img1 != null) {
            g.drawImage(img1, x, y, this);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GameButton = new javax.swing.JButton();
        infoButton = new javax.swing.JButton();

        GameButton.setText("Game");
        GameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GameButtonActionPerformed(evt);
            }
        });

        infoButton.setText("Info");
        infoButton.setToolTipText("");
        infoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(infoButton))
                    .addComponent(GameButton))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(GameButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(infoButton)
                .addContainerGap(110, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void GameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GameButtonActionPerformed
       switcher.switchToCard(GamePanel.CARD_NAME);
    }//GEN-LAST:event_GameButtonActionPerformed

    private void infoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoButtonActionPerformed
        switcher.switchToCard(InfoPanel.CARD_NAME);
    }//GEN-LAST:event_infoButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GameButton;
    private javax.swing.JButton infoButton;
    // End of variables declaration//GEN-END:variables
}
