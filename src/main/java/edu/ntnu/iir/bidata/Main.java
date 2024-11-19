package edu.ntnu.iir.bidata;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
  /** Main method */
  public static void main(String[] args) {
    Fridge fridge = new Fridge();
    mainMenu(fridge);
  }

  /** Interface for adding, opening fridge or exiting program */
  public static void mainMenu(Fridge fridge) {
    fridge.addIngredient("Egg", 1, Unit.PIECE, LocalDate.of(2024, 12, 24), 5);
    fridge.addIngredient("Egg", 1, Unit.PIECE, LocalDate.of(2023, 12, 24), 5);
    fridge.addIngredient("Melk", 1, Unit.LITER, LocalDate.of(2022, 12, 24), 5);
    fridge.addIngredient("Ost", 1, Unit.GRAM, LocalDate.of(2021, 12, 24), 5);
    fridge.addIngredient("Smør", 1, Unit.GRAM, LocalDate.of(2020, 12, 24), 5);
    while (true) {
      System.out.println("\n1. Legg til ingrediens");
      System.out.println("2. Åpne kjøleskap");
      System.out.println("3. Avslutt");
      System.out.print("Valg: ");
      Scanner sc = new Scanner(System.in);
      int choice = sc.nextInt();
      sc.nextLine();
      switch (choice) {
        case 1:
          fridge.addIngredientFromInput();
          break;
        case 2:
          System.out.println(fridge.toString());
          insideFridge(fridge);
          break;
        case 3:
          return;
        default:
          System.out.println("Ugyldig valg");
      }
    }
  }

  /** Interface for adding, removing or viewing ingredients in the fridge */
  public static void insideFridge(Fridge fridge) {
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
          fridge.addIngredientFromInput();
          break;
        case 2:
          fridge.removeIngredientFromFridge();
          break;
        case 3:
          System.out.println(fridge.toString());
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
