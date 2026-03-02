Completer l'UML a la FAC car il faut une clé licence sur StarUML 

Choix modélisation : shoot changement d'attribut 

Dans Upgrade on apply et on revert des upgrades alors qu'on le fais dans tower aussi, je les ai enlevés.
J'ai aussi décrémenté les crédits d'un joueur quand il fais une upgrade dans Tower.
J'ai aussi modifié la logique de removelife dans player car il y a un risque d'argent infini.
J'ai aussi créé une classe d'upgrades basics qui implémente Upgrade.

pour le 3/3
Pour les Upgrade :
RangeUpgrade(String name, int cost, double rangeBonus)
FireRateUpgrade(String name, int cost, double rateFactor)

changeProjectile(String name, int cost, Projectile newProjectile)
changeProjectile (this.getActiveProjectile().getDamage();) ??
public Projectile getActiveProjectile() {
    Projectile p = this.projectile; // Projectile de base
    for (Upgrade u : appliedUpgrades) {
        if (u.getProjectileOverride() != null) {
            p = u.getProjectileOverride();
        }
    }
    return p;
}