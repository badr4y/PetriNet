package petrinet.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import petrinet.main.ArcZero;
import petrinet.main.Place;
import petrinet.main.Transition;

public class ArcZeroTest {
    private ArcZero arcZero;
    private Place place;
    private Transition transition;

    @BeforeEach
    public void setUp() {
        place = new Place(0); // Initialize a Place with 0 tokens.
        transition = new Transition();
        arcZero = new ArcZero(place, transition); // Initialize an Arc_zero connected to the Place and Transition.
    }

    @Test
    public void testDefaultConstructor() {
        arcZero = new ArcZero();
        assertNotNull(arcZero);
    }

    @Test
    public void testParametrizedConstructor() {
        assertNotNull(arcZero);
    }

    @Test
    public void testFirableWhenPlaceIsEmpty() {
        assertTrue(arcZero.firable(), "Arc_zero should be tirable when the associated place is empty.");
    }

    @Test
    public void testFirableWhenPlaceHasTokens() {
        place.setTokens(3); // Set the number of tokens in the Place to 3.
        assertFalse(arcZero.firable(), "Arc_zero should not be tirable when the associated place has tokens.");
    }

    @Test
    public void testRetrieveTokens() {
        place.setTokens(0); // Set the number of tokens in the Place to 0.
        arcZero.retrieveTokens(); // Execute Retirer_jetons.

        assertEquals(0, place.getTokens(), "Retirer_jetons should not change the number of tokens in the associated place.");
    }
}
