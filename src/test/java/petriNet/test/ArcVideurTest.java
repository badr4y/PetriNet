package petrinet.test;

import static org.junit.jupiter.api.Assertions.*;

import petrinet.main.ArcVideur;
import petrinet.main.Place;
import petrinet.main.Transition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArcVideurTest {
    private ArcVideur arcVideur;
    private Place place;
    private Transition transition;

    @BeforeEach
    public void setUp() {
        place = new Place(3); // Initialize a Place with 3 tokens.
        transition = new Transition();
        arcVideur = new ArcVideur(place, transition); // Initialize an Arc_videur connected to the Place and Transition.
    }

    @Test
    public void testDefaultConstructor(){
        arcVideur = new ArcVideur();
        assertNotNull(arcVideur);
    }

    @Test
    public void testParametrizedConstructor(){
        assertNotNull(arcVideur);
        assertNotNull(arcVideur.getTransition());
        assertNotNull(arcVideur.getPlace());
    }

    @Test
    public void testFirableWhenPlaceHasTokens() {
        assertTrue(arcVideur.firable(), "Arc_videur should be tirable when the associated place has tokens.");
    }

    @Test
    public void testFirableWhenPlaceIsEmpty() {
        place.setTokens(0); // Set the number of tokens in the Place to 0.
        assertFalse(arcVideur.firable(), "Arc_videur should not be tirable when the associated place is empty.");
    }

    @Test
    public void testRetrieveTokens() {
        place.setTokens(2); // Set the number of tokens in the Place to 2.
        arcVideur.retrieveTokens(); // Execute Retirer_jetons.

        assertEquals(0, place.getTokens(), "Retirer_jetons should remove all tokens from the associated place.");
    }
}
