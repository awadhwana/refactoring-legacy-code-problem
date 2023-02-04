package com.thoughtworks.furniturerental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatementTest {
    @Test
    public void shouldGenerateSimpleStringByDefault() {
        String customerName = "ankit";
        double totalAmount = 0.0;
        int frequentRenterPoints = 0;
        Statement customerStatement = new Statement(customerName,totalAmount, frequentRenterPoints);
        String expected = "Rental Record for " + customerName + "\n";
        expected += "Amount owed is " + totalAmount + "\n";
        expected += "You earned " + frequentRenterPoints
                + " frequent renter points";

        String actual = customerStatement.generate("");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGenerateHTMLString() {
        String customerName = "ankit";
        double totalAmount = 0.0;
        int frequentRenterPoints = 0;
        Statement customerStatement = new Statement(customerName,totalAmount, frequentRenterPoints);
        String expected = "<div>" + "\n" + "<h1>Rental Record for <b>" + customerName + "</b></h1>" + "\n" +
                "<p>Amount owed is <bold>" + totalAmount + "<bold></p>" + "\n" +
                "<p>You earned <bold>" + frequentRenterPoints + "<bold> frequent renter points</p> " + "\n"
                + "</div>";

        String actual = customerStatement.generate("html");

        assertEquals(expected, actual);
    }

}
