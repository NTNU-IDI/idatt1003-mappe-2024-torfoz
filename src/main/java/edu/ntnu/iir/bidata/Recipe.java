package edu.ntnu.iir.bidata;

import edu.ntnu.iir.bidata.utils.InputUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Recipe {

  private final String name;
  private final Type type;
  private List<Grocery> groceries = new ArrayList<>();
  private final String instructions;

  public Recipe(String name, Type type, String instructions, List<Grocery> groceries) {
    this.name = name;
    this.type = type;
    this.instructions = instructions;
    this.groceries.addAll(groceries);
  }

  public void addIngredientToRecipe() {
    String name = InputUtil.getString("Navn på ingrediens: ");
    Double amount = InputUtil.getDouble("Mengde av ingrediens: ");
    Unit unit = InputUtil.getUnit();
    groceries.add(new Grocery(name, amount, unit));
  }

  public void addIngredient(String name, double amount, Unit unit) {
    groceries.add(new Grocery(name, amount, unit));
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

  public Type getType() {
    return type;
  }

  public String getInstructions() {
    return instructions;
  }

  public String setInstructions(String instructions) {
    return instructions;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Navn: ").append(name).append("\n");
    sb.append("Type: ").append(type).append("\n");
    sb.append("Ingredienser: ").append("\n");
    for (Grocery grocery : groceries) {
      sb.append(grocery.getName()).append("\n");
    }
    return sb.toString();
  }
}
