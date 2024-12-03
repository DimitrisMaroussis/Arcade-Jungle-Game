public class Equipment extends Item {

    private String type;
    private int armor;

// CONSTRUCTORS

    public Equipment() {}

// SETTERS - GETTERS

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String getType() {
        return this.type;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
    public int getArmor() {
        return this.armor;
    }

// METHODS

    @Override
    public void upgradeItem() {
        armor += 40;
    }


}
