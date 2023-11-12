# PetriNet Java Project
PetriNet is a Java project that implements a simulation of a Petri Network.  
Petri Networks are mathematical modeling languages used for the description and analysis of systems.  
In this project, you can create Petri Nets, define places, transitions, and arcs, and simulate the dynamic behavior of the system.


## Table of Contents

- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Testing](#testing)
- [License](#license)

## Getting Started

### Prerequisites

Make sure you have the following prerequisites installed:
- Java Development Kit (JDK) - Version 17
- Maven - Version 4.0.0 (Optional, if you want to use Maven for building and dependency management)

### Installation

1. Clone the repository:
```bash
   git clone https://github.com/badr4y/PetriNet.git 
   cd PetriNet
   mvn clean install
```

## Usage
Utilize the classes and interfaces within this project to model and simulate systems using Petri Networks. Begin by instancing a PetriNet and subsequently incorporating places, transitions, and arcs. Simulate the system's behavior by either firing a specific transition or executing a step that triggers all firable transitions in the Petri Network.

Upon exploring the code, you'll discover various methods for creating a complete Petri Network, catering to the user's preferences. However, we recommend the following ideal sequence:

- First, create lists for arcs, transitions, and places.
- Next, construct the PetriNet using its parametrized constructor, passing the aforementioned lists as parameters.
- Subsequently, create places, followed by transitions, and finally arcs.
Associate the arcs with the transitions.
- Lastly, add the arcs to the PetriNet, which will automatically include the associated places and transitions.

This structured approach ensures a coherent setup of the Petri Network, aligning with best practices."

Example :  
```example
   Place place1 = new Place(3);
   Place place2 = new Place();
   Transition transition = new Transition(new ArrayList<>(),new ArrayList<>());
   Arc arc1 = new Arc(2,place1,transition);
   Arc arc2 = new Arc(3, place2, transition);
   transition.getEnteringArcs().add(arc1);
   transition.getExitingArcs().add(arc2);
   petriNet.addArc(arc1);
   petriNet.addArc(arc2);
```

## Project Structure
```
/PetriNet
  ├── src/                     # Source code directory
    ├── main/                  # Main source code
      ├── petrinet.exceptions  # Package for PetriNet exception classes
      ├── petrinet.main        # Package for main PetriNet application classes
    ├── test/                  # Test source code
      ├── petrinet.test        # Package for PetriNet test classes
  ├── .gitignore               # Git configuration file specifying files and directories to ignore
  ├── pom.xml                  # Maven configuration file for managing the project
  └── README.md                # Documentation file providing an overview of the project
```

## Testing
This project uses JUnit Jupiter for testing. You can run the tests using the following command:
```
mvn clean test
```
