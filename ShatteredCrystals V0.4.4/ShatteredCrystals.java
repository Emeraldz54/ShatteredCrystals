/**
 * Main game file for Shattered Crystals
 * Essentially the game runner class
 */
import java.util.Scanner;
import java.util.Random;
import javax.swing.JComponent;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
public class ShatteredCrystals{
    public static void main(String[] args){
        Scanner ui = new Scanner(System.in);
        Player userCharacter = null;
        System.out.println("\t      /\\");
        System.out.println("\t     /  \\__");
        System.out.println("\t     \\   \\ \\");
        System.out.println("\t      \\     \\");
        System.out.println("\t   _/\\/     /");
        System.out.println("\t  /          \\");
        System.out.println("\t /            \\");
        System.out.println("\t/ Shattered    \\");
        System.out.println("\t\\     Crystals /");
        System.out.println("\t \\            /");
        System.out.println("\t  \\     _/\\__/ ");
        System.out.println("\t  /     \\_   ");
        System.out.println("\t  \\       \\  ");
        System.out.println("\t   \\      /");
        System.out.println("\t    \\_\\  /");
        System.out.println("\t       \\/");
        System.out.println("== Welcome to Shattered Crystals! ==");
        try {
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        boolean hasChosenToLoad = false;
        while(!hasChosenToLoad){
            System.out.println("Would you like to load the save file? [y/n]");
            String loadChoice = ui.nextLine();
            switch(loadChoice){
                case "y":
                userCharacter = new Player();
                userCharacter.loadGame();
                if(userCharacter.lvl != 0){
                    System.out.println("You have loaded successfully!");
                    hasChosenToLoad = true;
                }
                else{
                    hasChosenToLoad = true;
                    userCharacter =  new Player();
                    userCharacter.intro();
                }
                break;
                case "n":
                userCharacter = new Player();
                userCharacter.intro();
                hasChosenToLoad = true;
                break;
            }
        }
        System.out.println("Enjoy the game!\n");
        try {
            Thread.sleep(250);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        boolean finished = false;
        while(!finished){
            System.out.println("Please choose an option (type 'help' if you don't know commands).");
            String choice = ui.nextLine();
            boolean hasDecided = false;
            switch(choice){
                case "help":
                System.out.println("\nType 'exit' to quit.\nType 'help' for help.\nType 'shop' for the shop.\nType 'battle' to battle.\nType 'boss' to fight a boss.\nType 'inn' to go to the inn.\nType wes to see the local wizard.\nType 'stats' to view your stats.\nType 'inv' to equip items in your inventory.\nType 'save' to save your game.\n");
                break;

                case "exit":
                System.out.println("\nThanks for playing!");
                finished = true;
                break;

                case "save":
                System.out.println("You saved your game.");
                userCharacter.saveGame();
                break;

                case "inv":
                System.out.println("You open your bag and look inside.");
                boolean lookingAtInv = true;
                while(lookingAtInv){
                    System.out.println("What would you like to do? (type 'help' for assistance)");
                    String userInvChoice = ui.nextLine();
                    switch(userInvChoice){
                        case "help":
                        System.out.println("Please input 'help', 'exit', 'equip', or 'unequip'.");
                        break;

                        case "equip":
                        boolean doneEquipping = false;
                        while(!doneEquipping){
                            System.out.println("What would you like to equip?(Type 'help' for assistance)");
                            int current = 1;
                            String toEquip = ui.nextLine();
                            switch(toEquip){
                                case "armor":
                                boolean armorOn = false;
                                while(!armorOn){
                                    System.out.println("Please type the full name of the item");
                                    System.out.println("Here are your options:");
                                    System.out.println("0. exit");
                                    for(int i=0; i<userCharacter.inv.size();i++){
                                        if(userCharacter.inv.get(i) instanceof Armor){
                                            System.out.println(current + ". " + userCharacter.inv.get(i).name);
                                            current ++;
                                        }
                                    }
                                    String equipArmor = ui.nextLine();
                                    for(int i=0; i<userCharacter.inv.size();i++){
                                        if(userCharacter.inv.get(i) instanceof Armor){
                                            if(userCharacter.inv.get(i).name.equals(equipArmor)){
                                                Armor temp = (Armor)(userCharacter.inv.get(i));
                                                userCharacter.equipArmor(temp);
                                                System.out.println("You equipped " + userCharacter.inv.get(i).name);
                                                armorOn = true;
                                            }
                                        }
                                    }
                                    doneEquipping = true;
                                    if (equipArmor.equals("exit"))
                                        armorOn = true;
                                    current = 1;
                                }
                                break;

                                case "sword":
                                boolean weaponOn = false;
                                while (!weaponOn){
                                    System.out.println("Please type the full name of the item");
                                    System.out.println("Here are your options:");
                                    System.out.println("0. exit");
                                    for(int i=0; i<userCharacter.inv.size();i++){
                                        if(userCharacter.inv.get(i) instanceof Sword){
                                            System.out.println(current + ". " + userCharacter.inv.get(i).name);
                                            current ++;
                                        }
                                    }
                                    String equipSword = ui.nextLine();
                                    for(int i=0; i<userCharacter.inv.size();i++){
                                        if(userCharacter.inv.get(i) instanceof Sword){
                                            if(userCharacter.inv.get(i).name.equals(equipSword)){
                                                Sword temp = (Sword)(userCharacter.inv.get(i));
                                                userCharacter.equipSword(temp);
                                                System.out.println("You equipped " + userCharacter.inv.get(i).name);
                                                weaponOn = true;
                                            }
                                        }
                                    }
                                    doneEquipping = true;
                                    if (equipSword.equals("exit"))
                                        weaponOn = true;
                                    current = 1;
                                }
                                break;
                                
                                case "staff":
                                boolean staffOn = false;
                                while (!staffOn){
                                    System.out.println("Please type the full name of the item");
                                    System.out.println("Here are your options:");
                                    System.out.println("0. exit");
                                    for(int i=0; i<userCharacter.inv.size();i++){
                                        if(userCharacter.inv.get(i) instanceof Staffs){
                                            System.out.println(current + ". " + userCharacter.inv.get(i).name);
                                            current ++;
                                        }
                                    }
                                    String equipStaff = ui.nextLine();
                                    for(int i=0; i<userCharacter.inv.size();i++){
                                        if(userCharacter.inv.get(i) instanceof Staffs){
                                            if(userCharacter.inv.get(i).name.equals(equipStaff)){
                                                Staffs temp = (Staffs)(userCharacter.inv.get(i));
                                                userCharacter.equipStaff(temp);
                                                System.out.println("You equipped " + userCharacter.inv.get(i).name);
                                                staffOn = true;
                                            }
                                        }
                                    }
                                    doneEquipping = true;
                                    if (equipStaff.equals("exit"))
                                        staffOn = true;
                                    current = 1;
                                }
                                break;
                                
                                case "exit":
                                System.out.println("You give up putting on clothes");
                                doneEquipping = true;
                                break;

                                case "help":
                                System.out.println("Type 'exit', 'sword', 'staff' or 'armor'.");
                                break;

                                default:
                                System.out.println("Please input a valid input. (type 'help' for assistance)");
                                break;
                            }

                        }
                        break;

                        case "unequip":
                        boolean doneUnequipping = false;
                        while(!doneUnequipping){
                            System.out.println("What would you like to unequip? (type 'help' for assistance)");
                            String toUnequip = ui.nextLine();
                            switch(toUnequip){
                                case "armor":
                                if(userCharacter.wearingArmor){
                                    userCharacter.unequipArmor();
                                    System.out.println("You unequipped your armor.");
                                    doneUnequipping = true;
                                }
                                else
                                    System.out.println("You're not wearing any armor!");
                                break;

                                case "weapon":
                                if(userCharacter.wearingArmor){
                                    userCharacter.unequipSword();
                                    System.out.println("You unequipped your weapon.");
                                    doneUnequipping = true;
                                }
                                else
                                    System.out.println("You're not holding a weapon!");
                                break;

                                case "exit":
                                System.out.println("You give up on unequipping.");
                                doneUnequipping = true;
                                break;

                                default:
                                System.out.println("Please input a valid input. (type 'help' for assistance)");
                                break;
                            }
                        }
                        break;

                        case "exit":
                        System.out.println("You close your bag.");
                        lookingAtInv = false;
                        break;

                        default:
                        System.out.println("Please input 'help' if you need assistance.");
                        break;
                    }
                }
                break;

                case "wes":
                hasDecided = false;
                boolean wizDecided = false;
                System.out.println("Welcome to Wizabon! Where you can get Cinnabons, only they are Wizabons!");
                while(!wizDecided){
                    System.out.println("Do you have any Wizabons to trade in? (y/n)\nType 'help' to find out what wizabons are.");
                    String wizabon = ui.nextLine();
                    switch(wizabon){
                        case "y":
                        if(userCharacter.wizabon >=3){
                            System.out.println("Thats great! You have enough!");
                            userCharacter.wizabon -= 3;
                            wizDecided = true;
                        }
                        else{
                            System.out.println("I am sorry. You don't have at least 3 wizabons. Go kill some monsters to get them!");
                            System.out.println("You will now be directed to the main menu. Good luck, and Have Fun killing more monsters!");
                            hasDecided = true;
                            wizDecided = true;
                        }
                        break;
                        case "n":
                        System.out.println("Dang it. Oh well. Good bye!");
                        System.out.println("You are now being teleported to the main menu.");
                        hasDecided = true;
                        wizDecided = true;
                        break;
                        case "help":
                        System.out.println("Wizabons are the currency to use this shop.");
                        System.out.println("Each monster you fight has a chance to drop them.");
                        System.out.println("Bosses have a high chance to drop them.");
                        System.out.println("I hear there is a special boss that drops a lot of Wizabons...");
                        System.out.println("Well, Happy Hunting!");
                        break;
                        default:
                        System.out.println("You have typed in an invalid response.");
                        System.out.println("You will now be directed to the main menu.");
                        hasDecided = true;
                        wizDecided = true;
                        break;
                    }
                }

                while(!hasDecided){
                    System.out.println("How can I help you?");
                    String wesChoice = ui.nextLine();
                    switch(wesChoice){
                        case "help":
                        System.out.println("I can do these things for ya. You can fight an easy battle, gain a level or recieve a full heal.");
                        System.out.println("Just say 'easy battle', 'lvl up', or 'heal' and I'll do the rest!");
                        System.out.println("Or just say 'exit' and leave me here all by my lonesome");
                        break;
                        case "easy battle":
                        hasDecided = true;
                        System.out.println("So you want an easy battle, do ya?");
                        System.out.println("I can summon one for you. Just beware that you get reduced exp and gold");
                        int mobChance = (int)(Math.random()*100);
                        if(mobChance<60){
                            Monster m = new Monster();
                            m.inStat(userCharacter);
                            Battle bat = new Battle();
                            bat.main(userCharacter, m);
                            m.exp -= 15*userCharacter.lvl;
                        }
                        else if(mobChance>=60 && mobChance<70){
                            Boss h = new TheHolyTerror();
                            h.inStat(userCharacter);
                            Battle bat = new Battle();
                            bat.main(userCharacter, h);
                            h.exp -= 10*userCharacter.lvl;
                        }
                        else if(mobChance>=70 && mobChance<80){
                            Monster m = new Monster();
                            m.inStat(userCharacter);
                            if((int)(Math.random()*10)>5)
                                m.str += 30;
                            else{
                                m.vit += 200;
                                m.hp += 200;
                            }
                            m.exp -= 15*userCharacter.lvl;
                            Battle bat = new Battle();
                            bat.main(userCharacter, m);
                        }
                        else{
                            Boss g = new GlassCannon();
                            g.inStat(userCharacter);
                            g.vit += 200;
                            g.hp += 200;
                            Battle bat = new Battle();
                            bat.main(userCharacter, g);
                            g.exp -= 20*userCharacter.lvl;
                        }
                        break;
                        case "lvl up":
                        hasDecided = true;
                        System.out.println("So you want to level up, ya? Well RAWR!");
                        int lvlChance = (int)(Math.random()*100);
                        int tempExp = userCharacter.exp;
                        if(lvlChance <= 40){
                            userCharacter.exp -= tempExp;
                            userCharacter.exp = 250+50*userCharacter.lvl;
                        }
                        else{
                            userCharacter.exp -= tempExp;
                        }
                        if(userCharacter.checkEXP())
                            userCharacter.levelUp();
                        System.out.println("There, done! Here is your brand new, shiny level!");
                        System.out.println("Here are your new stats:");
                        System.out.println("\n-=YOUR STATS=-");
                        System.out.println("Your strength: "+userCharacter.str);
                        System.out.println("Your defense: "+userCharacter.def);
                        System.out.println("Your vitality: "+userCharacter.vit);
                        System.out.println("Your dexterity: "+userCharacter.dex);
                        System.out.println("Your accuracy: "+userCharacter.acc);
                        System.out.println("Your avoidability: "+userCharacter.avoid);
                        System.out.println("Your attack: "+userCharacter.att);
                        System.out.println("Your magic attack :"+userCharacter.magAtt);
                        System.out.println("Your current health: "+userCharacter.hp);
                        System.out.println("Current level: "+userCharacter.lvl);
                        System.out.println("Current XP: "+userCharacter.exp+" out of "+(userCharacter.lvl*50 + 250)+"\n");
                        System.out.println("Current Gold:"+userCharacter.gold);
                        System.out.println("Current Wizabons :"+userCharacter.wizabon);
                        break;
                        case "heal":
                        hasDecided = true;
                        System.out.println("So a heal is what you want, a heal is what you get!");
                        int healChance = (int)(Math.random()*100);
                        if(healChance<= 90)
                            userCharacter.hp = userCharacter.vit;
                        else{
                            userCharacter.hp = userCharacter.vit;
                            userCharacter.hp -= (userCharacter.vit - 1);
                        }
                        break;
                        case "exit":
                        hasDecided = true;
                        System.out.println("Ok then. Hope you come again!");
                        break;
                        default:
                        System.out.println("Please type something that I can do.\nIf you need help, then type 'help'.");
                        break;
                    }
                }
                break;

                case "stats":
                System.out.println("\n-=YOUR STATS=-");
                System.out.println("You are "+userCharacter.stateClass()+".");
                System.out.println("Your strength: "+userCharacter.str);
                System.out.println("Your defense: "+userCharacter.def);
                System.out.println("Your vitality: "+userCharacter.vit);
                System.out.println("Your max mana: "+userCharacter.maxMana);
                System.out.println("Your mana regeneration rate: "+userCharacter.manaReg);
                System.out.println("Your dexterity: "+userCharacter.dex);
                System.out.println("Your accuracy: "+userCharacter.acc);
                System.out.println("Your avoidability: "+userCharacter.avoid);
                System.out.println("Your attack: "+userCharacter.att);
                System.out.println("Your magic attack: "+userCharacter.magAtt);
                System.out.println("Your current mana: "+userCharacter.mana);
                System.out.println("Your current health: "+userCharacter.hp);
                System.out.println("Current level: "+userCharacter.lvl);
                System.out.println("Current XP: "+userCharacter.exp+" out of "+(userCharacter.lvl*50 + 250));
                System.out.println("Current Gold: "+userCharacter.gold );
                System.out.println("Current Wizabons: "+userCharacter.wizabon);
                System.out.println("-============-\n");
                try {
                    Thread.sleep(250);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                break;

                case "inn":
                boolean decided = false;
                while(!decided){
                    System.out.println("\nWelcome to the inn!\nWould you like to rest? [yes/no]\n  150 gold to stay the night\n");
                    String innChoice = ui.nextLine();
                    switch(innChoice){
                        case "yes":
                        if(userCharacter.gold >= 150){
                            decided = true;
                            System.out.println("\nYou stayed the night! You feel rested.\nYour health and mana were restored to max.\n");
                            userCharacter.hp = userCharacter.vit;
                            userCharacter.mana = userCharacter.maxMana;
                            userCharacter.gold -= 150;
                            break;
                        }
                        else
                            System.out.println("\nYou don't have enough gold to stay the night!");
                        break;
                        case "no":
                        decided = true;
                        System.out.println("\nYou decided not to stay the night.");
                        break;
                        case "help":
                        System.out.println("\nPlease input 'yes', 'no', or 'help'.");
                        break;
                        default:
                        System.out.println("\nInvalid input.\nPlease input 'help' for assistance.");
                        break;
                    }
                }
                break;

                case "shop":
                ArrayList<Armor> armShopList = new ArrayList<Armor>();
                ArrayList<Sword> armSwordList = new ArrayList<Sword>();
                ArrayList<Staffs> armStaffList = new ArrayList<Staffs>();
                armShopList.add(new Armor(400, 200, "bronze armor", "armor", 1, 5, 2, 6,0));
                armShopList.add(new Armor(800, 400, "iron armor", "armor", 1, 10, 4, 7,0));
                armShopList.add(new Armor(1800, 900, "steel armor", "armor", 1, 15, 6, 8,0));
                armShopList.add(new Armor(3800, 1900, "gold armor", "armor", 1, 20, 8, 9,0));
                armShopList.add(new Armor(8000, 4000, "black diamond armor", "armor", 1, 30, 15, 10,0));
                armSwordList.add(new Sword(400, 200, "bronze sword", "sword", 1, 5, 2, 1,0));
                armSwordList.add(new Sword(900, 450, "iron sword", "sword", 1, 10, 4, 2,0));
                armSwordList.add(new Sword(1800, 900, "steel sword", "sword", 1, 15, 6, 8,0));
                armSwordList.add(new Sword(4000, 2000, "gold sword", "sword", 1, 20, 8, 4,0));
                armSwordList.add(new Sword(8000, 4000, "black diamond sword", "sword", 1, 30, 15, 5,0));
                armStaffList.add(new Staffs(400, 200, "Mana Mog", "staff", 1, 0, 5, 5, 11, 0));
                armStaffList.add(new Staffs(800, 400, "Star Cactuar", "staff", 1, 5, 10, 0 ,12,0));
                armStaffList.add(new Staffs(1800, 800, "Space Mage", "staff", 1, 15, 8, 0 , 13, 0));
                armStaffList.add(new Staffs(4000, 1800, "Moomba Triplet", "staff", 1, 8, 8, 8, 14, 0));
                armStaffList.add(new Staffs(10000, 6000, "Onion Knight", "staff", 1, 30, 30, 30, 15, 0));
                Shop shop = new Shop();
                shop.main(userCharacter, armShopList, armSwordList, armStaffList, false);
                break;

                case "battle":
                if(Math.random()*100>3){
                    Monster m = new Monster();
                    m.inStat(userCharacter);
                    Battle bat = new Battle();
                    bat.main(userCharacter, m);
                }
                else{
                    System.out.println("\n A Boss has appeared!\nGood luck surviving!");
                    int BossChance = (int)(Math.random()*100);
                    if(BossChance < 5){
                        Boss h = new TheHolyTerror();
                        h.inStat(userCharacter);
                        System.out.println("This is the Holy Terror! Run away in Fear!");
                        System.out.println("Some quick Stats:\n HP:"+h.hp+"\tSTR:"+h.str);
                        Battle bat = new Battle();
                        bat.main(userCharacter, h);
                    }
                    else if(BossChance >=5 && BossChance <50){
                        Boss b = new GlassCannon();
                        b.inStat(userCharacter);
                        Battle bat = new Battle();
                        bat.main(userCharacter, b);
                    }
                    else if(BossChance >=50){
                        Boss t = new Teemo();
                        t.inStat(userCharacter);
                        Battle bat = new Battle();
                        bat.main(userCharacter,t);
                    }
                }
                break;

                case "boss":
                System.out.println("\n A Boss has appeared!\nGood luck surviving!");
                int BossChance = (int)(Math.random()*100);
                if(BossChance < 15){
                    Boss h = new TheHolyTerror();
                    h.inStat(userCharacter);
                    System.out.println("This is the Holy Terror! Run away in Fear!");
                    System.out.println("Some quick Stats:\n HP:"+h.hp+"\tSTR:"+h.str);
                    Battle bat = new Battle();
                    bat.main(userCharacter, h);
                }
                else if(BossChance>=15&& BossChance<60){
                    Boss g = new GlassCannon();
                    g.inStat(userCharacter);
                    System.out.println("\nThis is the Glass Cannon. Beware of it's power!");
                    System.out.println("Some quick Stats:\n HP:"+g.hp+"\tSTR:"+g.str);
                    Battle bat = new Battle();
                    bat.main(userCharacter, g);
                }
                else if(BossChance >=60){
                    Boss t = new Teemo();
                    t.inStat(userCharacter);
                    System.out.println("\nThis is the legendary Teemo!");
                    System.out.println("It is rumored that this creature contains more wizabons than normal!");
                    Battle bat = new Battle();
                    bat.main(userCharacter, t);
                }
                break;
                case "revive":
                if (userCharacter.hp<=0)
                    userCharacter.hp = userCharacter.vit;
                System.out.println("\n\n\n");
                break;
                default:
                System.out.println("\nPlease type in a valid input.\nType 'help' if you need help."); 
                break;
            }
        }
    }
}
