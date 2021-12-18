// TODO: balancing of stats such that it has a combined limit of a number
// TODO: speed, skills
// TODO: will do different actions
public class Fighter {
    enum MOVE_SET{
        ATTACK,
        DEFENSE,
        SKILL,
        IDLE    // cannot be used when attacking
    }

    private String name;
    private int attack,
                defense,
                currentHealth,
                maxHealth;

    // Random stats
    public Fighter(String name) {
        this.name = name;
        this.attack = (int)(Math.random() * 10) + 1;
        this.defense = (int)(Math.random() * 10) + 1;
        this.maxHealth = (int)(Math.random() * 10) + 5;
        this.currentHealth = maxHealth;
    }

    public String getName(){
        return this.name;
    }

    public int getCurrentHealth(){
        return this.currentHealth;
    }

    public void dealDamageTo(Fighter opponent) {
        opponent.takeDamage( opponent.calculateDamage( this.attack ) );
    }

    public void takeDamage(int damage){
        currentHealth -= damage;
    }

    public boolean isAlive() {
        return currentHealth > 0;
    }

    public void printAttributes() {
        System.out.println("Name: " + name + "\n"
                                + "Health: " + currentHealth + " / " + maxHealth + "\n"
                                + "Attack: " + attack + "\n"
                                + "Defense: " + defense + "\n"
        );
    }

    private int calculateDamage(int opponentAttack) {
        int damageReceived = opponentAttack - defense;

        // damage should be minimum of 1 regardless of calculated damage
        if (damageReceived <= 0)
            damageReceived = 1;

        return damageReceived;
    }
}
