/**
 * Spells for characters in the game
 * Michael Lee and Justin Goodberry
 */

public class Spell{
    /*
     * So just a few clarifiers for this! Status is a string for the status effects (can be changed to a
     * status effect class when needed), damage is the multiplier of character damage, name is the name of the spell
     * (ie. 'fireball', 'bind', 'useless spell #3'), manaCost is... the mana cost, and modifiers is anything
     * special with the spell (like with the rogue if you wanna say like he gets exploding money that he spends
     * 50 gp and hurts 3xattack that turn, you could name modifiers 'g' for gold or just 'gold' or some'n), and
     * statusEffectChance is the chance out of 100 for the effect to happen. Also, the 'isSelf' variable
     * is used to determine whether a spell is used on the player or the enemy; 0 is used as a placeholder for
     * non-self casting spells whereas the other numbers are used to show which status it gives.
     */
    public String status;
    public double damage;
    public String name;
    public double manaCost;
    public String modifiers;
    public int statusEffectChance;
    public int isSelf;
    public int duration;
    public int enemyEffect;
    public int enemyDuration;
    
    public Spell(){
        status = "";
        damage = 0;
        name = "";
        manaCost = 0;
        modifiers = "";
        statusEffectChance = 0;
        isSelf = 0;
        duration = 0;
        enemyEffect = 0;
        enemyDuration = 0;
    }
    
    public Spell(String st, double dmg, String nm, double mc, String mod, int stc, int self, int dur, int ee, int eDur){
        status = st;
        damage = dmg;
        name = nm;
        manaCost = mc;
        modifiers = mod;
        statusEffectChance = stc;
        isSelf = self;
        duration = dur;
        enemyEffect = ee;
        enemyDuration = eDur;
    }
    /**
     * Self status effects!
     * 0: not self cast
     * 1: critical boost
     * 2: damage boost
     * 3: defense boost
     * 4: accuracy boost
     * 5: avoidability boost
     */
    
    /**
     * Status effects towards enemies!
     * 0: no effect
     * 1: poison
     * 2: fire
     * 3: stun
     * 4: chill
     */
    
    /**
     * Duration!
     * 0: generally just an attack spell, no status
     * 1-<><>(as close as I could get to infinity): that amount of turns
     */
}