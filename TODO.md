Completer l'UML a la FAC car il faut une clé licence sur StarUML 

Les upgrades sont finies (normalement ou presque) -> Penser au choix du joueur quand on lui demande d'upgrade une tower:
    List<Upgrade> up = tower.getRemainingUpgrades();
    int choice = player.choose(up);
    tower.upgrade(up.get(choice), player);
un truc du genre.

j'ai pas tester les upgrades j'ai juste "finie" les classes.

methodes a faire :
- Afficher la liste des remainingUpgrades
-