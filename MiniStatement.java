package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class MiniStatement extends JFrame {
    
    MiniStatement(String pinnumber){
        
        setTitle("Mini Statement");
        setLayout(null);
       
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);      
        JLabel icon= new JLabel(i3);
        icon.setBounds(90,10,50,50);
        add(icon);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setFont(new Font("Raleway", Font.BOLD, 16));
        bank.setBounds(150,30, 100, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setFont(new Font("Raleway", Font.BOLD, 15));
        card.setBounds(20,80, 300, 20);
        add(card);
        
        JLabel stmt = new JLabel("Your Transactions: ");
        stmt.setFont(new Font("Raleway", Font.BOLD, 15));
        stmt.setBounds(20,120, 300, 20);
        add(stmt);
        
        
        try{
            Conn conn = new Conn();
            ResultSet rs= conn.s.executeQuery("Select * from login where pin= '"+ pinnumber+ "'");
            while(rs.next()){
                card.setText("Card Number: "+ rs.getString("card_number").substring(0,4)+"XXXXXXXX"+ rs.getString("card_number").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        JLabel mini = new JLabel();
        mini.setFont(new Font("Raleway",Font.PLAIN, 15));
        add(mini);
        
        JLabel bal = new JLabel();
        bal.setFont(new Font("Raleway", Font.BOLD, 15));
        bal.setBounds(20, 400, 400,20);
        add(bal);
        
        try{
            int balance=0;
            Conn conn = new Conn();
            ResultSet rs= conn.s.executeQuery("Select * from bank where pin= '"+ pinnumber+ "'");
            while(rs.next()){
                mini.setText(mini.getText()+ "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("amount")+"<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance+= Integer.parseInt(rs.getString("amount"));
                }else{
                    balance-= Integer.parseInt(rs.getString("amount"));
                }
            }
            bal.setText("Your current account Balance is Rs "+ balance);
        }catch(Exception e){
            System.out.println(e);
        }
       
        mini.setBounds(20, 140, 400,300);
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
    }
    
    public static void main(String[] args){
        new MiniStatement("");
    }
}
