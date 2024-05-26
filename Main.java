import java.util.*;
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException
    {
        Scanner kb = new Scanner(System.in);
        boolean loop = true;
        while(loop)
        {
            System.out.println("Choose any one\n1.Taxi Booking\n2.Taxi Details\n3.Exit");
            int n = kb.nextInt();
            switch(n)
            {
                case 1:
                {
                    System.out.println("Pickup Location");
                    char pickupLocation = kb.next().charAt(0);
                    System.out.println("Drop Location:");
                    char dropLocation = kb.next().charAt(0);
                    System.out.println("Pickup Time:");
                    int pickupTime = kb.nextInt();
                    System.out.print(TaxiBooking.booking(pickupLocation,dropLocation,pickupTime));
                    break;
                }
                case 2:
                {
                    TaxiBooking.Display();
                    break;
                }
                case 3:
                {
                    loop = false;
                    System.out.println("Thank You!");
                    kb.close();
                    break;
                }
            }
        }

    }
}
