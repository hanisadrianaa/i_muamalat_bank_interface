/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  projectipt;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TandC extends JFrame {

    JPanel pane5, pane51, pane52, pane5a, pane5b, pane5c, pane5d, pane5e, pane6;
    JButton b5;
    JRadioButton r1, r2;

    public TandC() {

        setTitle("Bank Muamalat Malaysia Berhad");
        setSize(1366, 768);
        setLayout(null);
        setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("/Resources/white.jpg"))));
        setLayout(new GridLayout(3, 1));
        setVisible(true);
        Container pane = getContentPane();
        setContentPane(pane);
        FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
        pane.setLayout(flow);

        pane5 = new JPanel();
        pane5.setPreferredSize(new Dimension(1000, 500));
        pane5.setBackground(Color.WHITE);

        pane51 = new JPanel();

        ImageIcon icon = new ImageIcon(this.getClass().getResource("/Resources/test.png"));
        JLabel Label = new JLabel(icon, JLabel.CENTER);
        Label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                MainPage projectipt = new MainPage();
                projectipt.setSize(1366, 768);
                projectipt.setVisible(true);
                projectipt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });
        pane51.add(Label);

        pane52 = new JPanel();
        pane52.setBackground(Color.WHITE);

        JRadioButton r1 = new JRadioButton("Accept");
        /* r1.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
         if(e.getStateChange() == ItemEvent.SELECTED){
         b5.setVisible(false);
         }
         else if (e.getStateChange() == ItemEvent.DESELECTED) {
         b5.setVisible(true);
         }
         }
         });*/
        JRadioButton r2 = new JRadioButton("Decline");
        r2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "www.i-muamalat.com.my says \n"
                        + "Please accept the Terms & Conditions to proceed with the registration.");
            }
        });

        r1.setPreferredSize(new Dimension(500, 25));
        r2.setPreferredSize(new Dimension(300, 25));
        pane52.add(r1);
        pane52.add(r2);

        pane5b = new JPanel();
        pane5b.setBackground(new Color(0, 0, 0, 0));

        b5 = new JButton("Next");
        b5.setForeground(Color.ORANGE);
        b5.setPreferredSize(new Dimension(300, 30));
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Registration();
                dispose();

            }
        }
        );
        pane5b.add(b5);

        pane5.add(pane51);
        pane5.add(pane52);
        pane5.add(pane5b);

        add(pane5);
        //add(pane51);

    }

    public static void main(String[] args) {
        TandC projectipt = new TandC();
        projectipt.setSize(2000, 2000);
        projectipt.setVisible(true);
        projectipt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
