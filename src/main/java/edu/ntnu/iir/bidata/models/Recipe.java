package edu.ntnu.iir.bidata.models;

import edu.ntnu.iir.bidata.enums.RecipeType;
import edu.ntnu.iir.bidata.enums.Unit;
import edu.ntnu.iir.bidata.utils.InputUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/** Class for the recipe used in the cookbook. Utilizes the RecipeType enum and the Grocery class.
 *
 * @author Tord Fosse
 * @version 1.0
 */
public class Recipe {

  private final String name;
  private final RecipeType recipeType;
  private final String instructions;
  private List<Grocery> groceries = new ArrayList<>();

  /**
   * Constructor for the recipe.
   *
   * @param name Name of the recipe.
   * @param recipeType Type of the recipe.
   * @param instructions Instructions for the recipe.
   * @param groceries Ingredients/Groceries for the recipe.
   */
  public Recipe(String name, RecipeType recipeType, String instructions, List<Grocery> groceries) {
    this.name = name;
    this.recipeType = recipeType;
    this.instructions = instructions;
    this.groceries = groceries;
  }

  /**
   * Adds a grocery to the recipe.
   *
   * @return List of groceries in the recipe.
   */
  public static List<Grocery> addGroceryToRecipe() {
    List<Grocery> groceries = new ArrayList<>();
    while (true) {
      String groceryName = InputUtil.getString("Name of ingredient: ");
      double groceryAmount = InputUtil.getDouble("Amount of ingredient: ");
      Unit groceryUnit = InputUtil.getUnit();
      groceries.add(new Grocery(groceryName, groceryAmount, groceryUnit));
      if (!InputUtil.getBoolean("Add another grocery? (yes/no): ")) {
        break;
      }
    }
    return groceries;
  }

  /**
   * Gets all groceries in the recipe and sorts them by name.
   *
   * @return List of groceries in the recipe.
   */
  public List<Grocery> getGroceries() {
    groceries.sort(Comparator.comparing(Grocery::getName));
    return groceries;
  }

  /**
   * Sets the groceries in the recipe.
   *
   * @param groceries List of groceries to set.
   * @return List of groceries set.
   */
  public List<Grocery> setGroceries(List<Grocery> groceries) {
    this.groceries = groceries;
    return groceries;
  }

  /**
   * Gets the name of the recipe.
   *
   * @return Name of the recipe.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the type of the recipe.
   *
   * @return Type of the recipe.
   */
  public RecipeType getType() {
    return recipeType;
  }

  /**
   * Gets the instructions for the recipe.
   *
   * @return Instructions for the recipe.
   */
  public String getInstructions() {
    return instructions;
  }

  /**
   * Sets the instructions for the recipe.
   *
   * @param instructions Instructions to set.
   * @return Instructions set.
   */
  public String setInstructions(String instructions) {
    return instructions;
  }

  /**
   * Prints the recipe.
   *
   * @return String with the recipe.
   */
  public String printRecipe() {
    StringBuilder sb = new StringBuilder();
    sb.append("\nName: ").append(name).append("\n");
    sb.append("Type: ").append(recipeType).append("\n");
    sb.append("Ingredients: ").append("\n");
    for (Grocery grocery : groceries) {
      sb.append(grocery.getName()).append(grocery.getUnit()).append("\n");
    }
    sb.append("Instructions: ").append(instructions).append("\n");
    return sb.toString();
  }
}
