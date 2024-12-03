public class Wall extends Character {


    private String letter = ANSI_BLUE + "(W)" + ANSI_RESET;
    public Wall() {}

    @Override
    public String getLetter() {
        return letter;
    }
}
