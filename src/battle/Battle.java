package battle;

import characters.*;
import characters.Character;
import characters.enemies.Enemy;
import combat.CombatEngine;
import items.Item;
import items.Potion;
import java.util.Scanner;

public class Battle {
    private Player player;
    private Enemy enemy;
    private Scanner scanner = new Scanner(System.in);
    private CombatEngine combatEngine = new CombatEngine();


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
            System.out.println();
            System.out.println("Choose your action:");
            System.out.println("1. 🗡️ Attack");
            System.out.println("2. ✨ Special Attack");
            System.out.println("3. 🧪 Use Potion");
            System.out.print("Action: ");
            int choice = scanner.nextInt();


            if (choice == 1) {

                int actualDamage =
                        combatEngine.basicAttack(player, enemy);

                System.out.println("🗡️ " + player.getName()
                        + " attacks " + enemy.getName()
                        + " for " + actualDamage + " damage!");

            } else if (choice == 2) {
                int actualDamage = combatEngine.useSkill(player, enemy);
                System.out.println("✨ " + player.getName()
                        + " uses skill on " + enemy.getName()
                        + " for " + actualDamage + " damage!");

                } else if (choice == 3) {

                boolean foundPotion = false;

                for (Item item : player.getInventory().getStoreItems()) {

                    if (item instanceof Potion potion) {
                        int before = player.getHealth();

                        player.heal(potion.getHealAmount());
                        player.getInventory().removeItem(item);

                        System.out.println("🧪 Used: " + potion.getName()
                                + " | HP: " + before + " → " + player.getHealth());

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