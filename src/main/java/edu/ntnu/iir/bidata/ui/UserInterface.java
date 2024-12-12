package edu.ntnu.iir.bidata.ui;

import edu.ntnu.iir.bidata.enums.RecipeType;
import edu.ntnu.iir.bidata.enums.Unit;
import edu.ntnu.iir.bidata.models.CookBook;
import edu.ntnu.iir.bidata.models.Fridge;
import edu.ntnu.iir.bidata.models.Grocery;
import edu.ntnu.iir.bidata.utils.InputUtil;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * User interface for the program.
 *
 * @author Tord Fosse
 * @version 1.0
 */
public class UserInterface {

  /** Main method. */
  public static void main(String[] args) {
    mainMenu();
  }

  /** Interface for adding, opening fridge or exiting program. */
  public static void mainMenu() {
    Fridge fridge = new Fridge();
    fridge.addGrocery("Egg", 1, Unit.PIECE, LocalDate.of(2024, 12, 24), 5);
    fridge.addGrocery("Egg", 1, Unit.PIECE, LocalDate.of(2023, 12, 24), 5);
    fridge.addGrocery("Milk", 1, Unit.LITER, LocalDate.of(2022, 12, 24), 5);
    fridge.addGrocery("Cheese", 1, Unit.GRAM, LocalDate.of(2021, 12, 24), 5);
    fridge.addGrocery("Butter", 1, Unit.GRAM, LocalDate.of(2020, 12, 24), 5);
    while (true) {
      int choice = InputUtil.getInt("\n1. Open fridge\n2. Open cookbook\n3. Exit\nChoice: ");
      switch (choice) {
        case 1:
          insideFridge(fridge);
          break;
        case 2:
          insideCookBook(fridge);
          break;
        case 3:
          System.exit(0);
          return;
        default:
          System.out.println("Invalid choice");
      }
    }
  }

  /** Interface for adding, removing or viewing grocery in the fridge. */
  public static void insideFridge(Fridge fridge) {
    System.out.print(fridge.header());
    System.out.println(fridge.printGroceries());
    while (true) {
      int choice =
          InputUtil.getInt(
              "\n1. View fridge\n2. Add grocery\n3. Remove grocery"
                  + "\n4. View combined price\n5. View expired price\n"
                  + "6. View expired groceries\n7. Close fridge\nChoice: ");
      switch (choice) {
        case 1:
          System.out.print(fridge.header());
          System.out.println(fridge.printGroceries());
          break;
        case 2:
          fridge.addGroceryFromInput();
          break;
        case 3:
          fridge.removeGroceryFromFridge();
          break;
        case 4:
          System.out.println(fridge.getPriceOfGroceries());
          break;
        case 5:
          System.out.println(fridge.getPriceOfExpiredGroceries());
          break;
        case 6:
          System.out.println(fridge.getExpiredGroceries());
          break;
        case 7:
          mainMenu();
          break;
        default:
          System.out.println("Invalid choice");
      }
    }
  }

  /** Interface for adding, removing or viewing recipes in the cookbook. */
  public static void insideCookBook(Fridge fridge) {
    CookBook cookBook = new CookBook();
    List<Grocery> groceries = new ArrayList<>();
    groceries.add(new Grocery("Egg", 1, Unit.PIECE));
    cookBook.addRecipe("Kjøttkaker", RecipeType.DINNER, "", "Stek kjøttkaker", groceries);
    cookBook.addRecipe("Kake", RecipeType.DESSERT, "", "Lag kake", new ArrayList<>());
    cookBook.addRecipe("Salat", RecipeType.LUNCH, "", "Lag salat", new ArrayList<>());
    cookBook.addRecipe("Suppe", RecipeType.STARTER, "", "Lag suppe", new ArrayList<>());
    cookBook.addRecipe("Bananpannekaker", RecipeType.BREAKFAST, "", "Stek pannekaker", groceries);
    cookBook.addRecipe("Pannekaker", RecipeType.BREAKFAST, "", "Stek pannekaker", groceries);
    System.out.print(cookBook.header());
    System.out.print(cookBook.recipesNumbered());
    while (true) {
      int choice =
          InputUtil.getInt(
              "\n1. Print out recipes"
                  + "\n2. View recipe"
                  + "\n3. Add recipe"
                  + "\n4. Remove recipe"
                  + "\n5. Find recipes with ingredients in fridge"
                  + "\n6. Close cookbook"
                  + "\nChoice: ");
      switch (choice) {
        case 1:
          System.out.print(cookBook.header());
          System.out.println(cookBook.recipesNumbered());
          break;
        case 2:
          System.out.println(cookBook.printRecipe());
          break;
        case 3:
          cookBook.addRecipeFromInput();
          break;
        case 4:
          cookBook.removeRecipe();
          break;
        case 5:
          System.out.println(cookBook.getRecipesWithIngredientsInFridge(fridge));
          break;
        case 6:
          mainMenu();
          break;
        default:
          System.out.println("Invalid choice");
      }
    }
  }
}
