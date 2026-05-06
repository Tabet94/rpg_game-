package characters;

public abstract class  Character {
    private final String name;
    private int health;
    private int maxHealth;
    private final int attack;
    private final int defence;
    private boolean isAlive;

// Constructor ......................................................
    public Character( String name, int health, int maxHealth, int attack, int defence){
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.defence = defence;
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
    public int getDefence() {
        return defence;
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
    public void takeDamage(int damage){
        double actualDamage = (double) (damage * (100 - defence)) / 100;
        if (actualDamage < 1) {
            actualDamage = 1;
        }
       setHealth( health - (int) actualDamage);
    }

    public void heal (int amount){
        int actualHealth = amount + health;
        setHealth(actualHealth);
    }


}
