import javax.swing.*;
import java.awt.event.*;

public class Gui implements ActionListener{
    JButton Login;
    JFrame jf;
    JLabel Username;
    JLabel Password;
    JTextField EnterUsername;    
    JPasswordField EnterPassword;
    
    
    Gui(){
        
        jf = new JFrame("Swing");
        jf.setSize(100, 100);
        jf.setVisible(true);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        Username = new JLabel("Username");
        Username.setBounds(10, 25, 75, 25);
        
        
        
        EnterUsername = new JTextField();
        EnterUsername.setBounds(95, 25, 100, 20);
        
        
        Password = new JLabel("Password");
        Password.setBounds(10, 50, 75, 25);
        
        JPasswordField EnterPassword;
        EnterPassword = new JPasswordField();
        EnterPassword.setBounds(95, 50, 100, 20);
        
        
        Login = new JButton("login");
        Login.setBounds(55,100,75,25);
        
        
        jf.add(Username);
        jf.add(EnterUsername);
        jf.add(Password);
        jf.add(EnterPassword);
        jf.add(Login);
        
        
    }
    public void actionPerformed(ActionEvent e){
        String s1 = EnterUsername.getText();
        String s2 = EnterPassword.getText();
        
    }
    public static void main(String[] args) {

        Gui gf = new Gui();
            
    }
    
}
