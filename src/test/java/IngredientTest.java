import org.junit.Test;
import edu.ntnu.iir.bidata.Ingredient;
import edu.ntnu.iir.bidata.Unit;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;


public class IngredientTest {
  @Test
  public void testSettersAndGetters() {
    Ingredient ingredient = new Ingredient(1, "Milk", 1.0, Unit.LITER, LocalDate.now(), 10.0);
    assertEquals(1, ingredient.getQuantity());
    assertEquals("Milk", ingredient.getName());
    assertEquals(1.0, ingredient.getAmount(), 0.0);
    assertEquals(Unit.LITER, ingredient.getUnit());
    assertEquals(LocalDate.now(), ingredient.getExpiryDate());
    assertEquals(10.0, ingredient.getPrice(), 0.0);
    ingredient.setQuantity(2);
    assertEquals(2, ingredient.getQuantity());
    ingredient.setQuantity(0);
    assertEquals(0, ingredient.getQuantity());
  }

  @Test
  public void testToString() {
    LocalDate expiryDate = LocalDate.of(2023, 12, 31);
    Ingredient ingredient = new Ingredient(1, "Sukker", 500.0, Unit.GRAM, expiryDate, 20.0);
    String expected = "1 | Sukker | 500.0 gram | 2023-12-31 | 20.0 kr";
    assertEquals(expected, ingredient.toString());
  }
}
