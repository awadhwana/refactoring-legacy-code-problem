package com.thoughtworks.furniturerental;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    @Test
    public void shouldReturnThestatement() {
        String customerName = "ankit";
        String expected = "Rental Record for " + customerName + "\n";
        double totalAmount = 0.0;
        int frequentRenterPoints = 0;
        expected += "Amount owed is " + totalAmount + "\n";
        expected += "You earned " + frequentRenterPoints
                + " frequent renter points";
        Customer customer = new Customer(customerName);


        String statement = customer.statement("");

        assertEquals(expected, statement);
    }

    @Test
    public void shouldReturnThestatementAsHTMLString() {
        String customerName = "ankit";
        double totalAmount = 0.0;
        int frequentRenterPoints = 0;
        String expected = "<div>" + "\n" + "<h1>Rental Record for <b>" + customerName + "</b></h1>" + "\n" +
                "<p>Amount owed is <bold>" + totalAmount + "<bold></p>" + "\n" +
                "<p>You earned <bold>" + frequentRenterPoints + "<bold> frequent renter points</p> " + "\n"
                + "</div>";
        Customer customer = new Customer(customerName);


        String statement = customer.statement("html");

        assertEquals(expected, statement);
    }
}
