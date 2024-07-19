package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField , fnameTextField,emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JDateChooser dateChooser;
    JRadioButton male, female, other, married, unmarried, other2;
    SignupOne(){
        setLayout(null);
        
        Random ran= new Random();
        random= Math.abs((ran.nextLong()% 9000L)+1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. "+ random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140,20, 600, 40);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290,80, 400, 30);
        add(personalDetails);
        
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 200, 30);
        add(name);
        
        nameTextField= new JTextField();
        nameTextField.setFont(new Font("Arial", Font.BOLD, 14));
        nameTextField.setBounds(320, 140, 400, 30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnameTextField= new JTextField();
        fnameTextField.setFont(new Font("Arial", Font.BOLD, 14));
        fnameTextField.setBounds(320, 190, 400, 30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
       dateChooser = new JDateChooser();
       dateChooser.setBounds(320, 240, 400, 30);
       dateChooser.setForeground(new Color(105,105,105));
       add(dateChooser);
        
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        male= new JRadioButton("Male");
        male.setBounds(320, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female= new JRadioButton("Female");
        female.setBounds(430, 290, 80, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        other= new JRadioButton("Other");
        other.setBounds(560, 290, 80, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup gendergroup= new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);
        
        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        emailTextField= new JTextField();
        emailTextField.setFont(new Font("Arial", Font.BOLD, 14));
        emailTextField.setBounds(320, 340, 400, 30);
        add(emailTextField);
        
        JLabel  marital= new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
     
        married= new JRadioButton("Married");
        married.setBounds(320, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried= new JRadioButton("Unmarried");
        unmarried.setBounds(430, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other2= new JRadioButton("Other");
        other2.setBounds(560, 390, 80, 30);
        other2.setBackground(Color.WHITE);
        add(other2);
             
        ButtonGroup maritalgroup= new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other2);
        
        JLabel  address= new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        addressTextField= new JTextField();
        addressTextField.setFont(new Font("Arial", Font.BOLD, 14));
        addressTextField.setBounds(320, 440, 400, 30);
        add(addressTextField);
        
        JLabel city= new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        cityTextField= new JTextField();
        cityTextField.setFont(new Font("Arial", Font.BOLD, 14));
        cityTextField.setBounds(320, 490, 400, 30);
        add(cityTextField);
        
        JLabel  state= new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        stateTextField= new JTextField();
        stateTextField.setFont(new Font("Arial", Font.BOLD, 14));
        stateTextField.setBounds(320, 540, 400, 30);
        add(stateTextField);
        
        JLabel pincode= new JLabel("Pin Code: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        pinTextField= new JTextField();
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        pinTextField.setBounds(320, 590, 400, 30);
        add(pinTextField);
        
        next= new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(640, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno= ""+random;//long to string
        String name= nameTextField.getText();
        String fname= fnameTextField.getText();
        String dob= ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender= null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }else if(other.isSelected()){
            gender= "Other";
        }
        
        String email= emailTextField.getText();
        String marital= null;
        if(married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }else if(other2.isSelected()){
            marital="Other";
        }
        
        String address= addressTextField.getText();
        String city= cityTextField.getText();
        String state= stateTextField.getText();
        String pincode= pinTextField.getText();
        
        try{
            if ((name.equals("")) || (dob.equals("")) || (email.equals("")) || (address.equals("")) || (city.equals("")) || (state.equals("")) || (pincode.equals("")) ){
                JOptionPane.showMessageDialog(null, "Please fill all fields");
            }else{
                Conn c= new Conn();
                String query= "insert into signup values('"+ formno +"', '"+ name +"', '" + fname + "', '"+ dob+ "', '" + gender + "', '"+ email+ "', '"+ marital+ "', '" + address + "', '"+ city + "', '"+ state+ "', '"+ pincode+ "')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args){
        new SignupOne();
    }
         
}
