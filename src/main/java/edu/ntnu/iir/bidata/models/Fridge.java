package edu.ntnu.iir.bidata.models;

import edu.ntnu.iir.bidata.enums.Unit;
import edu.ntnu.iir.bidata.utils.InputUtil;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for the fridge. Acts as a register for all groceries in the fridge.
 *
 * @author Tord Fosse
 * @version 1.0
 */
public class Fridge {

  private final List<Grocery> groceries = new ArrayList<>();

  /**
   * Adds a grocery to the fridge.
   *
   * @param name       Name of the ingredient.
   * @param amount     Amount of the ingredient.
   * @param unit       Unit of the ingredient.
   * @param expiryDate Expiry date of the ingredient.
   * @param price      Price of the ingredient.
   */
  public void addGrocery(
      String name, double amount, Unit unit, LocalDate expiryDate, double price) {
    for (Grocery grocery : groceries) {
      if (grocery.getName().equals(name)
          && grocery.getAmount() == amount
          && grocery.getUnit() == unit
          && grocery.getExpiryDate().equals(expiryDate)
          && grocery.getPrice() == price) {
        grocery.setQuantity(grocery.getQuantity() + 1);
        return;
      }
    }
    groceries.add(new Grocery(1, name, amount, unit, expiryDate, price));
  }

  /**
   * Adds a grocery to the fridge from user input.
   */
  public void addGroceryFromInput() {
    String name = InputUtil.getString("Name of grocery: ");
    double amount = InputUtil.getDouble("Amount of grocery: ");
    Unit unit = InputUtil.getUnit();
    LocalDate expiryDate = InputUtil.getDate();
    double price = InputUtil.getDouble("Price of grocery: ");
    addGrocery(name, amount, unit, expiryDate, price);
  }

  /**
   * Gets all groceries in the fridge.
   *
   * @return List of groceries in the fridge.
   */
  public List<Grocery> getGroceriesInFridge() {
    groceries.sort(Comparator.comparing(Grocery::getName));
    return groceries;
  }

  /**
   * Gets all groceries in the fridge with a specific name.
   *
   * @param name Name of the grocery.
   * @return List of groceries with the specified name.
   */
  public List<Grocery> getGroceriesInFridgeByName(String name) {
    return groceries.stream()
        .filter(grocery -> grocery.getName().equals(name))
        .collect(Collectors.toList());
  }

  /**
   * Removes a grocery from the fridge. If there are multiple groceries with the same name, the user
   * will be prompted to choose which one to remove.
   */
  public void removeGroceryFromFridge() {
    String name = InputUtil.getString("Name of grocery to remove: ");
    List<Grocery> groceriesByName = getGroceriesInFridgeByName(name);
    if (groceriesByName.isEmpty()) {
      System.out.println("No groceries found with the name: " + name);
      return;
    }
    for (Grocery grocery : groceriesByName) {
      StringBuilder sb = new StringBuilder();
      sb.append(groceriesByName.indexOf(grocery) + 1).append(". ").append(grocery);
      System.out.println(sb);
    }
    while (true) {
      int index = InputUtil.getInt("Index of grocery to remove: ");
      index -= 1;

      if (index >= 0 && index < getGroceriesInFridgeByName(name).size()) {
        Grocery groceryToRemove = getGroceriesInFridgeByName(name).get(index);
        getGroceriesInFridge().remove(groceryToRemove);
        System.out.println(groceryToRemove.getName() + " fjernet");
        break;
      } else {
        System.out.println("Ugyldig valg");
      }
    }
  }

  /**
   * Gets the price of all groceries in the fridge.
   *
   * @return Price of all groceries in the fridge.
   */
  public double getPriceOfGroceries() {
    return groceries.stream().mapToDouble(Grocery::getPrice).sum();
  }

  /**
   * Gets the price of all expired groceries in the fridge.
   *
   * @return Price of all expired groceries in the fridge.
   */
  public double getPriceOfExpiredGroceries() {
    return groceries.stream()
        .filter(grocery -> grocery.getExpiryDate().isBefore(LocalDate.now()))
        .mapToDouble(Grocery::getPrice)
        .sum();
  }

  /**
   * Gets all expired groceries in the fridge.
   *
   * @return List of all expired groceries in the fridge.
   */
  public String getExpiredGroceries() {
    StringBuilder sb = new StringBuilder();
    for (Grocery grocery : groceries) {
      if (grocery.getExpiryDate().isBefore(LocalDate.now())) {
        sb.append(grocery).append("\n");
      }
    }
    return sb.toString().trim();
  }

  /**
   * Checks if the fridge has a grocery with a specific name.
   *
   * @param name Name of the grocery.
   * @return True if the fridge has a grocery with the specified name, false otherwise.
   */
  public boolean hasGrocery(String name) {
    return groceries.stream().anyMatch(grocery -> grocery.getName().equals(name));
  }

  /**
   * Header for the fridge.
   *
   * @return String with the header for the fridge.
   */
  public String header() {
    return "\n|------------------ FRIDGE ------------------|\n";
  }

  /**
   * Prints out all groceries in the fridge.
   *
   * @return String with all groceries in the fridge.
   */
  public String printGroceries() {
    StringBuilder sb = new StringBuilder();
    for (Grocery grocery : getGroceriesInFridge()) {
      sb.append(grocery.toString()).append("\n");
    }
    return sb.toString().trim();
  }
}
