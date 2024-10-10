/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatastarter;

import java.awt.Color;
import java.awt.Dimension;
import utils.CardSwitcher;
import utils.ImageUtil;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import utils.Constants;
import automatastarter.LangtonsAnt;
import java.util.HashSet;

/**
 *
 * @author michael.roy-diclemen
 */
public class GamePanel extends javax.swing.JPanel implements MouseListener {
    BufferedImage img2;
    LangtonsAnt l = new LangtonsAnt();
    
    public static final String CARD_NAME = "game";

    CardSwitcher switcher; // This is the parent panel
    Timer animTimer;
    
    //Variables for grid
    int rows = Constants.MINROW;
    int columns = Constants.MINCOLUMN;
    
    //Variables for ants
    int antNumber;
    int maxAntHealth;
    int[] antHealth;
    
    //variables to control your animation elements
    int x = 0;
    int y = 10;
    int xdir = 5;
    int lineX = 0;

    /**
     * Creates new form GamePanel
     */
    public GamePanel(CardSwitcher p) {
        initComponents();
        setPreferredSize(new Dimension(Constants.WIDTH,Constants.HEIGHT));
        l.makeGrid(0);

        this.setFocusable(true);

        // tell the program we want to listen to the mouse
        addMouseListener(this);
        //tells us the panel that controls this one
        switcher = p;
        //create and start a Timer for animation
        animTimer = new Timer(10, new AnimTimerTick());
        animTimer.start();

    }

    public void paintComponent(Graphics g) {
        if(jCheckBox1.isSelected()==true){
            if(antNumber!=0){
                l.turnAnts();
                l.flipColour();
                l.moveAnts();
            }
        }
        super.paintComponent(g);
        l.printGrid(g);
        img2 = ImageUtil.loadAndResizeImage("movingAnt.png", l.cellSize, l.cellSize);
        for(int i=0;i<antNumber;i++){
            if (img2!=null){
                g.drawImage(img2, l.antsRow[i]*l.cellSize, l.antsColumn[i]*l.cellSize, this);
            }
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

        jButton5 = new javax.swing.JButton();
        rowSlider = new javax.swing.JSlider();
        columnSlider = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton5.setText("Next Cycle");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        rowSlider.setMinimum(3);
        rowSlider.setPaintLabels(true);
        rowSlider.setToolTipText("");
        rowSlider.setValue(3);
        rowSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rowSliderStateChanged(evt);
            }
        });

        columnSlider.setMinimum(3);
        columnSlider.setPaintLabels(true);
        columnSlider.setValue(3);
        columnSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                columnSliderStateChanged(evt);
            }
        });

        jLabel1.setText("Rows");

        jLabel2.setText("Columns");

        jCheckBox1.setText("Automatic Simulation");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jTextField1.setText("Number of Ants");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setText("Start/Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField2.setText("Number of Health");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jCheckBox2.setText("Add Boot");

        jCheckBox3.setText("Add Sugar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(583, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(columnSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rowSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton1))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(rowSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(columnSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox2)
                .addGap(12, 12, 12)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addContainerGap(228, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        lineX = 0;
    }//GEN-LAST:event_formComponentShown

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        if(antNumber!=0){
            l.turnAnts();
            l.flipColour();
            l.moveAnts();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void rowSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rowSliderStateChanged
        // TODO add your handling code here:
        rows = rowSlider.getValue();
        l.setRows(rows);
        l.makeGrid(0);
    }//GEN-LAST:event_rowSliderStateChanged

    private void columnSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_columnSliderStateChanged
        // TODO add your handling code here:
        columns = columnSlider.getValue();
        l.setColumns(columns);
        l.makeGrid(0);
    }//GEN-LAST:event_columnSliderStateChanged

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String text = jTextField1.getText();
        antNumber = Integer.parseInt(text);
        text = jTextField2.getText();
        maxAntHealth = Integer.parseInt(text);
        l.makeGrid(0);
        if(jCheckBox2.isSelected()==true){
            l.setNeedsBoot(true);
        }
        else{
            l.setNeedsBoot(false);
        }
        if(jCheckBox3.isSelected()==true){
            l.setNeedsSugar(true);
        }
        else{
            l.setNeedsSugar(false);
        }
        l.setAntNumber(antNumber);
        l.setMaxAntHealth(maxAntHealth);
        l.setSugar();
        l.antStart();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        char c  = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        String text = jTextField1.getText();
        antNumber = Integer.parseInt(text);
        text = jTextField2.getText();
        maxAntHealth = Integer.parseInt(text);
        l.setAntNumber(antNumber);
        l.setMaxAntHealth(maxAntHealth);
        l.setSugar();
        l.antStart();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        char c  = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider columnSlider;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JSlider rowSlider;
    // End of variables declaration//GEN-END:variables

    /**
     * This event captures a click which is defined as pressing and releasing in
     * the same area
     *
     * @param me
     */
    public void mouseClicked(MouseEvent me) {
        
    }

    /**
     * When the mountain is pressed
     *
     * @param me
     */
    public void mousePressed(MouseEvent me) {
        
    }

    /**
     * When the mouse button is released
     *
     * @param me
     */
    public void mouseReleased(MouseEvent me) {
        
    }

    /**
     * When the mouse enters the area
     *
     * @param me
     */
    public void mouseEntered(MouseEvent me) {
        
    }

    /**
     * When the mouse exits the panel
     *
     * @param me
     */
    public void mouseExited(MouseEvent me) {
        
    }

    /**
     * Everything inside here happens when you click on a captured key.
     */
    private class Move extends AbstractAction {

        String key;

        public Move(String akey) {
            key = akey;
        }

        public void actionPerformed(ActionEvent ae) {
            // here you decide what you want to happen if a particular key is pressed
            System.out.println("llll" + key);
            switch(key){
                case "d": x+=2; break;
                case "x": animTimer.stop(); switcher.switchToCard(EndPanel.CARD_NAME); break;
            }
            if (key.equals("d")) {
                x = x + 2;
            }
            
        }

    }

    /**
     * Everything inside this actionPerformed will happen every time the
     * animation timer clicks.
     */
    private class AnimTimerTick implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            //the stuff we want to change every clock tick
            lineX++;
            //force redraw
            repaint();
        }
    }
}
