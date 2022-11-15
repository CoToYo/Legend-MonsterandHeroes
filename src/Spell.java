public class Spell implements Item{
    private String name;
    private int cost;
    private int requiredLevel;
    private int damage;
    private int manaCost;

    private int availNum = 1; // Can use only once

    Spell(String name, int cost, int requiredLevel, int damage, int manaCost){
        this.name = name;
        this.cost = cost;
        this.requiredLevel = requiredLevel;
        this.damage = damage;
        this.manaCost = manaCost;
        this.availNum = availNum;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    public void setAvailNum(int availNum) {
        this.availNum = availNum;
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

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getAvailNum() {
        return availNum;
    }

    public void cast(Hero hero, Monster target){;}

    @Override
    public String toString() {
        return "Spell{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", requiredLevel=" + requiredLevel +
                ", damage=" + damage +
                ", manaCost=" + manaCost +
                ", availNum=" + availNum +
                '}';
    }
}

class IceSpell extends Spell{

    IceSpell(String name, int cost, int requiredLevel, int damage, int manaCost) {
        super(name, cost, requiredLevel, damage, manaCost);
    }

    @Override
    public void cast(Hero hero, Monster target){
        System.out.println("[Hero]"+hero.getName()+" has used "+getName()+" towards "+target.getName()+"!");
        int loss = (int)Math.ceil(target.getDamage() * 0.1);
        target.setDamage(target.getDamage() - loss); // reduce monster damage
        target.getAttacked(getDamage() + hero.getDexterity()/10000 * getDamage()); // spell damage
        super.setAvailNum(super.getAvailNum() - 1); // reduce available use time
    }
}

class FireSpell extends Spell{

    FireSpell(String name, int cost, int requiredLevel, int damage, int manaCost) {
        super(name, cost, requiredLevel, damage, manaCost);
    }

    @Override
    public void cast(Hero hero, Monster target){
        System.out.println("[Hero]"+hero.getName()+" has used "+getName()+" towards "+target.getName()+"!");
        int loss = (int)Math.ceil(target.getDefense() * 0.1);
        target.setDefense(target.getDefense() - loss);
        target.getAttacked(getDamage() + hero.getDexterity()/10000 * getDamage()); // spell damage
        super.setAvailNum(super.getAvailNum() - 1); // reduce available use time
    }
}

class LightningSpell extends Spell{

    LightningSpell(String name, int cost, int requiredLevel, int damage, int manaCost) {
        super(name, cost, requiredLevel, damage, manaCost);
    }

    @Override
    public void cast(Hero hero, Monster target){
        System.out.println("[Hero]"+hero.getName()+" has used "+getName()+" towards "+target.getName()+"!");
        int loss = (int)Math.ceil(target.getDodge() * 0.1);
        target.setDodge(target.getDodge() - loss);
        target.getAttacked(getDamage() + hero.getDexterity()/10000 * getDamage()); // spell damage
        super.setAvailNum(super.getAvailNum() - 1); // reduce available use time
    }
}
