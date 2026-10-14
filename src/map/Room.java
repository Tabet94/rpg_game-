package map;

import battle.Battle;
import characters.Character;
import characters.Player;
import characters.enemies.Enemy;
import items.Item;
import items.Potion;
import items.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

public class Room {

    private final String name;
    private final String description;
    private boolean isCleared;
    private final ArrayList<Enemy> enemies;
    private final ArrayList<Item> loot;
    private Scanner scanner = new Scanner(System.in);
    private int requiredLevel;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        isCleared = false;
        enemies = new ArrayList<>();
        loot = new ArrayList<>();
        requiredLevel = 1;
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void addLoot(Item item) {
        loot.add(item);
    }

    public void enter(Player player) {


        if (player.getLevel()>= requiredLevel){
            System.out.println();
            System.out.println("════════════════════════════════════");
            System.out.println("Entering Room: " + name);
            System.out.println("════════════════════════════════════");
            System.out.println(description);
            System.out.println();
            System.out.println("Enemies detected: " + enemies.size());
            System.out.println("════════════════════════════════════");

            // Fight each enemy one by one
            for (Enemy enemy : enemies) {
                Battle battle = new Battle(player, enemy);
                battle.starBattle();
                // Stop if player dies mid-room
                if (!player.isAlive()) {
                    System.out.println("Game Over!");
                    return;
                }
            }

            // Room cleared — show loot if any
            setCleared(true);
            System.out.println("You have cleared " + getName());

            for (Item item : loot) {
                // Weapons go to inventory — player decides
                System.out.println("You found: " + item.getName());
                System.out.println("1. Add the weapon to  inventory");
                System.out.println("2. Leave it");
                int choice = scanner.nextInt();

                if (choice == 1 && item instanceof Weapon weapon) {
                    player.getInventory().addItem(weapon);
                    System.out.println(weapon.getName() + " added to inventory!");
                    player.equipWeapon(weapon);

                }else {
                    System.out.println("You left the " + item.getName());
                }

                // Potions go to inventory — player decides
                System.out.println("You found: " + item.getName());
                System.out.println("1. Add to inventory");
                System.out.println("2. Leave it");


                if (choice == 1 && item instanceof Potion potion) {
                    player.getInventory().addItem(potion);
                    System.out.println(potion.getName() + " added to inventory!");
                } else {
                    System.out.println("You left the " + item.getName());
                }
            }

            System.out.println("Your Health is: " + player.getHealth());
            // This else is for the first if statement to check if the player has the required level to enter to a room
        }else {
            System.out.println("You can't access to that room");
        }

    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public boolean isCleared() { return isCleared; }
    public ArrayList<Enemy> getEnemies() { return enemies; }
    public ArrayList<Item> getLoot() { return loot; }
    public void setCleared(boolean cleared) { isCleared = cleared; }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }
}