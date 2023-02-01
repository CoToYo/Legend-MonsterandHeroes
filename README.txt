## Files
---------------------------------------------------------------------------
<A brief description of each file and what it does>

- OOD:

[Use Factory Pattern]

Weapon --implements--> Item
Armor --implements--> Item
Spell --implements--> Item
Potion --implements--> Item

CharacterCatalog --implements--> Catalog
ItemCatalog --implements--> Catalog

Hero --implements--> Character
Monster --implements--> Character

IceSpell --extends--> Spell
FireSpell --extends--> Spell
LightningSpell --extends--> Spell

Warrior --extends--> Hero
Paladin --extends--> Hero
Sorcerer --extends--> Hero

Dragon --extends--> Monster
Exoskeleton --extends--> Monster
Spirit --extends--> Monster

- File list:

data // a directory file contains all kinds of info used in the game(provided by prof)

Armor.java //class for armor.

Battle.java //class for battle, create a Battle object in every battle.

Catalog.java //[Interface].

Character.java //[Interface].

CharacterCatalog.java //Implements of Catalog, is a catalog of all heroes and monsters in this game.

GameController.java //Main logic of this game.

GameInfo.java //class for game information

Hero.java //Implements of Character, a class for hero info(extended by class 'Warrior', class 'Paladin' and class 'Sorcerer').

Inventory.java //class for hero's inventory

Item.java //[Interface].

ItemCatalog.java //Implements of Catalog, is a catalog of all items (including weapons, armors, potions and so on) in this game.

Main.java //Just a gate of this program.

Market.java //Class for market.

Monster.java //Implements of Character, a class for monster info(extended by class 'Dragon', class 'Exoskeleton' and class 'Spirit').

PartyOfHeroes.java //Class for player's party of heroes.

Potion.java //Implements of Item, a class for potion.

Spell.java //Implements of Character, a class for spell (extended by class 'IceSpell', class 'FireSpell' and class'LightningSpell').

Weapon.java //Implements of Item, a class for weapon.

WorldMap.java //Class for the map of this game.

## Notes
---------------------------------------------------------------------------
<Bonus Done>
- Use factory pattern as design pattern (Very neat and professional structure)
- Achieve all example rules in the document(including rules of different price of selling and buying same stuff, hero level up,
 attack dodge and so on.)
- Reading data files to get all info of items, heroes and monsters, which allows to modify the game very easily.
- Allow player to quit the game when not in a battle.
- When comes to a battle, player can see battle info at any time; At the end of each round, 
player can see whether heroes or monsters are alive or not.
- Player can equip armor or weapon for heroes during  a battle.
- Inaccessible space detect
- Show latest game info after player quit the game.


<Notes to grader>

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "hw3" after unzipping the files
2. Run the following instructions:

