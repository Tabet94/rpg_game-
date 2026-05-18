package characters;

public class Warrior extends Player {

    private final int damageReduction;

    // Constructor .................................
    public Warrior(String name) {

        super(name, 150, 150, 20, 15);

        damageReduction = 5;
    }

    // Getter ......................................
    public int getDamageReduction() {
        return damageReduction;
    }

    // Warrior Special Attack ......................
    public int getSpecialAttackDamage() {
        return getAttack() * 2;
    }

    public void specialAttack(Character enemy) {
        enemy.takeDamage(getSpecialAttackDamage());
    }
}
