public class Armor implements Item{
    private String name;
    private int cost;
    private int requiredLevel;
    private int damageReduction;

    Armor(){ // Air armor
        this.name = "";
        this.cost = 0;
        this.requiredLevel = 0;
        this.damageReduction = 0;
    }

    Armor(String name, int cost, int requiredLevel, int damageReduction){
        this.name = name;
        this.cost = cost;
        this.requiredLevel = requiredLevel;
        this.damageReduction = damageReduction;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", requiredLevel=" + requiredLevel +
                ", damageReduction=" + damageReduction +
                '}';
    }
}
