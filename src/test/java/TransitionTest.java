import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        assertNull(transition.getArcs_entrant(), "Default constructor should set incoming arcs to null.");
        assertNull(transition.getArcs_sortant(), "Default constructor should set outgoing arcs to null.");
    }

    @Test
    public void testSetArcEntrant(){
        Arc arc = new Arc();
        ArrayList<Arc> arcs_entrant = new ArrayList<>();
        arcs_entrant.add(arc);
        transition.setArcs_entrant(arcs_entrant);
        assertNotNull(transition.getArcs_entrant());
    }

    @Test
    public void testSetArcSortant(){
        Arc arc = new Arc();
        ArrayList<Arc> arcs_sortant = new ArrayList<>();
        arcs_sortant.add(arc);
        transition.setArcs_entrant(arcs_sortant);
        assertNotNull(transition.getArcs_sortant());
    }


    @Test
    public void testParameterizedConstructor() {
        ArrayList<Arc> arcsEntrant = new ArrayList<>();
        arcsEntrant.add(new Arc(2, new Place(3), transition));
        ArrayList<Arc> arcsSortant = new ArrayList<>();
        arcsSortant.add(new Arc(3, new Place(0), transition));

        transition = new Transition(arcsEntrant, arcsSortant);
        assertNotNull(transition);
        assertEquals(arcsEntrant, transition.getArcs_entrant(), "Parameterized constructor should set incoming arcs.");
        assertEquals(arcsSortant, transition.getArcs_sortant(), "Parameterized constructor should set outgoing arcs.");
    }

    @Test
    public void testActiverWhenAllTirable() {
        List<Arc> arcsEntrant = new ArrayList<>();
        arcsEntrant.add(new Arc(2, new Place(3), transition));
        arcsEntrant.add(new Arc(1, new Place(4), transition));

        List<Arc> arcsSortant = new ArrayList<>();
        arcsSortant.add(new Arc(3, new Place(0), transition));

        transition.setArcs_entrant((ArrayList<Arc>) arcsEntrant);
        transition.setArcs_sortant((ArrayList<Arc>) arcsSortant);

        transition.Activer();

        assertEquals(1, arcsEntrant.get(0).getPlace().getNb_Jetons(), "Activer should have reduced tokens in the first incoming arc.");
        assertEquals(3, arcsEntrant.get(1).getPlace().getNb_Jetons(), "Activer should have reduced tokens in the second incoming arc.");
        assertEquals(3, arcsSortant.get(0).getPlace().getNb_Jetons(), "Activer should have added tokens to the outgoing arc.");
    }

    @Test
    public void testActiverWhenNotAllTirable() {
        ArrayList<Arc> arcsEntrant = new ArrayList<>();
        arcsEntrant.add(new Arc(4, new Place(2), transition));
        arcsEntrant.add(new Arc(3, new Place(5), transition));

        ArrayList<Arc> arcsSortant = new ArrayList<>();
        arcsSortant.add(new Arc(2, new Place(0), transition));

        transition.setArcs_entrant(arcsEntrant);
        transition.setArcs_sortant(arcsSortant);

        transition.Activer();

        assertEquals(2, arcsEntrant.get(0).getPlace().getNb_Jetons(), "Activer should not change tokens in the first incoming arc.");
        assertEquals(5, arcsEntrant.get(1).getPlace().getNb_Jetons(), "Activer should not change tokens in the second incoming arc.");
        assertEquals(0, arcsSortant.get(0).getPlace().getNb_Jetons(), "Activer should not change tokens in the outgoing arc.");
    }
}

