/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

/**
 * This object represents a non-member.
 * @author Rohan Zahid
 */
public class NonMember extends Passenger {
    /**
     * Creates a non-member.
     * @param name The passenger's name.
     * @param age The passenger's age.
     */
    public NonMember(String name, int age) {
        super(name, age);
    }
    
    @Override
    /**
     * Applies a discount to the given price depending on the passenger's age.
     * @param p
     */
    public double applyDiscount(double p) {
        if (this.getAge() >  65)
                return (p - p*0.1);
        return p;
    }
}
