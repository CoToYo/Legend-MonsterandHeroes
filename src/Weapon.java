public class Weapon implements Item{
    private String name;
    private int cost;
    private int requiredLevel;
    private int damage;
    private int requiredHands;

    Weapon(){
        this.name = "";
        this.cost = 0;
        this.requiredHands = 0;
        this.damage = 0;
        this.requiredLevel = 0;
    }

    Weapon(String name, int cost, int requiredLevel, int damage, int requiredHands){
        this.name = name;
        this.cost = cost;
        this.requiredLevel = requiredLevel;
        this.damage = damage;
        this.requiredHands = requiredHands;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setRequiredHands(int requiredHands) {
        this.requiredHands = requiredHands;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getRequiredHands() {
        return requiredHands;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", requiredLevel=" + requiredLevel +
                ", damage=" + damage +
                ", requiredHands=" + requiredHands +
                '}';
    }
}
