import java.util.*;

public class TaxiBooking
{
    private static ArrayList<Taxi> taxiList = new ArrayList<Taxi>();
    private static int taxiListLimit = 4,idGenerator = 1;
    private static ArrayList<Taxi> taxiBookingHistory = new ArrayList<Taxi>();

    public static String booking(char pickupLocation,char dropLocation,int pickupTime) throws CloneNotSupportedException
    {
        if(taxiList.size()<taxiListLimit){
            taxiList.add(new Taxi());
        }

        int min = Integer.MAX_VALUE;
        Taxi taxiReady = null;

        for(Taxi t:taxiList)
        {
            if(t.getDropLocation()<=pickupTime && Math.abs(pickupLocation-t.getCurrentLocation())<=min)
            {
                if(Math.abs(pickupLocation - t.getCurrentLocation())==min)
                {
                    if(taxiReady!=null && t.getEarnings()<taxiReady.getEarnings()){
                        taxiReady = t;
                    }
                }
                else
                {
                    taxiReady = t;
                    min = Math.abs(pickupLocation - t.getCurrentLocation());
                }
            }
        }

        if(taxiReady!=null)
        {
            taxiReady.setCustomerId(idGenerator++);
            taxiReady.setPickupTime(pickupTime);
            taxiReady.setPickupLocation(pickupLocation);
            taxiReady.setDropLocation(dropLocation);
            taxiReady.setCurrentLocation(dropLocation);
            taxiReady.setDropTime(pickupTime + Math.abs(pickupLocation-dropLocation));
            taxiReady.setEarnings((taxiReady.getEarnings())+(Math.abs(dropLocation-pickupLocation)*15-5)*10+100);
            taxiReady.setTaxiId(taxiList.indexOf(taxiReady)+1);
            taxiBookingHistory.add((Taxi)taxiReady.clone());
        }

        return taxiReady!=null?"Taxi number "+taxiReady.getTaxiId()+" is booked!":"Taxi is not available";
    }

    public static void Display()
    {
        System.out.println("----------------");
        for(Taxi t:taxiBookingHistory)
        {
            System.out.println(t.toString());
            System.out.println("---------------");
        }
    }

}
