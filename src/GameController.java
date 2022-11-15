import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class GameController {
    public static boolean gameOver = false;
    public WorldMap worldMap;
    public static ItemCatalog itemCatalog = new ItemCatalog();
    public static CharacterCatalog characterCatalog = new CharacterCatalog();

    public PartyOfHeroes partyOfHeroes = new PartyOfHeroes(3);

    public GameController(){
        worldMap = new WorldMap();
    }
    void run() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(" {   LEGENDS:MONSTERS AND HEROES   }");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("________________________");
        System.out.println("[Instructions]");
        System.out.println("|W/w: move up\n|A/a: move left\n|S/s: move down\n|D/d: move right" +
                "\n|Q/q: quit game\n|I/i: show information\n|M/m: enter market");
        System.out.println("________________________");

        characterCatalog.showAllHeroes();

        System.out.println("\nHow many heroes do you want to choose?(1~3)");
        int partySize;
        do{
            partySize = input.nextInt();
        }while(partySize <1 || partySize > 3);
        input.nextLine(); // ignore '\n'

        partyOfHeroes = new PartyOfHeroes(partySize); // initial party of heroes

        // Start: Pick up heroes
        int count = 0;
        do{
            System.out.println("What is you pick?(Enter complete name of a hero)");
            String heroName;
            heroName = input.nextLine();
            if(!characterCatalog.hasCharacter(heroName)){
                System.out.println("Wrong name! Try again.");
                continue;
            }
            if(partyOfHeroes.hasHero(heroName)){
                System.out.println("This hero has been chosen! Try again.");
                continue;
            }
            Hero hero = (Hero)characterCatalog.getCharacter(heroName);
            partyOfHeroes.addNewHero(hero);
            count++;
        }while(count < partySize);
        // End: Pick up heroes

        // Game now starts officially
        while(!gameOver){
            worldMap.show();
            System.out.print("Enter command:");
            String cmd = input.nextLine().toLowerCase();
            switch (cmd){
                case "w":
                    if(!worldMap.moveUp()){
                        continue;
                    }
                    if(worldMap.typeOfCurrSpace() == 1){ // commonplace: possible to meet a battle!
                        /*Start a battle*/
                        Random random = new Random();
                        if(random.nextInt(100) < 50){ // 50% to meet a battle
                            Battle battle = new Battle(partySize);
                            battle.run(partyOfHeroes);
                        }
                    }
                    break;
                case "a":
                    if(!worldMap.moveLeft()){
                        continue;
                    }
                    if(worldMap.typeOfCurrSpace() == 1){ // commonplace: possible to meet a battle!
                        /*Start a battle*/
                        Random random = new Random();
                        if(random.nextInt(100) < 50){ // 50% to meet a battle
                            Battle battle = new Battle(partySize);
                            battle.run(partyOfHeroes);
                        }
                    }
                    break;
                case "s":
                    if(!worldMap.moveDown()){
                        continue;
                    }
                    if(worldMap.typeOfCurrSpace() == 1){ // commonplace: possible to meet a battle!
                        /*Start a battle*/
                        Random random = new Random();
                        if(random.nextInt(100) < 50){ // 50% to meet a battle
                            Battle battle = new Battle(partySize);
                            battle.run(partyOfHeroes);
                        }
                    }
                    break;
                case "d":
                    if(!worldMap.moveRight()){
                        continue;
                    }
                    if(worldMap.typeOfCurrSpace() == 1){ // commonplace: possible to meet a battle!
                        /*Start a battle*/
                        Random random = new Random();
                        if(random.nextInt(100) < 50){ // 50% to meet a battle
                            Battle battle = new Battle(partySize);
                            battle.run(partyOfHeroes);
                        }
                    }
                    break;
                case "i":
                    /*show info of partyofheros*/
                    partyOfHeroes.showParty();
                    break;
                case "m":
                    if(worldMap.typeOfCurrSpace() == 2){ // marketplace: able to enter a market!
                        worldMap.enterMarket(partyOfHeroes);
                    }
                    else{
                        System.out.println("You are not in a marketplace!");
                    }
                    break;
                case "q":
                    System.out.println("You quit the game! Here are the latest game info:");
                    partyOfHeroes.showParty();
                    gameOver = true;
                    break;
            }
        }


    }


}
