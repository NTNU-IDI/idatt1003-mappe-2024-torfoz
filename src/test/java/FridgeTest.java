import edu.ntnu.iir.bidata.Fridge;
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
    String simulatedUserInput = "Egg\n1\nstk\n13-12-2024\n5\n";
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

  @Test
  public void testToString() {
    Fridge fridge = new Fridge();
    fridge.addGrocery("Egg", 1, Unit.PIECE, LocalDate.now(), 5);
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
