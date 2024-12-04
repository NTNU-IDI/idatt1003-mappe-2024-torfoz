package edu.ntnu.iir.bidata;

import edu.ntnu.iir.bidata.enums.RecipeType;
import edu.ntnu.iir.bidata.enums.Unit;
import edu.ntnu.iir.bidata.utils.InputUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Recipe {

  private final String name;
  private final RecipeType recipeType;
  private final String instructions;
  private List<Grocery> groceries = new ArrayList<>();

  public Recipe(String name, RecipeType recipeType, String instructions, List<Grocery> groceries) {
    this.name = name;
    this.recipeType = recipeType;
    this.instructions = instructions;
    this.groceries = groceries;
  }

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

  public List<Grocery> getGroceries() {
    groceries.sort(Comparator.comparing(Grocery::getName));
    return groceries;
  }

  public List<Grocery> setGroceries(List<Grocery> groceries) {
    this.groceries = groceries;
    return groceries;
  }

  public String getName() {
    return name;
  }

  public RecipeType getType() {
    return recipeType;
  }

  public String getInstructions() {
    return instructions;
  }

  public String setInstructions(String instructions) {
    return instructions;
  }

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
