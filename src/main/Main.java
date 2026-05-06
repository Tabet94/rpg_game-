package main;

import battle.Battle;
import characters.Archer;
import characters.Mage;
import characters.Player;
import characters.Warrior;
import characters.enemies.Dragon;
import characters.enemies.Goblin;
import characters.enemies.Orc;
import items.Item;
import items.Potion;
import items.Weapon;
import map.Room;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name:");
            String name = scanner.next();
            System.out.println("Welcome to the Dungeon Choose your class!");
            System.out.println("1. Warrior");
            System.out.println("2. Mage");
            System.out.println("3. Archer");

            int choice = scanner.nextInt();
            Player player;
            if (choice == 1) {
                player = new Warrior(name, 300,300,80,40);
            } else if (choice == 2) {
                player = new Mage(name, 300,300,60,30);
            } else {
                player = new Archer(name, 300,300,50,30);
            }




            // Creating Character Objects ...................................................................

        Goblin goblin1 = new Goblin("Sniv", 80, 30, 20, 20);
        Goblin goblin2 = new Goblin("Gribble", 80, 30, 20, 20);
        Goblin goblin3 = new Goblin("Tweak", 80, 30, 20, 20);
        Goblin goblin4 = new Goblin("Ruk", 80, 30, 20, 20);
        Goblin goblin5 = new Goblin("Zibzib", 80, 30, 20, 20);
        Orc orc1 = new Orc("Grommash", 80, 200, 30, 40);
        Orc orc2 = new Orc("Thokar", 80, 200, 30, 40);
        Orc orc3 = new Orc("Drak", 80, 200, 30, 40);

        Dragon dragon = new Dragon ("Vorthalion the Ash Lord", 500, 200, 50, 30);

        // Creating Items Objects ...................................................................
        Item weapon = new Weapon("Sword","Power of the heaven Sword", 20);
        Item potion = new Potion("Liquid of life","Heal", 10);
        Item weapon2 = new Weapon("Old Sword","Power of the old heaven Sword", 30);
        Item potion2 = new Potion("Liquid of ancient gods","Heal", 80);


        // Creating Room1 ..............................................................................
        Room room1 = new Room("Whispering Den","A damp, shadowy cave where faint whispers echo off the walls. Small shapes move in the dark—goblins lurking, waiting for the perfect moment to strike");
        room1.addEnemy(goblin1);
        room1.addEnemy(goblin2);
        room1.addEnemy(goblin3);
        room1.enter(player);

        //Creating Room2 ..............................................................................
        Room room2 = new Room("Forgotten Treasury","Dust blankets ancient chests overflowing with gold and relics. No enemies guard this place… but the silence feels almost unnatural.");
        room2.addLoot(weapon);
        room2.addLoot(potion);
        room2.enter(player);

        //Creating Room3 ..............................................................................
        Room room3 = new Room("Bloodfang Crossing","The air smells of iron and smoke. Goblins skitter between broken pillars while orcs stand their ground—this is a place where ambushes turn deadly.");
        room3.addEnemy(goblin4);
        room3.addEnemy(goblin5);
        room3.addEnemy(orc1);
        room3.addEnemy(orc2);
        room3.enter(player);

        //Creating Room4 ..............................................................................
        Room room4 = new Room("Warbringer Hall","Heavy footsteps echo through a vast stone hall scarred by countless battles. Orc warriors patrol relentlessly, ready to crush anything that dares enter.");
        room4.addEnemy(orc3);

        room4.addLoot(weapon2);
        room4.addLoot(potion2);
        room4.enter(player);

        //Creating Room5 ..............................................................................
        Room room5 = new Room("Emberlord’s Lair","Heat presses in from all sides as molten cracks glow beneath your feet. At the center lies the dragon, its eyes burning with ancient fury—this is where legends are made… or ended.");
        room5.addEnemy(dragon);
        room5.enter(player);

    }
}
