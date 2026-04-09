package btd.boards;    

public enum StateCell {
    EMPTY("   "),
    PATH_START(" ○ "),
    PATH_END(" ➔ "),
    PATH(" ─ "),
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