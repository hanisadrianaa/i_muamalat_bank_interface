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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Registration extends JFrame {

    String userid = "root", password = "";
    String url = "jdbc:mysql://localhost:3306/bank";

    Statement s;
    Connection conn;

    JPanel pane7, pane7a, pane7b, pane7c, pane7d, pane7e, pane7f, pane7g,
            pane8, pane8a, pane8b, pane8c, pane8d, pane8e, pane8f;
    JButton b5, b6, b7;
    JRadioButton r1, r2;
    JLabel step1, step2, please, bank, pintype, pin, input, identityType, identityNo, pin1;
    JTextField tf1, tf2, tf3;
    JComboBox cb1;

    public Registration() {

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

        pane7 = new JPanel();
        //pane7.setLayout(new GridLayout(6, 1));
        pane7.setPreferredSize(new Dimension(1000, 660));
        pane7.setBackground(Color.WHITE);

        pane7a = new JPanel();

        ImageIcon icon = new ImageIcon(this.getClass().getResource("/Resources/first.png"));
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
        pane7a.add(Label);

        pane7b = new JPanel();
        pane7b.setBackground(new Color(0, 0, 0, 0));

        step1 = new JLabel("Step 1");
        step1.setPreferredSize(new Dimension(900, 25));
        step1.setForeground(Color.RED);
        pane7b.add(step1);

        pane7c = new JPanel();
        pane7c.setBackground(new Color(0, 0, 0, 0));

        please = new JLabel("Please enter your Bank Card Number and iPIN");
        please.setPreferredSize(new Dimension(900, 25));
        please.setForeground(Color.BLUE);
        pane7c.add(please);

        pane7d = new JPanel();
        pane7d.setBackground(new Color(0, 0, 0, 0));
        tf1 = new JTextField(25);
        //tf1.setPreferredSize(new Dimension(900, 25));

        bank = new JLabel("Bank Card Number : ");
        bank.setPreferredSize(new Dimension(420, 25));
        bank.setForeground(Color.BLACK);
        pane7d.add(bank);
        pane7d.add(tf1);

        pane7e = new JPanel();

        pane7e.setBackground(new Color(0, 0, 0, 0));
        ButtonGroup bg = new ButtonGroup();
        final JRadioButton r1 = new JRadioButton("ATM PIN");
        final JRadioButton r2 = new JRadioButton("IB PIN");
        //r1.setBackground(new Color(0, 0, 0, 0));
        //r2.setBackground(new Color(0, 0, 0, 0));
        bg.add(r1);
        bg.add(r2);

        pintype = new JLabel("Pin Type :        ");
        pintype.setPreferredSize(new Dimension(560, 50));
        pintype.setForeground(Color.BLACK);
        pane7e.add(pintype);
        pane7e.add(r1);
        pane7e.add(r2);

        pane7f = new JPanel();
        pane7f.setBackground(new Color(0, 0, 0, 0));
        tf2 = new JTextField(25);

        pin = new JLabel("Pin : ");
        // pin1 = new JLabel("what is ATM PIN and IB PIN?");
        // pin1.setForeground(Color.BLUE);
        pin.setPreferredSize(new Dimension(420, 25));
        pin.setForeground(Color.BLACK);
        pane7f.add(pin);
        pane7f.add(tf2);
        // pane7f.add(pin1);

        pane8a = new JPanel();
        pane8a.setBackground(new Color(0, 0, 0, 0));

        step2 = new JLabel("Step 2");
        step2.setPreferredSize(new Dimension(900, 25));
        step2.setForeground(Color.RED);
        pane8a.add(step2);

        pane8b = new JPanel();
        pane8b.setBackground(new Color(0, 0, 0, 0));

        input = new JLabel("Input your identity number.");
        input.setPreferredSize(new Dimension(900, 25));
        input.setForeground(Color.BLUE);
        pane8b.add(input);

        pane8c = new JPanel();
        pane8c.setBackground(new Color(0, 0, 0, 0));

        identityType = new JLabel("Identity Type : ");
        identityType.setPreferredSize(new Dimension(420, 25));
        pane8c.setBackground(new Color(0, 0, 0, 0));

        String Infant[] = {"Please Select", "MYKAD", "OLD IC", "MYPR", "PASSPORT",
            "MYKID", "BIRTH CERTIFICATE", "MYTENTERA", "ARMY PERSONNEL ID", "MYPOLIS", "POLICE PERSONAL ID",
            "INDIVIDUAL LICENSE TO OPERATE IN LABUAN OFFSHORE", "UNHCR(REFUGEE)", "BUSINESS RESGISTRATION NUMBER"};
        final JComboBox cb1 = new JComboBox(Infant);
        cb1.setPreferredSize(new Dimension(280, 25));
        cb1.setBounds(50, 50, 90, 20);

        pane8c.add(identityType);
        pane8c.add(cb1);

        pane8d = new JPanel();
        pane8d.setBackground(new Color(0, 0, 0, 0));
        tf3 = new JTextField(25);

        identityNo = new JLabel("Identity Number : ");
        identityNo.setPreferredSize(new Dimension(420, 25));
        identityNo.setForeground(Color.BLACK);
        pane8d.add(identityNo);
        pane8d.add(tf3);

        pane8e = new JPanel();
        pane8e.setBackground(new Color(0, 0, 0, 0));

        b6 = new JButton("Clear");
        b6.setForeground(Color.ORANGE);
        b6.setPreferredSize(new Dimension(190, 30));
        b6.setBounds(100, 150, 80, 30);
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf1.setText("");
                r1.setSelected(false);
                r2.setSelected(false);
                tf2.setText("");
                cb1.setSelectedItem("Please Select");
                tf3.setText("");
                //r1.setEnabled(false);
                //r2.setEnabled(false);

            }
        });

        b7 = new JButton("Next");
        b7.setForeground(Color.ORANGE);
        b7.setPreferredSize(new Dimension(190, 30));
        b7.setBounds(100, 150, 80, 30);
        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                final JPanel pan = new JPanel();

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

                JPanel pane9 = new JPanel();
                // pane9.setLayout(new GridLayout(7,1));
                pane9.setPreferredSize(new Dimension(1000, 470));
                pane9.setBackground(Color.WHITE);

                JPanel pane9a = new JPanel();

                ImageIcon icon = new ImageIcon(this.getClass().getResource("/Resources/first.png"));
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

                JPanel pane9b = new JPanel();

                pane9b = new JPanel();
                pane9b.setBackground(new Color(0, 0, 0, 0));
                final JTextField username = new JTextField(20);
                //tf1.setPreferredSize(new Dimension(900, 25));

                bank = new JLabel("Username : ");
                bank.setPreferredSize(new Dimension(420, 25));
                bank.setForeground(Color.BLACK);
                pane9b.add(bank);
                pane9b.add(username);

                JPanel pane9f = new JPanel();
                pane9f.setBackground(new Color(0, 0, 0, 0));

                JLabel newpass = new JLabel("New Password : ");
                newpass.setPreferredSize(new Dimension(420, 25));
                newpass.setForeground(Color.BLACK);

                final JPasswordField password0 = new JPasswordField();
                password0.setPreferredSize(new Dimension(220, 20));

                pane9f.add(newpass);
                pane9f.add(password0);

                JPanel pane9g = new JPanel();
                pane9g.setBackground(new Color(0, 0, 0, 0));

                newpass = new JLabel("Confirm New Password :  ");
                newpass.setPreferredSize(new Dimension(420, 25));
                newpass.setForeground(Color.BLACK);

                final JPasswordField password1 = new JPasswordField();
                password1.setPreferredSize(new Dimension(220, 20));

                pane9g.add(newpass);
                pane9g.add(password1);

                JPanel pane9hi = new JPanel();
                pane9hi.setBackground(new Color(0, 0, 0, 0));

                b5 = new JButton("Clear");
                b5.setForeground(Color.ORANGE);
                b5.setPreferredSize(new Dimension(170, 30));
                b5.setBounds(100, 150, 80, 30);
                b5.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        username.setText("");
                        password0.setText("");
                        password1.setText("");

                    }
                });

                b6 = new JButton("Next");
                b6.setForeground(Color.ORANGE);
                b6.setPreferredSize(new Dimension(170, 30));
                b6.setBounds(100, 150, 80, 30);
                b6.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?" + "user=root&password=");
                                    Statement stmt = con.createStatement();
                                    
                                    String bankcardnumber = tf1.getText();
                                    String pin = tf2.getText();
                                    String identitytype = cb1.getSelectedItem().toString();
                                    String identitynumber = tf3.getText();
                                    String uname = username.getText();
                                    char[] pass1 = password0.getPassword();
                                    String unewpass = String.copyValueOf(pass1);
                                    char[] pass2 = password1.getPassword();
                                    String uconnewpass = String.copyValueOf(pass2);

                                    String query = "insert into user (BankCardNumber, Pin, IdentityType, IdentityNumber, Username, NewPassword, ConfirmNewPassword)"
                                            + "values('" + bankcardnumber + "','" + pin + "','" + identitytype + "','" + identitynumber + "','" + uname + "','" + unewpass + "','"+uconnewpass+"')";
                                    stmt.execute(query);
                                    JOptionPane.showMessageDialog(null, "Congratulations! You have successfully registered for Bank Muamalat Internet Banking.");
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                    e.printStackTrace();
                                }

                                try {
                                    if (s != null) {
                                        s.close();
                                        conn.close();
                                    }
                                } catch (SQLException e) {
                                    System.out.println(e.getMessage());
                                    e.printStackTrace();
                                }
                    }
                });

                pane9hi.add(b5);
                pane9hi.add(b6);

                JPanel pane9hii = new JPanel();

                pane9hii.setBackground(Color.WHITE);
                ImageIcon icon3 = new ImageIcon(this.getClass().getResource("/Resources/pane4.png"));
                JLabel Label3 = new JLabel(icon3, JLabel.CENTER);
                pane9hii.add(Label3);

                pane9.add(pane9a);
                pane9.add(pane9b);
                pane9.add(pane9f);
                pane9.add(pane9g);
                pane9.add(pane9hi);
                pane9.add(pane9hii);

                add(pane9);

                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        add(pan);
                        pane7.setVisible(false);
                        pan.revalidate();
                        pan.repaint();
                        pan.setVisible(false);
                    }
                });
            }
        });

        pane8e.add(b6);
        pane8e.add(b7);

        pane8f = new JPanel();
        pane8f.setBackground(Color.WHITE);

        ImageIcon icon3 = new ImageIcon(this.getClass().getResource("/Resources/pane4.png"));
        JLabel Label3 = new JLabel(icon3, JLabel.CENTER);
        pane8f.add(Label3);

        pane7.add(pane7a);
        pane7.add(pane7b);
        pane7.add(pane7c);
        pane7.add(pane7d);
        pane7.add(pane7e);
        pane7.add(pane7f);
        pane7.add(pane8a);
        pane7.add(pane8b);
        pane7.add(pane8c);
        pane7.add(pane8d);
        pane7.add(pane8e);
        pane7.add(pane8f);

        // pane8 = new JPanel();
        //pane8.setPreferredSize(new Dimension(1000, 260));
        //pane8.setBackground(Color.WHITE);
        add(pane7);
        // add(pane8);

    }

    public static void main(String[] args) {
        Registration projectipt = new Registration();
        projectipt.setSize(2000, 2000);
        projectipt.setVisible(true);
        projectipt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //});
}
