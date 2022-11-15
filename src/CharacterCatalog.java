import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CharacterCatalog {
    private HashMap<String, Character> allCharacterHashMap;
    private HashMap<String, Paladin> paladinHashMap;
    private HashMap<String, Warrior> warriorHashMap;
    private HashMap<String, Sorcerer> sorcererHashMap;
    private HashMap<String, Dragon> dragonHashMap;
    private HashMap<String, Exoskeleton> exoskeletonHashMap;
    private HashMap<String, Spirit> spiritHashMap;

    CharacterCatalog(){
        allCharacterHashMap = new HashMap<>();
        paladinHashMap = new HashMap<>();
        warriorHashMap = new HashMap<>();
        sorcererHashMap = new HashMap<>();
        dragonHashMap = new HashMap<>();
        exoskeletonHashMap = new HashMap<>();
        spiritHashMap = new HashMap<>();

        // readFile()...
        readSpiritFile();
        readDragonFile();
        readExoskeletonFile();
        readWarriorFile();
        readPaladinFile();
        readSorcererFile();
    }

    public Character getCharacter(String name){
        return allCharacterHashMap.get(name);
    }

    public boolean hasCharacter(String name){
        return allCharacterHashMap.containsKey(name);
    }

    public void showAllHeroes(){
        System.out.println("[Warriors]");
        System.out.println("Name    /Level    /Exp    /HP    /MP    /Strength    /Dexterity    /Agility    /Gold\t");
        for(Map.Entry<String, Warrior> set : warriorHashMap.entrySet()){
            System.out.println(set.getValue().toString());
        }

        System.out.println("[Paladins]");
        System.out.println("Name    /Level    /Exp    /HP    /MP    /Strength    /Dexterity    /Agility    /Gold\t");
        for(Map.Entry<String, Paladin> set : paladinHashMap.entrySet()){
            System.out.println(set.getValue().toString());
        }

        System.out.println("[Sorcerers]");
        System.out.println("Name    /Level    /Exp    /HP    /MP    /Strength    /Dexterity    /Agility    /Gold\t");
        for(Map.Entry<String, Sorcerer> set : sorcererHashMap.entrySet()){
            System.out.println(set.getValue().toString());
        }
    }

    /**
     * get a random monster with specific level and type(used in battle)
     * @param level
     * @return a random Monster object
     */
    public Dragon getRandomDragon(int level){
        Random random = new Random();
        int keySeq = random.nextInt(dragonHashMap.size());
        String key = (String)dragonHashMap.keySet().toArray()[keySeq];
        Dragon monster = dragonHashMap.get(key);
        monster.setLevel(level);
        return monster;
    }

    public Exoskeleton getRandomExoskeleton(int level){
        Random random = new Random();
        int keySeq = random.nextInt(exoskeletonHashMap.size());
        String key = (String)exoskeletonHashMap.keySet().toArray()[keySeq];
        Exoskeleton monster = exoskeletonHashMap.get(key);
        monster.setLevel(level);
        return monster;
    }

    public Spirit getRandomSpirit(int level){
        Random random = new Random();
        int keySeq = random.nextInt(spiritHashMap.size());
        String key = (String)spiritHashMap.keySet().toArray()[keySeq];
        Spirit monster = spiritHashMap.get(key);
        monster.setLevel(level);
        return monster;
    }

    /**
     * The following methods are for reading characters' info from txt documents.
     * @return
     */
    public boolean readPaladinFile(){
        try{
            File file = new File("./src/data/Paladins.txt");
            if(file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                BufferedReader in = new BufferedReader(read);
                String str;

                str = in.readLine(); // Ignore the title line
                while ((str = in.readLine()) != null) {
                    String[] line = str.split("\\s+"); // split a read line by any number of whitespace character
                    if(line.length < 7){ // ignore incomplete data
                        continue;
                    }

                    Paladin paladin = new Paladin(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                            Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6]));
                    paladinHashMap.put(paladin.getName(), paladin);
                    allCharacterHashMap.put(paladin.getName(), paladin); // Also add in collection of all items
                }
            }
            else{ // Not find file
                System.out.println("Can't find file: ./src/data/Paladins.txt");
                return false;
            }
        }catch(IOException e){
            return false;
        }
        return true;
    }

    public boolean readWarriorFile(){
        try{
            File file = new File("./src/data/Warriors.txt");
            if(file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                BufferedReader in = new BufferedReader(read);
                String str;

                str = in.readLine(); // Ignore the title line
                while ((str = in.readLine()) != null) {
                    String[] line = str.split("\\s+"); // split a read line by any number of whitespace character
                    if(line.length < 7){ // ignore incomplete data
                        continue;
                    }
                    Warrior warrior = new Warrior(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                            Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6]));
                    warriorHashMap.put(warrior.getName(), warrior);
                    allCharacterHashMap.put(warrior.getName(), warrior); // Also add in collection of all items
                }
            }
            else{ // Not find file
                System.out.println("Can't find file: ./src/data/Warriors.txt");
                return false;
            }
        }catch(IOException e){
            return false;
        }
        return true;
    }

    public boolean readSorcererFile(){
        try{
            File file = new File("./src/data/Sorcerers.txt");
            if(file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                BufferedReader in = new BufferedReader(read);
                String str;

                str = in.readLine(); // Ignore the title line
                while ((str = in.readLine()) != null) {
                    String[] line = str.split("\\s+"); // split a read line by any number of whitespace character
                    if(line.length < 7){ // ignore incomplete data
                        continue;
                    }

                    Sorcerer sorcerer = new Sorcerer(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                            Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6]));
                    sorcererHashMap.put(sorcerer.getName(), sorcerer);
                    allCharacterHashMap.put(sorcerer.getName(), sorcerer); // Also add in collection of all items
                }
            }
            else{ // Not find file
                System.out.println("Can't find file: ./src/data/Sorcerers.txt");
                return false;
            }
        }catch(IOException e){
            return false;
        }
        return true;
    }

    public boolean readDragonFile(){
        try{
            File file = new File("./src/data/Dragons.txt");
            if(file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                BufferedReader in = new BufferedReader(read);
                String str;

                str = in.readLine(); // Ignore the title line
                while ((str = in.readLine()) != null) {
                    String[] line = str.split("\\s+"); // split a read line by any number of whitespace character
                    if(line.length < 5){
                        continue;
                    }

                    Dragon dragon = new Dragon(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                            Integer.parseInt(line[3]), Integer.parseInt(line[4]));
                    dragonHashMap.put(dragon.getName(), dragon);
                    allCharacterHashMap.put(dragon.getName(), dragon); // Also add in collection of all items
                }
            }
            else{ // Not find file
                System.out.println("Can't find file: ./src/data/Dragons.txt");
                return false;
            }
        }catch(IOException e){
            return false;
        }
        return true;
    }

    public boolean readExoskeletonFile(){
        try{
            File file = new File("./src/data/Exoskeletons.txt");
            if(file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                BufferedReader in = new BufferedReader(read);
                String str;

                str = in.readLine(); // Ignore the title line
                while ((str = in.readLine()) != null) {
                    String[] line = str.split("\\s+"); // split a read line by any number of whitespace character
                    if(line.length < 5){ // ignore incomplete data
                        continue;
                    }

                    Exoskeleton exoskeleton = new Exoskeleton(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                            Integer.parseInt(line[3]), Integer.parseInt(line[4]));
                    exoskeletonHashMap.put(exoskeleton.getName(), exoskeleton);
                    allCharacterHashMap.put(exoskeleton.getName(), exoskeleton); // Also add in collection of all items
                }
            }
            else{ // Not find file
                System.out.println("Can't find file: ./src/data/Exoskeletons.txt");
                return false;
            }
        }catch(IOException e){
            return false;
        }
        return true;
    }

    public boolean readSpiritFile(){
        try{
            File file = new File("./src/data/Spirits.txt");
            if(file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                BufferedReader in = new BufferedReader(read);
                String str;

                str = in.readLine(); // Ignore the title line
                while ((str = in.readLine()) != null) {
                    String[] line = str.split("\\s+"); // split a read line by any number of whitespace character
                    if(line.length < 5){ // ignore incomplete data
                        continue;
                    }

                    Spirit spirit = new Spirit(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                            Integer.parseInt(line[3]), Integer.parseInt(line[4]));
                    spiritHashMap.put(spirit.getName(), spirit);
                    allCharacterHashMap.put(spirit.getName(), spirit); // Also add in collection of all items
                }
            }
            else{ // Not find file
                System.out.println("Can't find file: ./src/data/Spirits.txt");
                return false;
            }
        }catch(IOException e){
            return false;
        }
        return true;
    }
}
