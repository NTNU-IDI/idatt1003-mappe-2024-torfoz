package edu.ntnu.iir.bidata;

import java.util.HashMap;
import java.util.Map;

public class CookBook {
  private Map<String, Recipe> recipes;

  public CookBook() {
    this.recipes = new HashMap<>();
  }

  public Recipe getRecipe(String name) {
    return recipes.get(name);
  }

  public void addRecipe(Recipe recipe) {
    recipes.put(recipe.getName(), recipe);
  }

  public void removeRecipe(String name) {
    recipes.remove(name);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Recipe recipe : recipes.values()) {
      sb.append(recipe.toString()).append("\n");
    }
    return sb.toString();
  }
}