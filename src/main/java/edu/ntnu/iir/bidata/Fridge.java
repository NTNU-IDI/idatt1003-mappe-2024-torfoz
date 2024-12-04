package edu.ntnu.iir.bidata;

import edu.ntnu.iir.bidata.enums.Unit;
import edu.ntnu.iir.bidata.utils.InputUtil;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/** Class for the fridge. Acts as a register for all groceries in the fridge. */
public class Fridge {

  private final List<Grocery> groceries = new ArrayList<>();

  /**
   * Adds an ingredient to the fridge.
   *
   * @param name Name of the ingredient.
   * @param amount Amount of the ingredient.
   * @param unit Unit of the ingredient.
   * @param expiryDate Expiry date of the ingredient.
   * @param price Price of the ingredient.
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

  /** Adds an ingredient to the fridge from user input. */
  public void addGroceryFromInput() {
    String name = InputUtil.getString("Name of grocery: ");
    double amount = InputUtil.getDouble("Amount of grocery: ");
    Unit unit = InputUtil.getUnit();
    LocalDate expiryDate = InputUtil.getDate();
    double price = InputUtil.getDouble("Price of grocery: ");
    addGrocery(name, amount, unit, expiryDate, price);
  }

  /**
   * Gets all ingredients in the fridge.
   *
   * @return List of ingredients in the fridge.
   */
  public List<Grocery> getGroceriesInFridge() {
    groceries.sort(Comparator.comparing(Grocery::getName));
    return groceries;
  }

  /**
   * Gets all ingredients in the fridge with a specific name.
   *
   * @param name Name of the ingredient.
   * @return List of ingredients with the specified name.
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
      System.out.println(grocery.toString());
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
