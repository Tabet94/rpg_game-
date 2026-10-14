package characters;

import combat.WarriorSkill;

public class Warrior extends Player {

    private final int damageReduction;

    public Warrior(String name) {
        super(name, 150, 150, 20, 15);
        this.damageReduction = 5;
        this.setSkill(new WarriorSkill());
    }

    public int getDamageReduction() {
        return damageReduction;
    }
}