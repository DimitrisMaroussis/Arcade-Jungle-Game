import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Player extends Character {

    private int currentX, currentY;
    private int gold;
    Random r = new Random();

// CONSTRUCTORS

    public Player() {

    }


// SETTERS - GETTERS

    public void setGold(int gold) {
        this.gold = gold;
    }
    public int getGold() {
        return gold;
    }
//
    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }
    public int getCurrentX() {
        return currentX;
    }
//
    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }
    public int getCurrentY() {
        return currentY;
    }

// METHODS

   public boolean PickUpItem(Weapon item) {
        boolean a = true;
        if (gold >= item.getRequiredGold()) {
            getInventory().getItems().add(item);
            gold -= item.getRequiredGold();
            System.out.println(getName() + " bought " + item.getClassOfWeapon() + "!");
            a = false;
        } else {
            System.out.println("Not enough gold for " + item.getType() + ".");
        }
        return a;
   }

    public boolean GetEquipment(Equipment equipment) {
        boolean a = true;
        if (gold >= equipment.getRequiredGold()) {
            getEquipments().add(equipment);
            gold -= equipment.getRequiredGold();
            System.out.println(getName() + " got a " + equipment.getType() + ". (Total Armor " + getArmor() + ")");
            a = false;
        } else {
            System.out.println("Not enough gold for " + equipment.getType() + ".");
        }
        return a;
    }

    public void PickUpGold(Gold gold) {
        this.gold += gold.getGold();
        System.out.println( getName() + " picked up " + ANSI_YELLOW + gold.getGold() + " gold." + ANSI_RESET);
    }


}
