public class Ork extends Monster {

    public Ork() {
        setGold(30);
        setName(ANSI_RED + "Ork" + ANSI_RESET);
        setArmor(25);
        setHp(300);
        setAttackType1(" GRRRHK");
        setAttackType2(" ARGKHH");
        setLetter(ANSI_RED +"(O)" + ANSI_RESET);
        setWeapon(new OrkWeapon());
    }
}
