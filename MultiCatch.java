class MultiCatch {
   
public static void main(String args[]) {
int a = 10;//args.length;
int k,b;
  try {
      k = Integer.parseInt("5");  
    System.out.println("a = " + a);
    int c[] = { 1,2,5,5 };
    System.out.println("c = "+ c[3]);
    c[3] = 99;
    System.out.println("c = " + c[3]);
    b = 42 % k;
    System.out.println("b = " + b);
}
catch(ArithmeticException e) {
System.out.println("Divide by 0:  " + e);
k=10;
b = 42 / k;
System.out.println("b = " + b);
} 
catch(ArrayIndexOutOfBoundsException e) {
System.out.println(e);
}
catch(Exception e) {
 System.out.println(e);
}    
 
System.out.println("After try/catch blocks.");
}
}