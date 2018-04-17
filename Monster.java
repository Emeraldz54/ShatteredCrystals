/**
 * Monster Class
 * Used by monsters and bosses
 * Has Monster stats
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
public class Monster extends Character{
    Random rand = new Random();
    String name;
    int gold;
    int id;
    List<Spell> spellbook = new ArrayList<Spell>();
    public Monster(){
        name = "Monster";
    }

    /**
     * Monster ID list by location
     * 
     * 0-2: Undeads, plains region
     * 3-5: Yordles, forest region
     * 6-8: Trolls, mountain region
     * 9-11: Corrupteds, castle region
     */
    public Monster(int monsterID,Character other){
        str= 10;
        location = other.location;
        crit = 5;
        def = 5;
        vit=50;
        dex=10;
        acc=10;
        avoid=10;
        magAtt = 10;
        intel = 10;
        att=10;
        hp=50;
        mana = 10.00;
        manaReg=1.00;
        id = monsterID;
        lvl=other.lvl;
        if(lvl > 7*(location+1))
            lvl = 7*(location+1);
        exp=30+ 20*lvl;
        gold= 50 + 50*lvl;
        for(int i = 0; i<=(lvl-1)*3;i++){
            int choice = rand.nextInt(11);
            switch(choice){
                case 0:
                str++;
                break;

                case 1:
                def+= 2;
                break;

                case 2:
                vit+= 10;
                hp = vit;
                break;

                case 3:
                dex++;
                break;

                case 4:
                acc++;
                break;

                case 5:
                avoid++;
                break;

                case 6:
                att++;
                break;

                case 7:
                mana +=2.0;
                break;

                case 8:
                manaReg+=.5;
                break;

                case 9:
                intel++;
                break;

                case 10:
                magAtt++;
                break;

                default:
                vit+=10;
                hp= vit;
                break;
            }
        }
        incDef = def*3/2;
        maxMana = mana;
        hp = vit;
        switch(monsterID){
            case 0:
            name = "Undead Warrior";
            spellbook.add(new Spell("", 0, "Undead Revitalization", 5, "healing", 0, 1, 0, 0, 0));
            spellbook.add(new Spell("defUp", 0, "Iron Skin", 3, "str", 100, 3, 3, 0, 0));
            spellbook.add(new Spell("onestun", .7, "Hilt Strike", 5, "str", 75, 0, 0, 3, 2));
            break;

            case 1:
            name = "Undead Archer";
            spellbook.add(new Spell("", 0, "Undead Revitalization", 5, "healing", 0, 1, 0, 0, 0));
            spellbook.add(new Spell("", 1.4, "Barbed Arrow", 4, "str", 0, 0, 0, 0, 0));
            spellbook.add(new Spell("avoidUp", 0, "Double Team", /* sorry pokemon */ 2, "str", 100, 5, 3, 0, 0));
            break;

            case 2:
            name = "Undead Mage";
            spellbook.add(new Spell("", 0, "Undead Revitalization", 5, "healing", 0, 1, 0, 0, 0));
            spellbook.add(new Spell("burn", .8, "Ember", 6, "", 25, 0, 0, 2, 5));
            spellbook.add(new Spell("chill", .8, "Ice Shard", 6, "", 25, 0, 0, 4, 5));
            spellbook.add(new Spell("", 1.4, "Spark", 8, "", 0, 0, 0, 0, 0));
            break;

            case 3:
            name = "Yordle With a Hammer";
            spellbook.add(new Spell("onestun", .8, "Wall Stun", 2, "", 25, 0, 0, 3, 1));
            spellbook.add(new Spell("avoidUp", 0, "Yordle Luck", 2, "str", 100, 5, 3, 0, 0));
            break;

            case 4:
            name = "Yordle with a Shuriken";
            spellbook.add(new Spell("avoidUp", 0, "Yordle Luck", 2, "str", 100, 5, 3, 0, 0));
            break;

            case 5:
            name = "Yordle with Lightning";
            spellbook.add(new Spell("onestun", .8, "Triple Stacks", 2, "", 25, 0, 0, 3, 1));
            spellbook.add(new Spell("burn", .8, "Electric Burn", 6, "", 25, 0, 0, 2, 5));
            spellbook.add(new Spell("chill", .8, "Freezer Strike", 6, "", 25, 0, 0, 4, 5));
            spellbook.add(new Spell("", 1.4, "Lightning Strike", 8, "", 0, 0, 0, 0, 0));
            spellbook.add(new Spell("avoidUp", 0, "Yordle Luck", 2, "str", 100, 5, 3, 0, 0));
            break;

            case 6:
            name = "Hedge Troll";
            spellbook.add(new Spell("", 1.4, "Brutal Bite", 3, "", 0, 0, 0, 0, 0));
            break;

            case 7:
            name = "Troll Rock Thrower";
            spellbook.add(new Spell("", 1.4, "Brutal Bite", 3, "", 0, 0, 0, 0, 0));
            break;

            case 8:
            name = "Troll Mage";
            spellbook.add(new Spell("", 1.4, "Brutal Bite", 3, "", 0, 0, 0, 0, 0));
            break;

            case 9:
            name = "Corrupted Warrior";
            spellbook.add(new Spell("chill", 1.4, "Corruption Strike", 3, "", 55, 2, 4, 4, 4));
            break;

            case 10:
            name = "Corrupted Archer";
            spellbook.add(new Spell("chill", 1.4, "Corruption Strike", 3, "", 55, 2, 4, 4, 4));
            break;

            case 11:
            name = "Corrupted Mage";
            spellbook.add(new Spell("chill", 1.4, "Corruption Strike", 3, "", 55, 2, 4, 4, 4));
            break;

            default:
            name = "Missing No.";
            spellbook.add(new Spell("", 200, "Clean Slate", 0, "", 0, 0, 0, 0, 0));
            break;
        }
    }

    //allows for monster to attack
    public int attack(Character other){
        int damage = rand.nextInt(str) + att;
        int total;
        if(rand.nextInt(100)+(acc/2) > (other.avoid/3)){
            if(!other.defending)
                total =damage - (other.def*3/4);
            else
                total = damage-(other.incDef*3/4);
        }
        else
            total = 0;

        return total;
    }

    //temporarily makes def higher
    public void defend(){
        defending = true;
    }

    public int special(Character other){
        int damage = rand.nextInt(str) + att;
        int total;
        if(rand.nextInt(100)-(acc/2) > (other.avoid/3)){
            if(!other.defending)
                total =damage - (other.def*3/4);
            else
                total = damage-(other.incDef*3/4);
        }
        else
            total = 0;
        if(rand.nextInt(100) <= crit){
            System.out.println("Critical hit!");
            total *= 2;
        }
        return total;
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
}