package edu.ntnu.iir.bidata;

// Enum for SI-enheter med aliaser

public enum Unit {
  GRAM("g", "gram"),
  LITER("l", "liter"),
  PIECE("stk", "stykker");

  private final String[] symbol;

  // Konstruktør for enhetene

  Unit(String... symbol) {
    this.symbol = symbol;
  }

  // Get metode for å hente ut enhetens symbol

  public String[] getSymbol() {
    return symbol;
  }

  /* Metode som sjekker om input er en gyldig enhet
  Itererer gjennom alle enhetene og sammenligner input med enhetens symbol
*/
  public static Unit fromString(String symbol) {
    for (Unit unit : Unit.values()) {
      for (String s : unit.getSymbol()) {
        if (s.equalsIgnoreCase(symbol)) {
          return unit;
        }
      }
    }
    throw new IllegalArgumentException("Ugyldig enhet: " + symbol);
  }
}
