/**
 * Boss classs
 * extends the monster class
 * can do rediculous things
 */

public class Boss extends Monster{
	
	public Boss(){
		super();
	}
	
	public Boss(Character other){
		super();
		this.inStat(other);
	}
	
	public void inStat(Character other){
        str= 15;
        def = 20;
        vit=60;
        dex=20;
        acc=20;
        avoid=20;
        att=20;
        hp=other.hp;
        mana = 20.00;
        manaReg=2.00;
        lvl=other.lvl;
        exp=100*lvl;
        gold=150*lvl;
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
}