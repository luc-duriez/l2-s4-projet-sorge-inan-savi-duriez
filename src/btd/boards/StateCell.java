package btd.boards;    

public enum StateCell {
    EMPTY("   "),
    PATH("  \u001B[38;5;94m█\u001B[0m"),
    TOWER("  ♜"); // symbole par défaut

    private String symbol;

    StateCell(String symbol) {
        this.symbol = symbol;
    }

    public void setSymbol(String symbol) { // setter dynamique
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return this.symbol;
    }
}