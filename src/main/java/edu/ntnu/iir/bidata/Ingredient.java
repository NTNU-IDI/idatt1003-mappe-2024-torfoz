package edu.ntnu.iir.bidata;

import java.time.LocalDate;

public class Ingredient { // Dette er en klasse for ingredienser
  private String name; // Navn er en string så ingrediensen kan
  private double amount; // Mengde er en double fordi det kan være desimaltall
  private Unit unit;  // Enhet er en enum, fordi det er en begrenset mengde enheter. Bruker SI-enheter
  private LocalDate expiryDate; // Bruker LocalDate for å kun godta riktig datoformat, og den tar også hensyn til skuddår og måneder med ulikt antall dager.
  private double price; // Pris er en double fordi det kan være desimaltall

  // Konsruktør for ingredienser med navn, mengde, enhet, utløpsdato og pris

  public Ingredient(String name, double amount, Unit unit, LocalDate expiryDate, double price) {
    this.name = name;
    this.amount = amount;
    this.unit = unit;
    this.expiryDate = expiryDate;
    this.price = price;
  }

  // Get metoder for å hente ut informasjon om ingrediensen

  public String getName() {
    return name;
  }

  public double getAmount() {
    return amount;
  }

  public Unit getUnit() {
    return unit;
  }

  public LocalDate getExpiryDate() {
    return expiryDate;
  }

  public double getPrice() {
    return price;
  }
}
