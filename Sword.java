/**
 * Class for Sword to be worn by Player class
 * @author Justin Goodberry
 */

public class Sword extends Item{
    public int strBonus;
    public int attBonus;
    public Sword(){
        buyValue = 0;
        sellValue = 0;
        name = null;
        itemClass = null;
        strBonus = 0;
        attBonus = 0;
    }
    public Sword(int bv, int sv, String nm, String ic, int no, int sb, int ab, int id, int db){
        super(bv, sv, nm, ic, no, id, db);
        strBonus = sb;
        attBonus = ab;
    }
    public String stateSell(){return sellValue+" gold";}
    public String stateBuy(){ return buyValue+" gold";}
}