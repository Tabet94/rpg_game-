package inventory;

import items.Item;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> storeItems;
    private final int maxCapacity;


    //Constructor ........................................................
    public Inventory(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        storeItems = new ArrayList<>();
    }

    //Methods ............................................................

    public boolean addItem(Item item) {
       if(storeItems.size()>= maxCapacity){
           return false;
       }else {
           storeItems.add(item);
           return true;
       }
    }

    public boolean removeItem(Item item){
        return storeItems.remove(item);

    }

    public ArrayList<Item> getStoreItems() {
        return storeItems;
    }
}
