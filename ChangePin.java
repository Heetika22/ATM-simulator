package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class ChangePin extends JFrame implements ActionListener {
    
    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;
    ChangePin(String pinnumber){
        this.pinnumber= pinnumber;
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0, 900, 900);
        add(image);
        
        JLabel text= new JLabel("CHANGE YOUR PIN:");
        text.setBounds(250, 280, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        JLabel pintext= new JLabel("NEW PIN:");
        pintext.setBounds(165, 330, 180, 25);
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(pintext);
        
        pin= new JPasswordField();
        pin.setBounds(330, 330, 150, 25);
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(pin);
        
        JLabel repintext= new JLabel("RE-ENTER NEW PIN:");
        repintext.setBounds(165, 380, 180, 25);
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(repintext);
        
        repin= new JPasswordField();
        repin.setBounds(330, 380, 150, 25);
        repin.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(repin);
        
        change= new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);
        
        back= new JButton("BACK");
        back.setBounds(165, 485, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true); 
    }
    
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== change){
            try{
                String npin= pin.getText();
                String rpin= repin.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                
                if(npin.equals("") || rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter PIN");
                    return;
                }

                Conn conn= new Conn();
                String query1 = "update bank set pin= '" + rpin +"' where pin='" + pinnumber +"'";
                String query2 = "update login set pin= '" + rpin +"' where pin='" + pinnumber +"'";
                String query3 = "update signupthree set pin= '" + rpin +"' where pin='" + pinnumber +"'";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, " PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);

            }catch(Exception e){
                    System.out.println(e);
            }
            
        }else if (ae.getSource()== back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args){
        new ChangePin("").setVisible(true);
    }
    
}
