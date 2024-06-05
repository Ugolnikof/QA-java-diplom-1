package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class BunTest {
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Флюоресцентная булка R2-D3", 988);
    }

    @Test
    public void getName() {
        String actual = bun.getName();
        assertEquals("Флюоресцентная булка R2-D3", actual);
    }

    @Test
    public void getPrice() {
        float actual = bun.getPrice();
        float delta = 0;
        assertEquals(988, actual, delta);
    }
}