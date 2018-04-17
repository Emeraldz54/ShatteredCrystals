/**
 * Class to pit a Player and Monster object against each other
 * @authors Justin Goodberry and Michael Lee
 * @version 1 5/26/2016
 * 
 * DISCLAIMER: The 'authors' tag is used to show that the entire *project* is made by the two of us.
 * The Battle class itself was written by Justin Goodberry, though it was proofread by Michael Lee.
 */
import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Battle{
    public static void main(Player user, Monster enemy){
        Spell currentUserSpell = null;
        int userSpecCD = 0;
        int enemySpecCD = 0;
        System.out.println("\n"+ enemy.name + " has appeared!");
        System.out.println("Please input 'attack', 'defend', 'spell', 'special', 'potion', or 'run'.");
        Scanner ui = new Scanner(System.in);
        Random rand = new Random();
        boolean running = false;
        while((user.hp > 0 && enemy.hp > 0) && !running){
            if(!user.checkStun()){
                List<Object> userBattleStoof = user.userBattleChoice();
                running = (boolean)userBattleStoof.get(0);
                String userChoice = (String)userBattleStoof.get(1);
                currentUserSpell = (Spell)userBattleStoof.get(2);
                if(userChoice.equals("attack")){
                    int damage = user.attack(enemy);
                    if(damage > 0){
                        System.out.println("You dealt " + damage + " damage.");
                        enemy.hp -= damage;
                        if(enemy.hp < 0)
                            enemy.hp = 0;
                        System.out.println("The "+enemy.name+" has " + (enemy.hp) + " health left.\n");
                    }
                    else{
                        System.out.println("Your attack missed!\n"+enemy.name+" still has "+enemy.hp+" health left.\n");
                    }
                    try {
                        Thread.sleep(500);
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
                else if(userChoice.equals("special")){userSpecCD = 3;
                    int specialDamage;
                    switch(user.className){
                        case 1:
                        System.out.println("You used your special, Vampire Slash!");
                        specialDamage = (int)(3*(rand.nextInt(user.str)+user.att)/2);
                        System.out.println("You hurt the "+enemy.name+" "+specialDamage+" damage and healed for half!");
                        System.out.println("It's now on a three-turn cooldown!");
                        enemy.hp -= specialDamage;
                        user.hp += (int)(1/2*specialDamage);
                        if(user.hp > user.vit)
                        user.hp = user.vit;
                        break;
                        
                        
                        case 2:
                        System.out.println("You used your special, Concussive Arrow!");
                        specialDamage = (int)((1.5)*(rand.nextInt(user.str)+user.att));
                        System.out.println("You hurt the "+enemy.name+" "+specialDamage+" damage!\nIt was also stunned for two turns!");
                        System.out.println("It's now on a three-turn cooldown!");
                        enemy.hp -= specialDamage;
                        enemy.seList.add(new StatusEffect(2, false, 3));
                        break;
                        
                        
                        case 3:
                        System.out.println("You used your special, Assassinate!\nYou stabbed "+enemy.name+" in the back with a poisoned dagger.");
                        specialDamage = (int)(enemy.hp/3);
                        System.out.println("You hurt the "+enemy.name+" "+specialDamage+" damage!");
                        System.out.println("It's also afflicted with poison for five turns.");
                        System.out.println("It's now on a three-turn cooldown!");
                        enemy.hp -= specialDamage;
                        enemy.seList.add(new StatusEffect(5, true, 1));
                        break;
                        
                        
                        case 4:
                        System.out.println("You used your special, Energy Blast!\nYou blasted "+enemy.name+" for extra damage.");
                        specialDamage = (int)((3)*(rand.nextInt(user.magAtt)+user.intel));
                        System.out.println("You dealt "+enemy.name+" "+specialDamage+" damage.\nYour special is now on a three-turn cooldown.");
                        enemy.hp -= specialDamage;
                        break;
                        
                        
                        case 5:
                        System.out.println("You used your special, which does essentially nothing!");
                        System.out.println("Your health is regenerated to full. It's on a three-turn cooldown.");
                        user.hp = user.vit;
                        break;
                        
                        
                        case 6:
                        System.out.println("Here comes the MONAYYYYYYYYYYYYYYYYYYYYYY\nHERE COMES the MONAY\nMONAY MONAY MONAY MONAY");
                        user.gold = 999999999;
                        user.wizabon = 99999999;
                        enemy.gold = 99999999;
                        enemy.hp = enemy.vit;
                        break;
                        
                        
                        case 7:
                        System.out.println("I don't care. The enemy died, or something.");
                        enemy.hp -= enemy.hp;
                        break;
                        
                        default:
                        System.out.println("Oops!");
                        break;
                    }
                    try{
                        Thread.sleep(500);
                    }catch(InterruptedException ex){
                        Thread.currentThread().interrupt();
                    }
                }
                else if(userChoice.equals("spell")){
                    double multiplier = currentUserSpell.damage;
                    if(currentUserSpell.modifiers == "3x"){
                        System.out.println("You used Triple Stab!");
                        for(int i = 0; i < 3; i++){
                            int damage = (int)(user.attack(enemy)*multiplier);
                            System.out.println("You stab the "+enemy.name+" for "+damage+" damage!");
                            enemy.hp -= damage;
                        }
                        System.out.println("The "+enemy.name+" has "+enemy.hp+" health!\n");
                    } else{
                        if(currentUserSpell.damage !=0){
                            int damage;
                            if(currentUserSpell.modifiers == "str" || currentUserSpell.modifiers == "3x")
                                damage = (int)(user.attack(enemy)*multiplier);
                            else
                                damage = (int)(user.spellAttack(enemy)*multiplier);
                            user.mana -= currentUserSpell.manaCost;
                            if(damage>0){
                                System.out.println(currentUserSpell.name + " deals " + damage + " to " + enemy.name + ".");
                                enemy.hp -= damage;
                                if(enemy.hp <0)
                                    enemy.hp = 0;
                                System.out.println("The "+enemy.name+" has "+enemy.hp+" health left.\n");
                            }
                            else
                                System.out.println(currentUserSpell.name+" missed!\n"+enemy.name+" still has "+enemy.hp+" health left.\n");
                        }
                        if(currentUserSpell.name == "Extremely Useless Spell #1" || currentUserSpell.name == "Extremely Useless Spell #2" || currentUserSpell.name == "Extremely Useless Spell #3"){
                            System.out.println("You did something extremely useless.");
                        }
                        if(currentUserSpell.isSelf != 0){
                            switch(currentUserSpell.isSelf){
                                case 1:
                                System.out.println("Your critical hit rate increased for "+currentUserSpell.duration+" turns.");
                                user.crit += 45;
                                user.seList.add(new StatusEffect(currentUserSpell.duration, false, 5));
                                break;

                                case 2:
                                System.out.println("Your damage increased for "+currentUserSpell.duration+" turns.");
                                user.str += 5;
                                user.seList.add(new StatusEffect(currentUserSpell.duration, false, 6));
                                break;

                                case 3:
                                System.out.println("Your defense increased for "+currentUserSpell.duration+" turns.");
                                user.def += 5;
                                user.seList.add(new StatusEffect(currentUserSpell.duration, false, 7));
                                break;

                                case 4:
                                System.out.println("Your accuracy increased for "+currentUserSpell.duration+" turns.");
                                user.acc += 20;
                                user.seList.add(new StatusEffect(currentUserSpell.duration, false, 8));
                                break;

                                case 5:
                                System.out.println("Your avoidability increased for "+currentUserSpell.duration+" turns.");
                                user.avoid += 20;
                                user.seList.add(new StatusEffect(currentUserSpell.duration, false, 9));
                                break;

                                default:
                                System.out.println("error");
                                break;
                            }
                        }
                        if(currentUserSpell.enemyEffect != 0){
                            switch(currentUserSpell.enemyEffect){
                                case 1:
                                System.out.println("The "+enemy.name+" was afflicted with poison for "+currentUserSpell.enemyDuration+" turns.");
                                enemy.seList.add(new StatusEffect(currentUserSpell.enemyDuration, true, 1));
                                break;

                                case 2:
                                System.out.println("The "+enemy.name+" was afflicted with burn for "+currentUserSpell.enemyDuration+" turns.");
                                enemy.seList.add(new StatusEffect(currentUserSpell.enemyDuration, true, 2));
                                break;

                                case 3:
                                System.out.println("The "+enemy.name+" was afflicted with stun for "+currentUserSpell.enemyDuration+" turns.");
                                enemy.seList.add(new StatusEffect(currentUserSpell.enemyDuration, false, 3));
                                break;

                                case 4:
                                System.out.println("The "+enemy.name+" was afflicted with chill for "+currentUserSpell.enemyDuration+" turns.");
                                enemy.seList.add(new StatusEffect(currentUserSpell.enemyDuration, false, 4));
                                enemy.dex -= 3;
                                enemy.acc -= 5;
                                enemy.avoid -= 5;
                                break;

                                default:
                                System.out.println("error");
                                break;
                            }
                        }
                    }
                    System.out.println();
                }
                else if(userChoice.equals("defend")){
                    user.defend();
                    System.out.println("You are defending from "+enemy.name+"'s attacks.\n");
                    try {
                        Thread.sleep(500);
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
                else if(userChoice.equals("potion")){
                    if(user.potionsOwned == 0)
                        System.out.println("You don't own any potions");
                    else
                        user.usePotion();
                    try {
                        Thread.sleep(500);
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
                if(user.checkPoison()){
                    int upd = (int)(user.hp*.07);
                    if(upd < 3)
                    upd = 3;
                    System.out.println("You were hurt "+upd+" poison damage!");
                    user.hp-=upd;
                }
                if(user.checkBurn()){
                    System.out.println("You were hurt 10 burn damage!");
                    user.hp-=10;
                }
            } else{
                System.out.println("You are stunned! You can't attack!");
            }
            enemy.defending = false;
            if(enemy.hp > 0){
                if(!enemy.checkStun()){
                    int monsterChoice = (int)(Math.random()*100);
                    if(enemy.hp <= enemy.vit/2 && Math.random()*100 < 30 && (enemy.id == 0 || enemy.id == 1 || enemy.id == 2)){
                        monsterChoice = 0;
                    }
                    if(monsterChoice == 0){
                        System.out.println("The "+ enemy.name+" attempted to heal!");
                        int healVal = 0;
                        if(Math.random()*10 < 5){
                            System.out.println("It succeeded!");
                            healVal += 10;
                            healVal += (int)(Math.random()*5 + 1);
                            if(Math.random()*20 < 3){
                                System.out.println("The "+ enemy.name+" critically healed!");
                                healVal *= 2;
                            }
                            System.out.println("The "+ enemy.name+" healed for "+healVal+" health!\nIt now has "+(enemy.hp+healVal)+" health!");
                        } else {
                            System.out.println("But it failed!");
                        }
                        enemy.hp+=healVal;
                        System.out.println();
                    }
                    if(monsterChoice > 0 && monsterChoice <60){
                        System.out.println("The "+ enemy.name+" attacks you!");
                        int damage = enemy.attack(user);
                        if(damage > 0){
                            System.out.println("The "+enemy.name+" deals " + damage + " damage.");
                            user.hp -= damage;
                            if(user.hp < 0)
                                user.hp = 0;
                            System.out.println("You still have " + user.hp + " health.\n");
                        }
                        else{
                            System.out.println("The attack missed!\nYou still have "+user.hp+" health.\n");
                        }
                    }
                    else if(monsterChoice >=60 && monsterChoice <90){
                        System.out.println("The "+enemy.name+" is defending.\n");
                        enemy.defend();
                    }
                    else if(monsterChoice >=90){
                        System.out.println("The " +enemy.name +" does a special move!");
                        int damage = enemy.special(user);
                        if(damage > 0){
                            System.out.println("The "+enemy.name+"'s special move hits!");
                            System.out.println("It deals " + damage + " damage");
                            user.hp-=damage;
                            if(user.hp<0)
                                user.hp = 0;
                            System.out.println("You still have " + user.hp+ " health.\n");
                        }
                        else{
                            System.out.println("The "+enemy.name+"'s attack missed!");
                            System.out.println("You still have " + user.hp+" health");
                        }
                    }
                } else{
                    System.out.println("The "+enemy.name+" is stunned! It can't attack!");
                }
                if(enemy.checkPoison()){
                    int epd = (int)(enemy.hp*.07);
                    if(epd < 3)
                    epd = 3;
                    System.out.println("The "+enemy.name+" was hurt "+epd+" poison damage!");
                    enemy.hp-=epd;
                }
                if(enemy.checkBurn()){
                    System.out.println("The "+enemy.name+" was hurt 10 burn damage!");
                    enemy.hp-=10;
                }
            }
            user.defending = false;

            user.mana += user.manaReg;
            if(user.mana > user.maxMana)
                user.mana = user.maxMana;

            enemy.mana += enemy.manaReg;
            if(enemy.mana > enemy.maxMana)
                enemy.mana = enemy.maxMana;
            List<StatusEffect> toRemove = new ArrayList<StatusEffect>();
            for(int i = 0;i<user.seList.size(); i++){
                user.seList.get(i).duration--;
                if(user.seList.get(i).duration <= 0){
                    System.out.println("Your "+user.seList.get(i).stateName()+" has expired!");
                    if(user.seList.get(i).identifier == 4){
                        user.dex += 3;
                        user.acc += 5;
                        user.avoid += 5;
                    }
                    if(user.seList.get(i).identifier == 5){
                        user.crit -= 5;
                    }
                    if(user.seList.get(i).identifier == 6){
                        user.str -= 5;
                    }
                    if(user.seList.get(i).identifier == 7){
                        user.def -= 5;
                    }
                    if(user.seList.get(i).identifier == 8){
                        user.acc -= 20;
                    }
                    if(user.seList.get(i).identifier == 9){
                        user.avoid -= 20;
                    }
                    user.seList.remove(i);
                    i--;
                }
            }
            List<StatusEffect> toRemoveE = new ArrayList<StatusEffect>();
            for(int i = 0; i<enemy.seList.size();i++){
                enemy.seList.get(i).duration--;
                if(enemy.seList.get(i).duration <= 0){
                    System.out.println("The "+enemy.name+"'s "+enemy.seList.get(i).stateName()+" has expired!");
                    if(enemy.seList.get(i).identifier == 4){
                        enemy.dex += 3;
                        enemy.acc += 5;
                        enemy.avoid += 5;
                    }
                    if(enemy.seList.get(i).identifier == 5){
                        enemy.crit -= 5;
                    }
                    if(enemy.seList.get(i).identifier == 6){
                        enemy.str -= 5;
                    }
                    if(enemy.seList.get(i).identifier == 7){
                        enemy.def -= 5;
                    }
                    if(enemy.seList.get(i).identifier == 8){
                        enemy.acc -= 20;
                    }
                    if(enemy.seList.get(i).identifier == 9){
                        enemy.avoid -= 20;
                    }
                    enemy.seList.remove(i);
                    i--;
                }
            }
            userSpecCD--;
            if(userSpecCD < 0)
            userSpecCD = 0;
            
            enemySpecCD--;
            if(enemySpecCD < 0)
            enemySpecCD = 0;
        }
        if(user.hp <= 0){
            System.out.println("You died!");
            System.out.println("You lost " + user.exp/5 + " experience.\n");
            user.exp -= user.exp/5;
            user.hp = user.vit;
            try {
                Thread.sleep(500);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        else if(running){
            System.out.println("Coward.\n");
            try {
                Thread.sleep(500);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        else{
            System.out.println("You win!");
            System.out.println("You gain " + enemy.exp + " experience and " + enemy.gold + " gold.\n");
            user.exp += enemy.exp;
            user.gold += enemy.gold;
            if(enemy instanceof Boss)
            {
                if(enemy instanceof Teemo)
                    user.wizabon += enemy.wizabon;
                int wizloot = (int)(Math.random()*5);
                System.out.println("You got some Wizabons!" + wizloot + " Wizabons to be exact!");
                user.wizabon += wizloot;
            }
            else{
                int wizChance = (int)(Math.random()*100);
                if(wizChance <40){
                    System.out.println("You have got a Wizabon!");
                    user.wizabon += 1;
                }
            }
            if(user.checkEXP()){
                user.levelUp();
            }
            try {
                Thread.sleep(500);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}