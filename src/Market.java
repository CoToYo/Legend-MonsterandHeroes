import java.util.LinkedList;
import java.util.Scanner;

public class Market {
    /**
     * Use LinkedList to store goods in a market,
     * 'cause market needs frequent insert and delete behaviors and LinkedList is good at it.
     */
    LinkedList<Weapon> weaponList;
    LinkedList<Armor> armorList;
    LinkedList<Potion> potionList;
    LinkedList<IceSpell> iceSpellList;
    LinkedList<FireSpell> fireSpellList;
    LinkedList<LightningSpell> lightningSpellList;
    Market(){
        weaponList = new LinkedList<>();
        armorList = new LinkedList<>();
        potionList = new LinkedList<>();
        iceSpellList = new LinkedList<>();
        fireSpellList = new LinkedList<>();
        lightningSpellList = new LinkedList<>();

        // 1 weapon
        weaponList.offer(GameController.itemCatalog.getRandomWeapon());
        // 1 armor
        armorList.offer(GameController.itemCatalog.getRandomArmor());
        // 1 potion
        potionList.offer(GameController.itemCatalog.getRandomPotion());
        // 1 ice spell
        iceSpellList.offer(GameController.itemCatalog.getRandomIceSpell());
        // 1 fire spell
        fireSpellList.offer(GameController.itemCatalog.getRandomFireSpell());
        // 1 lightning spell
        lightningSpellList.offer(GameController.itemCatalog.getRandomLightningSpell());

    }


//    LinkedList<Item> goodsList;


    public void enterMarket(PartyOfHeroes ph){
        System.out.println("\nWelcome to mystery market.");
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
        Scanner input = new Scanner(System.in);
        while(true){
            boolean quit = false;
            System.out.println("Enter [B/b] to buy, [S/s] to sell or [Q/q] to quit:");
            String cmd = input.nextLine().toLowerCase();
            switch (cmd){
                case "b":
                    System.out.println("Who(Hero) wants to buy stuff?(Enter complete name):");
                    String buyer = input.nextLine();
                    buyer.substring(0,1); // throw '\n'
                    buy(ph.getHero(buyer));
                    break;
                case "s":
                    System.out.println("Who(Hero) wants to sell stuff?(Enter complete name)");
                    String seller = input.nextLine();
                    seller.substring(0,1); // throw '\n'
                    sell(ph.getHero(seller));
                    break;
                case "q":
                    quit = true;
                    break;
            }
            if(quit){
                break;
            }
        }
    }

