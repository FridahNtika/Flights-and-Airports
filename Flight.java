import java.util.Scanner;

/**
 * Flight represents an airline flight with various properties such as it's 
 * origin and destination cities, the name of the airline and the flight
 * number
 *
 * @Fridah Karimi Ntika
 * @09/22/2022
 */

public class Flight
{
    // Declaring instance variables
    private String airline;
    private int flightNumber;
    private String origin;
    private String destination;

    /**
     * Constructor for objects of class Flight that takes the flight 
     * @param airline, flight number, origin city, destination
     */
    public Flight(String line, int number, String originatingCity, String 
    destinationCity)
    {
        // initialise instance variables
        airline = line;
        flightNumber = number; 
        origin = originatingCity;
        destination = destinationCity;
    }
    
    /**
     * Returns the flight's airline
     */
    public String getAirline()
    {
        return airline;
    }
    
    /**
     * Sets the flight's airline
     * @param the airline
     */
    public void setAirline(String line)
    {
        airline = line;
    }
    
    /**
     * Returns the flight's number
     */
    public int getFlightNumber()
    {
        return flightNumber;
    }
    
    /**
     * Sets the flight's number
     * @param the flight number
     */
    public void setFlightNumber(int f1num)
    {
        flightNumber = f1num;
    }
    
    /**
     * Returns the flight's origin
     */
    public String getOrigin()
    {
        return origin;
    }

    /**
     * Sets the flight's origin
     * @param the from city
     */
    public void setOrigin(String fromCity)
    {
        origin = fromCity;
    }
    
    
    /**
     * Returns the flight's destination
     */
    public String getDestination()
    {
        return destination;
    }
    
    /**
     * Sets the flight's destination
     * @param the destination
     */
    public void setDestination(String toCity)
    {
        destination = toCity;
    }
    
    /**
     * @param two flights
     * @return true or false if the destination of the 
     * first flight is the origin of the second
     */
    public static boolean stopOver(Flight f1, Flight f2)
    {
       if (f1.destination == f2.origin)
       {
           return true;
       }
       return false;
    }
    
    /**
     * Returns a string representation of a flight
     */
    public String toString()
    {
        // creates a string using all instance variables and returns it
        String s = "Welcome to flight " + airline + flightNumber + " from " + origin 
        + " to " + destination;
        return s;
    }
    
    /**
     * Collects flight information from the user, creates a flight, 
     * and returns it
     */
    public static Flight readFlight()
    {
        //collect flight information
        Scanner scan = new Scanner(System.in);
        System.out.println("What airline will you be using? ");
        String line = scan.nextLine();
        
        System.out.println("What is your flight number? ");
        int number = scan.nextInt();
        
        System.out.println("What is your flight origin? ");
        String originatingCity = scan.next();
        
        System.out.println("What is your flight destination? ");
        String destinationCity = scan.next();
  
        //create a new flight
        Flight newFlight = new Flight(line, number, originatingCity, destinationCity);
        return newFlight;
    }
    
    /**
     * Tests the methods of class Flight
     */
    public static void main(String [] args)
    {
        Scanner newScan = new Scanner(System.in);
        
        //testing readFlight()
        System.out.println("A test for the readFlight method:");
        Flight f1 = readFlight();
        System.out.println(f1.toString());
        
        //testing the constructor
        System.out.println("A test for the constructor:");
        Flight f2 = new Flight("KQ", 777, "NBO", "NYC");
        System.out.println("The second flight f2 is: " + f2.airline 
        + f2.flightNumber + " from " + f2.origin + " to " + f2.destination);
        Flight f3 = new Flight("AA", 345, "NYC", "DC");
        
        //testing getAirline()
        System.out.println("A test for getAirline(): (KQ) got = " + 
        f2.getAirline());
        //testing getFlightNumber()
        System.out.println("A test for getFlightNumber(): (777) got = " 
        + f2.getFlightNumber());
        //testing getOrigin()
        System.out.println("A test for getOrigin(): (NYC) got = " + f3.getOrigin());
        //testing getDestination()
        System.out.println("A test for getDestination(): (DC) got = " 
        + f3.getDestination());
        
        //testing stopOver()
        boolean test = stopOver(f2, f3);
        if (test)
        {
            System.out.println("Flights " + f2.airline + f2.flightNumber 
            + " from " + f2.origin + " to " + f2.destination + " and " + 
            f3.airline + f3.flightNumber + " from " + f3.origin + " to " 
            + f3.destination + " share a stopver city (TRUE): " + test);
        }
        else
        {
            System.out.println("Flights " + f2.airline + f2.flightNumber + 
            " from " + f2.origin + " to " + f2.destination + " and " + f3.airline 
            + f3.flightNumber + " from " + f3.origin + " to " + f3.destination 
            + " share a stopver city (FALSE): " + test);
        }
        
        //testing setDestination()
        f1.setDestination("AUH");
        System.out.println("A test for setDestination(f1): " + f1.getDestination());
        
        //testing setOrigin()
        f1.setOrigin("ALY");
        System.out.println("A test for setOrigin(f1): " + f1.getOrigin());
        
        //testing the changes made
        System.out.println("Testing changes made to flight f1: " + f1.airline 
        + f1.flightNumber + " from " + f1.origin + " to " + f1.destination); 
        
        //testing stopOver()
        boolean test2 = stopOver(f1, f3);
        if (test2)
        {
            System.out.println("Flights " + f1.airline + f1.flightNumber + 
            " from " + f1.origin + " to " + f1.destination + " and " + f3.airline 
            + f3.flightNumber + " from " + f3.origin + " to " + f3.destination + 
            " share a stopver city (TRUE): " + test2);
        }
        else
        {
            System.out.println("Flights " + f1.airline + f1.flightNumber + " from " 
            + f1.origin + " to " + f1.destination + " and " + f3.airline + f3.flightNumber 
            + " from " + f3.origin + " to " + f3.destination + " share a stopver city (FALSE): " 
            + test2);
        }
    }
}
