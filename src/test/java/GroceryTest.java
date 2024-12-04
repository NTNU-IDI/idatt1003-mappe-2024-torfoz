import org.junit.Test;
import edu.ntnu.iir.bidata.Grocery;
import edu.ntnu.iir.bidata.enums.Unit;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;


public class GroceryTest {
  @Test
  public void testSettersAndGetters() {
    Grocery grocery = new Grocery(1, "Milk", 1.0, Unit.LITER, LocalDate.now(), 10.0);
    assertEquals(1, grocery.getQuantity());
    assertEquals("Milk", grocery.getName());
    assertEquals(1.0, grocery.getAmount(), 0.0);
    assertEquals(Unit.LITER, grocery.getUnit());
    assertEquals(LocalDate.now(), grocery.getExpiryDate());
    assertEquals(10.0, grocery.getPrice(), 0.0);
    grocery.setQuantity(2);
    assertEquals(2, grocery.getQuantity());
    grocery.setQuantity(0);
    assertEquals(0, grocery.getQuantity());
  }

  @Test
  public void testToString() {
    LocalDate expiryDate = LocalDate.of(2023, 12, 31);
    Grocery grocery = new Grocery(1, "Sukker", 500.0, Unit.GRAM, expiryDate, 20.0);
    String expected = "1 | Sukker | 500.0 gram | 2023-12-31 | 20.0 kr";
    assertEquals(expected, grocery.toString());
  }
}
