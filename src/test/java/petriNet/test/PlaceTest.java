package petriNet.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import petrinet.main.Place;

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
    public void testGetTokens() {
        int tokens = place.getTokens();
        assertEquals(5, tokens, "getNb_Jetons should return the current number of tokens.");
    }

    @Test
    public void testChangeTokens() {
        place.changeTokens(10); // Modify the number of tokens to 10.
        Assertions.assertEquals(10, place.getTokens(), "Modifier_jetons should update the number of tokens.");
    }

    @Test
    public void testChangeTokensWithNegativeNumber() {
        place.changeTokens(-5);
        Assertions.assertEquals(0, place.getTokens());
    }

    @Test
    public void testSetTokens() {
        place.setTokens(7); // Set the number of tokens to 7.
        Assertions.assertEquals(7, place.getTokens(), "setNbJetons should set the number of tokens.");
    }


}
