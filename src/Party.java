import java.util.ArrayList;
import java.util.List;
public class Party {

    private List<Player> Players = new ArrayList<>();

// CONSTRUCTORS

    public Party() {}

// METHODS

    public void EnterParty(Player player) {
        Players.add(player);
    }

    public void ExitParty(Player player) {
        Players.remove(player);
    }

    public List<Player> PartyInfo() {
        return Players;
    }
}
