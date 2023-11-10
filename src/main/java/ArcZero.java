public class ArcZero extends Arc {

	public ArcZero(){}
	
	public ArcZero(Place place, Transition transition) {
		this.place=place;
		this.transition=transition;
	}

	// Redéfinition de la méthode Tirable pour un Arc Zéro
	@Override
	public boolean drawable() {
		// Un Arc Zéro est tirable si la place associée n'a aucun jeton
		return place.getTokens() ==0;
	}

	@Override
	public void retrieveTokens() {
	}
}
