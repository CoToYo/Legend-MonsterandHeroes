//import javax.xml.catalog.Catalog;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedList;
import java.io.*;
import java.util.Random;

/**
 * This class is to restore all items' info in this game
 * Each market will randomly "pick up" some items in this pool as goods for sale.(Copy an object of item and return to market, not change catalog itself)
 * Catalog is only for providing info of different items.
 */
public class ItemCatalog implements Catalog{
    HashMap<String, Weapon> weaponHashMap;
    HashMap<String, Armor> armorHashMap;
    HashMap<String, Potion> potionHashMap;
    HashMap<String, IceSpell> iceSpellHashMap;
    HashMap<String, FireSpell> fireSpellHashMap;
    HashMap<String, LightningSpell> lightningSpellHashMap;
    HashMap<String, Item> allItemHashMap; // A collection of all items

    ItemCatalog(){
        weaponHashMap = new HashMap<>();
        armorHashMap = new HashMap<>();
        potionHashMap = new HashMap<>();
        iceSpellHashMap = new HashMap<>();
        fireSpellHashMap = new HashMap<>();
        lightningSpellHashMap = new HashMap<>();
        allItemHashMap = new HashMap<>();

        // Read data files to get all items and initialize the ItemPool.
        readWeaponFile();
        readArmorFile();
        readPotionFile();
        readIceSpellFile();
        readFireSpellFile();
        readLightningSpellFile();
    }

    /**
     The following methods are for getting a random Item with specific type.
     Used by Market: each market have random goods for sale*/

    public Weapon getRandomWeapon(){
        Random random = new Random();
        int keySeq = random.nextInt(weaponHashMap.size());
        String key = (String)weaponHashMap.keySet().toArray()[keySeq];

        return weaponHashMap.get(key);
    }

    public Armor getRandomArmor(){
        Random random = new Random();
        int keySeq = random.nextInt(armorHashMap.size());
        String key = (String)armorHashMap.keySet().toArray()[keySeq];
        return armorHashMap.get(key);
    }

    public Potion getRandomPotion(){
        Random random = new Random();
        int keySeq = random.nextInt(potionHashMap.size());
        String key = (String)potionHashMap.keySet().toArray()[keySeq];
        return potionHashMap.get(key);
    }

    public IceSpell getRandomIceSpell(){
        Random random = new Random();
        int keySeq = random.nextInt(iceSpellHashMap.size());
        String key = (String)iceSpellHashMap.keySet().toArray()[keySeq];
        return iceSpellHashMap.get(key);
    }

    public FireSpell getRandomFireSpell(){
        Random random = new Random();
        int keySeq = random.nextInt(fireSpellHashMap.size());
        String key = (String)fireSpellHashMap.keySet().toArray()[keySeq];
        return fireSpellHashMap.get(key);
    }

    public LightningSpell getRandomLightningSpell(){
        Random random = new Random();
        int keySeq = random.nextInt(lightningSpellHashMap.size());
        String key = (String)lightningSpellHashMap.keySet().toArray()[keySeq];
        return lightningSpellHashMap.get(key);
    }

