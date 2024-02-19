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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 *
 * @author HP-W10
 */
public class Home extends JFrame {

    Home() {
        setLayout(null);
        setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("/Resources/bg2.jpg"))));
        setLayout(new GridLayout(3, 1));
        setVisible(true);
        Container c = getContentPane();
        setContentPane(c);
        FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
        c.setLayout(flowlayout);

        final JPanel p1 = new JPanel();
        p1.setBackground(new Color(0, 0, 0, 0));
        p1.setLayout(new FlowLayout());
        ImageIcon img1 = new ImageIcon(this.getClass().getResource("/Resources/header1.jpg"));
        JLabel labelimg1 = new JLabel(img1);
        p1.add(labelimg1);
        add(p1);

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
        add(p2);
        
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

        JPanel p3 = new JPanel();
        p3.setBackground(new Color(0, 0, 0, 0));
        p3.setPreferredSize(new Dimension(1012, 180));
        p3.setLayout(null);
        //p3.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 3));

        JLabel welcomeLabel = new JLabel("Welcome!");
        welcomeLabel.setBounds(50, 30, 300, 30);
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        welcomeLabel.setForeground(Color.BLUE);
        p3.add(welcomeLabel);

        JLabel dateLabel = new JLabel();
        Date date = new Date();
        dateLabel.setText(date.getDate() + "-" + date.getMonth() + "-" + date.getYear());
        dateLabel.setBounds(53, 55, 50, 30);
        p3.add(dateLabel);
        
        JLabel timeLabel = new JLabel();
        Date time = new Date();
        timeLabel.setText(time.getHours() + ":" + time.getMinutes() + ":" + time.getSeconds() + " PM");
        timeLabel.setBounds(110, 55, 80, 30);
        p3.add(timeLabel);
        
        JLabel successLabel = new JLabel("• Your last successful login 09/03/2018 10:23:21 AM");
        successLabel.setBounds(50, 95, 300, 30);
        p3.add(successLabel);
        
        JLabel failLabel = new JLabel("• Your last failed login 09/03/2018 08:54:05 AM");
        failLabel.setBounds(50, 120, 300, 30);
        p3.add(failLabel);
        
        JLabel messageLabel1 = new JLabel("• You have new ");
        messageLabel1.setBounds(450, 95, 300, 30);
        p3.add(messageLabel1);
        
        JLabel messageLabel2 = new JLabel("0 message(s)");
        messageLabel2.setBounds(545, 95, 300, 30);
        messageLabel2.setForeground(Color.BLUE);
        p3.add(messageLabel2);
        
        JLabel pendingLabel1 = new JLabel("• You have ");
        pendingLabel1.setBounds(450, 120, 300, 30);
        p3.add(pendingLabel1);
        
        JLabel pendingLabel2 = new JLabel("0 pending transaction(s)");
        pendingLabel2.setBounds(517, 120, 300, 30);
        pendingLabel2.setForeground(Color.BLUE);
        p3.add(pendingLabel2);
        
        JLabel failLabel1 = new JLabel("• You have");
        failLabel1.setBounds(450, 145, 300, 30);
        p3.add(failLabel1);
        
        JLabel failLabel2 = new JLabel("0 failed transaction(s)");
        failLabel2.setBounds(517, 145, 300, 30);
        failLabel2.setForeground(Color.BLUE);
        p3.add(failLabel2);
        
        add(p3);
    }

    public static void main(String[] args) {
        Home projectipt = new Home();
        projectipt.setTitle("Welcome to i-Muamalat");
        projectipt.setSize(1366, 768);
        projectipt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        projectipt.setVisible(true);
    }
}