javac -d bin src/*.java
java -cp bin Main

## Input/Output Example
---------------------------------------------------------------------------
<Place here an example of how the program runs. Include both its
outputs and correctly formatted inputs. Please clearly mark the inputs.>

Output:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 {   LEGENDS:MONSTERS AND HEROES   }
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
________________________
[Instructions]
|W/w: move up
|A/a: move left
|S/s: move down
|D/d: move right
|Q/q: quit game
|I/i: show information
|M/m: enter market
________________________
[Warriors]
Name    /Level    /Exp    /HP    /MP    /Strength    /Dexterity    /Agility    /Gold	
Sehanine_Monnbow    	0    	800    	8    	600    	700    	500    	800    	2500
Flandal_Steelskin    	0    	700    	7    	200    	750    	700    	650    	2500
Eunoia_Cyn    	0    	600    	6    	400    	700    	600    	800    	2500
Gaerdal_Ironhand    	0    	700    	7    	100    	700    	600    	500    	1354
Muamman_Duathall    	0    	600    	6    	300    	900    	750    	500    	2546
Undefeated_Yoj    	0    	700    	7    	400    	800    	700    	400    	2500
[Paladins]
Name    /Level    /Exp    /HP    /MP    /Strength    /Dexterity    /Agility    /Gold	
Sehanine_Moonbow    	0    	700    	7    	300    	750    	700    	700    	2500
Garl_Glittergold    	0    	500    	5    	100    	600    	400    	500    	2500
Skoraeus_Stonebones    	0    	400    	4    	250    	650    	350    	600    	2500
Caliber_Heist    	0    	800    	8    	400    	400    	400    	400    	2500
Parzival    	0    	700    	7    	300    	750    	700    	650    	2500
Amaryllis_Astra    	0    	500    	5    	500    	500    	500    	500    	2500
[Sorcerers]
Name    /Level    /Exp    /HP    /MP    /Strength    /Dexterity    /Agility    /Gold	
Kalabar    	0    	600    	6    	800    	850    	600    	400    	2500
Skye_Soar    	0    	500    	5    	1000    	700    	500    	400    	2500
Rillifane_Rallathil    	0    	900    	9    	1300    	750    	500    	450    	2500
Segojan_Earthcaller    	0    	500    	5    	900    	800    	650    	500    	2500
Reign_Havoc    	0    	800    	8    	800    	800    	800    	800    	2500
Reverie_Ashels    	0    	700    	7    	900    	800    	400    	700    	2500

How many heroes do you want to choose?(1~3)

Input: 2

Output:
What is you pick?(Enter complete name of a hero)

Input: Kalarbar

Output:
Kalabar has joined in you party!
What is you pick?(Enter complete name of a hero)

Input: Parzival

Output:
Parzival has joined in you party!

  #  #  #  #  #  #  #  #
  #  P              $  #
  #  $     $  #  #  #  #
  #     #     #     $  #
  #     #     #     #  #
  #  #  #              #
  #              $     #
  #  #  #  #  #  #  #  #
Enter command:

Input: w

Output:
Not accessible space!
  #  #  #  #  #  #  #  #
  #  P              $  #
  #  $     $  #  #  #  #
  #     #     #     $  #
  #     #     #     #  #
  #  #  #              #
  #              $     #
  #  #  #  #  #  #  #  #
Enter command:

Input: s

Output:
  #  #  #  #  #  #  #  #
  #                 $  #
  #  P     $  #  #  #  #
  #     #     #     $  #
  #     #     #     #  #
  #  #  #              #
  #              $     #
  #  #  #  #  #  #  #  #
Enter command:

Input: m

Output:

Welcome to mystery market.
___________________________
[Weapon]
0. Weapon{name='Bow', cost=300, requiredLevel=2, damage=500, requiredHands=2}
[Armor]
0. Armor{name='Breastplate', cost=350, requiredLevel=3, damageReduction=600}
[Potion]
0. Potion{name='Healing_Potion', cost=250, requiredLevel=1, attriIncrease=100, attrAffect='Health', availNum=1}
[IceSpell]
0. Spell{name='Frost_Blizzard', cost=750, requiredLevel=5, damage=850, manaCost=350, availNum=1}
[FireSpell]
0. Spell{name='Heat_Wave', cost=450, requiredLevel=2, damage=600, manaCost=150, availNum=1}
[LightningSpell]
0. Spell{name='Electric_Arrows', cost=550, requiredLevel=5, damage=650, manaCost=200, availNum=1}
Enter [B/b] to buy, [S/s] to sell or [Q/q] to quit:

Input: b

Output:
Who(Hero) wants to buy stuff?(Enter complete name):
.
.
.

Enter [B/b] to buy, [S/s] to sell or [Q/q] to quit:

Input: s

Output:
Who(Hero) wants to sell stuff?(Enter complete name)
Kalabar

Inventory
___________________________
[Weapon]
0. Weapon{name='Bow', cost=300, requiredLevel=2, damage=500, requiredHands=2}
[Armor]
[Potion]
[IceSpell]
[FireSpell]
[LightningSpell]
What type of goods do you want to sell?(Enter complete type name)(Enter [Q/q] to quit)

Input: weapon
.
.
.

Output:
Enter [B/b] to buy, [S/s] to sell or [Q/q] to quit:

Input: q

Output:
  #  #  #  #  #  #  #  #
  #                 $  #
  #  P     $  #  #  #  #
  #     #     #     $  #
  #     #     #     #  #
  #  #  #              #
  #              $     #
  #  #  #  #  #  #  #  #
Enter command:

Input: i

Output:
[Info Begin] Your party of heroes:
Name    /Level    /Exp    /HP    /MP    /Strength    /Dexterity    /Agility    /Gold
Kalabar 	6 	0 	600 	800 	850 	600 	400 	2200
Parzival 	7 	0 	700 	300 	750 	700 	650 	2500
[Info End]
  #  #  #  #  #  #  #  #
  #                 $  #
  #  P     $  #  #  #  #
  #     #     #     $  #
  #     #     #     #  #
  #  #  #              #
  #              $     #
  #  #  #  #  #  #  #  #
Enter command:

Input: d

Output:
>>>>>>>>>>>Battle Starts!
[Monster]
0. name='Rakkshasass', level=7, HP=700, damage=550, defense=600, dodge=35}
1. name='Chronepsish', level=7, HP=700, damage=650, defense=750, dodge=60}


     V.S     


[Heroes]
[Info Begin] Your party of heroes:
Name    /Level    /Exp    /HP    /MP    /Strength    /Dexterity    /Agility    /Gold
Kalabar 	6 	0 	600 	800 	850 	600 	400 	2200
Parzival 	7 	0 	700 	300 	750 	700 	650 	2500
[Info End]

[Heroes' turn]
Kalabar is ready.
Enter [A/a] for basic attack, [I/i] for battle info, [K/k] for using stuff in inventory:

Input: a

Output:
Choose a target(Enter sequence number of a monster):0
Parzival is ready.
Enter [A/a] for basic attack, [I/i] for battle info, [K/k] for using stuff in inventory:

Input: a

Output:
Choose a target(Enter sequence number of a monster):

Input: 0

Output:
Rakkshasass successfully dodge the attack!

---
Kalabar[Died]
Parzival[Alive]
Rakkshasass[Died]
Chronepsish[Alive]
---

.
.
.

Output:
---
Kalabar[Died]
Parzival[Alive]
Rakkshasass[Died]
Chronepsish[Died]
---
<<<<<<<<<<<<<<<<<Battle Ends
Heroes win the battle!!!

  #  #  #  #  #  #  #  #
  #                 $  #
  #  $  P  $  #  #  #  #
  #     #     #     $  #
  #     #     #     #  #
  #  #  #              #
  #              $     #
  #  #  #  #  #  #  #  #
Enter command:

Input: i

Output:[Exp++ & Gold++]

[Info Begin] Your party of heroes:
Name    /Level    /Exp    /HP    /MP    /Strength    /Dexterity    /Agility    /Gold
Kalabar 	6 	4 	600 	800 	850 	600 	400 	2900
Parzival 	7 	4 	700 	300 	750 	700 	650 	3200
[Info End]
  #  #  #  #  #  #  #  #
  #                 $  #
  #  $  P  $  #  #  #  #
  #     #     #     $  #
  #     #     #     #  #
  #  #  #              #
  #              $     #
  #  #  #  #  #  #  #  #
Enter command:

.
.
.

Input: q

You quit the game! Here are the latest game info:
[Info Begin] Your party of heroes:
Name    /Level    /Exp    /HP    /MP    /Strength    /Dexterity    /Agility    /Gold
Kalabar 	6 	4 	600 	800 	850 	600 	400 	2900
Parzival 	7 	4 	700 	300 	750 	700 	650 	3200
[Info End]
leon@LeondeMacBook-Air hw3 % 
