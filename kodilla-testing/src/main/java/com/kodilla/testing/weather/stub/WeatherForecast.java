package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {
        double sum = 0.0;
        Map<String, Double> temps = temperatures.getTemperatures();

        for (double temp : temps.values()) {
            sum += temp;
        }
        return sum / temps.size();
    }
    public double calculateMedianTemperature() {
        double sum = 0.0;
        List<Double> tempList = new ArrayList<>();
        Map<String, Double> temp = temperatures.getTemperatures();
        for (Double tempValue : temp.values()) {
            tempList.add(tempValue);
        }
        Collections.sort(tempList);
        int s = tempList.size();
        double median = s % 2 != 0
                ? tempList.get(s / 2)
                : (tempList.get(s / 2) + tempList.get((s / 2) -1))/2 ;
        return median;
    }
}