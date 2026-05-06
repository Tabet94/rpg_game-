package battle;

import characters.Character;
import characters.Player;
import characters.Warrior;
import items.Item;
import items.Potion;
import java.util.Scanner;

public class Battle {
    private Player player;
    private Character enemy;
    private Scanner scanner = new Scanner(System.in);

    public Battle(Player player, Character enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void starBattle() {

        // Keep fighting until someone dies
        while (player.isAlive() && enemy.isAlive()) {

            // Show player options each turn
            System.out.println("\nYour turn!");
            System.out.println("1. Attack");
            System.out.println("2. Special Attack");
            System.out.println("3. Use Potion");
            int choice = scanner.nextInt();
            int damage = 0;

            if (choice == 1) {
                // Normal attack — base attack + weapon bonus if equipped
                damage = player.getAttack();
                if (player.getWeapon() != null) {
                    damage += player.getWeapon().getDamageBonus();
                }
                enemy.takeDamage(damage);
                System.out.println("Player Attack power: " + damage + " | Player: " + player.getName());

            } else if (choice == 2) {
                // Special attack — Warrior only, deals double damage
                if (player instanceof Warrior warrior) {
                    warrior.specialAttack(enemy);
                    System.out.println("⚔️ SPECIAL ATTACK! deals: " + warrior.getSpecialAttackDamage());
                }

            } else if (choice == 3) {
                // Find first potion in inventory, use it, then remove it
                boolean foundPotion = false;
                for (Item item : player.getInventory().getStoreItems()) {
                    if (item instanceof Potion potion) {
                        player.heal(potion.getHealAmount());
                        player.getInventory().removeItem(item);
                        System.out.println("You used: " + potion.getName());
                        System.out.println("Health: " + player.getHealth() + " | Player: " + player.getName());
                        foundPotion = true;
                        break;
                    }
                }
                if (!foundPotion) {
                    System.out.println("No potions in inventory!");
                }
            }

            // Check if enemy died from player's attack
            System.out.println("Enemy HP: " + enemy.getHealth() + " | Enemy: " + enemy.getName());
            if (!enemy.isAlive()) {
                System.out.println("Enemy defeated!");
                break;
            }

            // Enemy attacks back
            player.takeDamage(enemy.getAttack());
            System.out.println("Player HP: " + player.getHealth() + " | Player: " + player.getName());
            if (!player.isAlive()) {
                System.out.println("You are defeated!");
                break;
            }
        }
    }
}