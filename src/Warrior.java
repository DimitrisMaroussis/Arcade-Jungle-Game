import java.util.Scanner;

public class Warrior extends Player {


    public Warrior() {
        setHp(350);
        setArmor(40);
        setWeapon(new Sword());
        setGold(20);
        setAttackType1(" attacks with Atomic Slash!");
        setAttackType2(" unleashes Furious Punches!");
        System.out.print("\nType the Name of your Hero: ");
        setName(ANSI_PURPLE + sc.nextLine() + ANSI_RESET);
        getInventory().getItems().add(new Sword());
    }

    Scanner sc = new Scanner(System.in);
}
