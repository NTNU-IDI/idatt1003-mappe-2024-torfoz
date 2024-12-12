import edu.ntnu.iir.bidata.models.Fridge;
import org.junit.Test;
import java.time.LocalDate;
import edu.ntnu.iir.bidata.enums.Unit;
import static org.junit.Assert.assertEquals;

public class FridgeTest {
  @Test
  public void testGetters() {
    Fridge fridge = new Fridge();
    fridge.addGrocery("Egg", 1, Unit.PIECE, LocalDate.now(), 5);
    assertEquals(1, fridge.getGroceriesInFridge().size());
  }

  @Test
  public void testAddGroceryFromInput() {
    Fridge fridge = new Fridge();
    String simulatedUserInput = "Egg\n1\npcs\n13-12-2024\n5\n";
    System.setIn(new java.io.ByteArrayInputStream(simulatedUserInput.getBytes()));
    fridge.addGroceryFromInput();
    assertEquals(1, fridge.getGroceriesInFridge().size());
  }

  @Test
  public void testRemoveGroceryFromFridge() {
    Fridge fridge = new Fridge();
    fridge.addGrocery("Egg", 1, Unit.PIECE, LocalDate.now(), 5);
    fridge.addGrocery("Egg", 1, Unit.PIECE, LocalDate.now(), 10);
    String simulatedUserInput = "Egg\n1\n";
    System.setIn(new java.io.ByteArrayInputStream(simulatedUserInput.getBytes()));
    fridge.removeGroceryFromFridge();
    assertEquals(1, fridge.getGroceriesInFridge().size());
  }
}
