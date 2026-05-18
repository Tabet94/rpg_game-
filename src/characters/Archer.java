package characters;

import java.util.Random;

public class Archer extends Player {

    private int critChance = 20;          // 20% chance
    private double critMultiplier = 1.5;

    private final Random random = new Random();

    public Archer(String name) {
        super(name, 110, 110, 25, 10);
    }

    // Returns final damage after crit check
    public int applyCrit(int damage) {

        if (random.nextInt(100) < critChance) {
            System.out.println("🎯 CRITICAL HIT!");
            return (int) Math.round(damage * critMultiplier);
        }

        return damage;
    }

    public int getDoubleShotDamage() {
        return getAttack() * 2;
    }

    public void doubleShot(Character enemy) {
        enemy.takeDamage(getAttack());
        enemy.takeDamage(getAttack());
    }
}