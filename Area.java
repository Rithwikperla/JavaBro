class Circle{
    public double x,y,r;
    //constructors 
    public Circle(double centerX,double centerY, double radius){
        x = centerX;
        y = centerY;
        r = radius;
    }
    public Circle(double radius){
        x = 0;
        y = 0;
        r = radius;
    }
    public Circle(){
        x = 0;
        y = 0;
        r = 1;
    }
    public double circumference(){
        return 2*3*3.14;
    }
    public double area(){
        return 3.14*r*r;
    }
}
class Area{
    public static void main(String args[]){
        Circle CircleA = new Circle(10,12,20);
        Circle CircleB = new Circle();
        Circle CircleC = new Circle(10.0);

        double area = CircleA.area();
        double circumference = CircleA.circumference();

        System.out.println("Area: " +area+"\nCircumference: " + circumference );
        area = CircleB.area();
        circumference = CircleB.circumference();

        System.out.println("Area: " +area+"\nCircumference: " + circumference );
        area = CircleC.area();
        circumference = CircleC.circumference();

        System.out.println("Area: " +area+"\nCircumference: " + circumference );
    }
}