package btd;    

public enum StateCell {
    EMPTY("."),
    PATH("X"),
    TOWER("T");

    private String symbol;

    private StateCell(String symbol) {
        this.symbol = symbol;
    }

    public String toString() {
        return this.symbol;
    }
}