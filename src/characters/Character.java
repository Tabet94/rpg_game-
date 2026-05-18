package characters;

public abstract class  Character {
    private final String name;
    private int health;
    private int maxHealth;
    private final int attack;
    private final int defense;
    private boolean isAlive;

// Constructor ......................................................
    public Character( String name, int health, int maxHealth, int attack, int defense){
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.defense = defense;
        isAlive = true;
    }
//Getter ...............................................................
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getAttack() {
        return attack;
    }
    public int getDefense() {
        return defense;
    }
    public boolean isAlive() {
        return isAlive;
    }
//Setter ..............................................................
    public void setHealth(int health) {

        if (health < 0){
            health = 0;
        } else if (health > maxHealth) {
            health = maxHealth;
        }

        isAlive = health > 0;

        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        if( maxHealth < 1){
            maxHealth = 1;
        }
        this.maxHealth = maxHealth;
    }
//Methods ............................................................
//Take damage logic maybe it will be changed to Flat or scaling formula ............................................................
public int takeDamage(int damage){

    double actualDamage =
            (double) (damage * (100 - defense)) / 100;

    // Warrior passive..........
    if(this instanceof Warrior warrior){

        actualDamage =
                actualDamage *
                        (100 - warrior.getDamageReduction()) / 100;
    }

    if(actualDamage < 1){
        actualDamage = 1;
    }

    int finalDamage = (int)Math.round(actualDamage);

    setHealth(health - finalDamage);

    return finalDamage;
}

    public void heal (int amount){
        int actualHealth = amount + health;
        setHealth(actualHealth);
    }


}


