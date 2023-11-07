import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PetriNetTest {
    private PetriNet petriNet;
    private List<Arc> arcs;
    private List<Place> places;
    private List<Transition> transitions;

    @BeforeEach
    public void setUp() {
        arcs = new ArrayList<>();
        places = new ArrayList<>();
        transitions = new ArrayList<>();
        petriNet = new PetriNet(arcs, places, transitions);
    }

    @Test
    public void testDefaultConstructor(){
        petriNet = new PetriNet();
        assertNotNull(petriNet);
    }

    @Test
    public void testAjouterArcLinkedToPlaceAndTransitionNotAddedToPetriNetPlacesAndTransitionsRecords() {
        Transition transition = new Transition();
        Place place = new Place(2);

        Arc arc = new Arc(2, place, transition);
        petriNet.Ajouter_arc(arc);

        assertTrue(arcs.contains(arc), "Ajouter_arc should add the arc to the list of arcs.");
        assertTrue(transitions.contains(transition), "Ajouter_arc should add the transition to the list of transitions.");
        assertTrue(places.contains(place), "Ajouter_arc should add the place to the list of places.");
    }

    @Test
    public void testAjouterPlace() {
        Place place = new Place(2);
        petriNet.Ajouter_place(place);
        assertTrue(places.contains(place), "Ajouter_place should add the place to the list of places.");
    }

    @Test
    public void testAjouterTransition() {
        Transition transition = new Transition();
        petriNet.Ajouter_transition(transition);
        assertTrue(transitions.contains(transition), "Ajouter_transition should add the transition to the list of transitions.");
    }

    @Test
    public void testSupprimerArc() {
        Transition transition = new Transition();
        Place place = new Place(2);
        Arc arc = new Arc(2, place, transition);
        petriNet.Ajouter_arc(arc);

        petriNet.Supprimer_arc(arc);
        assertFalse(arcs.contains(arc), "Supprimer_arc should remove the arc from the list of arcs.");
        assertTrue(transitions.contains(transition), "Supprimer_arc should not remove the transition from the list of transitions.");
        assertTrue(places.contains(place), "Supprimer_arc should not remove the place from the list of places.");
    }

    @Test
    public void testSupprimerPlace() {
        Place place = new Place(2);
        places.add(place);
        petriNet.Supprimer_place(place);
        assertFalse(places.contains(place), "Supprimer_place should remove the place from the list of places.");
    }

    @Test
    public void testSupprimerTransition() {
        Transition transition = new Transition();
        transitions.add(transition);
        petriNet.Supprimer_transition(transition);
        assertFalse(transitions.contains(transition), "Supprimer_transition should remove the transition from the list of transitions.");
    }

    @Test
    public void testFire() {
        Transition transition = new Transition();
        TransitionSpy transitionSpy = new TransitionSpy(transition);
        transitions.add(transitionSpy);
        petriNet.Fire(transition);
        assertTrue(transitionSpy.isActivated(), "Fire should activate the transition.");
    }
}

class TransitionSpy extends Transition {
    private boolean activated = false;

    public TransitionSpy() {
    }

    public TransitionSpy(Transition original) {
        super();
    }

    @Override
    public void Activer() {
        super.Activer();
        activated = true;
    }

    public boolean isActivated() {
        return activated;
    }
}

