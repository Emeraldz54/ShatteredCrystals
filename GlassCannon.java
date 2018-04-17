/**
 * Boss classs
 * extends the monster class
 * can do rediculous things
 */

public class GlassCannon extends Boss{
    public GlassCannon(){
        super();
    }

    public GlassCannon(Character other){
        super();
        this.inStat(other);
    }

    public void inStat(Character other){
        str= 1000;
        def = 5;
        vit=60;
        dex=20;
        acc=200;
        avoid=1;
        att=200;
        hp=25;
        mana = 20.00;
        manaReg=2.00;
        lvl=other.lvl;
        exp=50*lvl;
        gold=150*lvl;
        name = "The Glass Cannon";
        for(int i = 0; i<=(lvl-1)*3;i++){
            int choice = rand.nextInt(10);
            switch(choice){
                case 0:str+=20;break;

                case 1:def++;break;

                case 2:vit++;break;

                case 3:dex++;break;

                case 4:acc++;break;

                case 5:avoid++;break;

                case 6:att++;break;

                case 7:hp++;break;

                case 8: mana +=10.0;break;

                case 9:manaReg+=2.5;break;

                default:vit++;
            }
        }
        incDef = def*3/2;
    }

    public int special(Character other){
        int damage = rand.nextInt(str)+att;
        int total;
        System.out.println("The Glass Cannon uses Extreme Laser Beam!");
        if(other.avoid > (acc/2)){
            System.out.println("You dodge the LASER BEAM");
            total = 0;
        }
        else{
            if(!other.defending)
                total = damage;
            else
                total = (int)(damage / other.def) + (att - other.def);
        }
        return total;
    }
}