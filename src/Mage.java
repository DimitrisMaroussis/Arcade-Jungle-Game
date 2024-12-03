import java.util.Scanner;
public class Mage extends Player {

    public Mage() {
        setHp(250);
        setArmor(15);
        setWeapon(new MagicalRod());
        setGold(20);
        setAttackType1(" throws rocks like bullets!");
        setAttackType2(" unleashes Dark Sphere!");
        System.out.print("\nType the Name of your Hero: ");
        setName(ANSI_PURPLE + sc.nextLine() + ANSI_RESET);
        getInventory().getItems().add(new MagicalRod());
    }

    Scanner sc = new Scanner(System.in);
}
