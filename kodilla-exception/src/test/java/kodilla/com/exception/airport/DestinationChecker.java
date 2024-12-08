package kodilla.com.exception.airport;

import java.util.HashMap;
import java.util.Map;

public class DestinationChecker {

    private Map<String, Boolean> availableDestinations = new HashMap<>();

    // Dodawanie dostępności lotniska
    public void addDestination(String airport, boolean isAvailable) {
        availableDestinations.put(airport, isAvailable);
    }

    // Sprawdzanie, czy lot na dane lotnisko jest możliwy
    public boolean isFlightAvailable(Flight flight) throws RouteNotFoundException {
        if (!availableDestinations.containsKey(flight.getArrivalAirport())) {
            throw new RouteNotFoundException("Lotnisko " + flight.getArrivalAirport() + " nie istnieje.");
        }
        return availableDestinations.get(flight.getArrivalAirport());
    }
}