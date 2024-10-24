package edu.ntnu.iir.bidata;

import java.time.LocalDate;

public class Ingredient { // Dette er en klasse for ingredienser
  private String name; // Navn er en string
  private double amount; // Mengde er en double fordi det kan være desimaltall
  private Unit unit;
  private LocalDate expiryDate;
  private double price;

  public Ingredient(String name, double amount, Unit unit, LocalDate expiryDate, double price) {
    this.name = name;
    this.amount = amount;
    this.unit = unit;
    this.expiryDate = expiryDate;
    this.price = price;
  }

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
