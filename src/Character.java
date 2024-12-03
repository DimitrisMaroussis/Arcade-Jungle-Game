import java.util.ArrayList;
import java.util.List;
public class Character {

    private String letter = ANSI_PURPLE +"(P)" + ANSI_RESET;
    private String name;
    private int hp, gold, armor;
    private String attackType1, attackType2;
    private Inventory inventory = new Inventory();
    private Weapon weapon;
    private List<Equipment> equipments = new ArrayList<>();

// CONSTRUCTORS

    public Character() {}

// SETTERS - GETTERS

    public void setArmor(int armor) {
        this.armor = armor;
    }
//
    public void setLetter(String letter) {
        this.letter = letter;
    }
    public String getLetter() {
        return letter;
    }
//
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getHp() {
        return hp;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public Inventory getInventory() {
        return inventory;
    }
//
    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }
    public List<Equipment> getEquipments() {
        return equipments;
    }
//
    public void setAttackType1(String attackType1) {
        this.attackType1 = attackType1;
    }
    public String getAttackType1() {
        return attackType1;
    }
//
    public void setAttackType2(String attackType2) {
        this.attackType2 = attackType2;
    }
    public String getAttackType2() {
        return attackType2;
    }
//
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
//
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public Weapon getWeapon() {
        return weapon;
    }
//
    public void setGold(int gold) {
        this.gold = gold;
    }
    public int getGold() {
        return gold;
    }

    // METHODS

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public int getArmor() {
        int x = armor;
        if (!equipments.isEmpty()) {
            for (int i = 0; i < equipments.size(); i++) {
                x += equipments.get(i).getArmor();
            }
        }
        return x;
    }

   /* public boolean UpgradeWeapon() {
        if (gold >= weapon.getRequiredGold()) {
            gold -= weapon.getRequiredGold();
            weapon.upgradeItem();
            return false;
        } else {
            System.out.println("Cannot upgrade weapon.");
            return true;
        }
    }

    public boolean UpgradeEquipment(String itemType) {
        int x = 0;
        for (int i = 0; i < equipments.size(); i++) {
            if (equipments.get(i).equals(itemType)) {
                x = i;
            }
        }

        if (gold >= equipments.get(x).getRequiredGold()) {
            gold -= equipments.get(x).getRequiredGold();
            equipments.get(x).upgradeItem();
            return false;
        } else {
            System.out.println("Cannot upgrade equipment.");
            return true;
        }
    }*/

    public boolean EquipItem(String itemType) {
        boolean a = true;

        for (Weapon item : inventory.getItems()) {
            if (item.getClassOfWeapon().equals(itemType)) {
                weapon = item;
                System.out.println("\n" + weapon.getClassOfWeapon() + " equipped! (" + weapon.getAttackInterval() + " damage)");
                a = false;
            }
        }
        return a;
    }

   /* public void DropItem(String itemType) {
        for (Item item : inventory.getItems()) {
            if (item.getType().equals(itemType)) {
                inventory.getItems().remove(item);
                break;
            }
        }
    }

    public Item GetItem(String itemType) {
        for (Item item : inventory.getItems()) {
            if (item.getType().equals(itemType)) {
                return item;
            }
        }
        System.out.println("Item not found");
        return null;
    }*/


}
