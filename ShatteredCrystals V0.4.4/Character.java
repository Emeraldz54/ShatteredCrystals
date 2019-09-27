/**
 * Character class for use by Enemy and Player
 * Abstract so can be edited for use by those classes
 */
import java.util.List;
import java.util.ArrayList;
public abstract class Character{
    public int str;
    public int def;
    public int incDef;
    public int crit;
    public int vit;
    public int intel;
    public int magAtt;
    public int dex;
    public int acc;
    public int avoid;
    public int att;
    public int hp;
    public double maxMana;
    public double mana;
    public double manaReg;
    public int exp;
    public int lvl;
    public List<StatusEffect> seList = new ArrayList<StatusEffect>();
    public static boolean defending;
    public int wizabon;
    public abstract int attack(Character other);
    public abstract void defend();
}
