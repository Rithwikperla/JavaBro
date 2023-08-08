import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class InvalidNumber extends Exception{
    public String toString(){
        return "Number length less than 10";
    }
}
class Contact{
    double MobileNumber;
    String ContactName;
    String ContactType;

    public Contact(double number, String name, String type){

        MobileNumber = number;
        ContactName = name;
        ContactType = type;
    }

}
class ContactManagement implements ActionListener{
    
    JRadioButton ContactType1,ContactType2;
    JFrame gui;
    JLabel ContactNameLabel,ContactNumberLabel;
    JTextField ContactNameField,ContactNumberField;
    JButton Addcontact,Search,DisplayAll;
    JTextArea ShowDet;


    TreeSet<Contact> det = new TreeSet<Contact>(new Comparator<Contact>() {
        public int compare(Contact c1, Contact c2) {
            double dif = c1.MobileNumber - c2.MobileNumber;
            return (int)dif ; 
        }
    });
    
    ContactManagement(){
    gui = new JFrame("Contacts");
    gui.setSize(700, 500);
    gui.setVisible(true);
    gui.setLayout(null);
    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    
    ContactNameLabel = new JLabel("Contact Name: ");
    ContactNameLabel.setBounds(20, 50, 150, 30);
    gui.add(ContactNameLabel);

    ContactNameField = new JTextField();
    ContactNameField.setBounds(180, 50, 100, 30);
    gui.add(ContactNameField);

    ContactNumberLabel = new JLabel("Contact Number: ");
    ContactNumberLabel.setBounds(20, 90, 120, 30);
    gui.add(ContactNumberLabel);

    ContactNumberField = new JTextField();
    ContactNumberField.setBounds(180, 90, 100, 30);
    gui.add(ContactNumberField); 
    
    ContactType1 = new JRadioButton("Family");
    ContactType1.setBounds(20, 150, 100, 30);
    gui.add(ContactType1);

    ContactType2 = new JRadioButton("Office");
    ContactType2.setBounds(120, 150, 100, 30);
    gui.add(ContactType2);   
    
    ButtonGroup bg = new ButtonGroup();
    bg.add(ContactType1);
    bg.add(ContactType2);

    Addcontact = new JButton("Add");
    Addcontact.setBounds(40, 200, 100, 30);
    gui.add(Addcontact);
    Addcontact.addActionListener(this);
    
    Search = new JButton("Search");
    Search.setBounds(150, 200, 100, 30);
    gui.add(Search);
    Search.addActionListener(this);

    DisplayAll = new JButton("Display");
    DisplayAll.setBounds(100, 250, 100, 30);
    gui.add(DisplayAll);
    DisplayAll.addActionListener(this);
    
    ShowDet = new JTextArea();
    ShowDet.setBounds(400,50, 200, 200);
    gui.add(ShowDet);
   
    }

    public static void main(String args[]){
        new ContactManagement();
    }
    public int compareTo(Contact c){
        return 0;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == Addcontact){
            try{
            String name = ContactNameField.getText();
            double number = Double.parseDouble(ContactNumberField.getText());
            String type = " ";
            if(ContactNumberField.getText().length()<10){
                throw new InvalidNumber();
            }
            JOptionPane.showMessageDialog(null,"Clicked");
            if(ContactType1.isSelected()){
                type = "Family";
            }
            else{
                type = "Office";
            }
            Contact c = new Contact(number,name,type);
            ShowDet.append("Successfully added.");
            det.add(c);
            ShowDet.append("Success.");
        }
        catch(Exception e1)
        {
            JOptionPane.showMessageDialog(null, e1 + " ");
        }
        }
        if(e.getSource() == Search){
            
            double number = Double.parseDouble(ContactNumberField.getText());
            ShowDet.setText("");
            for(Contact c : det){
                if(c.MobileNumber == number){
                    ShowDet.append(c.ContactName + " " + Double.valueOf(c.MobileNumber).toString() + " " + c.ContactType + "\n" );
                }
            }

        }
        if(e.getSource() == DisplayAll){
            ShowDet.setText(" ");
            for(Contact c : det){
                ShowDet.append(c.ContactName + " " + Double.valueOf(c.MobileNumber).toString() + " " + c.ContactType + "\n" );
                
            }
        }
    }
}