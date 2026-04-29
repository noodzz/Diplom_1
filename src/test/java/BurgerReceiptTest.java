import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Burger;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class BurgerReceiptTest extends BaseBurgerTest {

    private Burger buildBurger() {
        Mockito.when(bun.getName()).thenReturn("Розовая");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(filling.getName()).thenReturn("Котлета");
        Mockito.when(filling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(filling.getPrice()).thenReturn(200f);

        Burger burger = new Burger();
        burger.addIngredient(filling);
        burger.setBuns(bun);
        return burger;
    }

    @Test
    public void receiptShouldHaveCorrectFormatTest() {
        String expected = "(==== Розовая ====)\n"
                + "= filling Котлета =\n"
                + "(==== Розовая ====)\n"
                + "\nPrice: 400,000000\n";

        assertEquals(expected, buildBurger().getReceipt());
    }
}