    /**
     * Hero buys goods in market
     * @return boolean
     */
    public boolean buy(Hero buyer) {
        Scanner input = new Scanner(System.in);
        System.out.println("What type of goods do you want to buy?(Enter complete type name)(Enter [Q/q] to quit)");
        String type = input.nextLine().toLowerCase();
        System.out.println("What "+type+" do you want to buy?(Enter sequence number)(Enter [Q/q] to quit)");
        int id = input.nextInt();
        input.nextLine(); // ignore '\n'

        switch (type){
            case "weapon":
                Weapon weapon = weaponList.get(id);
                if(buyer.getGold() < weapon.getCost()){
                    System.out.println("Oops! Your hero doesn't have enough golds to buy it!");
                }
                else{
                    buyer.getInventory().insert(type,weapon); // move stuff into buyer's inventory
                    buyer.setGold(buyer.getGold() - weapon.getCost()); // reduce buyer's golds
                    weaponList.remove(id); // remove sold stuff
                }
                break;
            case "armor":
                Armor armor = armorList.get(id);
                if(buyer.getGold() < armor.getCost()){
                    System.out.println("Oops! Your hero doesn't have enough golds to buy it!");
                }
                else{
                    buyer.getInventory().insert(type,armor); // move stuff into buyer's inventory
                    buyer.setGold(buyer.getGold() - armor.getCost()); // reduce buyer's golds
                    armorList.remove(id); // remove sold stuff
                }
                break;
            case "potion":
                Potion potion = potionList.get(id);
                if(buyer.getGold() < potion.getCost()){
                    System.out.println("Oops! Your hero doesn't have enough golds to buy it!");
                }
                else{
                    buyer.getInventory().insert(type,potion); // move stuff into buyer's inventory
                    buyer.setGold(buyer.getGold() - potion.getCost()); // reduce buyer's golds
                    armorList.remove(id); // remove sold stuff
                }
                break;
            case "icespell":
                IceSpell icespell = iceSpellList.get(id);
                if(buyer.getGold() < icespell.getCost()){
                    System.out.println("Oops! Your hero doesn't have enough golds to buy it!");
                }
                else{
                    buyer.getInventory().insert(type,icespell); // move stuff into buyer's inventory
                    buyer.setGold(buyer.getGold() - icespell.getCost()); // reduce buyer's golds
                    armorList.remove(id); // remove sold stuff
                }
                break;
            case "firespell":
                FireSpell firespell = fireSpellList.get(id);
                if(buyer.getGold() < firespell.getCost()){
                    System.out.println("Oops! Your hero doesn't have enough golds to buy it!");
                }
                else{
                    buyer.getInventory().insert(type,firespell); // move stuff into buyer's inventory
                    buyer.setGold(buyer.getGold() - firespell.getCost()); // reduce buyer's golds
                    armorList.remove(id); // remove sold stuff
                }
                break;
            case "lightningspell":
                LightningSpell lightningspell = lightningSpellList.get(id);
                if(buyer.getGold() < lightningspell.getCost()){
                    System.out.println("Oops! Your hero doesn't have enough golds to buy it!");
                }
                else{
                    buyer.getInventory().insert(type,lightningspell); // move stuff into buyer's inventory
                    buyer.setGold(buyer.getGold() - lightningspell.getCost()); // reduce buyer's golds
                    armorList.remove(id); // remove sold stuff
                }
                break;
            case "q":
                return false;
        }
        return true;
    }

    /***
     * Hero sells goods in market
     * @param seller
     * @return
     */
    public boolean sell(Hero seller){
        seller.getInventory().show(); // show seller's inventory first

        Scanner input = new Scanner(System.in);
        System.out.println("What type of goods do you want to sell?(Enter complete type name)(Enter [Q/q] to quit)");
        String type = input.nextLine().toLowerCase();
        System.out.println("What "+type+" do you want to buy?(Enter sequence number)(Enter [Q/q] to quit)");
        int id = input.nextInt();
        input.nextLine(); // ignore '\n'

        switch (type){
            case "weapon":
                Weapon weapon = seller.getInventory().weaponList.get(id);
                weapon.setCost(weapon.getCost()/2); // sell goods with half price
                weaponList.offer(weapon); // add into market
                seller.getInventory().weaponList.remove(id); // remove from seller's inventory
                break;
            case "armor":
                Armor armor = seller.getInventory().armorList.get(id);
                armor.setCost(armor.getCost()/2); // sell goods with half price
                armorList.offer(armor); // add into market
                seller.getInventory().armorList.remove(id); // remove from seller's inventory
                break;
            case "potion":
                Potion potion = seller.getInventory().potionList.get(id);
                potion.setCost(potion.getCost()/2); // sell goods with half price
                potionList.offer(potion); // add into market
                seller.getInventory().potionList.remove(id); // remove from seller's inventory
                break;
            case "icespell":
                IceSpell iceSpell = seller.getInventory().iceSpellList.get(id);
                iceSpell.setCost(iceSpell.getCost()/2); // sell goods with half price
                iceSpellList.offer(iceSpell); // add into market
                seller.getInventory().iceSpellList.remove(id); // remove from seller's inventory
                break;
            case "firespell":
                FireSpell firespell = seller.getInventory().fireSpellList.get(id);
                firespell.setCost(firespell.getCost()/2); // sell goods with half price
                fireSpellList.offer(firespell); // add into market
                seller.getInventory().fireSpellList.remove(id); // remove from seller's inventory
                break;
            case "lightningspell":
                LightningSpell lightningspell = seller.getInventory().lightningSpellList.get(id);
                lightningspell.setCost(lightningspell.getCost()/2); // sell goods with half price
                lightningSpellList.offer(lightningspell); // add into market
                seller.getInventory().lightningSpellList.remove(id); // remove from seller's inventory
                break;
            case "q":
                return false;
        }

        return true;
    }
}


