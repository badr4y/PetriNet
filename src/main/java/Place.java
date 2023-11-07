public class Place {
	private int nb_jetons;

	public Place() {
		nb_jetons =0;
	}

	public Place(int n) {
		if(n<0) {
			nb_jetons = 0;
		} else {
			nb_jetons = n;
		}
	}
	public void Modifier_jetons(int m) {
		if(m<0) {
			nb_jetons = 0;
		} else {
			nb_jetons = m;
		}
	}
	public int getNb_Jetons() {
		return nb_jetons;
	}
	public void setNb_Jetons(int m) {
		nb_jetons = m;
	}
}
