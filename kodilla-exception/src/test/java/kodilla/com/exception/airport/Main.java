package kodilla.com.exception.airport;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        DestinationChecker destinationChecker = new DestinationChecker();


        destinationChecker.addDestination("JFK", true);
        destinationChecker.addDestination("LAX", true);
        destinationChecker.addDestination("ORD", false);
        destinationChecker.addDestination("WAW", true);


        Flight flight1 = new Flight("WAW", "JFK");
        Flight flight2 = new Flight("WAW", "ORD");
        Flight flight3 = new Flight("WAW", "LHR");

        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);

        for (Flight flight : flightList) {

            try {
                boolean canFly = destinationChecker.isFlightAvailable(flight);
                System.out.println(canFly ? "Flight to " + flight.getArrivalAirport() + " is possible." : "Flight to " + flight.getArrivalAirport() + " is not possible.");
            } catch (RouteNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

