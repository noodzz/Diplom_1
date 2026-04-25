import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerReceiptTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("Розовая");
        Mockito.when(ingredient.getName()).thenReturn("Котлета");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);

        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.setBuns(bun);

        String receipt = burger.getReceipt();

        assertTrue(receipt.startsWith("(==== Розовая ===="));
        assertTrue(receipt.contains("= filling Котлета ="));
        assertTrue(receipt.contains("Price:"));
    }
}
