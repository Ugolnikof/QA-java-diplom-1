package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static config.EnvConfig.*;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient2;

    @Mock
    Bun bun;

    private final Burger burger = new Burger();


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
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        assertEquals(ingredient2, burger.getIngredients().get(0));
        assertEquals(ingredient, burger.getIngredients().get(1));
    }

    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(INGREDIENT_PRICE);
        Mockito.when(ingredient2.getPrice()).thenReturn(INGREDIENT_PRICE);
        assertEquals(6000, burger.getPrice(), DELTA);
    }

    @Test
    public void getReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.valueOf(String.valueOf(FILLING)));
        Mockito.when(ingredient.getName()).thenReturn(INGREDIENT_FILLING_NAME);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.valueOf(String.valueOf(SAUCE)));
        Mockito.when(ingredient2.getName()).thenReturn(INGREDIENT_SAUCE_NAME);
        Mockito.when(burger.getPrice()).thenReturn(BURGER_PRICE);
        assertEquals(RECEIPT, burger.getReceipt());
    }
}

