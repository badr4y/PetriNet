package petriNet.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import petrinet.exceptions.NullTransitionException;
import petrinet.main.*;

import java.util.ArrayList;
import java.util.List;

public class TransitionTest {
    private Transition transition;

    @BeforeEach
    public void setUp() {
        transition = new Transition();
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(transition);
        Assertions.assertNull(transition.getEnteringArcs(), "Default constructor should set incoming arcs to null.");
        Assertions.assertNull(transition.getExitingArcs(), "Default constructor should set outgoing arcs to null.");
    }

    @Test
    public void testSetEnteringArcs(){
        Arc arc = new Arc();
        ArrayList<Arc> arcs_entrant = new ArrayList<>();
        arcs_entrant.add(arc);
        transition.setEnteringArcs(arcs_entrant);
        assertNotNull(transition.getEnteringArcs());
    }

    @Test
    public void testSetExitingArcs(){
        Arc arc = new Arc();
        ArrayList<Arc> exitingArcs = new ArrayList<>();
        exitingArcs.add(arc);
        transition.setExitingArcs(exitingArcs);
        assertNotNull(transition.getExitingArcs());
    }


    @Test
    public void testParameterizedConstructor() {
        ArrayList<Arc> enteringArcs = new ArrayList<>();
        enteringArcs.add(new Arc(2, new Place(3), transition));
        ArrayList<Arc> arcsSortant = new ArrayList<>();
        arcsSortant.add(new Arc(3, new Place(0), transition));

        transition = new Transition(enteringArcs, arcsSortant);
        assertNotNull(transition);
        Assertions.assertEquals(enteringArcs, transition.getEnteringArcs(), "Parameterized constructor should set incoming arcs.");
        Assertions.assertEquals(arcsSortant, transition.getExitingArcs(), "Parameterized constructor should set outgoing arcs.");
    }

    @Test
    public void testActivateForDefaultTransition() {
        assertThrows(NullTransitionException.class, () -> {
            // Call the Activer method on a null Transition object
            transition.activate();
        });
    }

    @Test
    public void testActivateWithEmptyArcLists() throws NullTransitionException {
        transition = new Transition(new ArrayList<Arc>(),new ArrayList<Arc>()) ;
        transition.activate();
    }

    @Test
    public void testActivateCase1() throws NullTransitionException {
        ArrayList<Arc> enteringArcs = new ArrayList<>();
        enteringArcs.add(new Arc(0, new Place(2), transition));

        ArrayList<Arc> exitingArcs = new ArrayList<>();
        exitingArcs.add(new Arc(2, new Place(0), transition));

        transition.setEnteringArcs(enteringArcs);
        transition.setExitingArcs(exitingArcs);

        transition.activate();

        assertEquals(2, enteringArcs.get(0).getPlace().getTokens(), "Activer should not change tokens in the first incoming arc.");
        assertEquals(2, exitingArcs.get(0).getPlace().getTokens(), "Activer should not change tokens in the outgoing arc.");
    }



    @Test
    public void testActivateCase2() throws NullTransitionException {
        ArrayList<Arc> enteringArcs = new ArrayList<>();
        enteringArcs.add(new Arc(0, new Place(0), transition));

        ArrayList<Arc> exitingArcs = new ArrayList<>();
        exitingArcs.add(new Arc(2, new Place(0), transition));

        transition.setEnteringArcs(enteringArcs);
        transition.setExitingArcs(exitingArcs);

        transition.activate();

        assertEquals(0, enteringArcs.get(0).getPlace().getTokens(), "Activer should not change tokens in the first incoming arc.");
        assertEquals(2, exitingArcs.get(0).getPlace().getTokens(), "Activer should change tokens in the outgoing arc.");
    }

    @Test
    public void testActivateCase3() throws NullTransitionException {
        ArrayList<Arc> enteringArcs = new ArrayList<>();
        enteringArcs.add(new ArcVideur(new Place(5), transition));

        ArrayList<Arc> exitingArcs = new ArrayList<>();
        exitingArcs.add(new Arc(2, new Place(0), transition));

        transition.setEnteringArcs(enteringArcs);
        transition.setExitingArcs(exitingArcs);

        transition.activate();

        assertEquals(0, enteringArcs.get(0).getPlace().getTokens(), "Activer should not change tokens in the first incoming arc.");
        assertEquals(2, exitingArcs.get(0).getPlace().getTokens(), "Activer should change tokens in the outgoing arc.");
    }

