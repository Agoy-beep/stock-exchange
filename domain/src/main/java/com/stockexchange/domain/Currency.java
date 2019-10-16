package com.stockexchange.domain;

public enum Currency {
    EUR("euro", '€'),
    USD("dollar", '$'),
    GBP("pound", '£');

    private final String label;
    private final char symbol;

    Currency(String label, char symbol) {
        this.label = label;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "label='" + label + '\'' +
                '}';
    }
}
