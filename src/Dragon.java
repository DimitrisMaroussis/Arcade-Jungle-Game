public class Dragon extends Monster {

    public Dragon() {
        setWeapon(new DragonFire());
        setGold(180);
        setArmor(200);
        setHp(600);
        setName(ANSI_CYAN + "Dragon" + ANSI_RESET);
        setLetter(ANSI_CYAN +"{D}" + ANSI_RESET);
    }
}
