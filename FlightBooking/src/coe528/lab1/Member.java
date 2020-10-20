/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

/**
 * This object represents a member.
 * @author Rohan Zahid
 */
public class Member extends Passenger {
    private int yearsOfMembership;
    
    /**
     * Creates a member.
     * @param name The passenger's name.
     * @param age The passenger's age.
     * @param yearsOfMembership The number of years a passenger has been a member.
     */
    public Member(String name, int age, int yearsOfMembership) {
        super(name, age);
        this.yearsOfMembership = yearsOfMembership;
    }
    
    @Override
    /**
     * Applies a discount to the given price depending on the number of years a passenger has been a member.
     * @param p
     */
    public double applyDiscount (double p) {
        if(yearsOfMembership > 5)
            return (p - p*0.5);
        if(yearsOfMembership > 1)
            return (p - p*0.1);
        return p;          
    }
}
