package edu.ntnu.iir.bidata;

import edu.ntnu.iir.bidata.enums.RecipeType;
import edu.ntnu.iir.bidata.utils.InputUtil;
import java.util.List;
import java.util.ArrayList;

/** Class for the cookbook. */
public class CookBook {
  private List<Recipe> recipes = new ArrayList<>();

  /** Adds a recipe to the cookbook.
   * @param name Name of the recipe.
   * @param type Type of the recipe.
   * @param instructions Instructions for the recipe.
   * @param groceries Ingredients for the recipe.
   */
  public void addRecipe(String name, RecipeType type, String instructions, List<Grocery> groceries) {
    Recipe recipe = new Recipe(name, type, instructions, groceries);
    recipes.add(recipe);
  }

  /** Adds a recipe to the cookbook from user input. */
  public void addRecipeFromInput() {
    String name = InputUtil.getString("Name of recipe: ");
    RecipeType type = InputUtil.getRecipeType();
    String instructions = InputUtil.getString("Instructions: ");
    List<Grocery> groceries = Recipe.addGroceryToRecipe();
    addRecipe(name, type, instructions, groceries);
  }

  /** Get a recipe by name.
   * @return Recipe with the given name.
   */
  public Recipe getRecipeByName() {
    String name = InputUtil.getString("Name of recipe: ");
    for (Recipe recipe : recipes) {
      if (recipe.getName().equals(name)) {
        return recipe;
      }
    }
    return null;
  }

  /** Remove a recipe from the cookbook by name. */
  public void removeRecipe() {
    Recipe recipe = getRecipeByName();
    if (recipe == null) {
      System.out.println("Recipe not found");
      return;
    }
    recipes.remove(recipe);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Recipe recipe : recipes.values()) {
      sb.append(recipe.toString()).append("\n");
    }
    return sb.toString();
  }
}