/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

/**
 * This object represents a ticket.
 * @author Rohan Zahid
 */
public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private double price;
    private int number;
    private static int num = 1;
    
    /**
     * Creates a ticket.
     * @param p The passenger.
     * @param flight The flight.
     * @param price The price of the ticket.
     */
    public Ticket(Passenger p, Flight flight, double price) {
        this.passenger = p;
        this.flight = flight;
        this.price = price;
        number = num++;
    }
    
    /**
     * Returns the passenger.
     *
     * @return passenger
     */
   public Passenger getPassenger() {
       return passenger;
   }
   
   /**
     * Sets the passenger.
     *
     * @param p
     */
   public void setPassenger(Passenger p) {
       this.passenger = p;
   }
   
   /**
     * Returns the flight.
     *
     * @return flight
     */
   public Flight getFlight() {
       return flight;
   }
   
   /**
     * Sets the flight.
     *
     * @param flight
     */
   public void setFlight(Flight flight) {
       this.flight = flight;
   }
   
   /**
     * Returns the price.
     *
     * @return price
     */
   public double getPrice() {
       return price;
   }
   
   /**
     * Returns the ticket's number.
     *
     * @return number
     */
   public int getNumber() {
       return number;
   }
   
   /**
     * Sets the ticket's number.
     *
     * @param number
     */
   public void setNumber(int number) {
       this.number = number;
   }
   
   /**
     * Sets the price.
     *
     * @param price
     */
   public void setPrice(double price) {
       this.price = price;
   }
   
   /**
     * Returns the String representation of the ticket.
     *
     * @return s
     */
   public String toString() {
       String s = passenger.getName() + ", " + flight.toString() + ", ticket price: $" + price;
       return s;
   }
}
