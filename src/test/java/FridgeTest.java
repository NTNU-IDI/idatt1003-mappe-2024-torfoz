import edu.ntnu.iir.bidata.Fridge;
import org.junit.Test;
import java.time.LocalDate;
import edu.ntnu.iir.bidata.Unit;
import static org.junit.Assert.assertEquals;

public class FridgeTest {
  @Test
  public void testGetters() {
    Fridge fridge = new Fridge();
    fridge.addIngredient("Egg", 1, Unit.PIECE, LocalDate.now(), 5);
    assertEquals(1, fridge.getIngredientsInFridge().size());
  }

  @Test
  public void testRemoveIngredientFromFridge() {
    Fridge fridge = new Fridge();
    fridge.addIngredient("Egg", 1, Unit.PIECE, LocalDate.now(), 5);
    fridge.addIngredient("Egg", 1, Unit.PIECE, LocalDate.now(), 10);
    String simulatedUserInput = "Egg\n1\n";
    System.setIn(new java.io.ByteArrayInputStream(simulatedUserInput.getBytes()));
    fridge.removeIngredientFromFridge();
    assertEquals(1, fridge.getIngredientsInFridge().size());
  }

  @Test
  public void testToString() {
    Fridge fridge = new Fridge();
    fridge.addIngredient("Egg", 1, Unit.PIECE, LocalDate.now(), 5);
    String expected =
        "#######################\n"
            + "------ KJØLESKAP ------\n"
            + "#######################\n"
            + "1 | Egg | 1.0 stykker | "
            + LocalDate.now()
            + " | 5.0 kr";
    assertEquals(expected, fridge.toString());
  }
}
