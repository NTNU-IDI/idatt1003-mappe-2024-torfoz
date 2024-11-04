import edu.ntnu.iir.bidata.Fridge;
import edu.ntnu.iir.bidata.Ingredient;
import edu.ntnu.iir.bidata.Unit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class test {

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
          addIngredient(fridge);
          break;
        case 2:
          printIngredientsInFridge(fridge);
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
          addIngredient(fridge);
          break;
        case 2:
          removeIngredientFromFridge(fridge);
          break;
        case 3:
          printIngredientsInFridge(fridge);
          break;
        case 4:
          mainMenu(fridge);
          break;
        default:
          System.out.println("Ugyldig valg");
      }
    }
  }

  /** Method for adding ingredients to the fridge */
  public static void addIngredient(Fridge fridge) {
    Scanner sc = new Scanner(System.in);
    System.out.print("\nNavn på vare: ");
    String name = sc.nextLine();

    double amount;
    while (true) {
      System.out.print("Mengde av vare (gram, liter, stk..): ");
      try {
        amount = sc.nextDouble();
        sc.nextLine();
        break;
      } catch (Exception e) {
        System.out.println("Ugyldig mengde");
        sc.nextLine();
      }
    }

    Unit unit;
    while (true) {
      System.out.print("Enhet (g, l, stk): ");
      String unitString = sc.nextLine();
      try {
        unit = Unit.fromString(unitString);
        break;
      } catch (IllegalArgumentException e) {
        System.out.println("Ugyldig enhet: " + unitString);
      }
    }

    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // Dato til norsk standard
    LocalDate expiryDate;
    while (true) {
      System.out.print("Best før dato (dd-MM-yyyy): ");
      String expiryDateString = sc.nextLine();
      try {
        expiryDate = LocalDate.parse(expiryDateString, format);
        break;
      } catch (Exception e) {
        System.out.println("Ugyldig datoformat");
      }
    }

    double price;
    while (true) {
      System.out.print("Pris på vare: ");
      try {
        price = sc.nextDouble();
        sc.nextLine();
        break;
      } catch (Exception e) {
        System.out.println("Ugyldig pris");
      }
    }

    fridge.addIngredient(name, amount, unit, expiryDate, price);
  }

  public static void printIngredient(Ingredient ingredient) {
    System.out.println(ingredient);
  }

  public static void printIngredientsInFridge(Fridge fridge) {
    System.out.println("\n##############################");
    System.out.println("# Ingredienser i kjøleskapet #");
    System.out.println("##############################");
    for (Ingredient ingredient : fridge.getIngredients()) {
      printIngredient(ingredient);
    }
  }

  public static void removeIngredientFromFridge(Fridge fridge) {
    Scanner sc = new Scanner(System.in);
    System.out.print("\nNavn på vare: ");
    String name = sc.nextLine();
    for (Ingredient ingredient : fridge.getIngredientsByName(name)) {
      printIngredient(ingredient);
    }
    while (true) {
      System.out.print("\nVelg nummeret på ingrediensen du vil fjerne: ");
      int index = sc.nextInt() - 1;
      sc.nextLine();

      if (index >= 0 && index < fridge.getIngredientsByName(name).size()) {
        Ingredient ingredientToRemove = fridge.getIngredientsByName(name).get(index);
        fridge.getIngredients().remove(ingredientToRemove);
        System.out.println(ingredientToRemove.getName() + " fjernet");
        break;
      } else {
        System.out.println("Ugyldig valg");
      }
    }
  }
}
