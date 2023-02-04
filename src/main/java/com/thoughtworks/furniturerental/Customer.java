package com.thoughtworks.furniturerental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement(String type) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        for (Rental rentedItem : rentals) {
            double thisAmount = 0;
            //determine amounts for rentedItem line
//            rentedItem.getTotalAmount()
            switch (rentedItem.getFurniture().getPriceCode()) {
                case Furniture.REGULAR:
                    thisAmount += 200;
                    if (rentedItem.getDaysRented() > 2)
                        thisAmount += (rentedItem.getDaysRented() - 2) * 150;
                    break;
                case Furniture.NEW_LAUNCH:
                    thisAmount += rentedItem.getDaysRented() * 300;
                    break;
                case Furniture.CHILDREN:
                    thisAmount += 150;
                    if (rentedItem.getDaysRented() > 3)
                        thisAmount += (rentedItem.getDaysRented() - 3) * 150;
                    break;
            }
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two days new launch rental
            if ((rentedItem.getFurniture().getPriceCode() == Furniture.NEW_LAUNCH) && rentedItem.getDaysRented() > 1)
                frequentRenterPoints++;

            //show figures for this rental
            totalAmount += thisAmount;
        }

        Statement statement = new Statement(getName(), totalAmount, frequentRenterPoints);
        statement.generate(type);
        //add footer lines result
        return statement.generate(type);
    }
}

