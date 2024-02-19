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
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class Account extends JFrame {

    JPanel pane1, p2;
    //JLabel acc, payment, limit, security, acc1;
    JTextField tf1;

    public Account() {

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
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/Resources/header1.jpg"));
        JLabel Label = new JLabel(icon, JLabel.CENTER);
        pane1.add(Label);

        JPanel p2 = new JPanel();
        p2.setBackground(new Color(0, 0, 0, 0));
        p2.setLayout(new FlowLayout());
        JMenuBar menubar = new JMenuBar();
        menubar.setPreferredSize(new Dimension(1012, 35));
        menubar.setBackground(Color.WHITE);
        JMenu homeMenu = new JMenu("Home");
        JMenu myaccountMenu = new JMenu("My Accounts");
        JMenu accountSMenu = new JMenu("Account Setting");
        JMenu transferMenu = new JMenu("Transfers");
        JMenu remittanceMenu = new JMenu("Remittance");
        JMenu paymentMenu = new JMenu("Payments");
        JMenu chequemanageMenu = new JMenu("Cheque Management");
        JMenu prepaidreloadMenu = new JMenu("Prepaid Reload");
        JMenu serviceMenu = new JMenu("Other Services");
        JMenu billpaymentSMenu = new JMenu("Bill Payment");
        JMenu otherpaymentSMenu = new JMenu("Other Payments");
        JMenu jompaySMenu = new JMenu("JomPAY");
        JMenu favouritepaymentSMenu = new JMenu("Favourite Payments");
        myaccountMenu.add(accountSMenu);
        paymentMenu.add(billpaymentSMenu);
        paymentMenu.add(otherpaymentSMenu);
        paymentMenu.add(jompaySMenu);
        paymentMenu.add(favouritepaymentSMenu);
        menubar.add(homeMenu);
        menubar.add(myaccountMenu);
        menubar.add(transferMenu);
        menubar.add(remittanceMenu);
        menubar.add(paymentMenu);
        menubar.add(chequemanageMenu);
        menubar.add(prepaidreloadMenu);
        menubar.add(serviceMenu);
        p2.add(menubar);
        
        accountSMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                Account paymentForm = new Account();
                paymentForm.setTitle("Welcome to i-Muamalat");
                paymentForm.setSize(1366, 768);
                paymentForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                paymentForm.setVisible(true);
                dispose();
            }
        });

        jompaySMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                JomPayPayment paymentForm = new JomPayPayment();
                paymentForm.setTitle("Welcome to i-Muamalat");
                paymentForm.setSize(1366, 768);
                paymentForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                paymentForm.setVisible(true);
                dispose();
            }
        });

        JPanel pane2 = new JPanel();
        pane2.setPreferredSize(new Dimension(1012, 300));
        pane2.setBackground(Color.WHITE);
        pane2.setLayout(null);

        ImageIcon img1 = new ImageIcon(this.getClass().getResource("/Resources/user.png"));
        JLabel img1Label = new JLabel(img1);
        img1Label.setBounds(80, 30, 32, 32);
        pane2.add(img1Label);

        JLabel myaccLabel = new JLabel("My Account");
        myaccLabel.setBounds(120, 30, 300, 30);
        pane2.add(myaccLabel);

        JLabel accountLabel = new JLabel("Account Setting");
        accountLabel.setBounds(80, 70, 300, 30);
        accountLabel.setForeground(Color.BLUE);
        pane2.add(accountLabel);

        JLabel monthlyLabel = new JLabel("Monthly Payment Limit");
        monthlyLabel.setBounds(80, 110, 300, 30);
        monthlyLabel.setForeground(Color.BLUE);
        pane2.add(monthlyLabel);

        JLabel overdraftLabel = new JLabel("Overdraft Limit");
        overdraftLabel.setBounds(80, 150, 300, 30);
        overdraftLabel.setForeground(Color.BLUE);
        pane2.add(overdraftLabel);

        JLabel securityLabel = new JLabel("Security Settings");
        securityLabel.setBounds(80, 190, 300, 30);
        securityLabel.setForeground(Color.BLUE);
        pane2.add(securityLabel);

        JLabel accLabel = new JLabel("Account");
        accLabel.setBounds(400, 70, 300, 30);
        accLabel.setFont(new Font("Arial", Font.BOLD, 20));
        pane2.add(accLabel);

        JLabel cardLabel = new JLabel("Card Status");
        cardLabel.setBounds(550, 70, 300, 30);
        cardLabel.setFont(new Font("Arial", Font.BOLD, 20));
        pane2.add(cardLabel);

        ImageIcon img2 = new ImageIcon(this.getClass().getResource("/Resources/delete.png"));
        JLabel img2Label = new JLabel(img2);
        img2Label.setBounds(796, 70, 24, 24);
        pane2.add(img2Label);

        JLabel accText = new JLabel("- Online Banking");
        accText.setBounds(400, 110, 300, 30);
        pane2.add(accText);

        JLabel cardText = new JLabel("- Active");
        cardText.setBounds(550, 110, 300, 30);
        pane2.add(cardText);

        JButton deleteButton = new JButton("Delete Account");
        deleteButton.setBounds(760, 110, 150, 30);
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);
        pane2.add(deleteButton);

        final JLabel usernameL = new JLabel("Username: ");
        usernameL.setBounds(760, 150, 100, 30);
        usernameL.setVisible(false);
        pane2.add(usernameL);

        final JTextField usernameTF = new JTextField();
        usernameTF.setBounds(830, 150, 100, 25);
        usernameTF.setVisible(false);
        pane2.add(usernameTF);

        final JLabel passwordL = new JLabel("Password:");
        passwordL.setBounds(760, 180, 100, 30);
        passwordL.setVisible(false);
        pane2.add(passwordL);

        final JPasswordField passwordTF = new JPasswordField();
        passwordTF.setBounds(830, 180, 100, 25);
        passwordTF.setVisible(false);
        pane2.add(passwordTF);

        final JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(839, 210, 90, 25);
        confirmButton.setBackground(Color.RED);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setVisible(false);
        pane2.add(confirmButton);

        add(pane1);
        add(p2);
        add(pane2);

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                usernameL.setVisible(true);
                usernameTF.setVisible(true);
                passwordL.setVisible(true);
                passwordTF.setVisible(true);
                confirmButton.setVisible(true);
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String user = usernameTF.getText();
                char[] pass = passwordTF.getPassword();
                String pw = String.copyValueOf(pass);

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?" + "user=root&password=");

                    String sql = "delete from user where Username='" + user + "'";
                    PreparedStatement st = con.prepareStatement(sql);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Delete Successful!");

                    MainPage projectipt = new MainPage();
                    projectipt.setSize(2000, 2000);
                    projectipt.setVisible(true);
                    projectipt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Delete Failed!");
                }

            }
        });
    }

    public static void main(String[] args) {
        Account projectipt = new Account();
        projectipt.setSize(1366, 768);
        projectipt.setVisible(true);
        projectipt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
