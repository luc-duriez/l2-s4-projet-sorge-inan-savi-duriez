# l2s4-projet-2026

Vous devez *forker* ce projet dans votre espace de travail Gitlab (bouton `Fork`) et vidéo sur le [portail](https://www.fil.univ-lille.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)
Un unique fork doit être réalisé par équipe.

Une fois cela réalisé, supprimer ces premières lignes et remplir les noms des membres de votre équipe.
N'oubliez pas d'ajouter les autres membres de votre équipe aux membres du projet, ainsi que votre enseignant·e (statut Maintainer).

# Equipe

- sami INAN
- luc DURIEZ
- clément SORGE
- kamal SAVI

# Sujet

[Le sujet 2026](https://www.fil.univ-lille.fr/~varre/portail/l2s4-projet/sujet2026.pdf)

# Livrables

Les paragraphes concernant les livrables doivent être remplis avant la date de rendu du livrable. A chaque fois on décrira l'état du projet par rapport aux objectifs du livrable. Il est attendu un texte de plusieurs lignes qui explique la modélisation choisie, et/ou les algorithmes choisis et/ou les modifications apportées à la modélisation du livrable précédent.

Un lien vers une image de l'UML doit être fourni (une photo d'un diagramme UML fait à la main est suffisant).

## Livrable 1

### Atteinte des objectifs

Nous avons réussi à créer les deux types de plateaux :Board et LinearBoard. Nous avons également réalisé la méthode getPath() dans Board et dans LinearBoard. 

La méthode getPath() dans Board prend 3 paramètres : La position de départ du chemin, la position finale du chemin et une liste qui va être renvoyée à la fin qui va servir de liste entre appels récursifs. 
Dans Board, le chemin va être choisi aléatoirement mais suivant une règle :
Une cellule ne peut être ajoutée au chemin que si elle n'est connectée qu'à exactement une seule cellule déjà présente dans la liste.
Cette règle évite que le chemin construit ne soit pas collé au chemin déjà existant.

La méthode getPath() dans LinearBoard prend les 3 mêmes paramètre que Board.
Dans cette méthode le chemin renvoyé est une ligne droite entre les deux points.
La principale difficulté était dans le calcul des nouveaux points.
Si on prend deux points alignés verticalement ou horizontalement, nous devons savoir le sens (pour savoir si devais ajouter i ou soustraire i de X ou Y)
Par exemple, si on prend deux points alignés verticalement et que le début du chemin est en haut (donc l'arriver est en bas).
On souhaite savoir le sens. Pour le calculer nous regardons le résultat de la soustraction des Y des deux points: 
si le Y de la position finale - le Y de la position d'arrivée est supérieur à 0 le sens est du haut vers le bas. Sinon l'inverse.
On a donc a incrémenter un i en commencant à 1 et de le multiplier au résultat précèdent. (si sens haut vers bas = 1 sinon -1)

### Difficultés restant à résoudre

Les difficultés à résondre vont être pour la classe Baloon et la gestion de plusieurs entités sur une même case. 

### UML Livrable 1
![UML Livrable 1](image.png)

## Livrable 2

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 3

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 4

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 5

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 6

### Atteinte des objectifs

### Difficultés restant à résoudre

# Journal de bord

Le journal de bord doit être rempli à la fin de chaque séance encadrée, et **avant** de quitter la salle. 

Pour chaque semaine on y trouvera :
- ce qui a été réalisé, les difficultés rencontrées et comment elles ont été surmontées (on attend du contenu, pas uniquement une phrase du type "tous les objectifs ont été atteints")
- la liste des objectifs à réaliser d'ici à la prochaine séance encadrée

## Semaine 1

### Ce qui a été réalisé

UML :
    environ 50-60% de l'UML a été réalisé. Il reste à ajouter tous les attributs et toutes les méthodes. 

Calcul du chemin :
    l'algorithme du calcul du chemin a été réalisé en pseudo-code pour le premier type de plateau. Le calcul du chemin n'est pas complêtement terminé. Environ 80% de cette étape a été fait.

### Difficultés rencontrées

Pas de difficultés rencontrées pour l'instant au niveau de l'UML. Au niveau du calcul du chemin, quelques difficultés ont été rencontrées sur la validité du chemin.

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 2

### Ce qui a été réalisé

L'UML a été à peu pris fini avec quelques modifications (environ 95% de l'UML est réalisé). Les classes java sont en cours de création.

### Difficultés rencontrées

On a eu quelques difficultées au niveau de certains concepts comme la gestion du parcours des ballons avec une taille de cases donnée...

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 3

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 4

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 5

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 6

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 7

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 8

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 9

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 10

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 11

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 12

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour finaliser le projet et répartition du travail par membre