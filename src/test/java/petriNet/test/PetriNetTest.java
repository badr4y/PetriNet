package petrinet.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import petrinet.main.Arc;
import petrinet.main.PetriNet;
import petrinet.main.Place;
import petrinet.main.Transition;

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
    public void testDefaultConstructor() {
        petriNet = new PetriNet();
        assertNotNull(petriNet);
    }

    @Test
    public void testAjouterArcLinkedToPlaceAndTransitionNotAddedToPetriNetPlacesAndTransitionsRecords() {
        Transition transition = new Transition();
        Place place = new Place(2);

        Arc arc = new Arc(2, place, transition);
        petriNet.addArc(arc);

        assertTrue(arcs.contains(arc), "Ajouter_arc should add the arc to the list of arcs.");
        assertTrue(transitions.contains(transition), "Ajouter_arc should add the transition to the list of transitions.");
        assertTrue(places.contains(place), "Ajouter_arc should add the place to the list of places.");
    }

    @Test
    public void testAddPlace() {
        Place place = new Place(2);
        petriNet.addPlace(place);
        assertTrue(places.contains(place), "Ajouter_place should add the place to the list of places.");
    }

    @Test
    public void testAddTransition() {
        Transition transition = new Transition();
        petriNet.addTransition(transition);
        assertTrue(transitions.contains(transition), "Ajouter_transition should add the transition to the list of transitions.");
    }

    @Test
    public void testDeleteArc() {
        Transition transition = new Transition();
        Place place = new Place(2);
        Arc arc = new Arc(2, place, transition);
        petriNet.addArc(arc);

        petriNet.deleteArc(arc);
        assertFalse(arcs.contains(arc), "Supprimer_arc should remove the arc from the list of arcs.");
        assertTrue(transitions.contains(transition), "Supprimer_arc should not remove the transition from the list of transitions.");
        assertTrue(places.contains(place), "Supprimer_arc should not remove the place from the list of places.");
    }

    @Test
    public void testDeletePlace() {
        Place place = new Place(2);
        places.add(place);
        petriNet.deletePlace(place);
        assertFalse(places.contains(place), "Supprimer_place should remove the place from the list of places.");
    }

    @Test
    public void testDeleteTransition() {
        Transition transition = new Transition();
        transitions.add(transition);
        petriNet.deleteTransition(transition);
        assertFalse(transitions.contains(transition), "Supprimer_transition should remove the transition from the list of transitions.");
    }

    @Test
    void testFireWhenTransitionFirable() {

    }

    @Test
    void testFireWhenNotTransitionFirable() {
    }
}

