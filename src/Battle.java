import java.util.Random;
import java.util.Scanner;

public class Battle {
    private int heroNum;
    private Monster[] monsterList;
    Battle(int heroNum){
        this.heroNum = heroNum;
        monsterList = new Monster[heroNum];
    }

    void showBattleInfo(PartyOfHeroes partyOfHeroes){
        System.out.println("[Monster]");
        for(int i=0 ; i<monsterList.length ; i++){
            System.out.println(i + ". " + monsterList[i].toString());
        }
        System.out.print("\n\n");
        System.out.println("     V.S     ");
        System.out.print("\n\n");
        System.out.println("[Heroes]");
        partyOfHeroes.showParty();
    }

    void run(PartyOfHeroes partyOfHeroes){
        // initial monsters in this battle
        int level = partyOfHeroes.getHighestLevel();
        Random random = new Random();
        for(int i=0 ; i<heroNum ; i++){
            switch (random.nextInt(3)){ // Randomly creat different monster
                case 0:
                    monsterList[i] = GameController.characterCatalog.getRandomDragon(level);
                    break;
                case 1:
                    monsterList[i] = GameController.characterCatalog.getRandomExoskeleton(level);
                    break;
                case 2:
                    monsterList[i] = GameController.characterCatalog.getRandomSpirit(level);
                    break;
            }
        }
        // initial end

        System.out.println(">>>>>>>>>>>Battle Starts!");

        while(true){
            int aliveHeroNum = heroNum;
            int aliveMonsterNum = heroNum;

            showBattleInfo(partyOfHeroes);

            Scanner input = new Scanner(System.in);
            System.out.println("\n[Heroes' turn]");
            // Start: hero's turn
            for(Hero hero : partyOfHeroes.getPartyOfHeroes()){
                if(hero.getHP() <= 0){
                    continue;
                }
                System.out.println(hero.getName()+" is ready.");
                System.out.print("Enter [A/a] for basic attack, [I/i] for battle info, [K/k] for using stuff in inventory:");
                String cmd = input.nextLine().toLowerCase();
                int seq;
                switch (cmd){
                    case "a":
                        System.out.print("Choose a target(Enter sequence number of a monster):");
                        seq = input.nextInt();
                        input.nextLine(); // ignore '\n'
                        monsterList[seq].getAttacked(hero.getStrength() + hero.getEquippedWeapon().getDamage()); // basic strength + weapon damage
                        break;
                    case "i":
                        showBattleInfo(partyOfHeroes);
                        break;
                    case "k":
                        hero.getInventory().show();
                        System.out.print("What type of stuff you want to use?(Enter complete type name; [Q/q] to quit):");
                        String type = input.nextLine().toLowerCase();
                        System.out.print("What "+ type +" you want to use?(Enter sequence number):");
                        seq = input.nextInt();
                        input.nextLine(); // ignore '\n'
                        switch (type){
                            case "weapon":
                                Weapon weapon = hero.getInventory().weaponList.get(seq);
                                hero.setEquippedWeapon(weapon);
                                break;
                            case "armor":
                                Armor armor = hero.getInventory().armorList.get(seq);
                                hero.setEquippedArmor(armor);
                                break;
                            case "potion":
                                Potion potion = hero.getInventory().potionList.get(seq);
                                potion.cast(hero);
                                break;
                            case "icespell":
                                IceSpell iceSpell = hero.getInventory().iceSpellList.get(seq);
                                System.out.print("Choose a target(Enter sequence number of a monster):");
                                seq = input.nextInt();
                                input.nextLine(); // ignore '\n'
                                iceSpell.cast(hero, monsterList[seq]);
//                            monsterList[seq].getAttacked(iceSpell.getDamage() + hero.getDexterity()/10000 * iceSpell.getDamage());
                                break;
                            case "firespell":
                                FireSpell fireSpell = hero.getInventory().fireSpellList.get(seq);
                                System.out.print("Choose a target(Enter sequence number of a monster):");
                                seq = input.nextInt();
                                input.nextLine(); // ignore '\n'
                                fireSpell.cast(hero, monsterList[seq]);
//                            monsterList[seq].getAttacked(fireSpell.getDamage() + hero.getDexterity()/10000 * fireSpell.getDamage());
                                break;
                            case "lightningspell":
                                LightningSpell lightningspell = hero.getInventory().lightningSpellList.get(seq);
                                System.out.print("Choose a target(Enter sequence number of a monster):");
                                seq = input.nextInt();
                                input.nextLine(); // ignore '\n'
                                lightningspell.cast(hero, monsterList[seq]); // cast this spell
//                            monsterList[seq].getAttacked(lightningspell.getDamage() + hero.getDexterity()/10000 * lightningspell.getDamage());
                                break;
                            case "q":
                                break;
                        }
                }
            }
            // End: hero's turn

            // Start: monster's turn
            for(Monster monster : monsterList){
                if(monster.getHP() <= 0){
                    continue;
                }
                int seq = random.nextInt(partyOfHeroes.getPartyOfHeroes().size()); // monster attack a random hero
                Hero targetHero = partyOfHeroes.getPartyOfHeroes().get(seq);
                targetHero.getAttacked(monster.getDamage());
            }
            // End: monster's turn

            // Start: check heroes and monsters' status
            System.out.println("---");
            for(Hero hero : partyOfHeroes.getPartyOfHeroes()){
                if(hero.getHP() <= 0){
                    aliveHeroNum--;
                    System.out.println(hero.getName() + "[Died]");
                }
                else{
                    System.out.println(hero.getName() + "[Alive]");
                }
            }
            for(Monster monster : monsterList){
                if(monster.getHP() <= 0){
                    aliveMonsterNum--;
                    System.out.println(monster.getName() + "[Died]");
                }
                else{
                    System.out.println(monster.getName() + "[Alive]");
                }
            }
            System.out.println("---");
            if(aliveHeroNum <= 0){ // all hero died, game over!!!
                System.out.println("<<<<<<<<<<<<<<<<<Battle Ends");
                System.out.println("All heroes have died. Game Over!");
                GameController.gameOver = true;
                return;
            }
            if(aliveMonsterNum <= 0){
                System.out.println("<<<<<<<<<<<<<<<<<Battle Ends");
                System.out.println("Heroes win the battle!!!");
                break;
            }
            // End: check heroes and monsters' status
        }

        // Heroes get rewards
        for(Hero hero : partyOfHeroes.getPartyOfHeroes()){
            hero.refreshHPMP();
            hero.increaseExp(monsterList.length * 2);
            hero.setGold(hero.getGold() + level * 100);
        }
    }
}
