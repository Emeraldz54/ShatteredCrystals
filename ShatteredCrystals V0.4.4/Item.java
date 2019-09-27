/**
 * Class which encompasses weapons, armor, and potions
 * @author Justin Goodberry
 */

public class Item{
    public int buyValue;
    public int sellValue;
    public String name;
    public String itemClass;
    public int numOwned;
    public int itemID;
    public int deBuff;
    public Item(){
        buyValue = 0;
        sellValue = 0;
        name = null;
        itemClass = null;
        numOwned = 0;
        itemID = 0;
    }
    
    public Item(int bv, int sv, String nm, String ic, int no, int id, int db){
        buyValue = bv;
        sellValue = sv;
        name = nm;
        itemClass = ic;
        numOwned = no;
        itemID = id;
        deBuff = db;
    }
    
    public String stateSell(){return sellValue+" gold";}
    public String stateBuy(){ return buyValue+" gold";}
}
