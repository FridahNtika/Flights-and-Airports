
/**
 * Airport keeps track of the flights of the flights that use a certain, 
 * either as their origin or destination.
 *
 * @author Janice Preko & Fridah Ntika
 * @version 09/24/2022
 */
public class Airport
{
    // instance variables
    protected String airportName;
    protected Flight flights [];
    protected int maxCapacity = 5;
    protected int flightCount;

    /**
     * Constructor for objects of class Airport
     * @param airport name
     */
    //ask in OH
    public Airport(String airportName)
    {
        //initialise instance variables
        flights = new Flight[maxCapacity];
        flightCount = 0;
        this.airportName = airportName;
    }

    /**
     * Takes a Flight as input, and adds it to the array of Flights.
     *
     * @param a Flight
     */
    public void addFlight(Flight f)
    {
        //checks if airport is at capacity and if not, adds the flight
        if (flightCount != maxCapacity)
        {
            flights[flightCount] = f;
            flightCount ++;
        }
        else
        {
            System.out.println("Sorry, we are at full capacity. Please check back later.");
        }
    }

    /**
     * takes in the name of an airline, and returns all the 
     * flights of this airline that use this airport
     *
     * @param an airline
     * @return an array of flights
     */
    public Flight [] findFlightsByAirline(String airline)
    {
        //loops through the Flights array to check for flights with this airline
        Flight [] airlineFlights = new Flight[maxCapacity];
        for (int i = 0; i < flights.length; i++)
        {
            if (flights[i].getAirline() != null)
            {
                if (flights[i].getAirline().equals(airline))
                {
                    airlineFlights[i] = flights[i];
                }
            }
            else
            {
                continue;
            }
        }
        return airlineFlights;
    }

    /**
     * given the name of an airline, it prints all the flights of this 
     * airline that are using this airport
     *
     * @param an airline
     */
    public void printFlightsByAirline(String airline)
    {
        //check our flights array and find flights with this name
        //get all the flights
        System.out.println("These are the flights of " + 
            airline + " using this airport");
            
               
        for (int i = 0; i < flightCount; i++)
        {
            if (findFlightsByAirline(airline)[i] != null)
            {
                System.out.println(findFlightsByAirline(airline)[i]);
            }
        }
    }

    /**
     * returns the capacity of the airport
     * 
     * @return integer
     */
    public int getCapacity()
    {
        //returns how many flights the airport can accommodate
        return flights.length;
    }

    /**
     * returns the number of flights currently using the airport
     * 
     * @return integer
     */
    public int getNumFlights()
    {
        //finds the flights registered
        return flightCount;
    }

    /**
     * provides a String representation of an object of type Airport.
     * @return string representation of this airport
     */
    public String toString()
    {
        String fString = " "; 
        //looping through flights array to get the actual flights
        for (int i = 0; i < flightCount; i++)
        {
            fString += "\n" + flights[i];
        }

        String s = "The airport " + airportName + " has a capacity of " +
            getCapacity() + " flights and currently serves " + 
            getNumFlights() + " flights.\nThe flights are:" + fString ;

        return s;
    }

    /**
     * tests the methods of the Airport class.
     *
     */
    public static void main(String [] args)
    {
        //creates a new airport and flights
        Airport Logan = new Airport("BOS");
        System.out.println("Creating a new airport BOS");
        Flight f1 = new Flight("KQ", 777, "BOS", "NYC");
        Flight f2 = new Flight("UA", 342, "LAX", "BOS");
        Flight f3 = new Flight("UA", 343, "BOS", "SKS");
        Flight f4 = new Flight("UA", 344, "CANCUN", "BOS");
        Flight f5 = new Flight("AA", 346, "DC", "BOS");
        Flight f6 = new Flight("AA", 346, "BOS", "DC");

        System.out.println("\nTesting addFlight():");
        Logan.addFlight(f1);
        Logan.addFlight(f2);
        Logan.addFlight(f3);
        Logan.addFlight(f4);
        Logan.addFlight(f5);
        System.out.println(Logan.toString());
        System.out.println("Testing addFlight() when at capacity with Flight: " + f6 + ".");
        Logan.addFlight(f6);
      
        
        System.out.println();
        System.out.println("Testing printFlightsByAirline():");
        Logan.printFlightsByAirline("UA");
        
        
        
        System.out.println();
        System.out.println("Testing printFlightsByAirline():");
        Logan.printFlightsByAirline("AA");
    }
}
