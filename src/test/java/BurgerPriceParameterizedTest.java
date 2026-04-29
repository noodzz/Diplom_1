import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerPriceParameterizedTest extends BaseBurgerTest {

    private final float bunPrice;
    private final float ingredientPrice;
    private final float expected;

    public BurgerPriceParameterizedTest(float bunPrice, float ingredientPrice, float expected) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.expected = expected;
    }

    @Before
    public void setUpStubs() {
        when(bun.getPrice()).thenReturn(bunPrice);
        when(sauce.getPrice()).thenReturn(ingredientPrice);
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
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);

        assertEquals(expected, burger.getPrice(), 0.001);
    }
}