package kodilla.com.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FindFlight {
    public boolean findFlight(Flight flight) throws RouteNotFoundException{
        Map<String, Boolean> airports = new HashMap<>();
        airports.put("JFK", true);
        airports.put("LAX", true);
        airports.put("ORD", false);
        airports.put("WAW", true);
        airports.put("NYC",true);

        if (!airports.containsKey(flight.getArrivalAirport())) {
            throw new RouteNotFoundException("Not found flight to " + flight.getArrivalAirport());

        }
        return airports.get(flight.getArrivalAirport());

    }
}
