public class Boss extends Monster {

    public Boss() {
        setLetter(ANSI_BLACK +"[B]" + ANSI_RESET);
        setHp(1000);
        setGold(1);
        setArmor(120);
        setName(ANSI_BLACK + "Boss" + ANSI_RESET);
        setAttackType1(" Super Ground Slam!");
        setAttackType2(" Mega Death Punch!");
        setWeapon(new BossWeapon());
    }
}
