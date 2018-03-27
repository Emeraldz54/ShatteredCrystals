/**
 * Player class
 * Used by person playing game
 * Has player's stats
 */
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.lang.Object;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
public class Player extends Character{
    Random rand = new Random();
    Scanner ui = new Scanner(System.in);
    List<Spell> spellbook = new ArrayList<Spell>();
    public int gold;
    boolean wearingSword;
    boolean wearingArmor;
    boolean wearingStaff;
    boolean wearingRobe;
    int potionsOwned;
    Sword currentSword;
    Armor currentArmor;
    Staffs currentStaff;
    Robes currentRobe;
    int className;
    List<Item> inv = new ArrayList<Item>();
    String specialname;
    //instantiates Player's stats
    public Player(){
        className = 0;
        str = 10;
        def = 10;
        incDef = def*3/2;
        crit = 5;
        vit = 100;
        dex = 10;
        acc = 10;
        avoid = 10;
        att = 10;
        hp = 100;
        magAtt = 10;
        intel = 10;
        maxMana = 10.0;
        mana = 10.0;
        manaReg = 1.0;
        exp = 0;
        gold = 0;
        lvl = 1;
        wizabon = 0;
        defending = false;
        wearingSword = false;
        wearingArmor = false;
        wearingStaff = false;
        wearingRobe = false;
        potionsOwned = 0;
        currentSword = null;
        currentArmor = null;
        currentStaff = null;
        currentRobe = null;
        specialname=null;
    }

