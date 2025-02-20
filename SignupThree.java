package bank.management.system;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    String formno;
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2 ,c3, c4, c5, c6, c7;
    JButton submit, cancel;
    SignupThree(String formno){
        this.formno= formno;
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3: Additional Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(300,40, 400, 40);
        add(l1);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100,130, 200, 30);
        add(type);
        
        r1= new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 300, 20);
        add(r1);
        
        r2= new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(450, 180, 300, 20);
        add(r2);
        
        r3= new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 300, 20);
        add(r3);
        
        r4= new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(450, 220, 300, 20);
        add(r4);
        
        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(r1);
        accountGroup.add(r2);
        accountGroup.add(r3);
        accountGroup.add(r4);
        
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100,280, 200, 30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-2356");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(450,280, 300, 30);
        add(number);
        
        JLabel cardDetails = new JLabel("Your 16 Digit Card Number");
        cardDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetails.setBounds(100,310, 300, 30);
        add(cardDetails);
        
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100,370, 200, 30);
        add(pin);
        
        JLabel pinDetails = new JLabel("Your 4 Digit PIN.");
        pinDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetails.setBounds(100,400, 300, 30);
        add(pinDetails);
        
        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pinNumber.setBounds(450,370, 300, 30);
        add(pinNumber);
        
        JLabel services = new JLabel("Services Required: ");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 460, 300, 30);
        add(services);
        
        c1= new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 510, 300, 30);
        add(c1);
        
        c2= new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(100, 550, 300, 30);
        add(c2);
        
        c3= new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 590, 300, 30);
        add(c3);
        
        c4= new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(450, 510, 300, 30);
        add(c4);
        
        c5= new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(450, 550, 200, 30);
        add(c5);
        
        
        c6= new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(450, 590, 200, 30);
        add(c6);
        
        c7= new JCheckBox("I hereby declare the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway", Font.BOLD, 16));
        c7.setBounds(100, 650, 700, 30);
        add(c7);
        
        cancel= new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(300, 700, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        submit= new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 16));
        submit.setBounds(450, 700, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType= null;
            if(r1.isSelected()){
                accountType= "Savings Account";
            }else if(r2.isSelected()){
                accountType= "Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType= "Current Account";
            }else if(r4.isSelected()){
                accountType= "Reccuring Deposit Account";
            }
            
            Random random = new Random();
            String cardNumber= "5040936"+ String.format("%09d", new Random().nextInt(1000000000));
            
            String pinNumber= String.format("%04d", new Random().nextInt(10000));
            
            String facility= "";
            
            if(c1.isSelected()){
                facility= facility+ " ATM Card,";
            }
            if(c2.isSelected()){
                facility= facility+ " Internet Banking,";
            }
            if(c3.isSelected()){
                facility= facility+ " Mobile Banking,";
            }
            if(c4.isSelected()){
                facility= facility+ " Email & SMS Alerts,";
            }
            if(c5.isSelected()){
                facility= facility+ " Cheque Book,";
            }
            if(c6.isSelected()){
                facility= facility+ " E-Statement";
            }
            
            try{
                if(accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the Fields");
                }else{
                    Conn conn= new Conn();
                    String query1= "insert into signupthree values('"+ formno + "', '" + accountType + "', '"+ cardNumber + "', '" + pinNumber + "', '" + facility + "')";
                    String query2= "insert into login values('" + formno + "', '"+ cardNumber + "', '"+ pinNumber+ "')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: "+ cardNumber + "\n Pin:"+ pinNumber);   
                    
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }
                   
            
        }else if(ae.getSource()== cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new SignupThree("");
    }
}
