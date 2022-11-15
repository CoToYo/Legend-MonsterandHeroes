import java.util.ArrayList;
/**
 * Heroes chosen by the player will be added into this party
 * */
public class PartyOfHeroes {
    private int partySize;

    private ArrayList<Hero> partyOfHeroes;

    PartyOfHeroes(int partySize){
        this.partySize = partySize;
        partyOfHeroes = new ArrayList<>(partySize);

    }

    public int getHighestLevel(){
        int highest = 0;
        for(int i=0 ; i<partyOfHeroes.size() ; i++){
            if(highest < partyOfHeroes.get(i).getLevel()){
                highest = partyOfHeroes.get(i).getLevel();
            }
        }
        return highest;
    }
    public Hero getHero(String name){
        for(Hero hero : partyOfHeroes){
            if(hero.getName().equals(name)){
                return hero;
            }
        }
        return null;
    }

    public void addNewHero(Hero hero){
        partyOfHeroes.add(hero);
        System.out.println(hero.getName()+" has joined in you party!");
    }

    public boolean hasHero(String name){
        for(Hero hero : partyOfHeroes){
            if(hero.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public void showParty(){
        System.out.println("[Info Begin] Your party of heroes:");
        System.out.println("Name    /Level    /Exp    /HP    /MP    /Strength    /Dexterity    /Agility    /Gold");

        for(Hero hero : partyOfHeroes){
            System.out.println(hero.getName()+" \t"+hero.getLevel()+" \t"+hero.getExp()+" \t"+hero.getHP()+" \t"+hero.getMP()
                    +" \t"+hero.getStrength()+" \t"+hero.getDexterity()+" \t"+hero.getAgility()+" \t"+hero.getGold());
        }
        System.out.println("[Info End]");
    }

    public ArrayList<Hero> getPartyOfHeroes() {
        return partyOfHeroes;
    }
}
