/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;
import java.io.*; 
import java.util.*; 
/**
 * A very simple model of a flight booking system.
 * @author Rohan Zahid
 */

public class Manager {
    private ArrayList<Flight> flights = new ArrayList<Flight>();
    private ArrayList<Ticket> issuedTickets = new ArrayList<Ticket>();
    
    /**
     * Creates various flights.
     */
    public void createFlights() {
        flights.add(new Flight(1000, "Toronto", "Kolkata", "03/02/99 7:50 pm", 200, 600));
        flights.add(new Flight(1010, "Toronto", "Seoul", "03/02/99 8:50 pm", 290, 750));
        flights.add(new Flight(942, "Toronto", "London", "12/02/94 9:50 am", 2, 5000));
        flights.add(new Flight(2010, "Kolkata", "Toronto", "03/02/99 8:50 pm", 290, 750));
        flights.add(new Flight(2011, "Kolkata", "London", "08/02/99 8:00 am", 82, 1000));
        flights.add(new Flight(2012, "Kolkata", "Seoul", "18/03/99 4:00 am", 25, 1500));
        flights.add(new Flight(952, "London", "Seoul", "12/02/94 9:50 am", 2, 50));
        flights.add(new Flight(953, "London", "Kolkata", "12/02/94 6:50 am", 1, 500));
        flights.add(new Flight(954, "London", "Toronto", "01/02/94 3:50 am", 25, 1));
        flights.add(new Flight(888, "Seoul", "London", "09/02/84 12:50 am", 99, 60));
        flights.add(new Flight(889, "Seoul", "Toronto", "10/02/84 12:50 am", 99, 60));
        flights.add(new Flight(890, "Seoul", "Kolkata", "11/02/84 12:50 am", 99, 60));
    }
    
    /**
     * Displays all available flights from the origin to the destination.
     * @param origin
     * @param destination
     */
    public void displayAvailableFlights(String origin, String destination) {
        boolean isFlight = false;
        for(int i = 0; i < flights.size(); i++) {
            if(flights.get(i).getOrigin().equalsIgnoreCase(origin) && flights.get(i).getDestination().equalsIgnoreCase(destination) && flights.get(i).getNumberOfSeatsLeft() > 0) {
                System.out.println("\n" + flights.get(i));
                isFlight = true;
            }               
        }
        if(isFlight == false) {
            System.out.println("\nSorry, there are no flights from " + origin + " to " + destination + ".");
            throw new IllegalArgumentException();
        } 
    }
    
    /**
     * Returns the flight corresponding to the flight number.
     * @param flightNumber
     */
    public Flight getFlight(int flightNumber) {
        for(int i = 0; i < flights.size(); i++) {
            if(flights.get(i).getFlightNumber() == flightNumber)
                return flights.get(i);
        }
        throw new IllegalArgumentException("The requested flight does not exist.");
    }
    
    /**
     * Books a seat on the flight corresponding to the flight number for the given passenger.
     * @param flightNumber
     * @param p
     */
    public void bookSeat(int flightNumber, Passenger p) {
        Ticket t;
        if(getFlight(flightNumber).bookASeat() == true){
            t = new Ticket(p, getFlight(flightNumber), p.applyDiscount(getFlight(flightNumber).getOriginalPrice()));
            issuedTickets.add(t);
            System.out.println("\nThe following ticket has been purchased:\n" + t);
        } 
        else
            throw new IllegalArgumentException("The flight is full.");     
    }
    
    /**
     * Allows the user to purchase ticket(s) while providing necessary information.
     * @param args 
     */
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        Manager m = new Manager();
        m.createFlights();
        Passenger p = null;
        int age = 0, yearsOfMembership, flightNum;
        String origin, destination, name, yesorno;
        boolean quit = false;
        
        do {
            System.out.print("Welcome to Air Canada. Please enter your name.\n");
            //scan.nextLine();
            name = scan.nextLine();
            System.out.println("\nPlease enter your age.");
            boolean done = false;
            
            do {
                try {
                    age = scan.nextInt();
                    done = true;
                }
                catch(InputMismatchException e) {
                    System.out.println("\nPlease enter a valid age.");
                    scan.next();
                }
            } while(done == false);
            
            do {
                System.out.println("\nAre you a member of the Air Rewards program?(Y/N)");
                yesorno = scan.next();
            } while(!yesorno.equalsIgnoreCase("y") && !yesorno.equalsIgnoreCase("n"));
            
            if(yesorno.equalsIgnoreCase("y")) {
                System.out.println("\nHow many years have you been a member?");
                done = false;
            
                do {
                    try {
                        yearsOfMembership = scan.nextInt();
                        p = new Member(name, age, yearsOfMembership);
                        done = true;
                    }
                    catch(InputMismatchException e) {
                        System.out.println("\nPlease enter a valid number.");
                        scan.next();
                    }
                } while(done == false);
                    
                    
                }
            else {
                p = new NonMember(name, age);
            }
            done = false;
            do {
                try {
                    System.out.println("\nWe have flights from: Toronto, Kolkata, London, and Seoul.");
                    System.out.println("Where are you traveling from?");
                    origin =  scan.next();
                    System.out.println("\nWe have flights to: Toronto, Kolkata, London, and Seoul.");
                    System.out.println("Where do you want to travel?");
                    destination = scan.next();
                    m.displayAvailableFlights(origin, destination);
                    done = true;
                }
                catch(IllegalArgumentException e) {
                    System.out.println("Please enter a valid origin and destination.");
                    //scan.next();
                }
            } while(done == false);
            
            System.out.println("\nEnter a flight number");
            done = false;
            do {
                try {
                    m.bookSeat(scan.nextInt(), p);
                    done = true;
                }
                catch(InputMismatchException e) {
                    System.out.println("\nPlease enter a valid flight number.");
                    scan.next();
                }
                catch(IllegalArgumentException e) {
                    System.out.println("\nPlease enter a valid flight number.");
                    //scan.next();
                }
            } while(done == false);
            
            
            do {
                System.out.println("\nDo you want to buy another ticket?(Y/N)");
                yesorno = scan.next();
                scan.nextLine();
            } while(!yesorno.equalsIgnoreCase("y") && !yesorno.equalsIgnoreCase("n"));
            if(yesorno.equalsIgnoreCase("y")) {
                System.out.println("");
                quit = false;
            }
            else {
                System.out.println("\nHere is your receipt.");
                for(Ticket item: m.issuedTickets)
                    System.out.println(item.getNumber() + ": " + item.toString());
                System.out.println("\nThank you for trusting Air Canada with your travel needs!\nHave a great day!");
                quit = true;
            }
        } while (quit == false);
        
        
    }
}
