package edu.ntnu.iir.bidata.ui;

import edu.ntnu.iir.bidata.Fridge;
import edu.ntnu.iir.bidata.Unit;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * User interface for the program.
 */
public class UserInterface {

  /**
   * Main method.
   */
  public static void main(String[] args) {
    mainMenu();
  }

  /**
   * Interface for adding, opening fridge or exiting program.
   */
  public static void mainMenu() {
    while (true) {
      System.out.println("\n1. Åpne kjøleskap");
      System.out.println("2. Åpne kokebok");
      System.out.println("3. Avslutt");
      System.out.print("Valg: ");
      Scanner sc = new Scanner(System.in);
      int choice = sc.nextInt();
      sc.nextLine();
      switch (choice) {
        case 1:
          insideFridge();
          break;
        case 2:
          //insideCookBook();
          break;
        case 3:
          System.exit(0);
          return;
        default:
          System.out.println("Ugyldig valg");
      }
    }
  }

  /**
   * Interface for adding, removing or viewing grocery in the fridge.
   */
  public static void insideFridge() {
    Fridge fridge = new Fridge();
    fridge.addGrocery("Egg", 1, Unit.PIECE, LocalDate.of(2024, 12, 24), 5);
    fridge.addGrocery("Egg", 1, Unit.PIECE, LocalDate.of(2023, 12, 24), 5);
    fridge.addGrocery("Melk", 1, Unit.LITER, LocalDate.of(2022, 12, 24), 5);
    fridge.addGrocery("Ost", 1, Unit.GRAM, LocalDate.of(2021, 12, 24), 5);
    fridge.addGrocery("Smør", 1, Unit.GRAM, LocalDate.of(2020, 12, 24), 5);
    System.out.println(fridge.toString());
    while (true) {
      System.out.println("\n1. Sett inn ingrediens");
      System.out.println("2. Ta ut ingrediens");
      System.out.println("3. Ta en titt");
      System.out.println("3. Lukk kjøleskap");
      System.out.print("Valg: ");
      Scanner sc = new Scanner(System.in);
      int choice = sc.nextInt();
      sc.nextLine();
      switch (choice) {
        case 1:
          fridge.addGroceryFromInput();
          break;
        case 2:
          fridge.removeGroceryFromFridge();
          break;
        case 3:
          System.out.println(fridge);
          break;
        case 4:
          mainMenu();
          break;
        default:
          System.out.println("Ugyldig valg");
      }
    }
  }
}

  /**
   * Interface for adding, removing or viewing recipes in the cookbook.
  public static void insideCookBook() {
    CookBook cookBook = new CookBook();
    Ingredient egg = new Ingredient("Egg", 2, Unit.PIECE);
    omelett.addIngredient(egg);
    cookBook.addRecipe();
    while (true) {
      System.out.println("\n1. Legg til oppskrift");
      System.out.println("2. Fjern oppskrift");
      System.out.println("3. Se oppskrifter");
      System.out.println("4. Lukk kokebok");
      System.out.print("Valg: ");
      Scanner sc = new Scanner(System.in);
      int choice = sc.nextInt();
      sc.nextLine();
      switch (choice) {
        case 1:
          cookBook.addRecipeFromInput();
          break;
        case 2:
          cookBook.removeRecipeFromCookBook();
          break;
        case 3:
          System.out.println(cookBook.toString());
          break;
        case 4:
          mainMenu(fridge);
          break;
        default:
          System.out.println("Ugyldig valg");
      }
    }
  }
}
   */
