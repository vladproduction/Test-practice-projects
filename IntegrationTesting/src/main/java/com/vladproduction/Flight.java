package com.vladproduction;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Flight {

	private String flightNumber;
    private int places;
	private String origin;
    private String destination;
    private boolean flying;
    private boolean takenOff;
    private boolean landed;
    Set<Passenger> passengerSet = new HashSet<>();

    private String flightNumberRegex = "^[A-Z]{2}\\d{3,4}$";
    private Pattern pattern = Pattern.compile(flightNumberRegex);

	public Flight(String flightNumber, int places) {
        Matcher matcher = pattern.matcher(flightNumber);
        if(!matcher.matches()) {
            throw new RuntimeException("Invalid flight number");
        }
		this.flightNumber = flightNumber;
		this.places = places;
		this.flying = false;
        this.takenOff = false;
        this.landed = false;
	}

	public String getFlightNumber() {
            return flightNumber;
	}

    public int getPlaces() {
            return places;
    }

    public void setPlaces(int places) {
        if(passengerSet.size() > places){
            throw new RuntimeException("Cannot reduce number of places under the number ogf existing passengers!");
        }
        this.places = places;
    }

    public int getPassengersNumber() {
        return passengerSet.size();
    }

    public boolean addPassenger(Passenger passenger){
        sellTicket(passenger);
        return passengerSet.add(passenger);
    }

    public boolean removePassenger(Passenger passenger){
        return passengerSet.remove(passenger);
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        if(takenOff){
            throw new RuntimeException("Flight cannot change its origin any longer!");
        }
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        if(landed){
            throw new RuntimeException("Flight cannot change its destination any longer!");
        }
        this.destination = destination;
    }

    public boolean isFlying() {
        return flying;
    }

    public boolean isTakenOff() {
        return takenOff;
    }

    public boolean isLanded() {
        return landed;
    }

    @Override
    public String toString() {
        return "Flight " + getFlightNumber() + " from " + getOrigin() + " to " + getDestination();
    }

    private void sellTicket(Passenger passenger) {
        if(passengerSet.size() >= places) {
            throw new RuntimeException("Not enough places!");
        }
        System.out.println("Ticket for " + this + " sold to " + passenger);
    }

    public void takeOff() {
	    System.out.println(this + " is taking off");
	    flying = true;
        takenOff = true;
    }

    public void land() {
        System.out.println(this + " is landing");
        flying = false;
        landed = true;
    }

}
