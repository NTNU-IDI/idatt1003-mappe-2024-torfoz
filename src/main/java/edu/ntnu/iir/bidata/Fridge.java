package edu.ntnu.iir.bidata;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Fridge {
  private final List<Ingredient> ingredients = new ArrayList<>();

  /**
   * Adds an ingredient to the fridge.
   *
   * @param name Name of the ingredient.
   * @param amount Amount of the ingredient.
   * @param unit Unit of the ingredient.
   * @param expiryDate Expiry date of the ingredient.
   * @param price Price of the ingredient.
   */
  public void addIngredient(
      String name, double amount, Unit unit, LocalDate expiryDate, double price) {
    for (Ingredient ingredient : ingredients) {
      if (ingredient.getName().equals(name)
          && ingredient.getAmount() == amount
          && ingredient.getUnit() == unit
          && ingredient.getExpiryDate().equals(expiryDate)
          && ingredient.getPrice() == price) {
        ingredient.setQuantity(ingredient.getQuantity() + 1);
        return;
      }
    }
    ingredients.add(new Ingredient(1, name, amount, unit, expiryDate, price));
  }

  /** Adds an ingredient to the fridge from user input. */
  public void addIngredientFromInput() {
    Scanner sc = new Scanner(System.in);
    System.out.print("\nNavn på vare: ");
    String name = sc.nextLine();

    double amount;
    while (true) {
      System.out.print("Mengde av vare (gram, liter, stk..): ");
      try {
        amount = sc.nextDouble();
        sc.nextLine();
        break;
      } catch (Exception e) {
        System.out.println("Ugyldig mengde");
        sc.nextLine();
      }
    }

    Unit unit;
    while (true) {
      System.out.print("Enhet (g, l, stk): ");
      String unitString = sc.nextLine();
      try {
        unit = Unit.fromString(unitString);
        break;
      } catch (IllegalArgumentException e) {
        System.out.println("Ugyldig enhet: " + unitString);
      }
    }

    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // Dato til norsk standard
    LocalDate expiryDate;
    while (true) {
      System.out.print("Best før dato (dd-MM-yyyy): ");
      String expiryDateString = sc.nextLine();
      try {
        expiryDate = LocalDate.parse(expiryDateString, format);
        break;
      } catch (Exception e) {
        System.out.println("Ugyldig datoformat");
      }
    }

    double price;
    while (true) {
      System.out.print("Pris på vare: ");
      try {
        price = sc.nextDouble();
        sc.nextLine();
        break;
      } catch (Exception e) {
        System.out.println("Ugyldig pris");
      }
    }

    addIngredient(name, amount, unit, expiryDate, price);
  }

  /**
   * Gets all ingredients in the fridge.
   *
   * @return List of ingredients in the fridge.
   */
  public List<Ingredient> getIngredientsInFridge() {
    ingredients.sort(Comparator.comparing(Ingredient::getName));
    return ingredients;
  }

  /**
   * Gets all ingredients in the fridge with a specific name.
   *
   * @param name Name of the ingredient.
   * @return List of ingredients with the specified name.
   */
  public List<Ingredient> getIngredientsInFridgeByName(String name) {
    List<Ingredient> ingredientsByName = new ArrayList<>();
    for (Ingredient ingredient : ingredients) {
      if (ingredient.getName().equals(name)) {
        ingredientsByName.add(ingredient);
      }
    }
    return ingredientsByName;
  }

  /**
   * Returns a string representation of the fridge.
   * @return String with all ingredients in fridge.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("#######################");
    sb.append("\n------ KJØLESKAP ------");
    sb.append("\n#######################\n");
    for (Ingredient ingredient : getIngredientsInFridge()) {
      sb.append(ingredient.toString()).append("\n");
    }
    return sb.toString().trim();
  }

  /** Removes an ingredient from the fridge. */
  public void removeIngredientFromFridge() {
    Scanner sc = new Scanner(System.in);
    System.out.print("\nNavn på vare: ");
    String name = sc.nextLine();
    for (Ingredient ingredient : getIngredientsInFridgeByName(name)) {
      System.out.println(ingredient.toString());
    }
    while (true) {
      System.out.print("\nVelg nummeret på ingrediensen du vil fjerne: ");
      int index = sc.nextInt() - 1;
      sc.nextLine();

      if (index >= 0 && index < getIngredientsInFridgeByName(name).size()) {
        Ingredient ingredientToRemove = getIngredientsInFridgeByName(name).get(index);
        getIngredientsInFridge().remove(ingredientToRemove);
        System.out.println(ingredientToRemove.getName() + " fjernet");
        break;
      } else {
        System.out.println("Ugyldig valg");
      }
    }
  }
}
