package main;

import battle.Battle;
import characters.Archer;
import characters.Mage;
import characters.Player;
import characters.Warrior;
import characters.enemies.*;
import items.Item;
import items.Potion;
import items.Weapon;
import map.Room;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        // Need to fix the item for each class mage can't add sword to his inventory and so on ...................................................................
        Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name:");
            String name = scanner.next();
            System.out.println("════════════════════════════════════");
            System.out.println("        🏰 DUNGEON OF SHADOWS 🏰");
            System.out.println("════════════════════════════════════");
            System.out.println();
            System.out.println("Welcome, " + name + "...");
            System.out.println("Darkness has consumed the ancient dungeon.");
            System.out.println("Only one hero can defeat the Ash Lord.");
            System.out.println();
            System.out.println("Choose your class:");
            System.out.println();
            System.out.println("1. ⚔️ Warrior  → High HP & Defense");
            System.out.println("2. 🔥 Mage     → Powerful Magic Damage");
            System.out.println("3. 🏹 Archer   → Balanced & Deadly");
            System.out.println();
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            Player player;
            if (choice == 1) {
                player = new Warrior(name);
            } else if (choice == 2) {
                player = new Mage(name);
            } else {
                player = new Archer(name);
            }

        System.out.println();
        System.out.println("════════ CHARACTER CREATED ════════");
        System.out.println("Name: " + player.getName());
        System.out.println("Class: " + player.getClass().getSimpleName());
        System.out.println("HP: " + player.getHealth());
        System.out.println("Attack: " + player.getAttack());

        System.out.println("Level: " + player.getLevel());
        System.out.println("═══════════════════════════════════");


            // Creating Character Objects ...................................................................
        Skeleton skeleton1 = new Skeleton("Boneclaw");
        Skeleton skeleton2 = new Skeleton("Rattlefang");
        Skeleton skeleton3 = new Skeleton("Skulkrik");
        Skeleton skeleton4 = new Skeleton("Grimjaw");
        Skeleton skeleton5 = new Skeleton("Dreadbone");
        Totem totem1 = new Totem("Stonewatcher");
        Totem totem2 = new Totem("Ash Totem");
        Totem totem3 = new Totem("Void Pillar");
        Totem totem4 = new Totem("Runic Guardian");
        Totem totem5 = new Totem("Rabisto val");
        Necromancer necro1 = new Necromancer("Malzor");
        Necromancer necro2 = new Necromancer("Velthar");
        Necromancer necro3 = new Necromancer("Nerok");
        Necromancer necro4 = new Necromancer("Zareth");
        Goblin goblin1 = new Goblin("Sniv");
        Goblin goblin2 = new Goblin("Gribble");
        Goblin goblin3 = new Goblin("Tweak");
        Goblin goblin4 = new Goblin("Ruk");
        Goblin goblin5 = new Goblin("Zibzib");
        Orc orc1 = new Orc("Grommash");
        Orc orc2 = new Orc("Thokar");
        Orc orc3 = new Orc("Drak");

        Dragon dragon = new Dragon ("Vorthalion the Ash Lord");

        // Creating Items Objects ...................................................................
        Item sword = new Weapon("Sword", "A basic sword", 10, Warrior.class);
        Item steelSword = new Weapon("Steel Sword", "A stronger sword", 20, Warrior.class);
        Item battleAxe = new Weapon("Battle Axe", "A devastating axe", 35, Warrior.class);
        Item smallPotion = new Potion("Minor Healing Potion", "A small red potion that restores a little health", 30);
        Item mediumPotion = new Potion("Knight's Remedy", "A refined healing potion used by dungeon knights to recover during battle", 60);
        Item largePotion = new Potion("Elixir of Vitality", "A rare magical potion filled with powerful restorative energy", 100);



        // Creating Room1 ..............................................................................
        Room room1 = new Room("Whispering Den","A damp, shadowy cave where faint whispers echo off the walls. Small shapes move in the dark—goblins lurking, waiting for the perfect moment to strike");
        room1.addEnemy(skeleton1);

        room1.addEnemy(goblin1);
        room1.addLoot(smallPotion);
        room1.addLoot(sword);
        room1.enter(player);

        //Creating Room2 ..............................................................................
        Room room2 = new Room("Forgotten Treasury","Dust blankets ancient chests overflowing with gold and relics. No enemies guard this place… but the silence feels almost unnatural.");
        room2.addEnemy(skeleton3);
        room2.addEnemy(skeleton4);
        room2.addEnemy(goblin2);
        room2.addEnemy(goblin3);
        room2.addEnemy(totem1);
        room2.addLoot(mediumPotion);
        room2.addLoot(steelSword);
        room2.enter(player);

        //Creating Room3 ..............................................................................
        Room room3 = new Room("Bloodfang Crossing","The air smells of iron and smoke. Goblins skitter between broken pillars while orcs stand their ground—this is a place where ambushes turn deadly.");
        room3.addEnemy(skeleton5);
        room3.addEnemy(goblin4);
        room3.addEnemy(goblin5);
        room3.addEnemy(totem2);
        room3.addEnemy(totem3);
        room3.addEnemy(necro1);
        room3.addLoot(mediumPotion);
        room3.addLoot(smallPotion);
        room3.enter(player);

        //Creating Room4 ..............................................................................
        Room room4 = new Room("Warbringer Hall","Heavy footsteps echo through a vast stone hall scarred by countless battles. Orc warriors patrol relentlessly, ready to crush anything that dares enter.");
        room4.setRequiredLevel(3);
        room4.addEnemy(totem4);
        room4.addEnemy(totem5);
        room4.addEnemy(necro2);
        room4.addEnemy(necro3);
        room4.addEnemy(orc1);

        room4.addLoot(mediumPotion);
        room4.addLoot(smallPotion);
        room4.enter(player);

        //Creating Room5 ..............................................................................
        Room room5 = new Room("Emberlord’s Lair","Heat presses in from all sides as molten cracks glow beneath your feet. At the center lies the dragon, its eyes burning with ancient fury—this is where legends are made… or ended.");
        room5.setRequiredLevel(4);
        room5.addEnemy(necro4);
        room5.addEnemy(orc2);
        room5.addEnemy(orc3);
        room5.addLoot(battleAxe);
        room5.addLoot(mediumPotion);
        room5.addLoot(smallPotion);
        room5.enter(player);


        //Creating Room6 ..............................................................................
        Room room6 = new Room("Lair","Deep beneath the dungeon lies the Hidden Chamber, a forbidden place sealed away for centuries. The air is heavy with heat and ash, and the walls are covered with ancient markings scorched into the stone. Broken weapons and the skeletons of fallen warriors litter the ground, warning all who enter of the fate that awaits them.\n" +
                "\n" +
                "At the center of the chamber stands a massive gate of black iron, slowly glowing with fiery cracks. Behind it rests the Dragon, the ancient ruler of the dungeon. Its breathing alone shakes the room, and flames seep from beneath the gate with every growl.\n" +
                "\n" +
                "This is the final trial. Only heroes who survived every room and mastered their strength can hope to defeat the beast and escape the dungeon alive.");
        room6.setRequiredLevel(5);
        room6.addEnemy(dragon);
        room6.enter(player);

    }
}
