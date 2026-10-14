package characters;

import combat.Skill;
import inventory.Inventory;
import items.Weapon;


public class Player  extends  Character{

    private  Inventory inventory;
    private Weapon weapon;
    private int level;
    private int experience;
    private Skill skill;

    //Constructor.............................................

    public Player( String name, int health, int maxHealth, int attack, int defense){
        super(name, health, maxHealth, attack, defense);
        inventory = new Inventory(10, this);
        weapon = null;
        this.level = 1;
        this.experience = 0;

    }


    //Getter .............................................
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


    //Setter .............................................

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
    public void equipWeapon(Weapon weapon) {
        if (weapon.canBeUsedBy(this)) {
            System.out.println("A " + getClass().getSimpleName()
                    + " cannot wield " + weapon.getName() + ".");
            return;
        }
        setWeapon(weapon);
        System.out.println("You equipped: " + weapon.getName());
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

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
