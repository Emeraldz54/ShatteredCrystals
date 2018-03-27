/**
 * Boss classs
 * extends the monster class
 * can do ridiculous things
 */

public class Teemo extends Boss{
    public int wizabon;
    public Teemo(){
        super();
        name = "Teemo";
    }

    public Teemo(Character other){
        super();
        this.inStat(other);
    }

    public void inStat(Character other){
        str= 10;
        def = 15;
        vit=50;
        dex=20;
        acc=200;
        avoid=10;
        att=20;
        hp=vit;
        mana = 20.00;
        manaReg=2.00;
        lvl=other.lvl;
        exp=100*lvl;
        gold=150*lvl;
        wizabon = 1+ 2*lvl;
        name = "Teemo";
        for(int i = 0; i<=(lvl-1)*3;i++){
            int choice = rand.nextInt(10);
            switch(choice){
                case 0:str+=10;break;

                case 1:def+=3;break;

                case 2:vit+=5;break;

                case 3:dex+=10;break;

                case 4:acc+=10;break;

                case 5:avoid+=8;break;

                case 6:att+=3;break;

                case 7:hp+=20;break;

                case 8: mana +=10.0;break;

                case 9:manaReg+=2.5;break;

                default:vit++;
            }
        }
        incDef = def*3/2;
    }

    public int special(Character other){
        int damage = rand.nextInt(str)+att;
        int total = 0;
        boolean shrooms = false;
        System.out.println("Teemo uses SUPER ANNOYING SHROOM POWERS!");
        while(!shrooms){
            str += 50;
            vit += 100;
            hp = vit;
            avoid += 100;
            att += 50;
            total = attack(other) + damage;
            shrooms = true;
        }
        return total;
    }
}