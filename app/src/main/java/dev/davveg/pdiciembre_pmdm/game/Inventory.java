package dev.davveg.pdiciembre_pmdm.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dev.davveg.pdiciembre_pmdm.models.Item;
import dev.davveg.pdiciembre_pmdm.models.Weapon;

public class Inventory {
    private List<Item> inventoryList;

    public Inventory() {
        this.inventoryList = new ArrayList<>();
    }

    public Inventory(List<Item> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public void addItem (Item item ) {
        inventoryList.add(item);
    }

    public List<Weapon> getAllWeapon() {
        return inventoryList.stream()
                .filter(e -> e.getItemType().equals(Item.ItemType.WEAPON) )
                .map(Weapon::parseWeapon)
                .collect(Collectors.toList());
    }

    public List<Item> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Item> inventoryList) {
        this.inventoryList = inventoryList;
    }
}
