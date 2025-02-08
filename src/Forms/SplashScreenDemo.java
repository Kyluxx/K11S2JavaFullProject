/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Forms;

/**
 *
 * @author Rosita_Nesya
 */
/*
 * SplashScreenDemo.java
 *
 * Created on 14 Juni 2017, 13:42:40
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import CommForm.*;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

/**
 *
 * @author BENO JANGE
 */
public class SplashScreenDemo {

    SplashScreen screen;

    public SplashScreenDemo() {
        // menampilkan splash screen
        splashScreenInit();
        // melakukan proses untuk mensimulasikan program
        // sedang melakukan sesuatu yang banyak memakan waktu
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(200);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            // menampilkan progress bar
            screen.setProgress(i + "%", i);
        }
        // menghilangkan splash screen
        splashScreenDestruct();
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                new LoginForm().setVisible(true);
            }
        });
        // keluar dari program
        //System.exit(0);
    }

    private void splashScreenDestruct() {
        screen.setScreenVisible(false);
    }

    private void splashScreenInit() {
        //ImageIcon myImage = new ImageIcon("./000001.jpg"); --> Error example
        //ImageIcon myImage = new ImageIcon(getClass().getResource("./000001.jpg"));
        ImageIcon myImage = new ImageIcon(getClass().getResource("./thumbnail.png"));
        //ImageIcon myImage = new ImageIcon(getClass().getResource("./pngwing.com.png"));
        screen = new SplashScreen(myImage);
        screen.setLocationRelativeTo(null);
        screen.setProgressMax(100);
        screen.setScreenVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new SplashScreenDemo();
    }
}