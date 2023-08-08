import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class Student{
	String name;
	long reg_no;
	int total_score;
	int no_of_quizzes;
	float average;
	Student()
	{
		name="";
	    reg_no=0;
	   	total_score=0;
	  	no_of_quizzes=0;
      	average=0f;
	}
}
class NullException extends Exception
{
	public String toString()
	{
		return ("fill all the details");
	}
}
public class QuizManagement extends JFrame implements ActionListener{
JTextField t1,t2,t3,t4,t5;
JLabel l1,l2,l3,l4,l5;
JButton add,search,movf,movl,movp,movn,display;
JTextArea txtar;
int i;
ArrayList<Student> al=new ArrayList<>();
QuizManagement()
{
	setVisible(true);
	setLayout(null);
	setSize(1000,1000);
	setDefaultCloseOperation(3);
	l1=new JLabel("student name");
	l1.setBounds(50,50,100,30);
	add(l1);
	t1=new JTextField(30);
	t1.setBounds(150,50,100,30);
	add(t1);
	l2=new JLabel("reg_no");
	l2.setBounds(50,90,100,30);
	add(l2);
	t2=new JTextField(30);
	t2.setBounds(150,90,100,30);
	add(t2);
	l3=new JLabel("total_score");
	l3.setBounds(50,130,100,30);
	add(l3);
	t3=new JTextField(30);
	t3.setBounds(150,130,100,30);
	add(t3);
	l4=new JLabel("no_of_quizzes");
	l4.setBounds(50,170,100,30);
	add(l4);
	t4=new JTextField(30);
	t4.setBounds(150,170,100,30);
	add(t4);
	l5=new JLabel("reg_no search");
	l5.setBounds(300,300,100,30);
	add(l5);
	t5=new JTextField(30);
	t5.setBounds(410,300,100,30);
	add(t5);
	add=new JButton("add");
	add.setBounds(50,200,100,30);
	add(add);
	search=new JButton("search");
	search.setBounds(170,200,100,30);
	add(search);
	movf=new JButton("movf");
	movf.setBounds(280,200,100,30);
	add(movf);
	movp=new JButton("movp");
	movp.setBounds(390,200,100,30);
	add(movp);
	movn=new JButton("movn");
	movn.setBounds(500,200,100,30);
	add(movn);
	movl=new JButton("movl");
	movl.setBounds(610,200,100,30);
	add(movl);
	display=new JButton("Display");
	display.setBounds(550,300,100,30);
	add(display);
	txtar=new JTextArea();
	txtar.setBounds(800,100,100,400);
	add(txtar);
	add.addActionListener(this);
	search.addActionListener(this);
    display.addActionListener(this);
    movf.addActionListener(this);
    movp.addActionListener(this);
    movn.addActionListener(this);
    movl.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
	for(Student value :al)
	{
		value.average=value.total_score/value.no_of_quizzes;
	}
	if(ae.getSource()==add)
	{
		txtar.setText("");
		Add(t1.getText(),t2.getText(),t3.getText(),t4.getText());
		
	}
	if(ae.getSource()==search)
		{
	    txtar.setText(" ");
		Search(t5.getText());
	}
	if(ae.getSource()==movp)
	{   
		i=i-1;
		txtar.setText("");
		System.out.println(i);
	{   
        
		txtar.append("\nname :"+al.get(i).name+"\n"+"reg_no :"+al.get(i).reg_no+"\n"+"total+score :"+al.get(i).total_score+"\n"+"no_of_quizzes :"+al.get(i).no_of_quizzes+"\n"+"average :"+al.get(i).average);
	}
	}
	if(ae.getSource()==movn)
	{   
		i=i+1;
		txtar.setText("");
		System.out.println(i);
	{   
        
		txtar.append("\nname :"+al.get(i).name+"\n"+"reg_no :"+al.get(i).reg_no+"\n"+"total+score :"+al.get(i).total_score+"\n"+"no_of_quizzes :"+al.get(i).no_of_quizzes+"\n"+"average :"+al.get(i).average);
	}
	}
	if(ae.getSource()==movf)
	{   
		i=0;
		txtar.setText("");
		System.out.println(i);
	{   
        
		txtar.append("\nname :"+al.get(i).name+"\n"+"reg_no :"+al.get(i).reg_no+"\n"+"total+score :"+al.get(i).total_score+"\n"+"no_of_quizzes :"+al.get(i).no_of_quizzes+"\n"+"average :"+al.get(i).average);
	}
	}
	if(ae.getSource()==movl)
	{   
		i=al.size();
		i=i-1;
		txtar.setText("");
		System.out.println(i);
	{   
        
		txtar.append("\nname :"+al.get(i).name+"\n"+"reg_no :"+al.get(i).reg_no+"\n"+"total+score :"+al.get(i).total_score+"\n"+"no_of_quizzes :"+al.get(i).no_of_quizzes+"\n"+"average :"+al.get(i).average);
	}
	}
}


void Add(String s1,String s2,String s3,String s4) 
{ try {
	Student s=new Student();
	s.name=s1;
	s.reg_no=Long.parseLong(s2);
	s.total_score=Integer.parseInt(s3);
	s.no_of_quizzes=Integer.parseInt(s4);
	al.add(s);
	txtar.setText("successfully added!!!");
	i=al.indexOf(s);
	if(s1==null||s2==null||s3==null||s4==null)
	{
		throw new NullException();
	}
}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null,e.toString());
	}
}
void Search(String s1)
{
	for(Student value:al)
	{
		if(value.reg_no==Long.parseLong(s1))
		{
			txtar.append("name :"+value.name+"\n"+"reg_no :"+value.reg_no+"\n"+"total+score :"+value.total_score+"\n"+"no_of_quizzes :"+value.no_of_quizzes+"\n"+"average :"+value.average);
		}
	}
}
public static void main(String[] args)
{
	 new QuizManagement(); 
}
}