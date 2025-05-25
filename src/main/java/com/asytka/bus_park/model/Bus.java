package com.asytka.bus_park.model;

public class Bus {
    private String number;
    private String driver;
    private String route;

    public Bus(String number, String driver, String route) {
        this.number = number;
        this.driver = driver;
        this.route = route;
    }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public String getDriver() { return driver; }
    public void setDriver(String driver) { this.driver = driver; }

    public String getRoute() { return route; }
    public void setRoute(String route) { this.route = route; }
}
