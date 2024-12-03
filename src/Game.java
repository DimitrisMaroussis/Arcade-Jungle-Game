import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Game {

    private Party party =  new Party();
    Character[][] gameBoard = new Character[12][8];
    Random r = new Random();
    Scanner sc = new Scanner(System.in);

// CONSTRUCTORS

    public Game() {}

// SETTERS - GETTERS

    public void setParty(Party party) {
        this.party = party;
    }
    public Party getParty() {
        return party;
    }

//  METHODS

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public void informationAboutGame() {
        System.out.println(ANSI_BLUE + "\n\n\n\t\t\t\t\tWELCOME " + ANSI_RESET + ANSI_PURPLE + "TO " + ANSI_RESET + ANSI_YELLOW + "THE" + ANSI_RESET + ANSI_GREEN + " JUNGLE" + ANSI_RESET + ANSI_CYAN + "!\n" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "The Goal of the game is to walk through the Jungle, Fight, Built up your Strength and Defeat the Boss." + ANSI_RESET + ANSI_PURPLE + "\n(P): Your Player" + ANSI_RESET);
        System.out.println(ANSI_RED + "(O): Ork (Normal Monster)\n" + ANSI_RESET + ANSI_CYAN + "{D}: Dragon (Mighty Monster)\n" + ANSI_RESET + ANSI_BLACK + "[B]: Boss (Ultimate Monster)\n" + ANSI_RESET + ANSI_YELLOW + "|G|: Gold (Collect Lost Treasures)" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "(H): Healer (Heals you for an amount of Gold)\n" + ANSI_RESET + ANSI_YELLOW + "(V): Vendor (Sells you Items)\n" + ANSI_RESET + ANSI_BLUE + "(W): Water (It's a Lake, can't walk there)" + ANSI_RESET);

    }

    public void fillGameBoard() {


        List<NPC> Npcs = new ArrayList<>();
        Npcs.add(new Vendor());
        Npcs.add(new Healer());

        gameBoard[0][0] = new Wall();
        gameBoard[0][2] = new Wall();
        gameBoard[0][4] = new Wall();
        gameBoard[0][6] = new Wall();
        gameBoard[0][7] = new Wall();
        gameBoard[2][1] = new Wall();
        gameBoard[2][5] = new Wall();
        gameBoard[2][7] = new Wall();
        gameBoard[1][0] = new Wall();
        gameBoard[3][4] = new Wall();
        gameBoard[3][5] = new Wall();
        gameBoard[3][7] = new Wall();
        gameBoard[4][2] = new Wall();
        gameBoard[4][4] = new Wall();
        gameBoard[4][7] = new Wall();
        gameBoard[5][0] = new Wall();
        gameBoard[5][7] = new Wall();
        gameBoard[6][0] = new Wall();
        gameBoard[6][1] = new Wall();
        gameBoard[6][7] = new Wall();
        gameBoard[7][0] = new Wall();
        gameBoard[7][3] = new Wall();
        gameBoard[7][5] = new Wall();
        gameBoard[8][0] = new Wall();
        gameBoard[8][2] = new Wall();
        gameBoard[8][3] = new Wall();
        gameBoard[8][6] = new Wall();
        gameBoard[9][0] = new Wall();
        gameBoard[9][2] = new Wall();
        gameBoard[9][6] = new Wall();
        gameBoard[10][0] = new Wall();
        gameBoard[11][0] = new Wall();
        gameBoard[11][1] = new Wall();
        gameBoard[11][3] = new Wall();
        gameBoard[11][5] = new Wall();
        gameBoard[11][7] = new Wall();

        gameBoard[9][1] = new Gold();
        gameBoard[1][7] = new Gold();

        gameBoard[1][6] = new Dragon();
        gameBoard[3][2] = new Ork();
        gameBoard[6][2] = new Ork();
        gameBoard[10][1] = new Ork();
        gameBoard[5][6] = new Ork();

        gameBoard[2][0] = Npcs.get(r.nextInt(2));
        gameBoard[3][6] = Npcs.get(r.nextInt(2));
        gameBoard[4][0] = Npcs.get(r.nextInt(2));
        gameBoard[4][5] = Npcs.get(r.nextInt(2));
        gameBoard[7][1] = Npcs.get(r.nextInt(2));

        gameBoard[11][4] = new Boss();

        int x = 0;

        for (int i = 0; i > -1; i++) {
            int k = r.nextInt(11) + 1;
            int l = r.nextInt(8);

            if (gameBoard[k][l] == null) {
                gameBoard[k][l] = new Gold();
                x++;
            }
            if (x == 12) {
                break;
            }
        }


    }

    public void Board() {
        int y = 1;

        System.out.print("\n\n         ");
        for (int i = 1; i < 9; i++) {
            System.out.print(ANSI_CYAN + i + ANSI_RESET + "     ");
        }
        System.out.println(ANSI_GREEN + "\n       _________________________________________________" + ANSI_RESET);


        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 1) {
                    if (y > 9) {
                        System.out.print(ANSI_CYAN + "\t" + y++ + ANSI_RESET + ANSI_GREEN + " |" + ANSI_RESET);
                    } else {
                        System.out.print(ANSI_CYAN + "\t " + y++ + ANSI_RESET + ANSI_GREEN + " |" + ANSI_RESET);
                    }

                } else {
                    System.out.print(ANSI_GREEN + "\t   |");
                }
                for (int k = 0; k < 8; k++){
                    if (j == 1 && gameBoard[i][k] != null){
                        System.out.print(" " + gameBoard[i][k].getLetter() + ANSI_GREEN +  " |" + ANSI_RESET);
                    } else {
                        System.out.print(ANSI_GREEN + "     |" + ANSI_RESET);
                    }
                }

                System.out.print("\n");
            }
            System.out.println(ANSI_GREEN + "       -------------------------------------------------" + ANSI_RESET);
        }


    }

    public String PlayerStatsOrMove(Player player, String c) {
        boolean a = true;

        do {
            System.out.print("\nType: \n'Stats' (Show your Player's statistics and Inventory)\n'Equip' (Equip a Weapon from your Inventory)\n'W','S','A','D' (to Move)\n Input: " );
            c = sc.nextLine();
            c = c.toLowerCase();

            if (c.equals("stats")) {
                System.out.println("\nHP: " + player.getHp() + "\nArmor: " + player.getArmor() + "\nGold: " + player.getGold() + "\nEquipped Weapon: " + player.getWeapon().getClassOfWeapon() + " (" + player.getWeapon().getAttackInterval() + " damage)");
                if (player.getInventory().getItems().isEmpty()) {
                    System.out.println("No items in your inventory.");
                } else {
                    System.out.println("Inventory:");
                    for (int i = 0; i < player.getInventory().getItems().size(); i++) {
                        System.out.println(player.getInventory().getItems().get(i).getClassOfWeapon());
                    }
                }
            } else if (c.equals("equip")) {
                if (player.getInventory().getItems().size() == 1) {
                    System.out.println("\nYou only have " + player.getWeapon().getType() + ".");
                } else {
                    System.out.println("\nInventory:");
                    for (int i = 0; i < player.getInventory().getItems().size(); i++) {
                        System.out.println(player.getInventory().getItems().get(i).getClassOfWeapon());
                    }

                    boolean b = true;
                    do {
                        System.out.print("\nType the Weapon you want to equip: ");
                        String weapon = sc.nextLine();
                        weapon = weapon.toLowerCase();
                        b = player.EquipItem(weapon);
                    } while(b);
                }
            } else if (c.equals("a") || c.equals("s") || c.equals("d") || c.equals("w")) {
                a = false;
            }
        } while (a);
        return c;
    }

    public boolean Move(String c, Player player) {
        boolean a = true;

        if (c.equals("w")) {
             if (player.getCurrentX() > 0) {
                 if (gameBoard[player.getCurrentX() - 1][player.getCurrentY()] == null) {
                     gameBoard[player.getCurrentX()][player.getCurrentY()] = null;
                     player.setCurrentX(player.getCurrentX() - 1);
                     gameBoard[player.getCurrentX()][player.getCurrentY()] = player;
                     a = false;
                 } else if (gameBoard[player.getCurrentX() - 1][player.getCurrentY()] instanceof Gold) {
                     player.PickUpGold((Gold) gameBoard[player.getCurrentX() - 1][player.getCurrentY()]);
                     gameBoard[player.getCurrentX()][player.getCurrentY()] = null;
                     player.setCurrentX(player.getCurrentX() - 1);
                     gameBoard[player.getCurrentX()][player.getCurrentY()] = player;
                     a = false;
                 } else if (gameBoard[player.getCurrentX() - 1][player.getCurrentY()] instanceof Monster) {
                     if (Battle(player, gameBoard[player.getCurrentX() - 1][player.getCurrentY()])) {
                         gameBoard[player.getCurrentX()][player.getCurrentY()] = null;
                         player.setCurrentX(player.getCurrentX() - 1);
                         gameBoard[player.getCurrentX()][player.getCurrentY()] = player;
                         a = false;
                     } else {
                         gameBoard[player.getCurrentX()][player.getCurrentY()] = null;
                         a = false;
                     }
                 } else if (gameBoard[player.getCurrentX() - 1][player.getCurrentY()] instanceof NPC) {
                     Interact(player, (NPC) gameBoard[player.getCurrentX() - 1][player.getCurrentY()]);
                     a = false;
                 } else {
                     System.out.println ("Cannot move there!");
                 }
             } else {
                 System.out.println ("Cannot move there!");
             }
        } else if (c.equals("d")) {
            if (player.getCurrentY() < 7) {
                if (gameBoard[player.getCurrentX()][player.getCurrentY() + 1] == null) {
                    gameBoard[player.getCurrentX()][player.getCurrentY()] = null;
                    player.setCurrentY(player.getCurrentY() + 1);
                    gameBoard[player.getCurrentX()][player.getCurrentY()] = player;
                    a = false;
                } else if (gameBoard[player.getCurrentX()][player.getCurrentY() + 1] instanceof Gold) {
                    player.PickUpGold((Gold) gameBoard[player.getCurrentX()][player.getCurrentY() + 1]);
                    gameBoard[player.getCurrentX()][player.getCurrentY()] = null;
                    player.setCurrentY(player.getCurrentY() + 1);
                    gameBoard[player.getCurrentX()][player.getCurrentY()] = player;
                    a = false;
                }else if (gameBoard[player.getCurrentX()][player.getCurrentY() + 1] instanceof Monster) {
                    if (Battle(player, gameBoard[player.getCurrentX()][player.getCurrentY() + 1])) {
                        gameBoard[player.getCurrentX()][player.getCurrentY()] = null;
                        player.setCurrentY(player.getCurrentY() + 1);
                        gameBoard[player.getCurrentX()][player.getCurrentY()] = player;
                        a = false;
                    } else {
                        gameBoard[player.getCurrentX()][player.getCurrentY()] = null;
                        a = false;
                    }
                } else if (gameBoard[player.getCurrentX()][player.getCurrentY() + 1] instanceof NPC) {
                    Interact(player, (NPC) gameBoard[player.getCurrentX()][player.getCurrentY() + 1]);
                    a = false;
                } else {
                    System.out.println ("Cannot move there!");
                }
            } else {
                System.out.println ("Cannot move there!");
            }
        } else if (c.equals("a")) {
            if (player.getCurrentY() > 0) {
                if (gameBoard[player.getCurrentX()][player.getCurrentY() - 1] == null) {
                    gameBoard[player.getCurrentX()][player.getCurrentY()] = null;
                    player.setCurrentY(player.getCurrentY() - 1);
                    gameBoard[player.getCurrentX()][player.getCurrentY()] = player;
                    a = false;
                } else if (gameBoard[player.getCurrentX()][player.getCurrentY() - 1] instanceof Gold) {
                    player.PickUpGold((Gold) gameBoard[player.getCurrentX()][player.getCurrentY() - 1]);
                    gameBoard[player.getCurrentX()][player.getCurrentY()] = null;
                    player.setCurrentY(player.getCurrentY() - 1);
                    gameBoard[player.getCurrentX()][player.getCurrentY()] = player;
                    a = false;
                }else if (gameBoard[player.getCurrentX()][player.getCurrentY() - 1] instanceof Monster) {
                    if (Battle(player, gameBoard[player.getCurrentX()][player.getCurrentY() - 1])) {
                        gameBoard[player.getCurrentX()][player.getCurrentY()] = null;
                        player.setCurrentY(player.getCurrentY() - 1);
                        gameBoard[player.getCurrentX()][player.getCurrentY()] = player;
                        a = false;
                    } else {
                        gameBoard[player.getCurrentX()][player.getCurrentY()] = null;
                        a = false;
                    }
                } else if (gameBoard[player.getCurrentX()][player.getCurrentY() - 1] instanceof NPC) {
                    Interact(player, (NPC) gameBoard[player.getCurrentX()][player.getCurrentY() - 1]);
                    a = false;
                } else {
                    System.out.println ("Cannot move there!");
                }
            } else {
                System.out.println ("Cannot move there!");
            }
        } else if (c.equals("s")) {
            if (player.getCurrentX() < 11) {
                if (gameBoard[player.getCurrentX() + 1][player.getCurrentY()] == null){
                    gameBoard[player.getCurrentX()][player.getCurrentY()] = null;
                    player.setCurrentX(player.getCurrentX() + 1);
                    gameBoard[player.getCurrentX()][player.getCurrentY()] = player;
                    a = false;
                } else if (gameBoard[player.getCurrentX() + 1][player.getCurrentY()] instanceof Gold) {
                    player.PickUpGold((Gold) gameBoard[player.getCurrentX() + 1][player.getCurrentY()]);
                    gameBoard[player.getCurrentX()][player.getCurrentY()] = null;
                    player.setCurrentX(player.getCurrentX() + 1);
                    gameBoard[player.getCurrentX()][player.getCurrentY()] = player;
                    a = false;
                } else if (gameBoard[player.getCurrentX() + 1][player.getCurrentY()] instanceof Monster) {
                        if (Battle(player, gameBoard[player.getCurrentX() + 1][player.getCurrentY()])) {
                            gameBoard[player.getCurrentX()][player.getCurrentY()] = null;
                            player.setCurrentX(player.getCurrentX() + 1);
                            gameBoard[player.getCurrentX()][player.getCurrentY()] = player;
                            a = false;
                        } else {
                            gameBoard[player.getCurrentX()][player.getCurrentY()] = null;
                            a = false;
                        }
                } else if (gameBoard[player.getCurrentX() + 1][player.getCurrentY()] instanceof NPC) {
                    Interact(player, (NPC) gameBoard[player.getCurrentX() + 1][player.getCurrentY()]);
                    a = false;
                } else {
                    System.out.println ("Cannot move there!");
                }
            }
        } else {
            System.out.println ("Cannot move there!");
        }
        return a;
    }

    public boolean Battle(Player player, Character monster) {
        int playerAttack;
        if (player.getWeapon().getAttackInterval() - monster.getArmor() > 0) {
            playerAttack = player.getWeapon().getAttackInterval() - monster.getArmor();
        } else {
            playerAttack = 0;
        }

        int monsterAttack;
        if (monster.getWeapon().getAttackInterval() - player.getArmor() > 0) {
            monsterAttack = monster.getWeapon().getAttackInterval() - player.getArmor();
        } else {
            monsterAttack = 0;
        }

        System.out.println(player.getName() + " fights " + monster.getName());

         do {
             monster.setHp(monster.getHp() - playerAttack);
             if (monster.getHp() > 0) {
                 player.setHp(player.getHp() - monsterAttack);
             } else {
                 break;
             }
         } while (player.getHp() > 0 && monster. getHp() > 0);

         if (player.getHp() < 0) {
             System.out.println(player.getName() + " died!");
             gameBoard[player.getCurrentX()][player.getCurrentY()] = null;
             party.PartyInfo().remove(player);
             return false;
         } else {
             if (monster instanceof Dragon) {
                 System.out.println("Dragon Fire Acquired");
                 player.getInventory().getItems().add(new DragonFire());
             }
             System.out.println(monster.getName() + " died!  " + ANSI_YELLOW + "(+" + monster.getGold() + " gold)\n" + ANSI_RESET + player.getName() + " has " + player.getHp() + " HP.");
             player.setGold(player.getGold() + monster.getGold());
             return true;
         }
    }

    public void Interact(Player player, NPC npc) {
        MagicRing magicRing = new MagicRing();
        OlympicBow olympicBow = new OlympicBow();
        ClothArmor clothArmor = new ClothArmor();
        Shield shield = new Shield();

        String st;
        boolean a = true;

         if (npc instanceof Vendor) {
             System.out.println("Hello " + player.getName() + "! Do you want to buy a Weapon or Equipment?  (Press 'olympic bow', 'magic ring', 'shield', 'cloth armor' or 'no')\n Olympic Bow (200 damage): " + olympicBow.getRequiredGold() + " gold\n Magic Ring (270 damage): " + magicRing.getRequiredGold() + " gold\n Shield (+50 armor): " + shield.getRequiredGold() + " gold\n Cloth Armor (+70 armor): "  + clothArmor.getRequiredGold() + " gold\n\n\t\tYou have " + player.getGold() + " gold.");
             do {
                 st = sc.nextLine();
                 if (st.equals("magic ring")) {
                     a = player.PickUpItem(magicRing);
                 } else if (st.equals("olympic bow")) {
                     a = player.PickUpItem(olympicBow);
                 } else if (st.equals("cloth armor")) {
                     a = player.GetEquipment(clothArmor);
                 } else if (st.equals("shield")) {
                     a = player.GetEquipment(shield);
                 }
             } while (!st.equals("no") && a);
         } else if (npc instanceof Healer) {
             npc.Heal(player);
         }

    }

    public void StartGame() {


        fillGameBoard();

        for (int i = 0; i < party.PartyInfo().size(); i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                if (gameBoard[0][j] == null) {
                    gameBoard[0][j] = party.PartyInfo().get(i);
                    party.PartyInfo().get(i).setCurrentX(0);
                    party.PartyInfo().get(i).setCurrentY(j);
                    break;
                }
            }
        }
        Board();

        do {
            for (int i = 0; i < party.PartyInfo().size(); i++) {
                Board();

                System.out.print(ANSI_PURPLE + "\t\t\t\t | " + party.PartyInfo().get(i).getName() + ANSI_PURPLE + "'s turn |" + ANSI_RESET);
                boolean b;
                do {
                    String c = "";
                    c = PlayerStatsOrMove(party.PartyInfo().get(i), c);
                    b = Move(c, party.PartyInfo().get(i));
                } while (b);
            }
        } while(!party.PartyInfo().isEmpty() && gameBoard[11][4] instanceof Boss);

        if (party.PartyInfo().isEmpty()) {
            System.out.println(ANSI_RED + "\n\n\t\t\t\t\t\tYOU LOST!" + ANSI_RESET);
        } else if (gameBoard[11][4] instanceof Player) {
            System.out.println(ANSI_GREEN + "\n\n\t\t\t\t\t\tYOU WON!" + ANSI_RESET);
        }
    }


}
