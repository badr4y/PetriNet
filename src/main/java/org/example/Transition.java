package org.example;

public class Transition {
	private ArrayList<Arc> arcs_entrant;
	private ArrayList<Arc> arcs_sortant;
	
	public Transition() {
		
	}
	public Transition(ArrayList<Arc> arcs_entrant, ArrayList<Arc> arcs_sortant) {
		 arcs_entrant = arcs_entrant;
	     arcs_sortant = arcs_sortant;
	}
	
	public setArcs_entrants(ArrayList<Arc> arcs_entrants) {
		arcs_entrant = arcs_entrants;
	}
	
	public setArcs_sortant(ArrayList<Arc> arcs_sortrants) {
		arcs_sortant = arcs_sortants;
	}
}
