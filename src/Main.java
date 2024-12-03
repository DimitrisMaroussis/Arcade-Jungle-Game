import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Game game = new Game();
        game.informationAboutGame();

        int x = 1;
        String Class;

        do {
            System.out.print("\nWhat Class do you want your Hero to be? (Mage, Warrior): " );
            Class = sc.nextLine();
            Class = Class.toLowerCase();

            if (Class.equals("warrior")) {
                game.getParty().EnterParty(new Warrior());
                x++;
            } else if (Class.equals("mage")) {
                game.getParty().EnterParty(new Mage());
                x++;
            } else {
                System.out.println("There is no such Class.");
            }

        } while (!Class.equals("mage") && !Class.equals("warrior"));

        game.StartGame();

    }
}