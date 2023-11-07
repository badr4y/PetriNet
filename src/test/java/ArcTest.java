import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArcTest {
    private Arc arc;
    private Place place;
    private Transition transition;

    @BeforeEach
    public void setUp() {
        place = new Place(5); // Initialize a Place with 5 tokens.
        transition = new Transition();
        arc = new Arc(3, place, transition); // Initialize an Arc with weight 3, connected to the Place and Transition.
    }

    @Test
    public void testConstructor() {
        assertEquals(3, arc.getPoids(), "Constructor should set the weight of the Arc.");
    }

    @Test
    public void testModifierPoids() {
        arc.Modifier_poids(4); // Modify the weight of the Arc to 4.
        assertEquals(4, arc.getPoids(), "Modifier_poids should update the weight of the Arc.");
    }

    @Test
    public void testTirableWhenTrue() {
        assertTrue(arc.Tirable(), "Tirable should return true when the number of tokens in the Place is more than or equal to the weight.");
    }

    @Test
    public void testTirableWhenFalse() {
        place.setNb_Jetons(2); // Set the number of tokens in the Place to 8.
        assertFalse(arc.Tirable(), "Tirable should return false when the number of tokens in the Place is inferior the weight.");
    }

    @Test
    public void testAjouterJetons() {
        arc.Ajouter_jetons(); // Add tokens to the Place based on the Arc's weight.
        assertEquals(8, place.getNb_Jetons(), "Ajouter_jetons should add tokens to the Place.");
    }

    @Test
    public void testRetirerJetons() {
        place.setNb_Jetons(7); // Set the number of tokens in the Place to 7.
        arc.Retirer_jetons(); // Remove tokens from the Place based on the Arc's weight.
        assertEquals(4, place.getNb_Jetons(), "Retirer_jetons should remove tokens from the Place.");
    }
}
