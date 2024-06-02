package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final Ingredient ingredient;
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(Ingredient ingredient, IngredientType type, String name, float price) {
        this.ingredient = ingredient;
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] setUp() {
        return new Object[][] {
                {new Ingredient(SAUCE, "Соус Spicy-X", 90), SAUCE, "Соус Spicy-X", 90},
                {new Ingredient(FILLING, "Мясо бессмертных моллюсков Protostomia", 1337), FILLING, "Мясо бессмертных моллюсков Protostomia", 1337}
        };
    }

    @Test
    public void getPrice() {
        float actual = ingredient.getPrice();
        assertEquals(price, actual, 0);
    }

    @Test
    public void getName() {
        String actual = ingredient.getName();
        assertEquals(name, actual);
    }

    @Test
    public void getType() {
        IngredientType actual = ingredient.getType();
        assertEquals(type, actual);
    }
}