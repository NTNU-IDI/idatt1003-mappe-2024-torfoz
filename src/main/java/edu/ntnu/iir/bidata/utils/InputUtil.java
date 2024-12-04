package edu.ntnu.iir.bidata.utils;

import edu.ntnu.iir.bidata.enums.RecipeType;
import edu.ntnu.iir.bidata.enums.Unit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputUtil {
  private static final Scanner scanner = new Scanner(System.in);

  /**
   * Get a string from the user.
   *
   * @param prompt The prompt to display to the user.
   * @return The string entered by the user.
   */
  public static String getString(String prompt) {
    System.out.print(prompt);
    return scanner.nextLine();
  }

  /**
   * Get an integer from the user.
   *
   * @param prompt The prompt to display to the user.
   * @return The integer entered by the user.
   */
  public static int getInt(String prompt) {
    while (true) {
      System.out.print(prompt);
      try {
        return Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter an integer.");
      }
    }
  }

  /**
   * Get a double from the user.
   *
   * @param prompt The prompt to display to the user.
   * @return The double entered by the user.
   */
  public static double getDouble(String prompt) {
    while (true) {
      System.out.print(prompt);
      try {
        return Double.parseDouble(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a double.");
      }
    }
  }

  public static Unit getUnit() {
    while (true) {
      System.out.print("Unit (g, l, stk): ");
      String unitString = scanner.nextLine();
      try {
        return Unit.fromString(unitString);
    } catch (Exception e) {
        System.out.println("Invalid unit. " + unitString + " Please enter a valid unit.");
      }
    }
  }

  public static LocalDate getDate() {
    while (true) {
      System.out.print("Expiry date (dd-MM-yyyy): ");
      try {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(scanner.nextLine(), format);
      } catch (Exception e) {
        System.out.println("Invalid input. Please enter a date in the format dd-MM-yyyy.");
      }
    }
  }

  public static RecipeType getRecipeType() {
    while (true) {
      System.out.print(
          "Recipe type (BREAKFAST, LUNCH, STARTER, DINNER, DESSERT): ");
      String typeString = scanner.nextLine().toUpperCase();
      try {
        return RecipeType.valueOf(typeString);
      } catch (IllegalArgumentException e) {
        System.out.println("Invalid recipe type: " + typeString + ". Please enter a valid recipe type.");
      }
    }
  }

  public static boolean getBoolean(String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine();
      if (input.equalsIgnoreCase("yes")) {
        return true;
      } else if (input.equalsIgnoreCase("no")) {
        return false;
      } else {
        System.out.println("Invalid input. Please enter yes or no.");
      }
    }
  }
}