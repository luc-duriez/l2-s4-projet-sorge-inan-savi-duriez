package btd.boards;    

/** Enum for cell states */
public enum StateCell {
    /** Empty cell */
    EMPTY(" "),
    /** Path cell */
    PATH("x"),
    /** Tower cell */
    TOWER("T");

    private String symbol;

    private StateCell(String symbol) {
        this.symbol = symbol;
    }

    public String toString() {
        return this.symbol;
    }
}