    //Pick player's class and change stats based on class
    public void intro(){
        System.out.println("\nThis is the character creation screen.");
        System.out.println("You will be customizing your class here.");
        System.out.println("\nWhat would you like your class to be?");
        boolean hasntChosen = true;
        while(hasntChosen){
            System.out.println("Please input any of the following:");
            System.out.println("\nw for the warrior class");
            System.out.println("a for the archer class");
            System.out.println("r for the rogue class");
            System.out.println("m for the mage class");
            System.out.println("op for the most overpowered class created");
            System.out.print("Your input: ");
            String classChoice = ui.nextLine().toLowerCase();
            switch(classChoice){
                case "w":
                System.out.println("\nYou have chosen the Warrior class!");
                System.out.println("You are slow and meticulous but hard-hitting.");
                className = 1;
                str += 5;
                def += 10;
                crit -= 3;
                hp += 50;
                dex -= 5;
                avoid -= 7;
                maxMana -= 5;
                mana -= 5;
                manaReg -= .5;
                att += 2;
                magAtt -= 5;
                incDef = def*3/2;
                vit = hp;
                lvl = 1;
                specialname = "Ground Pound";
                spellbook.add(new Spell("defUp", 0, "Iron Skin", 3, "str", 100, 3, 3, 0, 0));
                spellbook.add(new Spell("onestun", .7, "Hilt Strike", 5, "str", 75, 0, 0, 3, 2));
                spellbook.add(new Spell("", 1.4, "Light Poke", 2.5, "str", 0, 0, 0, 0, 0));
                hasntChosen = false;
                break;

                case "a":
                System.out.println("\nYou have chosen the Archer class!");
                System.out.println("You are fast, accurate, and powerful,\nbut don't take too much damage!");
                className = 2;
                str += 2;
                att += 8;
                crit += 3;
                hp -= 20;
                magAtt -= 5;
                maxMana += 5;
                mana += 5;
                manaReg -= .5;
                avoid += 10;
                acc += 5;
                dex += 15;
                def -= 3;
                incDef = def*3/2;
                vit = hp;
                lvl = 1;
                specialname="Sniper Shot";
                spellbook.add(new Spell("", 1.4, "Barbed Arrow", 4, "str", 0, 0, 0, 0, 0));
                spellbook.add(new Spell("poison", .6, "Posioned Arrow", 5, "str", 35, 0, 0, 1, 5));
                spellbook.add(new Spell("avoidUp", 0, "Double Team", /* sorry pokemon */ 2, "str", 100, 5, 3, 0, 0));
                spellbook.add(new Spell("critUp", 0, "Sharp Eye", /* sorry Maplestory */ 3, "str", 100, 1, 3, 0, 0));
                hasntChosen = false;
                break;

                case "r":
                System.out.println("\nYou have chosen the Rogue class!");
                System.out.println("You are fast and tricky, but you don't hurt too much.\nUse speed to your advantage!");
                className = 3;
                str -= 2;
                att += 4;
                crit += 3;
                hp -= 20;
                magAtt -= 5;
                maxMana -= 3;
                mana -= 3;
                manaReg -= .5;
                avoid += 25;
                acc += 15;
                dex += 20;
                def -= 5;
                incDef = def*3/2;
                vit = hp;
                lvl = 1;
                specialname= "Backstab";
                spellbook.add(new Spell("dmgUp", 0, "Sharpen", 3, "str", 100, 2, 3, 0, 0));
                spellbook.add(new Spell("", .7, "Triple Stab", 5, "3x", 0, 0, 0, 0, 0));
                spellbook.add(new Spell("critUp", 0, "Sharp Eye", /* sorry Maplestory */ 3, "", 100, 1, 3, 0, 0));
                hasntChosen = false;
                break;

                case "m":
                System.out.println("\nYou have chosen the Mage class!");
                System.out.println("You're adept in magic! You hurt a lot with spells.\nJust beware, you're pretty slow!");
                className = 4;
                str -= 6;
                att -= 6;
                hp += 10;
                magAtt += 7;
                intel += 5;
                maxMana += 10;
                mana += 10;
                manaReg += 2;
                avoid -= 10;
                acc += 25;
                dex -= 10;
                def -= 5;
                incDef = def*3/2;
                vit = hp;
                lvl = 1;
                specialname = "Energy Blast";
                spellbook.add(new Spell("burn", .8, "Ember", 6, "", 25, 0, 0, 2, 5));
                spellbook.add(new Spell("chill", .8, "Ice Shard", 6, "", 25, 0, 0, 4, 5));
                spellbook.add(new Spell("", 1.4, "Spark", 8, "", 0, 0, 0, 0, 0));
                hasntChosen = false;
                break;

                case "op":
                System.out.println("\nYou have chosen the most Unbalanced Class of the Century!");
                System.out.println("You can do ANYTHING you wish!");
                className = 5;
                str -= 9;
                crit += 20;
                def += 100;
                hp -=80;
                dex -= 7;
                avoid -= 7;
                maxMana -= 5;
                mana -= 5;
                manaReg -= .5;
                att -= 9;
                incDef = def*3/2;
                vit = hp;
                lvl = 1;
                specialname= "KILL THEM ALL";
                spellbook.add(new Spell("", 0, "Extremely Useless Spell #1", 0, "", 0, 0, 0, 0, 0));
                spellbook.add(new Spell("", 0, "Extremely Useless Spell #2", 0, "", 0, 0, 0, 0, 0));
                spellbook.add(new Spell("twostun", 0, "Extremely Useless Spell #3", 5, "", 100, 0, 0, 3, 20));
                hasntChosen = false;
                break;

                case "gold":
                System.out.println("You entered the MONEY BETA TESTING CLASS!");
                System.out.println("But I do know that this character has a lot of gold");
                className = 6;
                str += 10;
                def -= 10;
                incDef = def*3/2;
                vit = 100;
                crit = 100; //Gave both of the beta-testing classes 100% crit. You're welcome.
                dex -= 10;
                acc -= 10;
                avoid -= 10;
                att -= 10;
                hp = 100;
                maxMana -= 10.0;
                mana -= 10.0;
                manaReg -= 1.0;
                exp = 0;
                gold = 999999999;
                lvl = 1;
                wizabon = 99999999;
                specialname = "Here comes the MONAYYY";
                //This is kinda for the lulz- the spell "Raining Money" is used to hurt the enemy 2000x damage
                //and will also multiply greatly the amount of money the enemy drops. So yeah.
                spellbook.add(new Spell("money", 2000, "Raining Money", 0, "", 100, 0, 0, 0, 0));
                hasntChosen = false;
                break;

                case "boss":
                System.out.println("You entered the BOSS BETA TESTING CLASS!");
                System.out.println("Congrats, you one-hit everything.\nIf you die I have no respect for you");
                className = 7;
                str += 1000;
                def += 1000;
                incDef = def*3/2;
                vit = 500;
                crit = 100; //Read above
                dex += 100;
                acc += 100;
                avoid += 100;
                att += 100;
                hp = vit;
                maxMana = 10.0;
                mana = 10.0;
                manaReg = 1.0;
                exp = 50;
                gold = 999999999;
                lvl = 3;
                specialname = "ONE SHOT WONDER";
                spellbook.add(new Spell("boss", 5, "I'MMA KILL U", 5, "", 100, 0, 0, 3, 5));
                hasntChosen = false;
                break;

                default:
                System.out.println("\nPlease input 'w', 'a', 'r', 'm', or 'op'");
                break;
            }
        }
    }

