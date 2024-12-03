public class Weapon extends Item {

    private String classOfWeapon;
    private int  attackInterval;

// CONSTRUCTORS

    public Weapon() {}

// SETTERS - GETTERS

    public void setClassOfWeapon(String classOfWeapon) {
        this.classOfWeapon = classOfWeapon;
    }
    public String getClassOfWeapon() {
        return this.classOfWeapon;
    }
//
    public void setAttackInterval(int attackInterval) {
        this.attackInterval = attackInterval;
    }
    public int getAttackInterval() {
        return this.attackInterval;
    }

// METHODS

    @Override
    public String getType() {
        return classOfWeapon;
    }

    @Override
    public void upgradeItem() {
        attackInterval += 50;
    }



}
