package config;

public class EnvConfig {
    public static final float DELTA = 0;
    public static final float BUN_PRICE = 1000;
    public static final float INGREDIENT_PRICE = 2000;
    public static final float BURGER_PRICE = 6000;
    public static final String BUN_NAME = "black bun";
    public static final String INGREDIENT_FILLING_NAME = "cutlet";
    public static final String INGREDIENT_SAUCE_NAME = "sour cream";

    public static final String RECEIPT = String.format("(==== black bun ====)%n" +
            "= filling cutlet =%n" +
            "= sauce sour cream =%n" +
            "(==== black bun ====)%n" +
            "%nPrice: 6000,000000%n");
}
