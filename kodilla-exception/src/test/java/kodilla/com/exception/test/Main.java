package kodilla.com.exception.test;

import javax.print.attribute.standard.Destination;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FindFlight flightFinder = new FindFlight();
        Flight flight1 = new Flight("WAW", "JFK");
        Flight flight2 = new Flight("KRK","WAW");
        Flight flight3 = new Flight("WAW", "KRK");
        Flight flight4 = new Flight("GDN", "KTW");
        Flight flight5 = new Flight("KTW","GDN");

//        for (Map<String,Boolean> fligth : airport) {
//
//        }
        try {
            boolean canFly = flightFinder.findFlight(flight5);
            if (canFly) {
                System.out.println("Flight to " + flight5.getArrivalAirport() + " is possible.");
            } else {
                System.out.println("Flight to " + flight5.getArrivalAirport() + " is not possible.");
            }
        } catch (RouteNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
