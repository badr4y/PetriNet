/**
 * This package contains classes representing components of a Petri Network.
 * A Petri Network consists of Places, Transitions, and Arcs connecting them.
 * The main classes in this package include:
 * - {@link petrinet.main.Place}: Represents a place in the Petri Network.
 * - {@link petrinet.main.Transition}: Represents a transition in the Petri Network.
 * - {@link petrinet.main.Arc}: Represents a generic arc connecting a place and a transition.
 * - {@link petrinet.main.ArcVideur}: Represents a specific type of arc with certain characteristics.
 * - {@link petrinet.main.ArcZero}: Represents another specific type of arc with different characteristics.
 * - {@link petrinet.main.IPetriNet}: Interface defining basic operations for a Petri Network.
 * - {@link petrinet.main.PetriNet}: Represents the overall Petri Network.
 * Usage:
 * Employ the classes and interfaces within this package for the modeling and simulation of systems using Petri Networks.
 * Initiate the process by constructing a PetriNet, incorporating places, transitions, and arcs. Subsequently, simulate the behavior of the system."
 * Example :
 * arcs = new ArrayList<>();
 * places = new ArrayList<>();
 * transitions = new ArrayList<>();
 * petriNet = new PetriNet(arcs, places, transitions);
 * Place place1 = new Place(3);
 * Place place2 = new Place();
 * Transition transition = new Transition(new ArrayList<>(),new ArrayList<>());
 * Arc arc1 = new Arc(2,place1,transition);
 * Arc arc2 = new Arc(3, place2, transition);
 * transition.getEnteringArcs().add(arc1);
 * transition.getExitingArcs().add(arc2);
 * @since 1.0
 * @version 1.0
 */
package petrinet.main;