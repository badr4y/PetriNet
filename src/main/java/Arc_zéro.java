public class Arc_zéro extends Arc {
	
	public Arc_zéro(Place place, Transition transition) {
		this.place=place;
		this.transition=transition;
	}

	// Redéfinition de la méthode Tirable pour un Arc Zéro
	@Override
	public boolean Tirable() {
		// Un Arc Zéro est tirable si la place associée n'a aucun jeton
		return place.getNb_Jetons() ==0;
	}

	@Override
	public void Retirer_jetons() {
	}
}
