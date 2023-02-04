package com.thoughtworks.furniturerental;

public class Statement {
    private final String name;
    private final double totalAmount;
    private final int frequentRenterPoints;

    public Statement(String name, double totalAmount, int frequentRenterPoints) {
        this.name = name;
        this.totalAmount = totalAmount;
        this.frequentRenterPoints = frequentRenterPoints;
    }

    private String toDefaultString() {
        String result = "Rental Record for " + this.name + "\n";
        result += "Amount owed is " + this.totalAmount + "\n";
        result += "You earned " + this.frequentRenterPoints + " frequent renter points";
        return result;
    }

    private String toHTMLString() {
        String result = "<div>" + "\n" + "<h1>Rental Record for <b>" + this.name + "</b></h1>" + "\n" +
                "<p>Amount owed is <bold>" + this.totalAmount + "<bold></p>" + "\n" +
                "<p>You earned <bold>" + this.frequentRenterPoints + "<bold> frequent renter points</p> " + "\n"
                + "</div>";
        return result;
    }

    public String generate(String type) {
        if ("html".equalsIgnoreCase(type)) {
            return this.toHTMLString();
        }
        return this.toDefaultString();
    }
}
