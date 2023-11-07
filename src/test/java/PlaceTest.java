
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlaceTest {
    private Place place;

    @BeforeEach
    public void setUp() {
        place = new Place(5); // Initialize a Place object with 5 tokens.
    }

    @Test
    public void testConstructor() {
        assertNotNull(place);
    }

    @Test
    public void testModifierJetons() {
        place.Modifier_jetons(10); // Modify the number of tokens to 10.
        assertEquals(10, place.getNb_Jetons(), "Modifier_jetons should update the number of tokens.");
    }

    @Test
    public void testSetNbJetons() {
        place.setNb_Jetons(7); // Set the number of tokens to 7.
        assertEquals(7, place.getNb_Jetons(), "setNbJetons should set the number of tokens.");
    }

    @Test
    public void testGetNbJetons() {
        int tokens = place.getNb_Jetons();
        assertEquals(5, tokens, "getNb_Jetons should return the current number of tokens.");
    }
}
