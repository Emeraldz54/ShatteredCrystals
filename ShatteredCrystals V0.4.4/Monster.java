/**
 * Monster Class
 * Used by monsters and bosses
 * Has Monster stats
 */
import java.util.Random;
public class Monster extends Character{
    Random rand = new Random();
    String name;
    int gold;
    public Monster(){
        name = "Monster";
    }

    //allows for monster to attack
    public int attack(Character other){
        int damage = rand.nextInt(str) + att;
        int total =0;
        if(rand.nextInt(acc+30) > (other.avoid/3)){
            if(!other.defending)
                total =damage - (other.def*3/4);
            if(rand.nextInt(100) <= crit){
                System.out.println("Critical hit!");
                total *= 2;
            }
            else
                total = damage-(other.incDef*3/4);
            if(rand.nextInt(100) <= crit){
                System.out.println("Critical hit!");
                total *= 2;
            }
        }
        else
            total = 0;

        if (total <0)
            total = 0;
        return total;
    }

    //temporarily makes def higher
    public void defend(){
        defending = true;
    }

    //instantiates stats of monster
    public void inStat(Character other){
        str= 10;
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
        lvl=other.lvl;
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
    }

    public int special(Character other){
        int damage = rand.nextInt(str) + att;
        int total=0;
        if(rand.nextInt(100)-(acc/2) > (other.avoid/3)){
            if(!other.defending)
                total =damage - (other.def*3/4);
            if(rand.nextInt(100) <= crit){
                System.out.println("Critical hit!");
                total *= 2;
            }
            else
                total = damage-(other.incDef*3/4);
            if(rand.nextInt(100) <= crit){
                System.out.println("Critical hit!");
                total *= 2;
            }
        }
        else
            total = 0;
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