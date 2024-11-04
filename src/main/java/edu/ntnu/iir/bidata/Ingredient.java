package edu.ntnu.iir.bidata;

import java.time.LocalDate;

/**
 * Class for ingredients. Contains name, amount, unit, expiry date and price. The class also
 * contains getters for the different fields.
 */
public class Ingredient {
  private int quantity;
  private String name;
  private double amount;
  private Unit unit;
  private LocalDate expiryDate;
  private double price;

  /**
   * Constructor for the Ingredient class.
   *
   * @param quantity Quantity of the ingredient.
   * @param name Name of the ingredient.
   * @param amount Amount of the ingredient.
   * @param unit Unit of the ingredient.
   * @param expiryDate Expiry date of the ingredient.
   * @param price Price of the ingredient.
   */
  public Ingredient(
      int quantity, String name, double amount, Unit unit, LocalDate expiryDate, double price) {
    this.quantity = quantity;
    this.name = name;
    this.amount = amount;
    this.unit = unit;
    this.expiryDate = expiryDate;
    this.price = price;
  }

  /**
   * Getter for the quantity of the ingredient.
   *
   * @return Quantity of the ingredient.
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Setter for the quantity of the ingredient.
   *
   * @param quantity Quantity of the ingredient.
   */
  public int setQuantity(int quantity) {
    this.quantity = quantity;
    return quantity;
  }

  /**
   * Getter for the name of the ingredient.
   *
   * @return Name of the ingredient.
   */
  public String getName() {
    return name;
  }

  /**
   * Getter for the amount of the ingredient.
   *
   * @return Amount of the ingredient.
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Getter for the unit of the ingredient.
   *
   * @return Unit of the ingredient.
   */
  public Unit getUnit() {
    return unit;
  }

  /**
   * Getter for the expiry date of the ingredient.
   *
   * @return Expiry date of the ingredient.
   */
  public LocalDate getExpiryDate() {
    return expiryDate;
  }

  /**
   * Getter for the price of the ingredient.
   *
   * @return Price of the ingredient.
   */
  public double getPrice() {
    return price;
  }

  /**
   * Returns a string representation of the ingredient.
   *
   * @return String representation of the ingredient.
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
