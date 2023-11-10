# PetriNet
Un réseau de Petri est composé de places (représentées par des cercles) qui peuvent contenir des
jetons et de transitions (représentées par des carrés). Des arcs (porteurs d’une valeur) relient
les places aux transitions (arcs sortants des places) et les transitions aux places (arcs entrants
dans des places). Sans précision, la valeur d’un arc est par défaut 1.
Une transition est tirable lorsque les places qui y sont reliées par un arc entrant contiennent au
moins autant de jetons qu’indiqué par la valeur de l’arc. Quand une transition est tirée (un pas),
on enlève des jetons des places en amont de la transition selon les indications des arcs sortants
(des places) et on ajoute des jetons dans les places en aval selon les indications des arcs y entrants.
Le nombre total de jetons peut donc changer d’un pas à l’autre.
Le schéma qui suit montre un réseau de Petri avant que la transition soit tirée et après qu’elle a
été tirée.
