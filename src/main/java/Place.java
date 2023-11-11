public class Place {
	private int tokens;

	public Place() {
		tokens =0;
	}

	public Place(int n) {
		if(n<0) {
			tokens = 0;
		} else {
			tokens = n;
		}
	}
	public void changeTokens(int m) {
		if(m<0) {
			tokens = 0;
		} else {
			tokens = m;
		}
	}
	public int getTokens() {
		return tokens;
	}
	public void setTokens(int m) {
		tokens = m;
	}
}
