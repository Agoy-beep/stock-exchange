package domain;

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

    /**
     * Singleton? NAAH
     */
}
