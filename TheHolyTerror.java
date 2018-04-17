
/**
 * Write a description of class TheHolyTerror here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TheHolyTerror extends Boss{
    public TheHolyTerror(){
        super();
    }

    public TheHolyTerror(Character other){
        super();
        this.inStat(other);
    }

    public void inStat(Character other){
        str= 25;
        def = 150;
        vit=500;
        dex=100;
        acc=100;
        avoid=50;
        att=75;
        hp=500;
        mana = 100.00;
        manaReg=10.00;
        lvl=other.lvl;
        exp=200;
        gold=1;
        name = "The Holy Terror";
        for(int i = 0; i<=(lvl-1)*3;i++){
            int choice = rand.nextInt(10);
            switch(choice){
                case 0:str+=5;break;

                case 1:def+=5;break;

                case 2:vit+=5;break;

                case 3:dex+=5;break;

                case 4:acc+=5;break;

                case 5:avoid+=5;break;

                case 6:att+=5;break;

                case 7:hp+=20;break;

                case 8: mana +=10.0;break;

                case 9:manaReg+=2.5;break;

                default:vit++;
            }
        }
        incDef = def*3/2;
    }

    public int special(Character other){
        int damage = rand.nextInt(str) + att;
        int total;
        System.out.println("The Holy Terror uses Teaching About Life!");
        if(other.def < str*5){
            if(!other.defending)
                total = damage + damage;
            else{
                total = damage + (int)(damage/2) - (other.incDef*3/4);
            }
        }
        else{
            total = damage - other.str;
            System.out.println("You ignore most of the advice, but still get hit!");
        }
        return total;
    }
}
