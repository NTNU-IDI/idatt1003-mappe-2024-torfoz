package edu.ntnu.iir.bidata.models;

import edu.ntnu.iir.bidata.enums.RecipeType;
import edu.ntnu.iir.bidata.utils.InputUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for the cookbook.
 *
 * @author Tord Fosse
 * @version 1.1
 */
public class CookBook {

  private List<Recipe> recipes = new ArrayList<>();

  /**
   * Adds a recipe to the cookbook.
   *
   * @param name Name of the recipe.
   * @param type Type of the recipe.
   * @param instructions Instructions for the recipe.
   * @param groceries Ingredients for the recipe.
   */
  public void addRecipe(
      String name,
      RecipeType type,
      String description,
      String instructions,
      List<Grocery> groceries) {
    Recipe recipe = new Recipe(name, type, description, instructions, groceries);
    recipes.add(recipe);
  }

  /** Adds a recipe to the cookbook from user input. */
  public void addRecipeFromInput() {
    String name = InputUtil.getString("Name of recipe: ");
    RecipeType type = InputUtil.getRecipeType();
    String description = InputUtil.getString("Description: ");
    String instructions = InputUtil.getString("Instructions: ");
    List<Grocery> groceries = Recipe.addGroceryToRecipe();
    addRecipe(name, type, instructions, description, groceries);
  }

  /**
   * Get all recipes in the cookbook.
   *
   * @return List of recipes.
   */
  public List<Recipe> getRecipes() {
    return recipes;
  }

  /**
   * Get a recipe by name.
   *
   * @param name Name of the recipe.
   * @return Recipe with the given name.
   */
  public Recipe getRecipeByName(String name) {
    for (Recipe recipe : recipes) {
      if (recipe.getName().equals(name)) {
        return recipe;
      }
    }
    return null;
  }

  /**
   * Get a recipe by name from a user input.
   *
   * @return Recipe with the given name.
   */
  public Recipe getRecipeByNameFromInput() {
    String name = InputUtil.getString("Name of recipe: ");
    return getRecipeByName(name);
  }

  /** Remove a recipe from the cookbook by name. */
  public void removeRecipe() {
    Recipe recipe = getRecipeByNameFromInput();
    if (recipe == null) {
      System.out.println("Recipe not found");
      return;
    }
    recipes.remove(recipe);
  }

  /** Header for the cookbook. */
  public String header() {
    return "\n |---------------- CookBook ----------------|\n";
  }

  /** Prints out all recipes in the cookbook listed by type. */
  public String recipesNumbered() {
    StringBuilder sb = new StringBuilder();
    int i = 1;
    for (RecipeType type : RecipeType.values()) {
      sb.append("\n  ").append(type).append(":\n");
      for (Recipe recipe : recipes) {
        if (recipe.getType() != type) {
          continue;
        }
        sb.append("  ").append(i).append(". ").append(recipe.getName()).append("\n");
        i++;
      }
    }
    return sb.toString();
  }

  /**
   * Get recipes with ingredients in the fridge. Checks if the ingredients in the recipe are in the
   * fridge. If one or more ingredients are in the fridge, the recipe is added to the list.
   *
   * @param fridge Fridge to check for ingredients.
   * @return String with recipes that can be made with ingredients in the fridge.
   */
  public String getRecipesWithIngredientsInFridge(Fridge fridge) {
    StringBuilder sb = new StringBuilder();
    for (Recipe recipe : recipes) {
      boolean ingredientIsInFridge =
          recipe.getGroceries().stream().anyMatch(grocery -> fridge.hasGrocery(grocery.getName()));
      if (ingredientIsInFridge) {
        sb.append(recipe.getName()).append("\n");
      }
    }
    return sb.toString().trim();
  }

  /** Prints out a recipe. */
  public String printRecipe() {
    Recipe recipe = getRecipeByNameFromInput();
    if (recipe == null) {
      return "Recipe not found";
    }
    return recipe.printRecipe();
  }
}
