import java.util.List;

public class PetriNet implements IPetriNet {

    private List<Arc> arcs;
    private List<Place> places;
    private List<Transition> transitions;

    public PetriNet() {
    }

    public PetriNet(List<Arc> arcs, List<Place> places, List<Transition> transitions) {
        this.arcs = arcs;
        this.transitions = transitions;
        this.places = places;
    }

    @Override
    public void Ajouter_arc(Arc arc) {
        if (!this.places.contains(arc.getPlace())) {
            this.arcs.add(arc);
            if (arc.getTransition() != null && !this.transitions.contains(arc.getTransition())) {
                this.transitions.add(arc.getTransition());
            }

            if (arc.getPlace() != null && !this.places.contains(arc.getPlace())) {
                this.places.add(arc.getPlace());
            }
        }
    }

    @Override
    public void Ajouter_place(Place place) {
        this.places.add(place);
    }

    @Override
    public void Ajouter_transition(Transition transition) {
        this.transitions.add(transition);
    }

    @Override
    public void Supprimer_arc(Arc arc) {
        this.arcs.remove(arc);
    }

    @Override
    public void Supprimer_transition(Transition transition) {
        this.transitions.remove(transition);
    }

    @Override
    public void Supprimer_place(Place place) {
        this.places.remove(place);
    }

    @Override
    public void Fire(Transition transition) {
        // Activation de la transition lorsqu'elle est déclenchée
        transition.Activer();
    }

}