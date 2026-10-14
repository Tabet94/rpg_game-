package inventory;

import characters.Player;
import items.Item;
import items.Weapon;

import java.util.ArrayList;

public class Inventory {

    private final ArrayList<Item> storeItems = new ArrayList<>();
    private final int maxCapacity;
    private final Player owner;


    //Constructor ........................................................
    public Inventory(int maxCapacity, Player owner) {
        this.maxCapacity = maxCapacity;
        this.owner = owner;

    }

    //Methods ............................................................

    public boolean addItem(Item item) {
        if (storeItems.size() >= maxCapacity) return false;
        if (item instanceof Weapon w && w.canBeUsedBy(owner)) return false;
        storeItems.add(item);
        return true;
    }

    public boolean removeItem(Item item){
        return storeItems.remove(item);

    }

    public ArrayList<Item> getStoreItems() {
        return storeItems;
    }
}
