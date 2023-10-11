package org.example;

public class Arc_videur extends Arc{

    public Arc_videur(Place place, Transition transition) {
        this.place = place;
        this.transition = transition;
    }
    @Override
    public boolean Tirable() {
        return place.getNb_Jetons() > 0;
    }
    @Override
    public void Retirer_jetons() {
        place.setNb_Jetons(0);
    }


}
