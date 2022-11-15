import java.util.Random;

public class Hero implements Character{
    private String name;
    private int level;
    private int exp;
    private int gold;
    private int HP;
    private int maxHP;
    private int MP;
    private int maxMP;
    private int strength;
    private int dexterity;
    private int agility;
    private Inventory inventory;

    private Armor equippedArmor;

    private Weapon equippedWeapon;

    Hero(String name, int MP, int strength, int agility, int dexterity, int gold, int level){
        this.name = name;
        this.level = level;
        this.exp = 0;
        this. gold = gold;
        this.HP = level * 100;
        this.maxHP = this.HP;
        this.MP = MP;
        this.maxMP = this.MP;
        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
        this.inventory = new Inventory();
        this.equippedArmor = new Armor();
        this.equippedWeapon = new Weapon();
    }

    public void increaseExp(int increase){
        exp += increase;

        if(exp >= level * 10){ // Level UP!
            int levelIncrease = exp / (level*10);
            int expRemain = exp % (level*10);

            levelUp(levelIncrease);

            exp = expRemain; // reset exp
        }
    }

    public boolean getAttacked(int damage){
        Random random = new Random();
        if(random.nextInt(10) < this.agility * 0.002){ // dodge!
            System.out.println(name + " successfully dodge the attack!");
            return false;
        }
        else{ // get hurt
            if(equippedArmor.getDamageReduction() > damage){ // perfectly protected by armor
                System.out.println(name + " successfully defend the attack!");
                return false;
            }
            else{
                this.HP -= (damage - equippedArmor.getDamageReduction());
            }
        }
        return true;
    }

    public void levelUp(int increase){
        level += increase;
        this.HP = this.level * 100; // HP increase with level
        this.maxHP = this.HP;
        this.MP = (int)(this.maxMP * 1.1);
        this.maxMP = this.MP;
    }

    public void refreshHPMP(){
        this.HP = this.maxHP;
        this.MP = this.maxMP;
    }

    public String getName(){
        return name;
    }

    public int getExp() {
        return exp;
    }

    public int getLevel() {
        return level;
    }

    public int getHP() {
        return HP;
    }

    public int getMP() {
        return MP;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getAgility() {
        return agility;
    }

    public int getGold() {
        return gold;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public void setLevel(int level) {
        this.level = level;
        this.HP = this.level * 100; // HP increase with level
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setEquippedArmor(Armor equippedArmor) {
        this.equippedArmor = equippedArmor;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public String toString(){
        String str = "";
        str += this.name + "    \t";
        str += this.exp + "    \t";
        str += this.HP + "    \t";
        str += this.level + "    \t";
        str += this.MP + "    \t";
        str += this.strength + "    \t";
        str += this.dexterity + "    \t";
        str += this.agility + "    \t";
        str += this.gold;

        return str;
    }

}

class Paladin extends Hero{

    Paladin(String name, int MP, int strength, int agility, int dexterity, int gold, int level) {
        super(name, MP, strength, agility, dexterity, gold, level);
    }
    @Override
    public void levelUp(int increase){
        super.levelUp(increase);

        int newStrength = (int)Math.ceil(super.getStrength() * 1.1); // extra increase
        int newDexterity = (int)Math.ceil(super.getDexterity() * 1.1); // extra increase
        super.setStrength(newStrength);
        super.setDexterity(newDexterity);

        System.out.print(super.getName()+" has level up! (Current level: "+super.getLevel()+")");
    }
}

class Warrior extends Hero{

    Warrior(String name, int MP, int strength, int agility, int dexterity, int gold, int level) {
        super(name, MP, strength, agility, dexterity, gold, level);
    }
    @Override
    public void levelUp(int increase){
        super.levelUp(increase);

        int newStrength = (int)Math.ceil(super.getStrength() * 1.1); // extra increase
        int newAgility = (int)Math.ceil(super.getAgility() * 1.1); // extra increase
        super.setStrength(newStrength);
        super.setAgility(newAgility);

        System.out.print(super.getName()+" has level up! (Current level: "+super.getLevel()+")");
    }
}

class Sorcerer extends Hero{

    Sorcerer(String name, int MP, int strength, int agility, int dexterity, int gold, int level) {
        super(name, MP, strength, agility, dexterity, gold, level);
    }
    @Override
    public void levelUp(int increase){
        super.levelUp(increase);

        int newDexterity = (int)Math.ceil(super.getDexterity() * 1.1); // extra increase
        int newAgility = (int)Math.ceil(super.getAgility() * 1.1); // extra increase
        super.setStrength(newDexterity);
        super.setAgility(newAgility);

        System.out.print(super.getName()+" has level up! (Current level: "+super.getLevel()+")");
    }
}