    /**
     * Read Weaponry.txt
     * */
    public boolean readWeaponFile(){
        try {
            File file = new File("./src/data/Weaponry.txt");

            if(file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                BufferedReader in = new BufferedReader(read);
                String str;

                str = in.readLine(); // Ignore the title line
                while ((str = in.readLine()) != null) {
                    String[] line = str.split("\\s+"); // split a read line by any number of whitespace character

                    Weapon weapon = new Weapon(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                            Integer.parseInt(line[3]), Integer.parseInt(line[4]));
                    weaponHashMap.put(weapon.getName(), weapon);
                    allItemHashMap.put(weapon.getName(), weapon); // Also add in collection of all items
                }
            }
            else{ // Not find file
                System.out.println("Can't find file: ./src/data/Weaponry.txt");
                return false;
            }

        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * Read Armory.txt
     */
    public boolean readArmorFile(){
        try {
            File file = new File("./src/data/Armory.txt");

            if(file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                BufferedReader in = new BufferedReader(read);
                String str;

                str = in.readLine(); // Ignore the title line
                while ((str = in.readLine()) != null) {
                    String[] line = str.split("\\s+"); // split a read line by any number of whitespace character

                    Armor armor = new Armor(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                            Integer.parseInt(line[3]));
                    armorHashMap.put(armor.getName(), armor);
                    allItemHashMap.put(armor.getName(), armor); // Also add in collection of all items
                }
            }
            else{ // Not find file
                System.out.println("Can't find file: ./src/data/Armory.txt");
                return false;
            }

        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * Read Potions.txt
     */
    public boolean readPotionFile(){
        try {
            File file = new File("./src/data/Potions.txt");

            if(file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                BufferedReader in = new BufferedReader(read);
                String str;

                str = in.readLine(); // Ignore the title line
                while ((str = in.readLine()) != null) {
                    String[] line = str.split("\\s+"); // split a read line by any number of whitespace character

                    Potion potion = new Potion(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                            Integer.parseInt(line[3]), line[4]);
                    potionHashMap.put(potion.getName(), potion);
                    allItemHashMap.put(potion.getName(), potion); // Also add in collection of all items
                }
            }
            else{ // Not find file
                System.out.println("Can't find file: ./src/data/Potions.txt");
                return false;
            }

        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * Read IceSpells.txt
     */
    public boolean readIceSpellFile(){
        try {
            File file = new File("./src/data/IceSpells.txt");

            if(file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                BufferedReader in = new BufferedReader(read);
                String str;

                str = in.readLine(); // Ignore the title line
                while ((str = in.readLine()) != null) {
                    String[] line = str.split("\\s+"); // split a read line by any number of whitespace character

                    IceSpell iceSpell = new IceSpell(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                            Integer.parseInt(line[3]), Integer.parseInt(line[4]));
                    iceSpellHashMap.put(iceSpell.getName(), iceSpell);
                    allItemHashMap.put(iceSpell.getName(), iceSpell); // Also add in collection of all items
                }
            }
            else{ // Not find file
                System.out.println("Can't find file: ./src/data/IceSpells.txt");
                return false;
            }

        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * Read FireSpells.txt
     */
    public boolean readFireSpellFile(){
        try {
            File file = new File("./src/data/FireSpells.txt");

            if(file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                BufferedReader in = new BufferedReader(read);
                String str;

                str = in.readLine(); // Ignore the title line
                while ((str = in.readLine()) != null) {
                    String[] line = str.split("\\s+"); // split a read line by any number of whitespace character

                    FireSpell fireSpell = new FireSpell(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                            Integer.parseInt(line[3]), Integer.parseInt(line[4]));
                    fireSpellHashMap.put(fireSpell.getName(), fireSpell);
                    allItemHashMap.put(fireSpell.getName(), fireSpell); // Also add in collection of all items
                }
            }
            else{ // Not find file
                System.out.println("Can't find file: ./src/data/FireSpells.txt");
                return false;
            }

        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * Read LightningSpells.txt
     */
    public boolean readLightningSpellFile(){
        try {
            File file = new File("./src/data/LightningSpells.txt");

            if(file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                BufferedReader in = new BufferedReader(read);
                String str;

                str = in.readLine(); // Ignore the title line
                while ((str = in.readLine()) != null) {
                    String[] line = str.split("\\s+"); // split a read line by any number of whitespace character

                    LightningSpell lightningSpell = new LightningSpell(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                            Integer.parseInt(line[3]), Integer.parseInt(line[4]));
                    lightningSpellHashMap.put(lightningSpell.getName(), lightningSpell);
                    allItemHashMap.put(lightningSpell.getName(), lightningSpell); // Also add in collection of all items
                }
            }
            else{ // Not find file
                System.out.println("Can't find file: ./src/data/LightningSpells.txt");
                return false;
            }

        } catch (IOException e) {
            return false;
        }
        return true;
    }

}