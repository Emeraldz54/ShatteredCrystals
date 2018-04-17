/**
 * Class for Armor to be worn by Player class
 * @author Justin Goodberry
 */

public class Armor extends Item{
    public int defBonus;
    public int vitBonus;
    public Armor(){
        buyValue = 0;
        sellValue = 0;
        name = null;
        itemClass = null;
        defBonus = 0;
        vitBonus = 0;
        numOwned = 0;
    }
    public Armor(int bv, int sv, String nm, String ic, int no, int db, int vb, int id, int db1){
        super(bv, sv, nm, ic, no, id, db1);
        defBonus = db;
        vitBonus = vb;
    }
    public String stateSell(){return sellValue+" gold";}
    public String stateBuy(){ return buyValue+" gold";}
}