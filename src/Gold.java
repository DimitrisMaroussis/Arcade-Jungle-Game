import java.util.Random;
public class Gold extends Character {

    public Gold() {
        setGold(r.nextInt(100) + 50);
        setLetter(ANSI_YELLOW + "|G|" + ANSI_RESET);
    }
    Random r = new Random();

    @Override
    public int getGold() {
        return super.getGold();
    }
}
