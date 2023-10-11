package org.example;

public class Arc {
    private int poids;
    protected Place place;
    protected Transition transition;

    public Arc() {
    }

    public Arc(int poids, Place place, Transition transition) {
        this.poids = poids;
        this.transition = transition;
        this.place= place;
    }

    public int getPoids() {
        return poids;
    }

    public void Modifier_poids(int n) {
        this.poids = n;
    }

    public boolean Tirable() {
        return place.getNb_Jetons() <= poids;
    }

    public void Ajouter_jetons() {
        place.setNb_Jetons(place.getNb_Jetons()+poids);
    }

    public void Retirer_jetons() {
        place.setNb_Jetons(place.getNb_Jetons()-poids);
    }


}
