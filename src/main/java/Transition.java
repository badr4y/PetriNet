import java.util.ArrayList;
import java.util.List;

public class Transition {
	private List<Arc> enteringArcs;
	private List<Arc> exitingArcs;
	
	public Transition() {
	}
	public Transition(ArrayList<Arc> enteringArcs, ArrayList<Arc> exitingArcs) {
		 this.enteringArcs = enteringArcs;
	     this.exitingArcs = exitingArcs;
	}

	public List<Arc> getEnteringArcs() {
		return enteringArcs;
	}

	public List<Arc> getExitingArcs() {
		return exitingArcs;
	}

	public void setEnteringArcs(ArrayList<Arc> enteringArcs) {
		this.enteringArcs = enteringArcs;
	}

	public void setExitingArcs(ArrayList<Arc> exitingArcs) {
		this.exitingArcs = exitingArcs;
	}

	public void activate() {
		boolean drawable = true;

		// Vérifier si tous les arcs entrants sont tirables
		for (int i = 0; i< enteringArcs.size(); i++) {
			if (!this.enteringArcs.get(i).drawable()) {
				drawable = false;
				break;
			}
		}
		if (drawable) {
			// Si tous les arcs entrants sont tirables, retirer les jetons des arcs entrants
			for (int i = 0; i < enteringArcs.size(); i++) {
				enteringArcs.get(i).retrieveTokens();
			}
			// Ajouter des jetons aux arcs sortants
			for (int i = 0; i < exitingArcs.size(); i++) {
				exitingArcs.get(i).addTokens();
			}
		}
	}
}
