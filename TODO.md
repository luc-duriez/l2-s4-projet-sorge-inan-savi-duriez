- Fusionner fonction decrease increase Balloon (health et speed)

- ajouter attribut balloons isSlowed pour slowtower et icetower.

- Affichage linearBoard -> debut fin

- Formule tir:
    x1,y1 -> coo balloon
    x2,y2 -> coo tower
    formule -> ((x2-x1)² + (y2-y1)²) <= range²  -> si true, possibilité de tir

- Recherche du balloon le plus avancé avec possibilité de tir.

- Verfifier si la methode shoot des towers prends bien un balloon en parametre.

- Methode de création de tower dans game ou board ou les deux.


- Reflexion comportement slow -> mettre attribut speed en double (initial et final) pour gérer le slow ou le freeze
ou 1 0 attribut isSlowed
-------------------
Pour le tri du tir ? Tir sur le 1er

list.sort(Comparator.comparingDouble(key));

selectTarget( b -> b.getDistanceTraveled())
selectTarget( b -> b.getSpeed())
              b -> b.getSpeed()

-------------------

QUESTIONS :

But exacte du livrable.

Date de rendu du livrable.