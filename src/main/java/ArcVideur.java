public class ArcVideur extends Arc {

    public ArcVideur(Place place, Transition transition) {
        this.place = place;
        this.transition = transition;
    }

    public ArcVideur() {
    }

    // Redéfinition de la méthode Tirable pour un Arc_videur
    @Override
    public boolean drawable() {
        // Un Arc_videur est tirable si la place associée a au moins un jeton
        return place.getTokens() > 0;
    }

    // Redéfinition de la méthode Retirer_jetons pour un Arc_videur
    @Override
    public void retrieveTokens() {
        // Lorsque l'Arc_videur est tiré, il retire tous les jetons de la place associée
        place.setTokens(0);
    }
}
