import java.awt.*;
import java.awt.event.*;

public class Awt extends Frame implements ActionListener{
    public TextField name;
    Awt(){
        //Frame
        setSize(400,300);
        setTitle("Learn button");
        setLayout(null);
        setVisible(true);

        //button
        Button b = new Button("Click me");
        b.setBounds(150,100,80,30);
        add(b);
        b.addActionListener(this);
        
        //Textfield
        name = new TextField();
        name.setBounds(150,50,75,25);
        add(name);

        //Label
        Label l = new Label("Employee name");
        l.setBounds(20,100,80,50);
        add(l);

    }
    public void actionPerformed(ActionEvent e)
    {
        name.setText("Welcome");
    }
    public static void main(String args[])
    {
        Awt f = new Awt();
    }
}