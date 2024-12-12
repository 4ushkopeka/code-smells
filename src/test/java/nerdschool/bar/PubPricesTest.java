package nerdschool.bar;

import Drinks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Pub spec")
public class PubPricesTest {

    private Pub pub;

    @BeforeEach
    public void setUp() throws Exception {
        pub = new Pub();
    }

    @Test
    @DisplayName("When we order one beer, then the price is 74 kr.")
    public void oneBeerTest() {
        int actualPrice = pub.computeCost(new HansaBeer(), false, 1);
        assertEquals(74, actualPrice);
    }

    @Test
    @DisplayName("When we order one cider, then the price is 103 kr.")
    public void testCidersAreCostly() throws Exception {
        int actualPrice = pub.computeCost(new GransCider(), false, 1);
        assertEquals(103, actualPrice);
    }

    @Test
    @DisplayName("When we order a proper cider, then the price is 110 kr.")
    public void testProperCidersAreEvenMoreExpensive() throws Exception {
        int actualPrice = pub.computeCost(new StrongbowCider(), false, 1);
        assertEquals(110, actualPrice);
    }

    @Test
    @DisplayName("When we order a gin and tonic, then the price is 115 kr.")
    public void testACocktail() throws Exception {
        int actualPrice = pub.computeCost(new GT(), false, 1);
        assertEquals(115, actualPrice);
    }

    @Test
    @DisplayName("When we order a bacardi special, then the price is 127 kr.")
    public void testBacardiSpecial() throws Exception {
        int actualPrice = pub.computeCost(new BacardiSpecial(), false, 1);
        assertEquals(127, actualPrice);
    }

    @Nested
    @DisplayName("Given a customer who is a student")
    class Students {
        @Test
        @DisplayName("When they order a beer, then they get a discount.")
        public void testStudentsGetADiscountForBeer() throws Exception {
            int actualPrice = pub.computeCost(new HansaBeer(), true, 1);
            assertEquals(67, actualPrice);
        }

        @Test
        @DisplayName("When they order multiple beers, they also get a discount.")
        public void testStudentsGetDiscountsWhenOrderingMoreThanOneBeer() throws Exception {
            int actualPrice = pub.computeCost(new HansaBeer(), true, 2);
            assertEquals(67 * 2, actualPrice);
        }

        @Test
        @DisplayName("When they order a cocktail, they do not get a discount.")
        public void testStudentsDoNotGetDiscountsForCocktails() throws Exception {
            int actualPrice = pub.computeCost(new GT(), true, 1);
            assertEquals(115, actualPrice);
        }
    }

    @Nested
    @DisplayName("When they order more than two drinks")
    class MultipleDrinks {
        @Test
        @DisplayName("and the order is for cocktails, then they are refused.")
        public void testCanBuyAtMostTwoDrinksInOneGo() throws Exception {
            assertThrows(RuntimeException.class, () -> pub.computeCost(new BacardiSpecial(), false, 3));
        }

        @Test
        @DisplayName("and the order is for beers, then they are served.")
        public void testCanOrderMoreThanTwoBeers() throws Exception {
            pub.computeCost(new HansaBeer(), false, 5);
        }
    }
}