    @Test
    public void testActivateCase4() throws NullTransitionException {
        ArrayList<Arc> arcsEntrant = new ArrayList<>();
        arcsEntrant.add(new ArcVideur(new Place(0), transition));

        ArrayList<Arc> exitingArcs = new ArrayList<>();
        exitingArcs.add(new Arc(2, new Place(0), transition));

        transition.setEnteringArcs(arcsEntrant);
        transition.setExitingArcs(exitingArcs);

        transition.activate();

        assertEquals(0, arcsEntrant.get(0).getPlace().getTokens(), "Activer should not change tokens in the first incoming arc.");
        assertEquals(0, exitingArcs.get(0).getPlace().getTokens(), "Activer should change tokens in the outgoing arc.");
    }

    @Test
    public void testActivateCase5() throws NullTransitionException {
        ArrayList<Arc> enteringArcs = new ArrayList<>();
        enteringArcs.add(new ArcZero(new Place(0), transition));

        ArrayList<Arc> exitingArcs = new ArrayList<>();
        exitingArcs.add(new Arc(5, new Place(0), transition));

        transition.setEnteringArcs(enteringArcs);
        transition.setExitingArcs(exitingArcs);

        transition.activate();

        assertEquals(0, enteringArcs.get(0).getPlace().getTokens(), "Activer should not change tokens in the first incoming arc.");
        assertEquals(5, exitingArcs.get(0).getPlace().getTokens(), "Activer should change tokens in the outgoing arc.");
    }

    @Test
    public void testActivateCase6() throws NullTransitionException {
        ArrayList<Arc> enteringArcs = new ArrayList<>();
        enteringArcs.add(new ArcZero(new Place(4), transition));

        ArrayList<Arc> exitingArcs = new ArrayList<>();
        exitingArcs.add(new Arc(5, new Place(0), transition));

        transition.setEnteringArcs(enteringArcs);
        transition.setExitingArcs(exitingArcs);

        transition.activate();

        assertEquals(4, enteringArcs.get(0).getPlace().getTokens(), "Activer should not change tokens in the first incoming arc.");
        assertEquals(0, exitingArcs.get(0).getPlace().getTokens(), "Activer should change tokens in the outgoing arc.");
    }


    @Test
    public void testActivateWhenAllTirable() throws NullTransitionException {
        List<Arc> enteringArcs = new ArrayList<>();
        enteringArcs.add(new Arc(2, new Place(3), transition));
        enteringArcs.add(new Arc(1, new Place(4), transition));

        List<Arc> exitingArcs = new ArrayList<>();
        exitingArcs.add(new Arc(3, new Place(0), transition));

        transition.setEnteringArcs((ArrayList<Arc>) enteringArcs);
        transition.setExitingArcs((ArrayList<Arc>) exitingArcs);

        transition.activate();

        assertEquals(1, enteringArcs.get(0).getPlace().getTokens(), "Activer should have reduced tokens in the first incoming arc.");
        assertEquals(3, enteringArcs.get(1).getPlace().getTokens(), "Activer should have reduced tokens in the second incoming arc.");
        assertEquals(3, exitingArcs.get(0).getPlace().getTokens(), "Activer should have added tokens to the outgoing arc.");
    }


    @Test
    public void testActivateWhenNotAllTirable() throws NullTransitionException {
        ArrayList<Arc> enteringArcs = new ArrayList<>();
        enteringArcs.add(new Arc(4, new Place(2), transition));
        enteringArcs.add(new Arc(3, new Place(5), transition));

        ArrayList<Arc> exitingArcs = new ArrayList<>();
        exitingArcs.add(new Arc(2, new Place(0), transition));

        transition.setEnteringArcs(enteringArcs);
        transition.setExitingArcs(exitingArcs);

        transition.activate();

        assertEquals(2, enteringArcs.get(0).getPlace().getTokens(), "Activer should not change tokens in the first incoming arc.");
        assertEquals(5, enteringArcs.get(1).getPlace().getTokens(), "Activer should not change tokens in the second incoming arc.");
        assertEquals(0, exitingArcs.get(0).getPlace().getTokens(), "Activer should not change tokens in the outgoing arc.");
    }

    @Test
    public void testActivateForDoubledArcs() throws NullTransitionException {
        ArrayList<Arc> enteringArcs = new ArrayList<>();
        Place place = new Place(3);
        enteringArcs.add(new Arc(2, place, transition));
        enteringArcs.add(new Arc(2, place, transition));

        ArrayList<Arc> exitingArcs = new ArrayList<>();
        exitingArcs.add(new Arc(2, new Place(0), transition));

        transition.setEnteringArcs(enteringArcs);
        transition.setExitingArcs(exitingArcs);

        transition.activate();

        assertEquals(0, enteringArcs.get(0).getPlace().getTokens());
        assertEquals(2, exitingArcs.get(0).getPlace().getTokens());
    }


}