    //Return damage done to enemy "other"
    public int attack(Character other){
        int damage = rand.nextInt(str) + att;
        int total;
        if(rand.nextInt(100)+(acc/2) > (other.avoid/3)){
            if(!other.defending)
                total = damage - (other.def*3/4);
            else
                total = damage - (other.incDef*3/4);
        }
        else
            total = 0;
        if(rand.nextInt(100) <= crit){
            System.out.println("Critical hit!");
            total *= 2;
        }
        return total;
    }

    public int spellAttack(Character other){
        int damage = rand.nextInt(magAtt) + intel;
        int total;
        if(rand.nextInt(100)+(acc*2/3) > (other.avoid/3)){
            if(!other.defending)
                total = damage - (other.def*3/4);
            else
                total = damage - (other.incDef*3/4);
        }
        else
            total = 0;
        if(rand.nextInt(100) < crit){
            System.out.println("Critical hit!");
            total *= 2;
        }
        return total;
    }

    public int special(Character other){
        int damage = rand.nextInt(str) + att;
        int total;
        if(rand.nextInt(100)-(acc/2) > (other.avoid/3)){
            total = (damage *3)/10;
        }
        else
            total = 0;

        return total;
    }

    public boolean checkEXP(){return (exp>=(250+50*lvl));}

    public void levelUp(){
        scaleChar();
        int statsToChoose = 3;
        System.out.println("\nYou have leveled up! Congratulations! Your health and mana have been reset to max!");
        lvl++;
        exp=0;
        while(statsToChoose > 0){
            System.out.println("What stat would you like to raise?\nYou have "+statsToChoose+" points left to spend.");
            System.out.println("If you're confused on your options, please type 'help'.");
            String userChoice = ui.nextLine();
            switch(userChoice){
                case "help":
                System.out.println("\nYour options are:");
                System.out.println("'str', 'def', 'vit', 'dex', 'acc',\n'avoid', 'mana', 'manareg','intel', 'magic attack',\nand 'att'.");
                break;
                case "str":
                System.out.println("You have increased your strength!\n");
                str++;
                statsToChoose--;
                break;
                case "def":
                System.out.println("You have increased your defense!\n");
                def++;
                statsToChoose--;
                break;
                case "vit":
                System.out.println("You have increased your vitality!\n");
                vit+=10;
                statsToChoose--;
                break;
                case "dex":
                System.out.println("You have increased your dexterity!\n");
                dex++;
                statsToChoose--;
                break;
                case "acc":
                System.out.println("You have increased your accuracy!\n");
                acc++;
                statsToChoose--;
                break;
                case "avoid":
                System.out.println("You have increased your avoidability!\n");
                avoid++;
                statsToChoose--;
                break;
                case "att":
                System.out.println("You have increased your attack!\n");
                att++;
                statsToChoose--;
                break;
                case "mana":
                System.out.println("You have increased your maximum mana!");
                mana+=2;
                statsToChoose--;
                break;
                case "manareg":
                System.out.println("You have increased your mana regeneration!");
                manaReg += .25;
                statsToChoose--;
                break;
                case "intel":
                System.out.println("You have increased your intelligence!");
                intel += 1;
                statsToChoose--;
                break;
                case "magic attack":
                System.out.println("You have increased your magic attack!");
                magAtt += 1;
                statsToChoose--;
                break;
                default:
                System.out.println("Please input a stat to increase or 'help'.\n");
                break;
            }
        }
        incDef = def*3/2;
        hp = vit;
    }

    public void unequipSword(){
        str -= currentSword.strBonus;
        att -= currentSword.attBonus;
        currentSword = null;
        wearingSword = false;
    }

    public void equipSword(Sword s){
        if(wearingSword){
            unequipSword();
        }
        wearingSword = true;
        currentSword = s;
        str += s.strBonus;
        att += s.attBonus;
    }
    
    public void equipStaff(Staffs s){
        if(wearingStaff || wearingSword){
            unequipStaff();
            unequipSword();
        }
        wearingStaff = true;
        wearingSword = false;
        currentStaff = s;
        magAtt += s.magicBonus;
        intel += s.intelBonus;
        maxMana += s.manaBonus;
        mana += s.manaBonus;
    }
    
