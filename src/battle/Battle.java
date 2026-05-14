package battle;

import characters.*;
import characters.Character;
import characters.enemies.Enemy;
import items.Item;
import items.Potion;
import java.util.Scanner;

public class Battle {
    private Player player;
    private Enemy enemy;
    private Scanner scanner = new Scanner(System.in);

    public Battle(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void starBattle() {
        System.out.println("\n⚔️ BATTLE START: " + player.getName() + " vs " + enemy.getName());
        System.out.println("Your HP: " + player.getHealth() + " | Enemy HP: " + enemy.getHealth());
        System.out.println("─────────────────────────────────");

        while (player.isAlive() && enemy.isAlive()) {

            System.out.println("\n📊 STATUS → " + player.getName() + " HP: " + player.getHealth() + " | " + enemy.getName() + " HP: " + enemy.getHealth());
            System.out.println("Your turn!");
            System.out.println("1. Attack");
            System.out.println("2. Special Attack");
            System.out.println("3. Use Potion");
            int choice = scanner.nextInt();
            int damage = 0;

            if (choice == 1) {
                damage = player.getAttack();
                if (player.getWeapon() != null) {
                    damage += player.getWeapon().getDamageBonus();
                }
                enemy.takeDamage(damage);
                System.out.println("🗡️ " + player.getName() + " attacks " + enemy.getName() + " for " + damage + " damage!");

            } else if (choice == 2) {
                if (player instanceof Warrior warrior) {
                    warrior.specialAttack(enemy);
                    System.out.println("⚔️ POWER SLASH! " + player.getName() + " deals " + warrior.getSpecialAttackDamage() + " damage!");
                }
                if (player instanceof Mage mage) {
                    mage.castSpell(enemy);
                    System.out.println("🔥 FIREBALL! " + player.getName() + " ignores defence and deals " + mage.getSpellDamage() + " damage!");
                }
                if (player instanceof Archer archer) {
                    archer.doubleShot(enemy);
                    System.out.println("🏹 DOUBLE SHOT! " + player.getName() + " fires twice for " + archer.getDoubleShotDamage() + " total damage!");
                }

            } else if (choice == 3) {
                boolean foundPotion = false;
                for (Item item : player.getInventory().getStoreItems()) {
                    if (item instanceof Potion potion) {
                        int before = player.getHealth();
                        player.heal(potion.getHealAmount());
                        player.getInventory().removeItem(item);
                        System.out.println("🧪 Used: " + potion.getName() + " | HP: " + before + " → " + player.getHealth());
                        foundPotion = true;
                        break;
                    }
                }
                if (!foundPotion) {
                    System.out.println("❌ No potions in inventory!");
                }
            }

            System.out.println("💀 " + enemy.getName() + " HP: " + enemy.getHealth());
            if (!enemy.isAlive()) {
                System.out.println("✅ " + enemy.getName() + " defeated! +" + enemy.getExpReward() + " XP");
                player.gainExperience(enemy.getExpReward());
                break;
            }

            player.takeDamage(enemy.getAttack());
            System.out.println("💢 " + enemy.getName() + " attacks " + player.getName() + " for " + enemy.getAttack() + " damage!");
            System.out.println("❤️ " + player.getName() + " HP: " + player.getHealth());
            if (!player.isAlive()) {
                System.out.println("💀 " + player.getName() + " has been defeated!");
                break;
            }
        }
        System.out.println("─────────────────────────────────");
    }
}