package btd.boards;    

public enum StateCell {
    EMPTY("   "),
    PATH(""),

    // --- PIÈCES DU CHEMIN CONTINU ---
    PATH_H("───"),         // Ligne horizontale
    PATH_V(" │ "),         // Ligne verticale
    
    // --- VIRAGES ---
    PATH_CORNER_LD("─┐ "), // (Left -> Down)
    PATH_CORNER_TR(" └─"), // (Top -> Right)
    PATH_CORNER_LU("─┘ "), // (Top -> Left)
    PATH_CORNER_BR(" ┌─"), // (Left -> Down)
    
    TOWER("  T");

    private final String symbol;

    private StateCell(String symbol) {
        this.symbol = symbol;
    }

    public String toString() {
        return this.symbol;
    }
}