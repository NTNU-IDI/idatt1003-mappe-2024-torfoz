import edu.ntnu.iir.bidata.enums.Unit;
import edu.ntnu.iir.bidata.models.Grocery;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import edu.ntnu.iir.bidata.models.Recipe;
import edu.ntnu.iir.bidata.enums.RecipeType;

import static org.junit.Assert.assertEquals;


public class RecipeTest {
  @Test
  public void testGetters() {
    List<Grocery> groceries = new ArrayList<>();
    groceries.add(new Grocery("Pasta", 1.0, Unit.PIECE));
    Recipe recipe = new Recipe("Pasta", RecipeType.DINNER, "Pasta with tomato sauce", "Boil pasta, add sauce", groceries);
    assertEquals("Pasta", recipe.getName());
    assertEquals(RecipeType.DINNER, recipe.getType());
    assertEquals("Pasta with tomato sauce", recipe.getDescription());
    assertEquals("Boil pasta, add sauce", recipe.getInstructions());
    assertEquals(groceries, recipe.getGroceries());
  }

 @Test
  public void testAddGroceryToRecipe() {
    List<Grocery> groceries = new ArrayList<>();
    groceries.add(new Grocery("Pasta", 1.0, Unit.PIECE));
    groceries.add(new Grocery("Tomato sauce", 0.5, Unit.LITER));
    Recipe recipe = new Recipe("Pasta", RecipeType.DINNER, "Pasta with tomato sauce", "Boil pasta, add sauce", groceries);
    assertEquals(groceries, recipe.getGroceries());
  }
}
