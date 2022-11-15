import java.util.Random;

public class Monster implements Character{
    private String name;
    private int level;
    private int HP;
    private int damage;
    private int defense;
    private int dodge;

    Monster(String name, int level, int damage, int defense, int dodge){
        this.name = name;
        this.level = level;
        this.HP = level * 100;
        this.damage = damage;
        this.defense = defense;
        this.dodge = dodge;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setLevel(int level) {
        this.level = level;
        this.HP = this.level * 100; // HP increase with level
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public int getHP() {
        return HP;
    }

    public int getLevel() {
        return level;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public int getDodge() {
        return dodge;
    }

    public String getName() {
        return name;
    }

    public boolean getAttacked(int damage){
        Random random = new Random();
        if(random.nextInt(10) < this.dodge * 0.1){ // dodge!
            System.out.println(name + " successfully dodge the attack!");
            return false;
        }
        else{ // get hurt
            this.HP -= damage;
        }
        return true;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", level=" + level +
                ", HP=" + HP +
                ", damage=" + damage +
                ", defense=" + defense +
                ", dodge=" + dodge +
                '}';
    }
}

class Dragon extends Monster{
    Dragon(String name, int level, int damage, int defense, int dodge){
        super(name, level, damage, defense, dodge);
    }

    /* Maybe some special skills*/
}

class Exoskeleton extends Monster{
    Exoskeleton(String name, int level, int damage, int defense, int dodge){
        super(name, level, damage, defense, dodge);
    }

    /* Maybe some special skills*/
}

class Spirit extends Monster{
    Spirit(String name, int level, int damage, int defense, int dodge){
        super(name, level, damage, defense, dodge);
    }

    /* Maybe some special skills*/
}
