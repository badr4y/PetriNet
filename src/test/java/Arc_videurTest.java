import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Arc_videurTest {
    private Arc_videur arcVideur;
    private Place place;
    private Transition transition;

    @BeforeEach
    public void setUp() {
        place = new Place(3); // Initialize a Place with 3 tokens.
        transition = new Transition();
        arcVideur = new Arc_videur(place, transition); // Initialize an Arc_videur connected to the Place and Transition.
    }

    @Test
    public void testTirableWhenPlaceHasTokens() {
        assertTrue(arcVideur.Tirable(), "Arc_videur should be tirable when the associated place has tokens.");
    }

    @Test
    public void testTirableWhenPlaceIsEmpty() {
        place.setNb_Jetons(0); // Set the number of tokens in the Place to 0.
        assertFalse(arcVideur.Tirable(), "Arc_videur should not be tirable when the associated place is empty.");
    }

    @Test
    public void testRetirerJetons() {
        place.setNb_Jetons(2); // Set the number of tokens in the Place to 2.
        arcVideur.Retirer_jetons(); // Execute Retirer_jetons.

        assertEquals(0, place.getNb_Jetons(), "Retirer_jetons should remove all tokens from the associated place.");
    }
}
