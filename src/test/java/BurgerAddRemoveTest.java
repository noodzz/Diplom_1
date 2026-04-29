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
    public void removeIngredientSizeTest() {
        Burger burger = new Burger();
        burger.addIngredient(filling);
        burger.addIngredient(sauce);

        burger.removeIngredient(1);

        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientNotContainsRemovedTest() {
        Burger burger = new Burger();
        burger.addIngredient(filling);
        burger.addIngredient(sauce);

        burger.removeIngredient(1);

        assertFalse(burger.ingredients.contains(sauce));
    }

    @Test
    public void moveIngredientFirstPositionTest() {
        Burger burger = new Burger();
        burger.addIngredient(filling);
        burger.addIngredient(sauce);

        burger.moveIngredient(0, 1);

        assertEquals(sauce, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientSecondPositionTest() {
        Burger burger = new Burger();
        burger.addIngredient(filling);
        burger.addIngredient(sauce);

        burger.moveIngredient(0, 1);

        assertEquals(filling, burger.ingredients.get(1));
    }
}