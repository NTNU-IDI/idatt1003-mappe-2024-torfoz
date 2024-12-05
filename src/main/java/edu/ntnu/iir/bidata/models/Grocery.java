package edu.ntnu.iir.bidata.models;

import edu.ntnu.iir.bidata.enums.Unit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Class for Grocery. This class is used to define the groceries used in the Fridge and Recipes with
 * paramaters such as: name, amount, unit, expiry date and price.
 *
 * @author Tord Fosse
 * @version 1.0
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
   * Returns a string representation of the grocery. If the expiry date is before the current date,
   * the expiry date will be red. If the expiry date is after the current date, the expiry date will
   * be green.
   *
   * @return String representation of the grocery.
   */
  public String toString() {
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String formattedExpiryDate = expiryDate.format(format);
    if (expiryDate.isBefore(LocalDate.now())) {
      return quantity
          + " | "
          + name
          + " | "
          + amount
          + " "
          + unit.getSymbol()[1]
          + " | "
          + "\033[31m"
          + formattedExpiryDate
          + "\033[0m"
          + " | "
          + price
          + " kr";
    } else {
      return quantity
          + " | "
          + name
          + " | "
          + amount
          + " "
          + unit.getSymbol()[1]
          + " | "
          + "\033[32m"
          + formattedExpiryDate
          + "\033[0m"
          + " | "
          + price
          + " kr";
    }
  }
}
