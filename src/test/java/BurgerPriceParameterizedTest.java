import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerPriceParameterizedTest {

    private final float bunPrice;
    private final float ingredientPrice;
    private final float expected;

    public BurgerPriceParameterizedTest(float bunPrice, float ingredientPrice, float expected) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Цена булки {0}, Цена ингредиента {1}")
    public static Object[][] data() {
        return new Object[][]{
                {100f, 50f, 250f},
                {70.5f, 150f, 291f},
                {0f, 0f, 0f}
        };
    }

    @Test
    public void priceTest() {
        Bun bun = new Bun("Розовая", bunPrice);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Сырный", ingredientPrice);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        assertEquals(expected, burger.getPrice(), 0.001);
    }
}