    public void unequipStaff(){
        magAtt -= currentStaff.magicBonus;
        intel -= currentStaff.intelBonus;
        maxMana -= currentStaff.manaBonus;
        mana -= currentStaff.manaBonus;
        if(mana < 0)
        mana = 0;
        currentStaff = null;
        wearingStaff = false;
    }

    public void unequipArmor(){
        def -= currentArmor.defBonus;
        vit -= currentArmor.vitBonus;
        if(hp > vit)
        hp = vit;
        currentArmor = null;
        wearingArmor = false;
    }

    public void equipArmor(Armor a){
        if(wearingArmor){
            unequipArmor();
        }
        wearingArmor = true;
        currentArmor = a;
        def += currentArmor.defBonus;
        vit += currentArmor.vitBonus;
    }

    public void usePotion(){
        if(potionsOwned == 0){
            System.out.println("\nYou don't own any potions!");
        }
        else{
            potionsOwned--;
            int healed = (vit/2)+(rand.nextInt(vit/5));
            System.out.println("\nYou healed "+healed+" health.");
            hp += healed;
            if(hp > vit)
                hp = vit;
            System.out.println("You have "+hp+" health.");
        }
    }
    //Sets defending equal to "true" for use in "attack" method
    public void defend(){
        defending = true;
    }

    public void saveGame(){
        try{
            PrintWriter writer = new PrintWriter("SaveFile.txt", "UTF-8");

            writer.println(str+"/");
            writer.println(def+"/");
            writer.println(vit+"/");
            writer.println(magAtt+"/");
            writer.println(dex+"/");
            writer.println(acc+"/");
            writer.println(avoid+"/");
            writer.println(att+"/");
            writer.println(hp+"/");
            writer.println(maxMana+"/");
            writer.println(mana+"/");
            writer.println(manaReg+"/");
            writer.println(exp+"/");
            writer.println(lvl+"/");
            writer.println(wizabon+"/");
            writer.println(gold+"/");
            writer.println(className+"/");
            writer.println(potionsOwned+"/");
            writer.println(intel+"/");
            writer.println(crit+"/");

            boolean foundBronzeSword = false;
            for(Item i: inv){
                if(i.name == "bronze sword")
                    foundBronzeSword = true;
            }
            if(foundBronzeSword)
                writer.print("y");
            else
                writer.print("n");

            boolean foundIronSword = false;
            for(Item i: inv){
                if(i.name == "iron sword")
                    foundIronSword = true;
            }
            if(foundIronSword)
                writer.print("y");
            else
                writer.print("n");

            boolean foundSteelSword = false;
            for(Item i: inv){
                if(i.name == "steel sword")
                    foundSteelSword = true;
            }
            if(foundSteelSword)
                writer.print("y");
            else
                writer.print("n");

            boolean foundGoldSword = false;
            for(Item i: inv){
                if(i.name == "gold sword")
                    foundGoldSword = true;
            }
            if(foundGoldSword)
                writer.print("y");
            else
                writer.print("n");

            boolean foundBlackDiamondSword = false;
            for(Item i: inv){
                if(i.name == "black diamond sword")
                    foundBlackDiamondSword = true;
            }
            if(foundBlackDiamondSword)
                writer.print("y");
            else
                writer.print("n");

            boolean foundBronzeArmor = false;
            for(Item i: inv){
                if(i.name == "bronze armor")
                    foundBronzeArmor = true;
            }
            if(foundBronzeArmor)
                writer.print("y");
            else
                writer.print("n");

            boolean foundIronArmor = false;
            for(Item i: inv){
                if(i.name == "iron armor")
                    foundIronArmor = true;
            }
            if(foundIronArmor)
                writer.print("y");
            else
                writer.print("n");

            boolean foundSteelArmor = false;
            for(Item i: inv){
                if(i.name == "steel armor")
                    foundSteelArmor = true;
            }
            if(foundSteelArmor)
                writer.print("y");
            else
                writer.print("n");

            boolean foundGoldArmor = false;
            for(Item i: inv){
                if(i.name == "gold armor")
                    foundGoldArmor = true;
            }
            if(foundGoldArmor)
                writer.print("y");
            else
                writer.print("n");

            boolean foundBlackDiamondArmor = false;
            for(Item i: inv){
                if(i.name == "black diamond armor")
                    foundBlackDiamondArmor = true;
            }
            if(foundBlackDiamondArmor)
                writer.print("y");
            else
                writer.print("n");
            writer.close();
        }catch(IOException ex){
            System.out.println("File not found!");
        }
    }

