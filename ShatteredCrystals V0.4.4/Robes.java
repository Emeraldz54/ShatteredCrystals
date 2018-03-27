/**
 * Class for Sword to be worn by Player class
 * @author Justin Goodberry
 */

public class Robes extends Item{
    public int magicBonus;
    public int intelBonus;
    public int manaBonus;
    public int defBonus;
    public Robes(){
        buyValue = 0;
        sellValue = 0;
        name = null;
        itemClass = null;
        magicBonus = 0;
        intelBonus = 0;
        manaBonus = 0;
        defBonus =0;
    }
    public Robes(int bv, int sv, String nm, String ic, int no, int db, int sb, int ab, int mb, int id, int db1){
        super(bv, sv, nm, ic, no, id, db1);
        magicBonus = sb;
        intelBonus = ab;
        manaBonus = mb;
        defBonus = db;
    }
    public String stateSell(){return sellValue+" gold";}
    public String stateBuy(){ return buyValue+" gold";}
}