import java.util.ArrayList;
import java.util.List;
public class Monster extends Character {


    private String monsterRace, monsterRank;

// CONSTRUCTORS

    public Monster() {}

// SETTERS - GETTERS



    public String getMonsterRace() {
        return this.monsterRace;
    }

    public String getMonsterRank() {
        return this.monsterRank;
    }

// METHODS

    public List<Item> DropAwards() {
        List<Item> monsterItemsAwards = new ArrayList<>();
        return monsterItemsAwards;
    }

}
