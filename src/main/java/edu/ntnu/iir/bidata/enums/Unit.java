package edu.ntnu.iir.bidata.enums;

/**
 * Enum for the unit of an ingredient. Contains the symbol and the name of the unit.
 */
public enum Unit {
  GRAM("g", "gram"),
  LITER("l", "liter"),
  PIECE("pcs", "piece"),;

  private final String[] symbol;

  /**
   * Constructor for the Unit enum.
   *
   * @param symbol The symbol of the unit.
   */
  Unit(String... symbol) {
    this.symbol = symbol;
  }

  /**
   * Getter for the symbol of the unit.
   *
   * @return The symbol of the unit.
   */
  public String[] getSymbol() {
    return symbol;
  }

  /**
   * Method for getting the Unit enum from a string.
   *
   * @param symbol The symbol of the unit.
   * @return The Unit enum.
   */
  public static Unit fromString(String symbol) {
    for (Unit unit : Unit.values()) {
      for (String s : unit.getSymbol()) {
        if (s.equalsIgnoreCase(symbol)) {
          return unit;
        }
      }
    }
    throw new IllegalArgumentException("Invalid unit: " + symbol);
  }
}
