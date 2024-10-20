import edu.ntnu.iir.bidata.Ingredient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class test {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    System.out.println("Navn på vare:");
    String navn = sc.nextLine();
    System.out.println("Mengde av vare (gram, liter, stk..):");
    double amount = sc.nextDouble();
    sc.nextLine();
    System.out.println("Enhet (gram, liter, stk..): ");
    String unit = sc.nextLine();
    System.out.println("Best før dato (dd-MM-yyyy): ");
    String expiryDateString = sc.nextLine();
    LocalDate expiryDate = LocalDate.parse(expiryDateString, format);
    System.out.println("Pris på vare:");
    double price = sc.nextDouble();
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
