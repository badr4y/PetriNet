package org.example;

public class Arc_zéro extends Arc{
	
	public Arc_zéro(Place place, Transition transition) {
		this.place=place;
		this.transition=transition;
	}
	
	@Override
	public boolean Tirable() {
		return place.getNb_Jetons() ==0;
	}
	
}
