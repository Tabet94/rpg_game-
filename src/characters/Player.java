package characters;

import inventory.Inventory;
import items.Weapon;


public class Player  extends  Character{

    private  Inventory inventory;
    private Weapon weapon;
    private int level;
    private int experience;

    //Constructor.............................................

    public Player( String name, int health, int maxHealth, int attack, int defense){
        super(name, health, maxHealth, attack, defense);
        inventory = new Inventory(10);
        weapon = null;
        this.level = 1;
        this.experience = 0;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }


    //Methods .................................................................
    public void equipWeapon(Weapon weapon){
       setWeapon(weapon);
       System.out.println("you equipped:" + weapon.getName());
    }

    public void gainExperience(int amount){
       experience+= amount;
        int[] thresholds = {0, 100, 250, 450, 700, 1000};

        if (level < thresholds.length && experience >= thresholds[level]) {
            level++;
            experience -= thresholds[level - 1];
            System.out.println("Level up! You are now level " + level);
        }
    }
}
