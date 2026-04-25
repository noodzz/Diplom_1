import org.junit.Test;
import praktikum.Burger;

import static org.junit.Assert.*;

public class BurgerAddRemoveTest extends BaseBurgerTest {
    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(filling);

        assertTrue(burger.ingredients.contains(filling));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(filling);
        burger.addIngredient(sauce);

        burger.removeIngredient(1);

        assertEquals(1, burger.ingredients.size());
        assertFalse(burger.ingredients.contains(sauce));
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(filling);
        burger.addIngredient(sauce);

        burger.moveIngredient(0, 1);

        assertEquals(sauce, burger.ingredients.get(0));
        assertEquals(filling, burger.ingredients.get(1));
    }
}