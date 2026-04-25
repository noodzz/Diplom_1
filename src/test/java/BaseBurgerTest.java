import org.junit.Before;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class BaseBurgerTest {

    protected Bun bun;
    protected Ingredient sauce;
    protected Ingredient filling;

    @Before
    public void setUp() {
        bun = new Bun("Розовая", 100);

        sauce = new Ingredient(IngredientType.SAUCE, "Сырный", 50);
        filling = new Ingredient(IngredientType.FILLING, "Котлета", 200);
    }
}