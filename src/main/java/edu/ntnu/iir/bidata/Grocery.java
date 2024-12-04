package edu.ntnu.iir.bidata;

import java.time.LocalDate;

/**
 * Class for Grocery. Contains name, amount, unit, expiry date and price. The class also
 * contains getters for the different fields.
 */
public class Grocery {

  private int quantity;
  private final String name;
  private final double amount;
  private final Unit unit;
  private LocalDate expiryDate;
  private double price;

  /**
   * Constructor for the Grocery class.
   *
   * @param quantity   Quantity of the grocery.
   * @param name       Name of the grocery.
   * @param amount     Amount of the grocery.
   * @param unit       Unit of the grocery.
   * @param expiryDate Expiry date of the grocery.
   * @param price      Price of the grocery.
   */
  public Grocery(
      int quantity, String name, double amount, Unit unit, LocalDate expiryDate, double price) {
    this.quantity = quantity;
    this.name = name;
    this.amount = amount;
    this.unit = unit;
    this.expiryDate = expiryDate;
    this.price = price;
  }


  /**
   * Constructor for the Grocery class. Used when adding grocery to a recipe.
   *
   * @param name   Name of the grocery.
   * @param amount Amount of the grocery.
   * @param unit   Unit of the grocery.
   */
  public Grocery(String name, double amount, Unit unit) {
    this.name = name;
    this.amount = amount;
    this.unit = unit;
  }

  /**
   * Getter for the quantity of the grocery.
   *
   * @return Quantity of the grocery.
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Setter for the quantity of the grocery.
   *
   * @param quantity Quantity of the grocery.
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * Getter for the name of the grocery.
   *
   * @return Name of the grocery.
   */
  public String getName() {
    return name;
  }

  /**
   * Getter for the amount of the grocery.
   *
   * @return Amount of the grocery.
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Getter for the unit of the grocery.
   *
   * @return Unit of the grocery.
   */
  public Unit getUnit() {
    return unit;
  }

  /**
   * Getter for the expiry date of the grocery.
   *
   * @return Expiry date of the grocery.
   */
  public LocalDate getExpiryDate() {
    return expiryDate;
  }

  /**
   * Getter for the price of the grocery.
   *
   * @return Price of the grocery.
   */
  public double getPrice() {
    return price;
  }

  /**
   * Returns a string representation of the grocery.
   *
   * @return String representation of the grocery.
   */
  public String toString() {
    return quantity
        + " | "
        + name
        + " | "
        + amount
        + " "
        + unit.getSymbol()[1]
        + " | "
        + expiryDate
        + " | "
        + price
        + " kr";
  }
}
