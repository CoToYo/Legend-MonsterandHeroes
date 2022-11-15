public class Potion implements Item{
    private String name;
    private int cost;
    private int requiredLevel;
    private int attriIncrease;
    private String attrAffect;
    private int availNum = 1; // Potion can only be used once!

    Potion(String name, int cost, int requiredLevel, int attriIncrease, String attrAffect){
        this.name = name;
        this.cost = cost;
        this.requiredLevel = requiredLevel;
        this.attriIncrease = attriIncrease;
        this.attrAffect = attrAffect;
    }

    public void cast(Hero hero){
        System.out.println("[Hero]"+hero.getName()+" has used "+getName()+"!");
        switch (attrAffect){
            case "Health":
                hero.setHP(hero.getHP() + attriIncrease);
                break;
            case "Strength":
                hero.setStrength(hero.getStrength() + attriIncrease);
                break;
            case "Mana":
                hero.setMP(hero.getMP() + attriIncrease);
                break;
            case "Agility":
                hero.setAgility(hero.getAgility() + attriIncrease);
                break;
            case "Health/Mana/Strength/Agility":
                hero.setHP(hero.getHP() + attriIncrease);
                hero.setMP(hero.getMP() + attriIncrease);
                hero.setStrength(hero.getStrength() + attriIncrease);
                hero.setAgility(hero.getAgility() + attriIncrease);
                break;
            case "All Health/Mana/Strength/Dexterity/Defense/Agility": // Ignore 'Defense', because hero doesn't have this attribute(only in 'Armor')
                hero.setHP(hero.getHP() + attriIncrease);
                hero.setMP(hero.getMP() + attriIncrease);
                hero.setStrength(hero.getStrength() + attriIncrease);
                hero.setAgility(hero.getAgility() + attriIncrease);
                hero.setDexterity(hero.getDexterity() + attriIncrease);
                break;
        }
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

    public void setAttrAffect(String attrAffect) {
        this.attrAffect = attrAffect;
    }

    public void setAttriIncrease(int attriIncrease) {
        this.attriIncrease = attriIncrease;
    }

    public void setAvailNum(int availNum) {
        this.availNum = availNum;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public int getAvailNum() {
        return availNum;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public int getAttriIncrease() {
        return attriIncrease;
    }

    public String getAttrAffect() {
        return attrAffect;
    }

    @Override
    public String toString() {
        return "Potion{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", requiredLevel=" + requiredLevel +
                ", attriIncrease=" + attriIncrease +
                ", attrAffect='" + attrAffect + '\'' +
                ", availNum=" + availNum +
                '}';
    }
}
