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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author HP-W10
 */
public class JomPayPayment extends JFrame {

    Statement stmt;
    Connection con;

    JomPayPayment() {
        setLayout(null);
        setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("/Resources/bg1.jpg"))));
        setLayout(new GridLayout(4, 1));
        setVisible(true);
        Container c = getContentPane();
        setContentPane(c);
        FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
        c.setLayout(flowlayout);

        final JPanel p1 = new JPanel();
        p1.setBackground(Color.WHITE);
        p1.setLayout(new FlowLayout());
        ImageIcon img1 = new ImageIcon(this.getClass().getResource("/Resources/header1.jpg"));
        JLabel labelimg1 = new JLabel(img1);
        labelimg1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                MainPage projectipt = new MainPage();
                projectipt.setSize(2000, 2000);
                projectipt.setVisible(true);
                projectipt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });

        p1.add(labelimg1);
        add(p1);

        final JPanel p2 = new JPanel();
        p2.setBackground(Color.WHITE);
        p2.setPreferredSize(new Dimension(1000, 100));
        ImageIcon img2 = new ImageIcon(this.getClass().getResource("/Resources/jompay.jpg"));
        JLabel labelimg2 = new JLabel(img2);
        p2.add(labelimg2);
        add(p2);

        final JPanel p3 = new JPanel();
        p3.setBackground(Color.WHITE);
        p3.setPreferredSize(new Dimension(1000, 50));
        ImageIcon img3 = new ImageIcon(this.getClass().getResource("/Resources/enterinfo.jpg"));
        JLabel labelimg3 = new JLabel(img3);
        p3.add(labelimg3);
        add(p3);

        final JPanel p4 = new JPanel();
        p4.setBackground(Color.WHITE);
        p4.setPreferredSize(new Dimension(700, 390));
        p4.setLayout(null);

        JLabel mandatoryLabel = new JLabel("* - mandatory field");
        mandatoryLabel.setForeground(Color.RED);
        mandatoryLabel.setBounds(10, 5, 150, 30);
        p4.add(mandatoryLabel);

        JLabel fromAccount1 = new JLabel("From Account *                                                      :");
        fromAccount1.setBounds(50, 30, 300, 30);
        p4.add(fromAccount1);

        String accounttype[] = {"Please Select", "1401-0040824-72-2 Savings Account", "1401-0007116-71-6 Current Account"};
        final JComboBox accountCBox = new JComboBox(accounttype);
        accountCBox.setBounds(340, 37, 250, 18);
        p4.add(accountCBox);

        JLabel toAccount = new JLabel("To Account *                                                           :");
        toAccount.setBounds(50, 60, 300, 30);
        p4.add(toAccount);

        final JRadioButton favRButton = new JRadioButton("Favourite");
        favRButton.setBackground(Color.WHITE);
        favRButton.setBounds(340, 64, 80, 25);
        p4.add(favRButton);

        final JRadioButton nonfavRButton = new JRadioButton("Non-Favourite");
        nonfavRButton.setBackground(Color.WHITE);
        nonfavRButton.setBounds(340, 90, 150, 25);
        p4.add(nonfavRButton);

        String favlist[] = {"Please Select", "Astro", "Celcom"};
        final JComboBox favlistCBox = new JComboBox(favlist);
        favlistCBox.setBounds(421, 67, 170, 18);
        p4.add(favlistCBox);

        JLabel billerCode1 = new JLabel("Biller Code *                                                            :");
        billerCode1.setBounds(50, 120, 300, 30);
        p4.add(billerCode1);

        final JTextField billercodeField = new JTextField();
        billercodeField.setBounds(340, 126, 120, 20);
        p4.add(billercodeField);

        JLabel paymentalertLabel = new JLabel("Payment Alert                                                         :");
        paymentalertLabel.setBounds(50, 150, 300, 30);
        p4.add(paymentalertLabel);

        final JCheckBox emailChBox = new JCheckBox("Email");
        emailChBox.setBackground(Color.WHITE);
        emailChBox.setBounds(340, 150, 70, 25);
        p4.add(emailChBox);

        final JCheckBox smsChBox = new JCheckBox("SMS");
        smsChBox.setBackground(Color.WHITE);
        smsChBox.setBounds(340, 180, 70, 25);
        p4.add(smsChBox);

        final JTextField emailField = new JTextField();
        emailField.setBounds(410, 152, 120, 20);
        p4.add(emailField);

        JLabel emailLabel = new JLabel("example@example.com");
        emailLabel.setBounds(535, 145, 300, 30);
        p4.add(emailLabel);

        final JTextField smsField = new JTextField();
        smsField.setBounds(410, 182, 120, 20);
        p4.add(smsField);

        JLabel beneficiaryLabel = new JLabel("Each Beneficiary SMS alert costs RM 0.21");
        beneficiaryLabel.setBounds(340, 210, 300, 20);
        p4.add(beneficiaryLabel);

        JLabel ref1Label1 = new JLabel("Ref-1 *                                                                       :");
        ref1Label1.setBounds(50, 240, 300, 20);
        p4.add(ref1Label1);

        final JTextField ref1Field = new JTextField();
        ref1Field.setBounds(340, 240, 120, 20);
        p4.add(ref1Field);

        JLabel ref2Label1 = new JLabel("Ref-2                                                                          :");
        ref2Label1.setBounds(50, 270, 300, 20);
        p4.add(ref2Label1);

        final JTextField ref2Field = new JTextField();
        ref2Field.setBounds(340, 272, 120, 20);
        p4.add(ref2Field);

        JLabel amountLabel1 = new JLabel("Amount (RM) *                                                         :");
        amountLabel1.setBounds(50, 300, 300, 20);
        p4.add(amountLabel1);

        final JTextField amountField = new JTextField();
        amountField.setBounds(340, 303, 120, 20);
        p4.add(amountField);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(320, 335, 65, 20);
        clearButton.setBackground(Color.ORANGE);
        clearButton.setForeground(Color.WHITE);
        p4.add(clearButton);

        JButton nextButton = new JButton("Next");
        nextButton.setBounds(395, 335, 65, 20);
        nextButton.setBackground(Color.ORANGE);
        nextButton.setForeground(Color.WHITE);
        p4.add(nextButton);

        add(p4);

        favRButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                int state = ie.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    nonfavRButton.setEnabled(false);
                } else if (state == ItemEvent.DESELECTED) {
                    nonfavRButton.setEnabled(true);
                }
            }
        });

        nonfavRButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                int state = ie.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    favRButton.setEnabled(false);
                    favlistCBox.setEnabled(false);
                } else if (state == ItemEvent.DESELECTED) {
                    favRButton.setEnabled(true);
                    favlistCBox.setEnabled(true);
                }
            }
        });

        emailChBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                int state = ie.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    smsChBox.setEnabled(false);
                    smsField.setEnabled(false);
                } else if (state == ItemEvent.DESELECTED) {
                    smsChBox.setEnabled(true);
                    smsField.setEnabled(true);
                }
            }
        });

        smsChBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                int state = ie.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    emailChBox.setEnabled(false);
                    emailField.setEnabled(false);
                } else if (state == ItemEvent.DESELECTED) {
                    emailChBox.setEnabled(true);
                    emailField.setEnabled(true);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accountCBox.setSelectedItem("Please Select");
                favRButton.setSelected(false);
                nonfavRButton.setSelected(false);
                favlistCBox.setSelectedItem("Please Select");
                billercodeField.setText("");
                emailChBox.setSelected(false);
                emailField.setText("");
                smsChBox.setSelected(false);
                smsField.setText("");
                ref1Field.setText("");
                ref2Field.setText("");
                amountField.setText("");
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setLayout(null);
                setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("/Resources/bg1.jpg"))));
                setLayout(new GridLayout(1, 1));
                setVisible(true);
                Container c = getContentPane();
                setContentPane(c);
                FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
                c.setLayout(flowlayout);

                final JPanel pan = new JPanel();
                pan.setBackground(Color.WHITE);

                final JPanel p1a = new JPanel();
                p1a.setBackground(Color.WHITE);
                p1a.setLayout(new FlowLayout());
                ImageIcon img1 = new ImageIcon(this.getClass().getResource("/Resources/header1.jpg"));
                JLabel labelimg1 = new JLabel(img1);
                p1a.add(labelimg1);
                add(p1a);

                final JPanel p2a = new JPanel();
                p2a.setBackground(Color.WHITE);
                p2a.setPreferredSize(new Dimension(1000, 100));
                ImageIcon img2 = new ImageIcon(this.getClass().getResource("/Resources/jompay.jpg"));
                JLabel labelimg2 = new JLabel(img2);
                p2a.add(labelimg2);
                add(p2a);

                final JPanel p3a = new JPanel();
                p3a.setBackground(Color.WHITE);
                p3a.setPreferredSize(new Dimension(1000, 50));
                ImageIcon img3 = new ImageIcon(this.getClass().getResource("/Resources/paymentconfirmation.jpg"));
                JLabel labelimg3 = new JLabel(img3);
                p3a.add(labelimg3);
                add(p3a);

                final JPanel p4a = new JPanel();
                p4a.setBackground(Color.WHITE);
                p4a.setPreferredSize(new Dimension(700, 390));
                p4a.setLayout(null);

                JLabel fromAccount2 = new JLabel("From Account                                                        :");
                fromAccount2.setBounds(50, 30, 300, 30);
                p4a.add(fromAccount2);

                JLabel fromaccountText = new JLabel();
                fromaccountText.setText(accountCBox.getSelectedItem().toString());
                fromaccountText.setBounds(320, 30, 300, 30);
                p4a.add(fromaccountText);

                JLabel billerCode2 = new JLabel("Biller Code                                                              :");
                billerCode2.setBounds(50, 70, 300, 30);
                p4a.add(billerCode2);

                JLabel billercodeText = new JLabel();
                billercodeText.setText(billercodeField.getText());
                billercodeText.setBounds(320, 70, 300, 30);
                p4a.add(billercodeText);

                JLabel ref1Label2 = new JLabel("Ref-1                                                                         :");
                ref1Label2.setBounds(50, 110, 300, 30);
                p4a.add(ref1Label2);

                JLabel ref1Text1 = new JLabel();
                ref1Text1.setText(ref1Field.getText());
                ref1Text1.setBounds(320, 110, 300, 30);
                p4a.add(ref1Text1);

                JLabel ref2Label2 = new JLabel("Ref-2                                                                         :");
                ref2Label2.setBounds(50, 150, 300, 30);
                p4a.add(ref2Label2);

                JLabel ref2Text1 = new JLabel();
                ref2Text1.setText(ref2Field.getText());
                ref2Text1.setBounds(320, 150, 300, 30);
                p4a.add(ref2Text1);

                JLabel amountLabel2 = new JLabel("Amount(RM)                                                            :");
                amountLabel2.setBounds(50, 190, 300, 30);
                p4a.add(amountLabel2);

                JLabel amountText1 = new JLabel();
                amountText1.setText(amountField.getText());
                amountText1.setBounds(320, 190, 300, 30);
                p4a.add(amountText1);

                JLabel transcode = new JLabel("Transaction Authorization Code                         :");
                transcode.setBounds(50, 230, 300, 30);
                p4a.add(transcode);

                JTextField codeField = new JTextField();
                codeField.setBounds(320, 237, 120, 20);
                p4a.add(codeField);

                JButton requesttacButton = new JButton("Request TAC");
                requesttacButton.setBounds(450, 237, 107, 20);
                requesttacButton.setBackground(Color.ORANGE);
                requesttacButton.setForeground(Color.WHITE);
                p4a.add(requesttacButton);

                JLabel codefail = new JLabel("Do not receive? Please click button to request again.");
                codefail.setBounds(320, 257, 300, 20);
                p4a.add(codefail);

                JButton backButton = new JButton("Back");
                backButton.setBackground(Color.ORANGE);
                backButton.setForeground(Color.WHITE);
                backButton.setBounds(320, 295, 65, 20);
                p4a.add(backButton);

                JButton confirmButton = new JButton("Confirm");
                confirmButton.setBackground(Color.ORANGE);
                confirmButton.setForeground(Color.WHITE);
                confirmButton.setBounds(388, 295, 79, 20);
                p4a.add(confirmButton);
                add(p4a);

                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {

                    }
                });

                confirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        setLayout(null);
                        setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("/Resources/bg1.jpg"))));
                        setLayout(new GridLayout(1, 1));
                        setVisible(true);
                        Container c = getContentPane();
                        setContentPane(c);
                        FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
                        c.setLayout(flowlayout);

                        final JPanel pan1 = new JPanel();
                        pan1.setBackground(Color.WHITE);

                        final JPanel p1b = new JPanel();
                        p1b.setBackground(Color.WHITE);
                        p1b.setLayout(new FlowLayout());
                        ImageIcon img1 = new ImageIcon(this.getClass().getResource("/Resources/header1.jpg"));
                        JLabel labelimg1 = new JLabel(img1);
                        labelimg1.addMouseListener(new MouseAdapter() {
                            public void mouseClicked(MouseEvent e) {
                                Home projectipt = new Home();
                                projectipt.setSize(2000, 2000);
                                projectipt.setVisible(true);
                                projectipt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                dispose();
                            }
                        });
                        p1b.add(labelimg1);
                        add(p1b);

                        final JPanel p2b = new JPanel();
                        p2b.setBackground(Color.WHITE);
                        p2b.setPreferredSize(new Dimension(1000, 100));
                        ImageIcon img2 = new ImageIcon(this.getClass().getResource("/Resources/jompay.jpg"));
                        JLabel labelimg2 = new JLabel(img2);
                        p2b.add(labelimg2);
                        add(p2b);

                        final JPanel p3b = new JPanel();
                        p3b.setBackground(Color.WHITE);
                        p3b.setPreferredSize(new Dimension(1000, 70));
                        ImageIcon img3 = new ImageIcon(this.getClass().getResource("/Resources/paymentacknowledgement.jpg"));
                        JLabel labelimg3 = new JLabel(img3);
                        p3b.add(labelimg3);
                        add(p3b);

                        final JPanel p4b = new JPanel();
                        p4b.setBackground(Color.WHITE);
                        p4b.setPreferredSize(new Dimension(700, 390));
                        p4b.setLayout(null);

                        JLabel referenceNumber = new JLabel("Reference Number                                      :");
                        referenceNumber.setBounds(50, 20, 300, 30);
                        p4b.add(referenceNumber);

                        JLabel referenceNumberText = new JLabel();
                        referenceNumberText.setText("JPY000000003");
                        referenceNumberText.setBounds(290, 20, 300, 30);
                        p4b.add(referenceNumberText);

                        JLabel transactionStatus = new JLabel("Transaction Status                                      :");
                        transactionStatus.setBounds(50, 50, 300, 30);
                        p4b.add(transactionStatus);

                        JLabel transtatusText = new JLabel();
                        transtatusText.setText("Successful");
                        transtatusText.setBounds(290, 50, 300, 30);
                        p4b.add(transtatusText);

                        JLabel jompaynumber = new JLabel("JomPAY Reference Number                     :");
                        jompaynumber.setBounds(50, 80, 300, 30);
                        p4b.add(jompaynumber);

                        JLabel jompaynumberText = new JLabel();
                        jompaynumberText.setText("25DPJQKU");
                        jompaynumberText.setBounds(290, 80, 300, 30);
                        p4b.add(jompaynumberText);

                        JLabel fromAccount3 = new JLabel("From Account                                                :");
                        fromAccount3.setBounds(50, 110, 300, 30);
                        p4b.add(fromAccount3);

                        JLabel fromaccountText2 = new JLabel();
                        fromaccountText2.setText(accountCBox.getSelectedItem().toString());
                        fromaccountText2.setBounds(290, 110, 300, 30);
                        p4b.add(fromaccountText2);

                        JLabel billerCode3 = new JLabel("Biller Code                                                      :");
                        billerCode3.setBounds(50, 140, 300, 30);
                        p4b.add(billerCode3);

                        JLabel billercodeText = new JLabel();
                        billercodeText.setText(billercodeField.getText() + " - BMMB Biller 3");
                        billercodeText.setBounds(290, 140, 300, 30);
                        p4b.add(billercodeText);

                        JLabel ref1Label3 = new JLabel("Ref-1                                                                :");
                        ref1Label3.setBounds(50, 170, 300, 30);
                        p4b.add(ref1Label3);

                        JLabel ref1Text2 = new JLabel();
                        ref1Text2.setText(ref1Field.getText());
                        ref1Text2.setBounds(290, 170, 300, 30);
                        p4b.add(ref1Text2);

                        JLabel ref2Label3 = new JLabel("Ref-2                                                                :");
                        ref2Label3.setBounds(50, 200, 300, 30);
                        p4b.add(ref2Label3);

                        JLabel ref2Text2 = new JLabel();
                        ref2Text2.setText(ref2Field.getText());
                        ref2Text2.setBounds(290, 200, 300, 30);
                        p4b.add(ref2Text2);

                        JLabel amountLabel3 = new JLabel("Amount (RM)                                                  :");
                        amountLabel3.setBounds(50, 230, 300, 30);
                        p4b.add(amountLabel3);

                        JLabel amountText2 = new JLabel();
                        amountText2.setText(amountField.getText());
                        amountText2.setBounds(290, 230, 300, 30);
                        p4b.add(amountText2);

                        JLabel balance = new JLabel("Balance After Transfer (RM)                      :");
                        balance.setBounds(50, 260, 300, 30);
                        p4b.add(balance);

                        final JLabel balanceText = new JLabel();
                        balanceText.setText("RM 203,888.73");
                        balanceText.setBounds(290, 260, 300, 30);
                        p4b.add(balanceText);

                        JLabel transdatetime = new JLabel("Transaction Date, Time                               :");
                        transdatetime.setBounds(50, 290, 300, 30);
                        p4b.add(transdatetime);

                        Date datetime = new Date();
                        JLabel transdatetimeText = new JLabel();
                        transdatetimeText.setText(datetime.getDate() + "/" + datetime.getMonth() + "/2018   " + datetime.getHours() + ":" + datetime.getMinutes() + ":" + datetime.getSeconds());
                        transdatetimeText.setBounds(290, 290, 300, 30);
                        p4b.add(transdatetimeText);

                        JLabel pointBalance = new JLabel("Your rewards point balance for JomPay Payment is 0");
                        pointBalance.setBounds(50, 320, 300, 30);
                        p4b.add(pointBalance);

                        JButton printButton = new JButton("Print");
                        printButton.setBackground(Color.ORANGE);
                        printButton.setForeground(Color.WHITE);
                        printButton.setBounds(300, 350, 61, 20);
                        p4b.add(printButton);

                        JButton okButton = new JButton("OK");
                        okButton.setBackground(Color.ORANGE);
                        okButton.setForeground(Color.WHITE);
                        okButton.setBounds(370, 350, 53, 20);
                        p4b.add(okButton);

                        okButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent ae) {
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?" + "user=root&password=");
                                    Statement stmt = con.createStatement();

                                    String fromaccount = accountCBox.getSelectedItem().toString();
                                    String billercode = billercodeField.getText();
                                    String ref1 = ref1Field.getText();
                                    String ref2 = ref2Field.getText();
                                    String amount = amountField.getText();
                                    String balance = balanceText.getText();

                                    String query = "insert into payment (FromAccount, BillerCode, Ref1, Ref2, AmountRM, BalanceAfterTransferRM) values('" + fromaccount + "','" + billercode + "','" + ref1 + "','" + ref2 + "','" + amount + "','" + balance + "')";
                                    stmt.execute(query);
                                    JOptionPane.showMessageDialog(null, "Insert Added!");
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                    e.printStackTrace();
                                }

                                try {
                                    if (stmt != null) {
                                        stmt.close();
                                        con.close();
                                    }
                                } catch (SQLException e) {
                                    System.out.println(e.getMessage());
                                    e.printStackTrace();
                                }
                            }
                        });

                        add(p4b);

                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                add(pan1);
                                p1a.setVisible(false);
                                p2a.setVisible(false);
                                p3a.setVisible(false);
                                p4a.setVisible(false);
                                pan1.revalidate();
                                pan1.repaint();
                                pan1.setVisible(false);
                            }
                        });
                    }
                });

                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        add(pan);
                        p1.setVisible(false);
                        p2.setVisible(false);
                        p3.setVisible(false);
                        p4.setVisible(false);
                        pan.revalidate();
                        pan.repaint();
                        pan.setVisible(false);
                    }
                });
            }
        });
    }

    public static void main(String[] args) {
        JomPayPayment projectipt = new JomPayPayment();
        projectipt.setTitle("Welcome to i-Muamalat");
        projectipt.setSize(1366, 768);
        projectipt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        projectipt.setVisible(true);
    }

}
