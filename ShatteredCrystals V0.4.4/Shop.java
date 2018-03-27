/**
 * A shiny new SHOP! Hope this works...
 * Justin Goodberry & Michael Lee
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop{
    public void main(Player user, ArrayList<Armor> avArm, ArrayList<Sword> avWep, ArrayList<Staffs> avStaff, boolean secretShop){
        boolean done = false;
        Scanner ui = new Scanner(System.in);
        if(!secretShop)
            System.out.println("\n-=-Welcome to the shop!-=-\nYou can buy and sell items here."+
                "\nWhat would you like to do?\n(Type 'help' for assistance)\nYou have "+user.gold+" gold.");
        else
            System.out.println("\n-=-Welcome to the secret shop!-=-\nYou can buy and sell items here."+
                "\nWhat would you like to do?\n(Type 'help' for assistance)\nYou have "+user.gold+" gold.");
        while(!done){
            String userIn = ui.nextLine();
            switch(userIn){
                case "help":
                System.out.println("Please type in 'buy' to buy items, 'exit' to leave,\n'sell' to sell items, or 'help' for help.");
                break;

                case "buy":
                boolean doneBuying = false;
                while(!doneBuying){
                    System.out.println("What would you like to buy? Please type a number.");
                    System.out.println("0: Done shopping\n1: Weapons\n2: Armor\n3: Staffs\n4: Robes\n5: Potions");
                    int buyChoice = ui.nextInt();
                    switch(buyChoice){
                        case 0:
                        System.out.println("Well, glad to help!");
                        doneBuying = true;
                        break;

                        case 1:
                        boolean doneBuyingWeapons = false;
                        while(!doneBuyingWeapons){
                            System.out.println("What weapon would you like to buy?\nHere's our inventory!\nPlease type in a valid number.\n");
                            System.out.println("0: Done buying weapons");
                            int current = 1;
                            for(Sword s: avWep){
                                System.out.println(current+": "+s.name+" - "+s.stateBuy());
                                current++;
                            }
                            int wepChoice = ui.nextInt();
                            if(wepChoice == 0){
                                System.out.println("Well, that's too bad!");
                                doneBuyingWeapons = true;
                            } else { 
                                wepChoice--;
                                System.out.println("You chose the "+avWep.get(wepChoice).name+", priced at "+avWep.get(wepChoice).stateBuy()+".");
                                if(user.gold >= avWep.get(wepChoice).buyValue){
                                    boolean undecided = true;
                                    while(undecided){
                                        System.out.println("You can afford this! Are you sure you would like to buy this? [y/n]");
                                        String st = ui.nextLine();
                                        switch(st){
                                            case "help":
                                            System.out.println("Please input 'y', 'n', or 'help'.");
                                            break;

                                            case "y":
                                            System.out.println("You decided to buy the "+avWep.get(wepChoice).name+"!");
                                            user.inv.add(avWep.get(wepChoice));
                                            user.gold -= avWep.get(wepChoice).buyValue;
                                            System.out.println("You have "+user.gold+" gold left.");
                                            undecided = false;
                                            break;

                                            case "n":
                                            System.out.println("You decided not to buy the "+avWep.get(wepChoice).name+". Bummer!");
                                            undecided = false;
                                            break;

                                            default:
                                            System.out.println("Oops! Please only input 'y', 'n', or 'help'.");
                                            break;
                                        }
                                    }

                                } else{
                                    System.out.println("But you don't have the gold for that!");
                                }
                            }
                        }
                        break;
                        case 2:
                        boolean doneBuyingArmor = false;
                        while(!doneBuyingArmor){
                            System.out.println("What armor would you like to buy?\nHere's our inventory!\nPlease type in a valid number.\n");
                            System.out.println("0: Done buying armor");
                            int current = 1;
                            for(Armor s: avArm){
                                System.out.println(current+": "+s.name+" - "+s.stateBuy());
                                current++;
                            }
                            int armChoice = ui.nextInt();
                            if(armChoice == 0){
                                System.out.println("Well, that's too bad!");
                                doneBuyingArmor = true;
                            } else { 
                                armChoice--;
                                System.out.println("You chose the "+avArm.get(armChoice).name+", priced at "+avArm.get(armChoice).stateBuy()+".");
                                if(user.gold >= avArm.get(armChoice).buyValue){
                                    boolean undecided = true;
                                    while(undecided){
                                        System.out.println("You can afford this! Are you sure you would like to buy this? [y/n]");
                                        String st = ui.nextLine();
                                        switch(st){
                                            case "help":
                                            System.out.println("Please input 'y', 'n', or 'help'.");
                                            break;

                                            case "y":
                                            System.out.println("You decided to buy the "+avArm.get(armChoice).name+"!");
                                            user.inv.add(avArm.get(armChoice));
                                            user.gold -= avArm.get(armChoice).buyValue;
                                            System.out.println("You have "+user.gold+" gold left.");
                                            undecided = false;
                                            break;

                                            case "n":
                                            System.out.println("You decided not to buy the "+avArm.get(armChoice).name+". Bummer!");
                                            undecided = false;
                                            break;

                                            default:
                                            System.out.println("Oops! Please only input 'y', 'n', or 'help'.");
                                            break;
                                        }
                                    }

                                } else{
                                    System.out.println("But you don't have the gold for that!");
                                }
                            }
                        }
                        break;
                        case 3:
                        boolean doneBuyingStaff = false;
                        while(!doneBuyingStaff){
                            System.out.println("What Staff would you like to buy?\nHere's our inventory!\nPlease type in a valid number.\n");
                            System.out.println("0: Done buying weapons");
                            int current = 1;
                            for(Staffs s: avStaff){
                                System.out.println(current+": "+s.name+" - "+s.stateBuy());
                                current++;
                            }
                            int wepChoice = ui.nextInt();
                            if(wepChoice == 0){
                                System.out.println("Well, that's too bad!");
                                doneBuyingStaff = true;
                            } else { 
                                wepChoice--;
                                System.out.println("You chose the "+avStaff.get(wepChoice).name+", priced at "+avStaff.get(wepChoice).stateBuy()+".");
                                if(user.gold >= avStaff.get(wepChoice).buyValue){
                                    boolean undecided = true;
                                    while(undecided){
                                        System.out.println("You can afford this! Are you sure you would like to buy this? [y/n]");
                                        String st = ui.nextLine();
                                        switch(st){
                                            case "help":
                                            System.out.println("Please input 'y', 'n', or 'help'.");
                                            break;

                                            case "y":
                                            System.out.println("You decided to buy the "+avStaff.get(wepChoice).name+"!");
                                            user.inv.add(avStaff.get(wepChoice));
                                            user.gold -= avStaff.get(wepChoice).buyValue;
                                            System.out.println("You have "+user.gold+" gold left.");
                                            undecided = false;
                                            break;

                                            case "n":
                                            System.out.println("You decided not to buy the "+avStaff.get(wepChoice).name+". Bummer!");
                                            undecided = false;
                                            break;

                                            default:
                                            System.out.println("Oops! Please only input 'y', 'n', or 'help'.");
                                            break;
                                        }
                                    }

                                } else{
                                    System.out.println("But you don't have the gold for that!");
                                }
                            }
                        }
                        break;

                        case 4:
                        break;

                        case 5:
                        boolean potionsDecided = false;
                        while(!potionsDecided){
                            System.out.println("Potions cost 50 gold each. You have "+user.gold+" gold.");
                            System.out.println("How many potions would you like?");
                            System.out.println("Type 0 to leave.");
                            int potionsDesired = ui.nextInt();
                            if(potionsDesired == 0){
                                System.out.println("You decide not to buy potions.");
                                potionsDecided = true;
                            }
                            else if(user.gold >= (potionsDesired*50)){
                                System.out.println("You purchased "+potionsDesired+" potions!");
                                user.gold -= (potionsDesired*50);
                                user.potionsOwned += potionsDesired;
                                potionsDecided = true;
                            }else{
                                System.out.println("You can't afford that!");
                            }
                        }
                        break;

                        default:
                        System.out.println("Please input 0 to quit, 1 to buy weapons,\n2 to buy armor, or 3 to buy potions.");
                        break;
                    }
                }
                break;

                case "sell":
                boolean doneSelling = false;
                while(!doneSelling){
                    System.out.println("What would you like to sell?\nPlease type in a number.\n0: done selling");
                    int currentS = 1;
                    for(Item i : user.inv){
                        System.out.println(currentS+": "+i.name+" - "+i.stateSell());
                        currentS++;
                    }
                    int choice = ui.nextInt();
                    if(choice == 0){
                        doneSelling = true;
                        System.out.println("You decided not to sell anything.");
                    } else if(choice > user.inv.size()){
                        System.out.println("That item doesn't exist!");
                    } else{
                        choice--;
                        boolean decidedSS = false;
                        while(!decidedSS){
                            System.out.println("Are you sure you would like to sell your "+user.inv.get(choice).name+" for "+user.inv.get(choice).stateSell()+"? [y/n]");
                            String sellChoice = ui.nextLine();
                            switch(sellChoice){
                                case "help":
                                System.out.println("Please input 'help', 'y' for yes, or 'n' for no.");
                                break;

                                case "y":
                                System.out.println("You decided to sell your "+user.inv.get(choice).name+".");
                                user.gold += user.inv.get(choice).sellValue;
                                user.inv.remove(choice);
                                decidedSS = true;
                                System.out.println("You have "+user.gold+" gold.");
                                break;

                                case "n":
                                System.out.println("You decided not to sell the item.");
                                decidedSS = true;
                                break;

                                default:
                                System.out.println("Please input 'help', 'y', or 'n'.");
                                break;
                            }
                        }
                    }
                }
                break;

                case "exit":
                System.out.println("Bye! Hope you enjoyed!");
                done = true;
                break;

                default:
                System.out.println("Oops! Please type in a valid option.\n(Type 'help' for assistance)");
                break;
            }
        }
    }
}