import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Ingredient;

public class BaseBurgerTest {

    @Mock
    protected Bun bun;

    @Mock
    protected Ingredient sauce;

    @Mock
    protected Ingredient filling;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}
