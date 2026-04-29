import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Burger;
import praktikum.IngredientType;

import static org.junit.Assert.assertTrue;

public class BurgerReceiptTest extends BaseBurgerTest {

    private Burger buildBurger() {
        Mockito.when(bun.getName()).thenReturn("Розовая");
        Mockito.when(filling.getName()).thenReturn("Котлета");
        Mockito.when(filling.getType()).thenReturn(IngredientType.FILLING);

        Burger burger = new Burger();
        burger.addIngredient(filling);
        burger.setBuns(bun);
        return burger;
    }

    @Test
    public void receiptShouldStartWithBunTest() {
        String receipt = buildBurger().getReceipt();

        assertTrue(receipt.startsWith("(==== Розовая ===="));
    }

    @Test
    public void receiptShouldContainIngredientTest() {
        String receipt = buildBurger().getReceipt();

        assertTrue(receipt.contains("= filling Котлета ="));
    }

    @Test
    public void receiptShouldContainPriceTest() {
        String receipt = buildBurger().getReceipt();

        assertTrue(receipt.contains("Price:"));
    }
}
