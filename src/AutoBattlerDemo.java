public class AutoBattlerDemo {
    // 2 for now
    static int NUMBER_OF_FIGHTERS = 2;
    static int MINIMUM_ALIVE_FIGHTERS = 2;

    // TODO: Better as a list
    static Fighter [] fighters = new Fighter[NUMBER_OF_FIGHTERS];

    public static void main(String [] args) {
        start();
    }

    private static void start() {
        System.out.println("Battle Start!");
        initializeFighters();
        startBattle();
        System.out.println("Battle ended");
    }

    private static void initializeFighters(){
        for(int i = 0; i < NUMBER_OF_FIGHTERS; i++){
            fighters[i] = new Fighter("F" + (i + 1));
            fighters[i].printAttributes();
        }
    }

    private static void startBattle() {
        int startWith = (int)(Math.random() * 10) % 2;
        Fighter attacker = fighters[startWith % 2];
        Fighter defender;
                // defender = fighters[(startWith + 1) % 2];

        while( canDoBattle() ){
            attacker = fighters[startWith % 2];
            defender = fighters[(startWith + 1) % 2];

            int defenderCurrentHealthBeforeDamage = defender.getCurrentHealth();

            attacker.dealDamage(defender);

            System.out.println(attacker.getName()
                    + " dealt "
                    + (defenderCurrentHealthBeforeDamage - defender.getCurrentHealth())
                    + " damage to "
                    + defender.getName() + "\n");

            System.out.println("===============================");
            attacker.printAttributes();
            defender.printAttributes();
            System.out.println("===============================");
            System.out.println("\n");

            startWith++;
        }

        System.out.println(attacker.getName() + " wins the battle!");
    }

    private static boolean canDoBattle() {
        int numberOfAliveFighters = MINIMUM_ALIVE_FIGHTERS;

        for (Fighter f : fighters) {
            if (! f.isAlive() ) numberOfAliveFighters--;
        }

        return numberOfAliveFighters == MINIMUM_ALIVE_FIGHTERS;
    }
}
