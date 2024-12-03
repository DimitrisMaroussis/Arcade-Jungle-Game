import java.util.List;
import java.util.ArrayList;
public class NPC extends Character {



//  CONSTRUCTORS

    public NPC() {}


// METHODS

    public void Heal(Player player) {
       if (player.getGold() >= getGold()) {
           if (player instanceof Warrior) {
               player.setHp(350);
               player.setGold(player.getGold() - getGold());
               System.out.println(player.getName() + ANSI_GREEN + " healed! " + ANSI_RESET + ANSI_YELLOW + "(" + player.getGold() + " gold remaining)" + ANSI_RESET);
           } else {
               player.setHp(250);
               player.setGold(player.getGold() - getGold());
               System.out.println(player.getName() + ANSI_GREEN + " healed! " + ANSI_RESET + ANSI_YELLOW + "(" + player.getGold() + " gold remaining)" + ANSI_RESET);
           }
       } else {
           System.out.println("Not enough gold to heal. (" + player.getGold() + "/80 gold)");
       }

    }


}