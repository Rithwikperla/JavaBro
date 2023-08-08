import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Beneficiary {
    int beneficiaryId, principalAmount, CarpetArea, NoOfYears;

    Beneficiary(int id,int amt,int area,int years) {
        beneficiaryId = id;
        principalAmount = amt;
        CarpetArea = area;
        NoOfYears = years;
    }}

class HomeLoan {
    ArrayList<Beneficiary> customers = new ArrayList<Beneficiary>();
    Beneficiary b1;
    void push(int id,int amt,int area,int years){
        
        b1 =  new Beneficiary(id,amt,area,years);
        customers.add(b1);
    }

    void eligibilityForSubsidy() {
            if(b1.principalAmount < 3500000 && b1.CarpetArea < 30){
                b1.principalAmount =  b1.principalAmount - 260000; 
    }
}
    float calculateEMI(){

            eligibilityForSubsidy();
            float rate_of_interest = 7.4f;
            float interest = b1.principalAmount * b1.NoOfYears * rate_of_interest; 
            float EMI = (b1.principalAmount + interest)/(b1.NoOfYears * 12);
        return EMI;

    }
}

public class EMI_GUI extends JFrame implements ActionListener {
        JFrame gui;
        JLabel IdentificationNumberLabel, PrincipalAmountLabel, CarpetAreaLabel, NoOfYearsLabel;
        JTextField IdentificationNumberField, PrincipalAmountField, CarpetAreaField, NoOfYearsField;
        JButton SubmitButton;
        JTextArea ShowDetails;
        HomeLoan h = new HomeLoan();

    EMI_GUI() {
        gui = new JFrame("Emi calculator");
        gui.setSize(400, 400);
        gui.setVisible(true);
        gui.setLayout(null);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        IdentificationNumberLabel = new JLabel("Identification Number: ");
        IdentificationNumberLabel.setBounds(20, 50, 150, 30);
        gui.add(IdentificationNumberLabel);

        IdentificationNumberField = new JTextField();
        IdentificationNumberField.setBounds(180, 50, 100, 30);
        gui.add(IdentificationNumberField);

        PrincipalAmountLabel = new JLabel("Principal Amount: ");
        PrincipalAmountLabel.setBounds(20, 90, 120, 30);
        gui.add(PrincipalAmountLabel);

        PrincipalAmountField = new JTextField();
        PrincipalAmountField.setBounds(180, 90, 100, 30);
        gui.add(PrincipalAmountField);

        CarpetAreaLabel = new JLabel("Carpet area:");
        CarpetAreaLabel.setBounds(20, 130, 100, 30);
        gui.add(CarpetAreaLabel);

        CarpetAreaField = new JTextField();
        CarpetAreaField.setBounds(180, 130, 100, 30);
        gui.add(CarpetAreaField);

        NoOfYearsLabel = new JLabel("No of years: ");
        NoOfYearsLabel.setBounds(20, 170, 100, 30);
        gui.add(NoOfYearsLabel);

        NoOfYearsField = new JTextField();
        NoOfYearsField.setBounds(180, 170, 100, 30);
        gui.add(NoOfYearsField);

        SubmitButton = new JButton("Submit");
        SubmitButton.setBounds(100, 240, 75, 30);
        SubmitButton.addActionListener(this);
        gui.add(SubmitButton);

        ShowDetails = new JTextArea();
        ShowDetails.setBounds(300, 40, 100, 200);
        gui.add(ShowDetails);
        setVisible(true);
        
    }

    public static void main(String args[]) {
        new EMI_GUI();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SubmitButton) {
            int id_no = Integer.parseInt(IdentificationNumberField.getText());
            int amt = Integer.parseInt(PrincipalAmountField.getText());
            int area = Integer.parseInt(CarpetAreaField.getText());
            int years = Integer.parseInt(NoOfYearsField.getText());

            h.push(id_no,amt,area,years);
            float emi = h.calculateEMI();
            ShowDetails.setText(" "+ emi);

        }
        
    }

}