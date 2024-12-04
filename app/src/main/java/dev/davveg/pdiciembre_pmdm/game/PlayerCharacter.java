package dev.davveg.pdiciembre_pmdm.game;

public class PlayerCharacter {
    String name;
    int level;

    int hp;
    int defense;
    int mana;

    int strength;
    int dexterity;
    int inteligence;

    Inventory inventory;


    public PlayerCharacter() {}

    public PlayerCharacter(String name, int level) {
        this.name = name;
        this.level = level;
        inventory = new Inventory();
    }

    public static PlayerCharacter baseCharacter ( String name ) {
        PlayerCharacter pc = new PlayerCharacter();
        pc.setName(name);

        pc.setHp(10);
        pc.setDefense(5);
        pc.setMana(5);

        pc.setDexterity(5);
        pc.setStrength(5);
        pc.setInteligence(5);

        pc.setInventory(new Inventory());


        return pc;
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getInteligence() {
        return inteligence;
    }

    public void setInteligence(int inteligence) {
        this.inteligence = inteligence;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
