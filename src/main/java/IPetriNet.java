public interface IPetriNet {
    void Ajouter_arc(Arc arc);
    void Ajouter_place(Place place);
    void Ajouter_transition(Transition transition);

    void Supprimer_arc(Arc arc);
    void Supprimer_transition(Transition transition);
    void Supprimer_place(Place place);

    // Méthode pour déclencher une transition dans le réseau de Petri
    void Fire(Transition transition);


}
