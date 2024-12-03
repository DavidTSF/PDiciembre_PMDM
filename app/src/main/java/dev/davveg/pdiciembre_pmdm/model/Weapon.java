package dev.davveg.pdiciembre_pmdm.model;

public class Weapon implements Item {
    public int id_weapon;
    public String name;
    public int level;
    public int base_damage;
    public String description;
    public Object image;

    public Weapon(int id_weapon, String name, int level, int base_damage, String description, Object image) {
        this.id_weapon = id_weapon;
        this.name = name;
        this.level = level;
        this.base_damage = base_damage;
        this.description = description;
        this.image = image;
    }

    public int getId_weapon() {
        return id_weapon;
    }

    public void setId_weapon(int id_weapon) {
        this.id_weapon = id_weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBase_damage() {
        return base_damage;
    }

    public void setBase_damage(int base_damage) {
        this.base_damage = base_damage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    @Override
    public String getItemName() {
        return name;
    }
    @Override
    public ItemType getItemType() {
        return ItemType.WEAPON;
    }
}
