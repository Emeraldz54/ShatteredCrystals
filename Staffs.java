/**
 * Class for Sword to be worn by Player class
 * @author Justin Goodberry
 */

public class Staffs extends Item{
    public int magicBonus;
    public int intelBonus;
    public int manaBonus;
    public Staffs(){
        buyValue = 0;
        sellValue = 0;
        name = null;
        itemClass = null;
        magicBonus = 0;
        intelBonus = 0;
        manaBonus = 0;
    }
    public Staffs(int bv, int sv, String nm, String ic, int no, int sb, int ab, int mb, int id, int db){
        super(bv, sv, nm, ic, no, id, db);
        magicBonus = sb;
        intelBonus = ab;
        manaBonus = mb;
    }
    public String stateSell(){return sellValue+" gold";}
    public String stateBuy(){ return buyValue+" gold";}
}