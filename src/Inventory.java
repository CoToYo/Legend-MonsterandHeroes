import java.util.HashMap;
import java.util.LinkedList;

public class Inventory {
//    private HashMap<Integer, Item> inventory;

    LinkedList<Weapon> weaponList;
    LinkedList<Armor> armorList;
    LinkedList<Potion> potionList;
    LinkedList<IceSpell> iceSpellList;
    LinkedList<FireSpell> fireSpellList;
    LinkedList<LightningSpell> lightningSpellList;

    Inventory(){
//        inventory = new HashMap<>();
        weaponList = new LinkedList<>();
        armorList = new LinkedList<>();
        potionList = new LinkedList<>();
        iceSpellList = new LinkedList<>();
        fireSpellList = new LinkedList<>();
        lightningSpellList = new LinkedList<>();
    }

    public boolean insert(String type, Item item){
        switch (type){
            case "weapon":
                weaponList.offer((Weapon) item);
                break;
            case "armor":
                armorList.offer((Armor) item);
                break;
            case "potion":
                potionList.offer((Potion) item);
                break;
            case "icespell":
                iceSpellList.offer((IceSpell) item);
                break;
            case "firespell":
                fireSpellList.offer((FireSpell) item);
                break;
            case "lightningspell":
                lightningSpellList.offer((LightningSpell) item);
                break;
        }
        return true;
    }

    public boolean delete(String type, int seq){
        switch (type){
            case "weapon":
                weaponList.remove(seq);
                break;
            case "armor":
                armorList.remove(seq);
                break;
            case "potion":
                potionList.remove(seq);
                break;
            case "icespell":
                iceSpellList.remove(seq);
                break;
            case "firespell":
                fireSpellList.remove(seq);
                break;
            case "lightningspell":
                lightningSpellList.remove(seq);
                break;
        }
        return true;
    }

    public void show(){
        System.out.println("\nInventory");
        System.out.println("___________________________");
        System.out.println("[Weapon]");
        for(int i=0 ; i<weaponList.size() ; i++){
            System.out.println(i+". "+weaponList.get(i).toString());
        }
        System.out.println("[Armor]");
        for(int i=0 ; i<armorList.size() ; i++){
            System.out.println(i+". "+armorList.get(i).toString());
        }
        System.out.println("[Potion]");
        for(int i=0 ; i<potionList.size() ; i++){
            System.out.println(i+". "+potionList.get(i).toString());
        }
        System.out.println("[IceSpell]");
        for(int i=0 ; i<iceSpellList.size() ; i++){
            System.out.println(i+". "+iceSpellList.get(i).toString());
        }
        System.out.println("[FireSpell]");
        for(int i=0 ; i<fireSpellList.size() ; i++){
            System.out.println(i+". "+fireSpellList.get(i).toString());
        }
        System.out.println("[LightningSpell]");
        for(int i=0 ; i<lightningSpellList.size() ; i++){
            System.out.println(i+". "+lightningSpellList.get(i).toString());
        }
    }
}
