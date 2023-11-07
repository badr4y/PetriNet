public class Arc_videur extends Arc {

    public Arc_videur(Place place, Transition transition) {
        this.place = place;
        this.transition = transition;
    }

    public Arc_videur() {
    }

    // Redéfinition de la méthode Tirable pour un Arc_videur
    @Override
    public boolean Tirable() {
        // Un Arc_videur est tirable si la place associée a au moins un jeton
        return place.getNb_Jetons() > 0;
    }

    // Redéfinition de la méthode Retirer_jetons pour un Arc_videur
    @Override
    public void Retirer_jetons() {
        // Lorsque l'Arc_videur est tiré, il retire tous les jetons de la place associée
        place.setNb_Jetons(0);
    }
}