    public void loadGame(){
        Scanner load = null;
        String saveInput = null;
        try{
            File file = new File("SaveFile.txt");
            load = new Scanner(file);
        }catch(IOException ex){
            System.out.println("File not found!");
        }
        if(load != null){
            saveInput = "";
            while (load.hasNext()){
                saveInput += load.next();
            }
        }
        String[] loading = saveInput.split("/");
        String invCreate = loading[loading.length-1];
        double[] loadingDubs = new double[loading.length-1];
        for(int i = 0; i < loading.length-1; i++){
            double s = Double.parseDouble(loading[i]);
            loadingDubs[i] = s;
        }
        str = (int)(loadingDubs[0]);
        def = (int)(loadingDubs[1]);
        vit = (int)(loadingDubs[2]);
        magAtt = (int)(loadingDubs[3]);
        dex = (int)(loadingDubs[4]);
        acc = (int)(loadingDubs[5]);
        avoid = (int)(loadingDubs[6]);
        att = (int)(loadingDubs[7]);
        hp = (int)(loadingDubs[8]);
        maxMana = loadingDubs[9];
        mana = loadingDubs[10];
        manaReg = loadingDubs[11];
        exp = (int)(loadingDubs[12]);
        lvl = (int)(loadingDubs[13]);
        wizabon = (int)(loadingDubs[14]);
        gold = (int)(loadingDubs[15]);
        className = (int)(loadingDubs[16]);
        potionsOwned = (int)(loadingDubs[17]);
        intel = (int)(loadingDubs[18]);
        crit = (int)(loadingDubs[19]);
        if(invCreate.charAt(0) == 'y'){
            inv.add(new Sword(500, 250, "bronze sword", "sword", 1, 5, 2, 1,0));
        }
        if(invCreate.charAt(1) == 'y'){
            inv.add(new Sword(1000, 500, "iron sword", "sword", 1, 10, 4, 2,0));
        }
        if(invCreate.charAt(2) == 'y'){
            inv.add(new Sword(2000, 1000, "steel sword", "sword", 1, 15, 6, 3,0));
        }
        if(invCreate.charAt(3) == 'y'){
            inv.add(new Sword(4000, 2000, "gold sword", "sword", 1, 20, 8, 4,0));
        }
        if(invCreate.charAt(4) == 'y'){
            inv.add(new Sword(8000, 4000, "black diamond sword", "sword", 1, 30, 15, 5,0));
        }
        if(invCreate.charAt(5) == 'y'){
            inv.add(new Armor(500, 250, "bronze armor", "armor", 1, 5, 2, 6,0));
        }
        if(invCreate.charAt(6) == 'y'){
            inv.add(new Armor(1000, 500, "iron armor", "armor", 1, 10, 4, 7,0));
        }
        if(invCreate.charAt(7) == 'y'){
            inv.add(new Armor(2000, 1000, "steel armor", "armor", 1, 15, 6, 8,0));
        }
        if(invCreate.charAt(8) == 'y'){
            inv.add(new Armor(4000, 2000, "gold armor", "armor", 1, 20, 8, 9,0));
        }
        if(invCreate.charAt(9) == 'y'){
            inv.add(new Armor(8000, 4000, "black diamond armor", "armor", 1, 30, 15, 10,0));
        }
        if(className == 1){
            specialname = "Ground Pound";
            spellbook.add(new Spell("defUp", 0, "Iron Skin", 3, "str", 100, 3, 3, 0, 0));
                spellbook.add(new Spell("onestun", .7, "Hilt Strike", 5, "str", 75, 0, 0, 3, 2));
                spellbook.add(new Spell("", 1.4, "Light Poke", 2.5, "str", 0, 0, 0, 0, 0));
        }
        if(className == 2){
            specialname="Sniper Shot";
            spellbook.add(new Spell("", 1.4, "Barbed Arrow", 4, "str", 0, 0, 0, 0, 0));
                spellbook.add(new Spell("poison", .6, "Posioned Arrow", 5, "str", 35, 0, 0, 1, 5));
                spellbook.add(new Spell("avoidUp", 0, "Double Team", /* sorry pokemon */ 2, "str", 100, 5, 3, 0, 0));
                spellbook.add(new Spell("critUp", 0, "Sharp Eye", /* sorry Maplestory */ 3, "str", 100, 1, 3, 0, 0));
        }
        if(className == 3){
            specialname= "Backstab";
            spellbook.add(new Spell("dmgUp", 0, "Sharpen", 3, "str", 100, 2, 3, 0, 0));
                spellbook.add(new Spell("", .7, "Triple Stab", 5, "3x", 0, 0, 0, 0, 0));
                spellbook.add(new Spell("critUp", 0, "Sharp Eye", /* sorry Maplestory */ 3, "", 100, 1, 3, 0, 0));
        }
        if(className == 4){
            specialname = "Energy Blast";
            spellbook.add(new Spell("burn", .8, "Ember", 6, "", 25, 0, 0, 2, 5));
                spellbook.add(new Spell("chill", .8, "Ice Shard", 6, "", 25, 0, 0, 4, 5));
                spellbook.add(new Spell("", 1.4, "Spark", 8, "", 0, 0, 0, 0, 0));
        }
        if(className == 5){
            specialname= "KILL THEM ALL";
            spellbook.add(new Spell("", 0, "Extremely Useless Spell #1", 0, "", 0, 0, 0, 0, 0));
                spellbook.add(new Spell("", 0, "Extremely Useless Spell #2", 0, "", 0, 0, 0, 0, 0));
                spellbook.add(new Spell("twostun", 0, "Extremely Useless Spell #3", 5, "", 100, 0, 0, 3, 20));
        }
        if(className == 6){
            specialname = "Here comes the MONAYYY";
            spellbook.add(new Spell("money", 2000, "Raining Money", 0, "", 100, 0, 0, 0, 0));
        }
        if(className == 7){
            specialname = "ONE SHOT WONDER";
            spellbook.add(new Spell("boss", 5, "I'MMA KILL U", 5, "", 100, 0, 0, 3, 5));
        }
    }
    
