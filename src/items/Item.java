package items;

public class Item {

    private final String name;
    private final String description;

    //Constructor .........................
    public Item (String name, String description){
        this.name = name;
        this.description = description;
    }
    //Getter ...................

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
