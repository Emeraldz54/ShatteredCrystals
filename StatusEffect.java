/**
 * Class for status effects in-game! Some things found will be copies of what is found in Spell.
 */

public class StatusEffect{
    public int duration;
    public boolean isDamage;
    public int identifier;
    public StatusEffect(){
        duration = 0;
        isDamage = false;
        identifier = 0;
    }
    public StatusEffect(int dur, boolean dmg, int id){
        duration = dur;
        isDamage = dmg;
        identifier = id;
    }
    public String stateName(){
        switch(identifier){
            case 0:
            return "Some'n messed up.";
            
            case 1:
            return "Poison";
            
            case 2:
            return "Burn";
            
            case 3:
            return "Stun";
            
            case 4:
            return "Chill";
            
            case 5:
            return "self Critical buff";
            
            case 6:
            return "self Damage buff";
            
            case 7:
            return "self Defense buff";
            
            case 8:
            return "self Accuracy buff";
            
            case 9:
            return "self Avoidability buff";
            
            default:
            return "error";
        }
    }
}
/**
 * Identifiers!
 * 0: no effect
 * 1: enemy poison
 * 2: enemy burn
 * 3: enemy stun
 * 4: enemy chill
 * 5: self crit up
 * 6: self dmg up
 * 7: self def up
 * 8: self acc up
 * 9: self avoid up
 */