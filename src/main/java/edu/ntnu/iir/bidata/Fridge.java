package edu.ntnu.iir.bidata;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fridge {
  private List<Ingredient> ingredients = new ArrayList<>();

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

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public List<Ingredient> getIngredientsByName(String name) {
    List<Ingredient> ingredientsByName = new ArrayList<>();
    for (Ingredient ingredient : ingredients) {
      if (ingredient.getName().equals(name)) {
        ingredientsByName.add(ingredient);
      }
    }
    return ingredientsByName;
  }
}
