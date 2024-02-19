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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ResetPassword extends JFrame {

    String userid = "root", password = "";
    String url = "jdbc:mysql://localhost:3306/bank";

    Statement s;
    Connection conn;

    JPanel pane9, pane9a, pane9b, pane9b1, pane9c, pane9d, pane9e, pane9f, pane9g, pane9h, pane9hi,
            pane9hii;
    JButton b5, b6;
    JLabel bank, identityType, identityNo, username, newpass, confirm;
    JTextField tf6, tf61, tf7, tf8, tf9, tf10;
    JPasswordField password0, password1;

    public ResetPassword() {

        setTitle("Bank Muamalat Malaysia Berhad");
        setSize(1366, 768);
        setLayout(null);
        setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("/Resources/white.jpg"))));
        //setLayout(new GridLayout(3, 1));
        setVisible(true);
        Container pane = getContentPane();
        setContentPane(pane);
        FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
        pane.setLayout(flow);

        pane9 = new JPanel();
        pane9.setBackground(new Color(0, 0, 0, 0));
        // pane9.setLayout(new GridLayout(7,1));
        pane9.setPreferredSize(new Dimension(1000, 570));
        pane9.setBackground(Color.WHITE);

        pane9a = new JPanel();

        ImageIcon icon = new ImageIcon(this.getClass().getResource("/Resources/reset.png"));
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
        pane9a.add(Label);

        pane9b = new JPanel();

        pane9b = new JPanel();
        pane9b.setBackground(new Color(0, 0, 0, 0));
        tf6 = new JTextField(20);
        //tf1.setPreferredSize(new Dimension(900, 25));

        bank = new JLabel("Bank Card Number : ");
        bank.setPreferredSize(new Dimension(420, 25));
        bank.setForeground(Color.BLACK);
        pane9b.add(bank);
        pane9b.add(tf6);

        pane9c = new JPanel();

        identityType = new JLabel("Identity Type : ");
        identityType.setPreferredSize(new Dimension(420, 25));
        pane9c.setBackground(new Color(0, 0, 0, 0));

        String Infant[] = {"Please Select", "MYKAD", "OLD IC", "MYPR", "PASSPORT",
            "MYKID", "BIRTH CERTIFICATE", "MYTENTERA", "ARMY PERSONNEL ID", "MYPOLIS", "POLICE PERSONAL ID",
            "INDIVIDUAL LICENSE TO OPERATE IN LABUAN OFFSHORE", "UNHCR(REFUGEE)", "BUSINESS RESGISTRATION NUMBER"};
        final JComboBox cb1 = new JComboBox(Infant);
        cb1.setPreferredSize(new Dimension(220, 25));
        cb1.setBounds(50, 50, 90, 20);

        pane9c.add(identityType);
        pane9c.add(cb1);

        pane9d = new JPanel();
        pane9d.setBackground(new Color(0, 0, 0, 0));
        tf7 = new JTextField(20);
        //tf1.setPreferredSize(new Dimension(900, 25));

        identityNo = new JLabel("Identity Number : ");
        identityNo.setPreferredSize(new Dimension(420, 25));
        identityNo.setForeground(Color.BLACK);

        pane9d.add(identityNo);
        pane9d.add(tf7);

        pane9e = new JPanel();
        pane9e.setBackground(new Color(0, 0, 0, 0));
        tf8 = new JTextField(20);

        username = new JLabel("Username : ");
        username.setPreferredSize(new Dimension(420, 25));
        username.setForeground(Color.BLACK);
        pane9e.add(username);
        pane9e.add(tf8);

        pane9f = new JPanel();
        pane9f.setBackground(new Color(0, 0, 0, 0));

        newpass = new JLabel("New Password : ");
        newpass.setPreferredSize(new Dimension(420, 25));
        newpass.setForeground(Color.BLACK);

        password0 = new JPasswordField();
        password0.setPreferredSize(new Dimension(220, 20));

        pane9f.add(newpass);
        pane9f.add(password0);

        pane9g = new JPanel();
        pane9g.setBackground(new Color(0, 0, 0, 0));

        newpass = new JLabel("Confirm New Password :  ");
        newpass.setPreferredSize(new Dimension(420, 25));
        newpass.setForeground(Color.BLACK);

        password1 = new JPasswordField();
        password1.setPreferredSize(new Dimension(220, 20));

        pane9g.add(newpass);
        pane9g.add(password1);

        pane9hi = new JPanel();
        pane9hi.setBackground(new Color(0, 0, 0, 0));

        b5 = new JButton("Clear");
        b5.setForeground(Color.ORANGE);
        b5.setPreferredSize(new Dimension(170, 30));
        b5.setBounds(100, 150, 80, 30);
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf6.setText("");
                tf61.setText("");
                cb1.setSelectedItem("Please Select");
                tf7.setText("");
                tf8.setText("");
                password0.setText("");
                password1.setText("");

            }
        });

        b6 = new JButton("Submit");
        b6.setForeground(Color.ORANGE);
        b6.setPreferredSize(new Dimension(170, 30));
        b6.setBounds(100, 150, 80, 30);
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    //String sql = "update user set BankCardNumber=?, IdentityType=?, IdentityNumber=?, Username=?, NewPassword=?, ConfirmNewPassword=? where Username = '"+tf8.getText()+"'";
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?" + "user=root&password=");
                    //PreparedStatement st = con.prepareStatement(sql);

                    char[] pass1 = password0.getPassword();
                    String np = String.copyValueOf(pass1);

                    char[] pass2 = password1.getPassword();
                    String cnp = String.copyValueOf(pass2);

                    Statement stmt = con.createStatement();

                    String sql = "update user set NewPassword='" + np + "', ConfirmNewPassword='" + cnp + "' where Username='" + tf8.getText() + "'";
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Update Successful!");
                   
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Update Failed!");
                    e.printStackTrace();
                    e.getMessage();
                }

            }
        });

        pane9hi.add(b5);
        pane9hi.add(b6);

        pane9hii = new JPanel();

        pane9hii.setBackground(Color.WHITE);
        ImageIcon icon3 = new ImageIcon(this.getClass().getResource("/Resources/pane4.png"));
        JLabel Label3 = new JLabel(icon3, JLabel.CENTER);
        pane9hii.add(Label3);

        pane9.add(pane9a);
        pane9.add(pane9b);
        pane9.add(pane9c);
        pane9.add(pane9d);
        pane9.add(pane9e);
        pane9.add(pane9f);
        pane9.add(pane9g);
        pane9.add(pane9hi);
        pane9.add(pane9hii);

        add(pane9);

    }

    public void getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {
            conn = DriverManager.getConnection(url, userid, password);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        ResetPassword projectipt = new ResetPassword();
        projectipt.setSize(2000, 2000);
        projectipt.getConnection();
        projectipt.setVisible(true);
        projectipt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //});
}
