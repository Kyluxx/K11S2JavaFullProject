/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Forms;

/*
 * SplashScreen.java
 *
 * Created on 02 February 2025, 11:20:21 PM
 *
 * @Kyluxx
 */


import CommForm.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

/**
 *
 * @author BENO JANGE
 */
public class SplashScreen extends JWindow {

    BorderLayout borderLayout1 = new BorderLayout();
    JLabel imageLabel = new JLabel();
    JPanel southPanel = new JPanel();
    FlowLayout southPanelFlowLayout = new FlowLayout();
    JProgressBar progressBar = new JProgressBar();
    ImageIcon imageIcon;

    public SplashScreen(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
        try {
            initComponents();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void initComponents() throws Exception {
        imageLabel.setIcon(imageIcon);
        this.getContentPane().setLayout(borderLayout1);
        southPanel.setLayout(southPanelFlowLayout);
        southPanel.setBackground(Color.BLACK);
        this.getContentPane().add(imageLabel, BorderLayout.CENTER);
        this.getContentPane().add(southPanel, BorderLayout.SOUTH);
        southPanel.add(progressBar, null);
        this.pack();
    }

    public void setProgressMax(int maxProgress) {
        progressBar.setMaximum(maxProgress);
    }

    public void setProgress(String message, int progress) {
        final int theProgress = progress;
        final String theMessage = message;
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                progressBar.setValue(theProgress);
                setMessage(theMessage);
            }
        });
    }

    public void setScreenVisible(boolean b) {
        final boolean boo = b;
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(boo);
            }
        });
    }
    
    public void setMessage (String message) {
        if (message == null) {
            message = "";
            progressBar.setStringPainted(false);
        } else {
            progressBar.setStringPainted(true);
        }
        progressBar.setString(message);
    }
}