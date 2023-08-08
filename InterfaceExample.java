import java.util.Scanner;
interface print
{
    void printvalue();
    void getvalue();
    void welcome(String s);
}

interface cal
{
    void calculation();
}

class Welcome
{
    public void welcome(String className)
    {
        System.out.println("Welcome to" + className );
    }
}
class student extends Welcome implements print,cal
{
    Scanner s=new Scanner(System.in);
    int sno;
    String sname;
    int mark[]=new int[3];
    int tot=0;
    public void getvalue()
    {
        System.out.println("Enter Student number,name, 3marks");
        sno=s.nextInt();
        sname=s.next();
        for (int i =0;i<3;i++)
        {
            mark[i]=s.nextInt();
        }
            
          }
     public void calculation()
     {
       for (int i =0;i<3;i++)
        {
                     tot=tot+mark[i];
        }
     }       
        public void printvalue ()
    {
        System.out.println(sno+" "+sname);
        for (int i =0;i<3;i++)
        {
            System.out.println(mark[i]);
        }
            System.out.println(tot);
          }

}
class product extends Welcome implements print
{
    Scanner s=new Scanner(System.in);
    int ino;
    String iname;
    int qty;
    public void getvalue()
    {
        System.out.println("Enter product number,name, qty");
        ino=s.nextInt();
        iname=s.next();
        qty=s.nextInt();
                       
          }
        public void printvalue ()
    {
        System.out.println(ino+" "+iname);
                    System.out.println(qty);
          }

}

public class InterfaceExample
{
    public static void main(String k[])
    {
    product p=new product();
    student s1=new student();
    print ip;
    ip=p;
    cal c;
    ip.welcome("Product class");
    ip.getvalue();
    ip.printvalue();
    ip=s1;
    ip.welcome("Student");
    ip.getvalue();
    c=s1;
    c.calculation();
    ip.printvalue();
    
      
    }
   
    }