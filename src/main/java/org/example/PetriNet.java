package org.example;

import java.util.ArrayList;
import java.util.List;

public class PetriNet implements IPetriNet{

    List<Arc> Arcs = new ArrayList<>();
    List<Place> Places = new ArrayList<>();
    List<Transition> Transitions = new ArrayList<>();

    @Override
    public void Ajouter_arc(Arc arc) {
        Arcs.add(arc);
    }

    @Override
    public void Ajouter_place(Place place) {
        Places.add(place);
    }

    @Override
    public void Ajouter_transition(Transition transition) {
        Transitions.add(transition);
    }

    @Override
    public void Supprimer_arc(Arc arc) {
        Arcs.remove(arc);
    }

    @Override
    public void Supprimer_transition(Transition transition) {
        Transitions.remove(transition);
    }

    @Override
    public void Supprimer_place(Place place) {
        Places.remove(place);
    }

    @Override
    public void Fire(Transition transition) {
        transition.Activer();
    }

    public static void main(String[] args) {

    }
}