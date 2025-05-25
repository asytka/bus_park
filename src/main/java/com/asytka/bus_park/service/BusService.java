package com.asytka.bus_park.service;

import com.asytka.bus_park.model.Bus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusService {
    private final List<Bus> stationBuses = new ArrayList<>();
    private final List<Bus> routeBuses = new ArrayList<>();

    public List<Bus> getStationBuses() {
        return stationBuses;
    }

    public List<Bus> getRouteBuses() {
        return routeBuses;
    }

    public void addToStation(Bus bus) {
        stationBuses.add(bus);
    }

    public void moveToRoute(String number) {
        stationBuses.removeIf(bus -> {
            if (bus.getNumber().equals(number)) {
                routeBuses.add(bus);
                return true;
            }
            return false;
        });
    }
}
