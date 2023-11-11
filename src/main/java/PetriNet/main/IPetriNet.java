package PetriNet.main;

public interface IPetriNet {
    void addArc(Arc arc);
    void addPlace(Place place);
    void addTransition(Transition transition);

    void deleteArc(Arc arc);
    void deleteTransition(Transition transition);
    void deletePlace(Place place);

    void fire(Transition transition);


}
