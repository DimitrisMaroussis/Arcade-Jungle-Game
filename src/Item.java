public class Item {

    private int size, rarity;
    private int requiredGold;
    private String effect;

// CONSTRUCTORS

    public Item() {}

// SETTERS - GETTERS

    public void setSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return this.size;
    }
//
    public void setRarity(int rarity) {
        this.rarity = rarity;
    }
    public int getRarity() {
        return this.rarity;
    }
//
    public void setRequiredGold(int requiredGold) {
        this.requiredGold = requiredGold;
    }
    public int getRequiredGold() {
        return requiredGold;
    }

    //
    public void setEffect(String effect) {
        this.effect = effect;
    }
    public String getEffect() {
        return this.effect;
    }

// METHODS

    public String getType() {
        String st = "";
        return st;
    }

    public void upgradeItem() {

    }



}
