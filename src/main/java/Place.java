public class Place {
	private int nb_jetons;
	
	
	public Place(int n) {
		nb_jetons = n;
	}
	public void Modifier_jetons(int m) {
		nb_jetons = m;
	}
	public int getNb_Jetons() {
		return nb_jetons;
	}
	public void setNb_Jetons(int m) {
		nb_jetons = m;
	}
}
