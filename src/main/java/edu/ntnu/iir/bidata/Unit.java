package edu.ntnu.iir.bidata;

public enum Unit {
  GRAM("g"),
  LITER("l"),
  PIECE("stk");

  private final String symbol;

  Unit(String symbol) {
    this.symbol = symbol;
  }

  public String getSymbol() {
    return symbol;
  }

  public static Unit fromString(String symbol) {
    for (Unit unit : Unit.values()) {
      if (unit.getSymbol().equalsIgnoreCase(symbol)) {
        return unit;
      }
    }
    throw new IllegalArgumentException("Ugyldig enhet: " + symbol);
  }
}
