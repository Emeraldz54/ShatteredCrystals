
/**
 * Write a description of class NetworkMonster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.text.*;
public class NetworkMonster extends Monster
{

    public NetworkMonster(){
        super();
    }

    public NetworkMonster(int lvl1){
        super();
        this.inStat(lvl1);
    }

    public void inStat(int lvl1){
        str= 15;
        def = 20;
        vit=60;
        dex=20;
        acc=20;
        avoid=20;
        att=20;
        hp=vit;
        mana = 20.00;
        manaReg=2.00;
        lvl=lvl1;
        exp=100*lvl;
        gold=150*lvl;
        for(int i = 0; i<=(lvl-1)*3;i++){
            int statChoice = rand.nextInt(10);
            switch(statChoice){
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

    public int choice(double pHp, double mHp){
        double xorInput[][] =
            {
                {100.0,70.0},
                {50.0,70.0},
                {25.0,30.0},
                {50.0,16.0}};

        double xorIdeal[][] =
            { {0.0},{0.0},{1.0},{2.0}};

        Network network = new Network(2,3,1,0.7,0.9);

        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMinimumFractionDigits(4);

        for (int i=0;i<10000;i++) {
            for (int j=0;j<xorInput.length;j++) {
                network.computeOutputs(xorInput[j]);
                network.calcError(xorIdeal[j]);
                network.learn();
            }
        }
        
        double choiceInput[][] = 
        {
            {pHp,mHp}
        };
        
        int y = 0;
        return y;
    }
    
}
