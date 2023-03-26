package utilities;

import java.util.*;

public class Inventory implements Iterable<Item> {
    private List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void printItems() {
        System.out.println("Inventory:");
        for (Item item : items) {
            System.out.println("- " + item.getName());
        }
    }

    public boolean contains(Item item) {
        return items.contains(item);
    }

    public int size() {
        return items.size();
    }

    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }
 
}