    public String stateClass(){
        switch(className){
            case 1:
            return "a Warrior";
            
            case 2:
            return "an Archer";
            
            case 3:
            return "a Rogue";
            
            case 4:
            return "a Mage";
            
            case 5:
            return "overpowered";
            
            case 6:
            return "beta testing money";
            
            case 7:
            return "beta testing bosses";
        }
        return null;
    }
    
    public boolean checkPoison(){
        for(StatusEffect s : seList){
            if(s.identifier == 1)
            return true;
        }
        return false;
    }
    
    public boolean checkBurn(){
        for(StatusEffect s : seList){
            if(s.identifier == 2)
            return true;
        }
        return false;
    }
    
    public boolean checkStun(){
        for(StatusEffect s : seList){
            if(s.identifier == 3)
            return true;
        }
        return false;
    }
    
    public boolean checkChill(){
        for(StatusEffect s : seList){
            if(s.identifier == 4)
            return true;
        }
        return false;
    }
    
    public boolean checkSCrit(){
        for(StatusEffect s : seList){
            if(s.identifier == 5)
            return true;
        }
        return false;
    }
    
    public boolean checkSDmg(){
        for(StatusEffect s : seList){
            if(s.identifier == 6)
            return true;
        }
        return false;
    }
    
    public boolean checkSDef(){
        for(StatusEffect s : seList){
            if(s.identifier == 7)
            return true;
        }
        return false;
    }
    
    public boolean checkSAcc(){
        for(StatusEffect s : seList){
            if(s.identifier == 8)
            return true;
        }
        return false;
    }
    
    public boolean checkSAvoid(){
        for(StatusEffect s : seList){
            if(s.identifier == 9)
            return true;
        }
        return false;
    }
    
    private void scaleChar(){
        switch(className){
            case 1: //warrior
            str += 1;
            def += 2;
            vit += 20;
            hp += 20;
            break;
            
            case 2: //archer
            att += 2;
            str += 1;
            acc += 2;
            break;
            
            case 3: //rogue
            att += 1;
            crit += 1;
            avoid += 2;
            acc += 2;
            break;
            
            case 4: //mage
            manaReg += .25;
            maxMana += 1;
            magAtt += 2;
            intel += 2;
            vit += 10;
            hp += 10;
            break;
            
            case 5: //op
            str--;
            att--;
            if(str<0)
            str = 0;
            if(att<0)
            att = 0;
            def += 20;
            vit += 200;
            hp += 200;
            break;
            
            case 6: //gold
            gold += 2;
            break;
            
            case 7: //boss
            exp += 2;
            break;
        }
    }
}
