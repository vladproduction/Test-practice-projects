package com.vladproduction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    @Test
    public void testFlightCreation(){
        Flight flight = new Flight("AA123", 100);
        assertNotNull(flight);
    }

    @Test
    public void testInvalidFlightNumber(){
        assertThrows(RuntimeException.class,
                ()->{
                    Flight flight = new Flight("AA12", 100);
                });

        assertThrows(RuntimeException.class,
                ()->{
                    Flight flight = new Flight("AA1234567", 100);
                });
    }

    @Test
    public void testValidFlightNumber() {
        Flight flight = new Flight("AA345", 100);
        assertNotNull(flight);
        flight = new Flight("AA3456", 100);
        assertNotNull(flight);
    }

    @Test
    public void testSellTickets() {
        Flight flight = new Flight("AA1234", 50);
        flight.setOrigin("London");
        flight.setDestination("Bucharest");
        for(int i = 0; i < flight.getPlaces(); i++) {
            flight.sellTicket();
        }
        assertEquals(50, flight.getPassengers());
        assertThrows(RuntimeException.class,
                ()->{
                    flight.sellTicket();
                });
    }

    @Test
    public void testSetInvalidPlaces() {
        Flight flight = new Flight("AA1234", 50);
        flight.setOrigin("London");
        flight.setDestination("Bucharest");
        for(int i = 0; i < flight.getPlaces(); i++) {
            flight.sellTicket();
        }
        assertEquals(50, flight.getPassengers());
        assertThrows(RuntimeException.class,
                ()->{
                    flight.setPlaces(49);
                });
    }

    @Test
    public void testSetValidPlaces() {
        Flight flight = new Flight("AA1234", 50);
        flight.setOrigin("London");
        flight.setDestination("Bucharest");
        for(int i=0; i<flight.getPlaces(); i++) {
            flight.sellTicket();
        }
        assertEquals(50, flight.getPassengers());
        flight.setPlaces(52);                                 //trying to increase number of places
        assertEquals(52, flight.getPlaces());
    }

    @Test
    public void testChangeOrigin() {
        Flight flight = new Flight("AA1234", 50);
        flight.setOrigin("London");
        flight.setDestination("Bucharest");
        flight.takeOff();
        assertEquals(true, flight.isFlying());
        assertEquals(true, flight.isTakenOff());
        assertEquals(false, flight.isLanded());
        assertThrows(RuntimeException.class,
                ()->{
                    flight.setOrigin("Manchester");
                });
    }

    @Test
    public void testLand() {
        Flight flight = new Flight("AA1234", 50);
        flight.setOrigin("London");
        flight.setDestination("Bucharest");
        flight.takeOff();
        assertEquals(true, flight.isTakenOff());
        assertEquals(false, flight.isLanded());
        flight.land();
        assertEquals(true, flight.isTakenOff());
        assertEquals(true, flight.isLanded());
        assertEquals(false, flight.isFlying());
    }

    @Test
    public void testChangeDestination() {
        Flight flight = new Flight("AA1234", 50);
        flight.setOrigin("London");
        flight.setDestination("Bucharest");
        flight.takeOff();
        flight.land();
        assertThrows(RuntimeException.class,
                ()->{
                    flight.setDestination("Sibiu");
                });
    }


}