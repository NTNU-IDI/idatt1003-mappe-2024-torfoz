package edu.ntnu.iir.bidata;

import edu.ntnu.iir.bidata.utils.InputUtil;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for the fridge. Acts as a register for all groceries in the fridge.
 */
public class Fridge {

  private final List<Grocery> groceries = new ArrayList<>();

  /**
   * Adds an ingredient to the fridge.
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
   * Adds an ingredient to the fridge from user input.
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
   * Returns a string representation of the fridge.
   *
   * @return String with all ingredients in fridge.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("_____________________________________________");
    sb.append("\n|---------------- KJØLESKAP ----------------|\n");
    for (Grocery grocery : getGroceriesInFridge()) {
      sb.append(grocery.toString()).append("\n");
    }
    return sb.toString().trim();
  }

  /**
   * Removes an ingredient from the fridge.
   */
  public void removeGroceryFromFridge() {
    String name = InputUtil.getString("Name of grocery to remove: ");
    for (Grocery grocery : getGroceriesInFridgeByName(name)) {
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
}
