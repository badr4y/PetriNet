import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Arc_zéroTest {
    private Arc_zéro arcZero;
    private Place place;
    private Transition transition;

    @BeforeEach
    public void setUp() {
        place = new Place(0); // Initialize a Place with 0 tokens.
        transition = new Transition();
        arcZero = new Arc_zéro(place, transition); // Initialize an Arc_zero connected to the Place and Transition.
    }

    @Test
    public void testTirableWhenPlaceIsEmpty() {
        assertTrue(arcZero.Tirable(), "Arc_zero should be tirable when the associated place is empty.");
    }

    @Test
    public void testTirableWhenPlaceHasTokens() {
        place.setNb_Jetons(3); // Set the number of tokens in the Place to 3.
        assertFalse(arcZero.Tirable(), "Arc_zero should not be tirable when the associated place has tokens.");
    }

    @Test
    public void testRetirerJetons() {
        place.setNb_Jetons(0); // Set the number of tokens in the Place to 0.
        arcZero.Retirer_jetons(); // Execute Retirer_jetons.

        assertEquals(0, place.getNb_Jetons(), "Retirer_jetons should not change the number of tokens in the associated place.");
    }
}
