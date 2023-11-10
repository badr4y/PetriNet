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
    public void addArc(Arc arc) {
            this.arcs.add(arc);
            if (arc.getTransition() != null && !this.transitions.contains(arc.getTransition())) {
                this.transitions.add(arc.getTransition());
            }

            if (arc.getPlace() != null && !this.places.contains(arc.getPlace())) {
                this.places.add(arc.getPlace());
            }
    }

    @Override
    public void addPlace(Place place) {
        this.places.add(place);
    }

    @Override
    public void addTransition(Transition transition) {
        this.transitions.add(transition);
    }

    @Override
    public void deleteArc(Arc arc) {
        this.arcs.remove(arc);
    }

    @Override
    public void deleteTransition(Transition transition) {
        this.transitions.remove(transition);
    }

    @Override
    public void deletePlace(Place place) {
        this.places.remove(place);
    }

    @Override
    public void fire(Transition transition) {
        // Activation de la transition lorsqu'elle est déclenchée
        transition.activate();
    }

}