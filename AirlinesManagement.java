import java.util.Scanner;

class Airlines{
    String PassengerName;
    int Passenger_no;
    int Flight_no;
    String Destination;
    String Source;
    Scanner sc = new Scanner(System.in);
    public Airlines()
    {
        PassengerName = "none";
        Passenger_no = 0000;
        Flight_no = 0000;
        Source = "none";
        Destination = "none";
    }

    void Passenger_details()
    {
        System.out.println("Enter you Passenger id: ");
        Passenger_no = sc.nextInt();
        System.out.println("Enter you name: ");
        PassengerName = sc.next();
        System.out.println("Enter Source: ");
        Source = sc.next();
        System.out.println("Enter Destination: ");
        Destination = sc.next();
        
    }
    void Search_Passenger(){
       
    }

}

class AirlinesManagement{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("No of passengers: ");
        int n = sc.nextInt();
        Airlines[] list = new Airlines[n];
        for(int i =0;i<n;i++){
            list[i] = new Airlines();
            list[i].Passenger_details();
        }
        System.out.println("Enter your Passenger no: ");
        int Passenger_no = sc.nextInt();

        for(int i=0;i<n;i++){
            if(Passenger_no == list[i].Passenger_no)
            {
                System.out.print("Your Details:");
                System.out.print(list[i].Passenger_no);
                System.out.print(list[i].PassengerName);
                System.out.print(list[i].Source);
                System.out.print(list[i].Destination);
            }
            else
            {
                System.out.println("Passenger not found.");
            }
        }
    }

}