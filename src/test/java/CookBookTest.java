import static org.junit.Assert.assertEquals;

import edu.ntnu.iir.bidata.enums.RecipeType;
import edu.ntnu.iir.bidata.enums.Unit;
import edu.ntnu.iir.bidata.models.CookBook;
import edu.ntnu.iir.bidata.models.Grocery;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CookBookTest {

  @Test
  void addRecipe() {
    CookBook cookBook = new CookBook();
    List<Grocery> groceries = new ArrayList<>();
    groceries.add(new Grocery("Pasta", 1, Unit.PIECE));
    cookBook.addRecipe("Pasta", RecipeType.LUNCH, "Pasta with tomato sauce", "Boil pasta and add sauce", groceries);
    assertEquals(1, cookBook.getRecipes().size());
    }

  @Test
  void getRecipeByName() {
    CookBook cookBook = new CookBook();
    List<Grocery> groceries = new ArrayList<>();
    groceries.add(new Grocery("Pasta", 1, Unit.PIECE));
    cookBook.addRecipe("Pasta", RecipeType.LUNCH, "Pasta with tomato sauce", "Boil pasta and add sauce", groceries);
    assertEquals("Pasta", cookBook.getRecipeByName("Pasta").getName());
    }

  @Test
  void removeRecipe() {
    CookBook cookBook = new CookBook();
    List<Grocery> groceries = new ArrayList<>();
    groceries.add(new Grocery("Pasta", 1, Unit.PIECE));
    cookBook.addRecipe("Pasta", RecipeType.LUNCH, "Pasta with tomato sauce", "Boil pasta and add sauce", groceries);
    String simulatedUserInput = "Pasta";
    System.setIn(new java.io.ByteArrayInputStream(simulatedUserInput.getBytes()));
    cookBook.removeRecipe();
    assertEquals(0, cookBook.getRecipes().size());
    }
}