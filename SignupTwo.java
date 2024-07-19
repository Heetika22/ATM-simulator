package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

    JTextField panTextField, aadharTextField;
    JComboBox religion, category,income, occupation, education;
    JButton next;
    JRadioButton senior, notsenior, exists, notexists;
    String formno;
    
    SignupTwo(String formno){
        this.formno= formno;
        setLayout(null);
        
        setTitle("APPLICATION FORM PAGE-2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80, 400, 30);
        add(additionalDetails);
        
        JLabel rel = new JLabel("Religion: ");
        rel.setFont(new Font("Raleway", Font.BOLD, 20));
        rel.setBounds(100, 140, 200, 30);
        add(rel);
        
        String valReligion[]= {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(320, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel cat = new JLabel("Category: ");
        cat.setFont(new Font("Raleway", Font.BOLD, 20));
        cat.setBounds(100, 190, 200, 30);
        add(cat);
        
        String valCategory[]= {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(320, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel inc = new JLabel("Income: ");
        inc.setFont(new Font("Raleway", Font.BOLD, 20));
        inc.setBounds(100, 240, 200, 30);
        add(inc);
        
        String incomeCategory[]= {"Null", "< 1,50,000", "< 2,50,000", "<5,00,000", "upto 8,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(320, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel edu = new JLabel("Educational ");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100, 290, 200, 30);
        add(edu);

        JLabel qual = new JLabel("Qualification: ");
        qual.setFont(new Font("Raleway", Font.BOLD, 20));
        qual.setBounds(100, 315, 200, 30);
        add(qual);
        
        String eduCategory[]= {"Non- Graduation", "Graduate", "Post Graduate", "Doctrate", "Others"};
        education = new JComboBox(eduCategory);
        education.setBounds(320, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel  occ= new JLabel("Occupation: ");
        occ.setFont(new Font("Raleway", Font.BOLD, 20));
        occ.setBounds(100, 365, 200, 30);
        add(occ);
        
        String occupationValues[]= {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(320, 365, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        
        JLabel  pan= new JLabel("Pan Number: ");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 415, 200, 30);
        add(pan);
        
        panTextField= new JTextField();
        panTextField.setFont(new Font("Arial", Font.BOLD, 14));
        panTextField.setBounds(320, 415, 400, 30);
        add(panTextField);
        
        JLabel aadhar= new JLabel("Aadhar Number: ");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 465, 200, 30);
        add(aadhar);
        
        aadharTextField= new JTextField();
        aadharTextField.setFont(new Font("Arial", Font.BOLD, 14));
        aadharTextField.setBounds(320, 465, 400, 30);
        add(aadharTextField);
        
        JLabel  state= new JLabel("Senior Citizen: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 515, 200, 30);
        add(state);
        
        senior= new JRadioButton("Yes");
        senior.setBounds(320, 515, 100, 30);
        senior.setBackground(Color.WHITE);
        add(senior);
        
        notsenior= new JRadioButton("No");
        notsenior.setBounds(430, 515, 100, 30);
        notsenior.setBackground(Color.WHITE);
        add(notsenior);      
             
        ButtonGroup seniorgroup= new ButtonGroup();
        seniorgroup.add(senior);
        seniorgroup.add(notsenior);
        
        JLabel existing= new JLabel("Existing Account: ");
        existing.setFont(new Font("Raleway", Font.BOLD, 20));
        existing.setBounds(100, 565, 200, 30);
        add(existing);
        
        exists= new JRadioButton("Yes");
        exists.setBounds(320, 565, 100, 30);
        exists.setBackground(Color.WHITE);
        add(exists);
        
        notexists= new JRadioButton("No");
        notexists.setBounds(430, 565, 100, 30);
        notexists.setBackground(Color.WHITE);
        add(notexists);
               
        ButtonGroup maritalgroup= new ButtonGroup();
        maritalgroup.add(exists);
        maritalgroup.add(notexists);
        
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
        String sreligion= (String) religion.getSelectedItem();
        String scategory= (String) category.getSelectedItem();
        String sincome= (String) income.getSelectedItem();
        String seducation= (String) education.getSelectedItem();
        String soccupation= (String) occupation.getSelectedItem();
        String seniorCitizen= null;
        if(senior.isSelected()){
            seniorCitizen="Yes";
        }else if(notsenior.isSelected()){
            seniorCitizen="No";
        }
        
        String existing= null;
        if(exists.isSelected()){
            existing="Yes";
        }else if(notexists.isSelected()){
            existing="No";
        }
        
        String pan= panTextField.getText();
        String aadhar= aadharTextField.getText();
        
        
        try{
            Conn conn= new Conn();
            String query= "insert into signuptwo values('"+ formno +"', '"+ sreligion +"', '" + scategory + "', '"+ sincome+ "', '"+ seducation +"', '"+ soccupation+ "', '"+pan+ "', '"+ aadhar+ "', '" +seniorCitizen+ "', '" + existing+ "')";
            conn.s.executeUpdate(query);
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args){
        new SignupTwo("");
    }
         
}
