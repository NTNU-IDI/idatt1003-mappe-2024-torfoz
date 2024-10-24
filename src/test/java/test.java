import edu.ntnu.iir.bidata.Ingredient;
import edu.ntnu.iir.bidata.Unit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class test {

  public static void main(String[] args) {
    while (true) {
      System.out.println("1. Legg til ingrediens");
      System.out.println("2. Avslutt");
      System.out.print("Valg: ");
      Scanner sc = new Scanner(System.in);
      int choice = sc.nextInt();
      sc.nextLine();
      switch (choice) {
        case 1:
          addIngredient();
          break;
        case 2:
          return;
        default:
          System.out.println("Ugyldig valg");
      }
    }
  }

  public static void addIngredient() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Navn på vare: ");
    String navn = sc.nextLine();

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

    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
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

    Ingredient ingredient = new Ingredient(navn, amount, unit, expiryDate, price);
    printIngredient(ingredient);
  }

  public static void printIngredient(Ingredient ingredient) {
    System.out.println(ingredient.getName());
    System.out.println(ingredient.getAmount() + " " + ingredient.getUnit());
    System.out.println(ingredient.getExpiryDate());
    System.out.println(ingredient.getPrice());
  }
}
