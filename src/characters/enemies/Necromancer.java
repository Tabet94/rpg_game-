package characters.enemies;

import characters.Character;

public class Necromancer extends Enemy {

    //Constructor ...................
    public Necromancer (String name){
        super( name, 130, 130, 30, 10, 75);
    }
    //Method Ability : Dark Curse Ignores 25% defense ........................
    public int getDarkCurseDamage(Character player) {
        int effectiveDefense = player.getDefense() * 75 / 100;
        return getAttack() - effectiveDefense;
    }

    public void darkCurse(Character player){
        player.takeDamage(getDarkCurseDamage(player));

    }

}
