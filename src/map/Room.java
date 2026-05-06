package map;

import battle.Battle;
import characters.Character;
import characters.Player;
import items.Item;
import items.Potion;
import items.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

public class Room {

    private final String name;
    private final String description;
    private boolean isCleared;
    private final ArrayList<Character> enemies;
    private final ArrayList<Item> loot;
    private Scanner scanner = new Scanner(System.in);

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        isCleared = false;
        enemies = new ArrayList<>();
        loot = new ArrayList<>();
    }

    public void addEnemy(Character enemy) {
        enemies.add(enemy);
    }

    public void addLoot(Item item) {
        loot.add(item);
    }

    public void enter(Player player) {

        // Fight each enemy one by one
        for (Character enemy : enemies) {
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

            // Weapons are auto-equipped — no choice needed
            if (item instanceof Weapon weapon) {
                player.equipWeapon(weapon);
                continue;
            }

            // Potions go to inventory — player decides
            System.out.println("You found: " + item.getName());
            System.out.println("1. Add to inventory");
            System.out.println("2. Leave it");
            int choice = scanner.nextInt();

            if (choice == 1 && item instanceof Potion potion) {
                player.getInventory().addItem(potion);
                System.out.println(potion.getName() + " added to inventory!");
            } else {
                System.out.println("You left the " + item.getName());
            }
        }

        System.out.println("Your Health is: " + player.getHealth());
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public boolean isCleared() { return isCleared; }
    public ArrayList<Character> getEnemies() { return enemies; }
    public ArrayList<Item> getLoot() { return loot; }
    public void setCleared(boolean cleared) { isCleared = cleared; }
}