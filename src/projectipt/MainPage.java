/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectipt;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MainPage extends JFrame {

    JPanel pane1, pane2, pane2a, pane2b, pane2b1, pane2b2, pane2b3, pane2b4, pane2b5, pane2b6, pane2b7,
            pane2b8, pane2b9, pane2b21, pane3;
    JLabel Label, username, password,pass, reset, announcement, update, mobile, security,
            is;
    JTextField tf1;
    JPasswordField tf2;
    JButton b1, b2, b3;
    Icon texticon;

    public MainPage() {

        setTitle("Bank Muamalat Malaysia Berhad");
        setSize(1366, 768);
        setLayout(null);
        setLayout(new GridLayout(3, 1));
        setVisible(true);
        Container pane = getContentPane();
        setContentPane(pane);
        FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
        pane.setLayout(flow);

        pane1 = new JPanel();
        pane1.setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/Resources/mainpage.png"));
        JLabel Label = new JLabel(icon, JLabel.CENTER);
        pane1.add(Label);

        pane2 = new JPanel();
        pane2.setBackground(Color.WHITE);
        pane2.setPreferredSize(new Dimension(2000, 570));
        pane2.setLayout(new FlowLayout());

        pane2a = new JPanel();
        pane2a.setPreferredSize(new Dimension(800, 1000));

        ImageIcon icon1 = new ImageIcon(this.getClass().getResource("/Resources/pane2a.png"));
        JLabel Label1 = new JLabel(icon1, JLabel.CENTER);
        pane2a.add(Label1);

        pane2b = new JPanel();
        pane2b.setPreferredSize(new Dimension(600, 1000));
        pane2b.setBackground(Color.WHITE);
        //pane2b.setLayout(new GridLayout(16, 1));

        pane2b1 = new JPanel();
        pane2b1.setBackground(new Color(0, 0, 0, 0));

        ImageIcon icon2 = new ImageIcon(this.getClass().getResource("/Resources/imua.png"));
        JLabel Label2 = new JLabel(icon2, JLabel.CENTER);
        pane2b1.add(Label2);

        pane2b2 = new JPanel();
        pane2b2.setBackground(new Color(0, 0, 0, 0));

        username = new JLabel("Username");
        username.setPreferredSize(new Dimension(200, 10));
        username.setForeground(Color.BLACK);
        pane2b2.add(username);
        
        pass = new JLabel("Password");
        pass.setPreferredSize(new Dimension(200, 10));
        pass.setForeground(Color.BLACK);
        pane2b2.add(pass);

        pane2b21 = new JPanel();
        pane2b21.setBackground(new Color(0, 0, 0, 0));

        tf1 = new JTextField(20);
        tf1.setPreferredSize(new Dimension(100, 28));
        pane2b21.add(tf1);


        tf2 = new JPasswordField(20);
        tf2.setPreferredSize(new Dimension(100, 28));
        pane2b21.add(tf2);

        pane2b3 = new JPanel();
        pane2b3.setBackground(new Color(0, 0, 0, 0));

        b1 = new JButton("Next");
        b1.setForeground(Color.BLUE);
        b1.setPreferredSize(new Dimension(400, 25));

        pane2b3.add(b1);

        pane2b4 = new JPanel();
        pane2b4.setBackground(new Color(0, 0, 0, 0));

        b2 = new JButton("First Time Registration");
        b2.setForeground(Color.BLUE);
        b2.setPreferredSize(new Dimension(200, 25));
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TandC();
                dispose();

            }
        }
        );

        b3 = new JButton("Demo");
        b3.setForeground(Color.BLUE);
        b3.setPreferredSize(new Dimension(150, 25));

        pane2b4.add(b2);
        pane2b4.add(b3);

        pane2b5 = new JPanel();
        pane2b5.setBackground(new Color(0, 0, 0, 0));

        JLabel label = new JLabel("Java Swing Label Demo", JLabel.CENTER);
        reset = new JLabel("Reset Password");
        reset.setPreferredSize(new Dimension(300, 25));
        reset.setForeground(Color.BLUE);
        reset.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                ResetPassword projectipt = new ResetPassword();
                projectipt.setSize(1366, 768);
                projectipt.setVisible(true);
                projectipt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }

        });

        pane2b5.add(reset);

        pane2b6 = new JPanel();
        pane2b6.setBackground(new Color(0, 0, 0, 0));

        announcement = new JLabel("Announcement");
        announcement.setPreferredSize(new Dimension(400, 25));
        announcement.setForeground(Color.BLACK);
        pane2b6.add(announcement);

        pane2b7 = new JPanel();
        pane2b7.setBackground(new Color(0, 0, 0, 0));

        JLabel labell = new JLabel("Java Swing Label Demo", JLabel.CENTER);
        update = new JLabel("Update of Personal Information");
        update.setPreferredSize(new Dimension(400, 25));
        update.setForeground(Color.BLUE);
        update.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Dear values Customer,\n"
                        + "kindly update your personal"
                        + "information(address, telephone number,Employment, etc)\n at"
                        + " any BMMB branches nearer to you or call our Customer Care Line"
                        + "1-300-88-8787 for assistance");

            }
        });
        pane2b7.add(update);

        pane2b8 = new JPanel();
        pane2b8.setBackground(new Color(0, 0, 0, 0));

        JLabel label2 = new JLabel("Java Swing Label Demo", JLabel.CENTER);
        mobile = new JLabel("Mobile App and Web Theme Change");
        mobile.setPreferredSize(new Dimension(400, 25));
        mobile.setForeground(Color.BLUE);
        mobile.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Dear values Customer, \n"
                        + "is considered by many scholars to be\n"
                        + "Mobile App and Web theme \n"
                        + "Should you have any other queries, please call our Customer Service"
                        + "at 1 300 88 8787");

            }
        });

        pane2b8.add(mobile);

        pane2b9 = new JPanel();
        pane2b9.setBackground(new Color(0, 0, 0, 0));

        ImageIcon icon3 = new ImageIcon(this.getClass().getResource("/Resources/alert.png"));
        JLabel Label3 = new JLabel(icon3, JLabel.CENTER);
        pane2b9.add(Label3);

        pane2b.add(pane2b1);
        pane2b.add(pane2b2);
        pane2b.add(pane2b21);
        pane2b.add(pane2b3);
        pane2b.add(pane2b4);
        pane2b.add(pane2b5);
        pane2b.add(pane2b6);
        pane2b.add(pane2b7);
        pane2b.add(pane2b8);
        pane2b.add(pane2b9);

        pane2.add(pane2a);
        pane2.add(pane2b);

        pane3 = new JPanel();
        pane3.setBackground(Color.WHITE);
        ImageIcon icon4 = new ImageIcon(this.getClass().getResource("/Resources/pane42.png"));
        JLabel Label4 = new JLabel(icon4, JLabel.CENTER);
        pane3.add(Label4);

        add(pane1);
        add(pane2);
        add(pane3);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String user = tf1.getText();
                char[] pass = tf2.getPassword();
                String pwd = String.copyValueOf(pass);
                if (validate_login(user, pwd)) {
                    Home projectipt = new Home();
                    projectipt.setTitle("Welcome to i-Muamalat");
                    projectipt.setSize(1366, 768);
                    projectipt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    projectipt.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Login Error! Please Login Again!");
                }
            }

            private boolean validate_login(String Username, String NewPassword) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?" + "user=root&password=");
                    PreparedStatement pst = con.prepareStatement("Select * from user where Username=? and NewPassword=?");
                    pst.setString(1, Username);
                    pst.setString(2, NewPassword);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        return true;
                    } else {
                        return false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        });

    }

    public static void main(String[] args) {
        MainPage projectipt = new MainPage();
        projectipt.setSize(1366, 768);
        projectipt.setVisible(true);
        projectipt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
