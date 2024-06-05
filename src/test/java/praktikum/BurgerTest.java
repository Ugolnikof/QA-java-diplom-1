package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Ingredient ingredient;

    @Mock
    Bun bun;

    @Spy
    private Burger burger = new Burger();


    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.getBun());
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient);
        assertEquals(ingredient, burger.getIngredients().get(0));
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(1);
        assertEquals(1, burger.getIngredients().size());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(new Ingredient(FILLING, "Мясо бессмертных моллюсков Protostomia", 1337));
        burger.addIngredient(new Ingredient(SAUCE, "Соус Spicy-X", 90));
        burger.moveIngredient(0,1);
        assertEquals( "Соус Spicy-X", burger.getIngredients().get(0).name);
        assertEquals( "Мясо бессмертных моллюсков Protostomia", burger.getIngredients().get(1).name);
    }

    @Test
    public void getPrice() {
        burger.setBuns(new Bun("Флюоресцентная булка R2-D3", 988));
        burger.addIngredient(new Ingredient(FILLING, "Мясо бессмертных моллюсков Protostomia", 1337));
        burger.addIngredient(new Ingredient(SAUCE, "Соус Spicy-X", 90));
        float actual = burger.getPrice();
        float delta = 0;
        assertEquals(3403, actual, delta);
    }

    @Test
    public void getReceipt() {
        burger.setBuns(new Bun("Флюоресцентная булка R2-D3", 988));
        burger.addIngredient(new Ingredient(FILLING, "Мясо бессмертных моллюсков Protostomia", 1337));
        burger.addIngredient(new Ingredient(SAUCE, "Соус Spicy-X", 90));
        String actual = burger.getReceipt();
        float actualPrice = burger.getPrice();
        String expected = String.format("(==== Флюоресцентная булка R2-D3 ====)%n" +
                "= filling Мясо бессмертных моллюсков Protostomia =%n" +
                "= sauce Соус Spicy-X =%n" +
                "(==== Флюоресцентная булка R2-D3 ====)%n" +
                "%nPrice: %f%n", actualPrice);
        assertEquals(expected, actual);
    }
}