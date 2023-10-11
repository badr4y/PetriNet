package org.example;

import java.util.ArrayList;
import java.util.List;

public class Transition {
	private List<Arc> arcs_entrant;
	private List<Arc> arcs_sortant;
	
	public Transition() {
	}
	public Transition(ArrayList<Arc> arcs_entrant, ArrayList<Arc> arcs_sortant) {
		 this.arcs_entrant = arcs_entrant;
	     this.arcs_sortant = arcs_sortant;
	}

	public void setArcs_entrant(ArrayList<Arc> arcs_entrant) {
		this.arcs_entrant = arcs_entrant;
	}

	public void setArcs_sortant(ArrayList<Arc> arcs_sortant) {
		this.arcs_sortant = arcs_sortant;
	}

	public void Activer() {
		boolean tirable = true;
		for (int i=0; i<arcs_entrant.size(); i++) {
			if (!this.arcs_entrant.get(i).Tirable()) {
				tirable = false;
				break;
			}
		}
		if (tirable) {
			for (int i = 0; i < arcs_entrant.size(); i++) {
				arcs_entrant.get(i).Retirer_jetons();
			}
			for (int i = 0; i < arcs_sortant.size(); i++) {
				arcs_sortant.get(i).Ajouter_jetons();
			}
		}
	}
}
