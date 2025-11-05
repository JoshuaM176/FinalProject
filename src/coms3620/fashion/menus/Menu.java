package coms3620.fashion.menus;

import java.util.ArrayList;
import java.util.List;
import coms3620.fashion.util.Stdin;

//This menu class represents a basic menu, it contains a list of options that will be ran when selected
//To make a submenu have a Menu that is also an option, and its run method should call its enter_menu method.
//See menus/marketing_and_sales/MarketingAndSales.java for an example of a submenu
public abstract class Menu {

    private final List<Option> options = new ArrayList<Option>();

    public void enter_menu() {
        while(true) {
            if(!selectOption()) {
                break;
            }
        }
    }

    private boolean selectOption() {
        System.out.println("0. Exit Menu");
        for(int i = 0; i < options.size(); i++) {
            System.out.println(Integer.toString(i+1) + ". " + options.get(i).getName());
        }
        int user_input;
        while(true) {
            user_input = Stdin.nextInt();
            if(user_input<0 || user_input > options.size()) {
                System.out.println("Invalid option, please enter a number from 0 to " + (options.size()-1) + ".");
            }
            else {
                break;
            }
        }
        if(user_input == 0) {
            return false;
        }
        options.get(user_input-1).run();
        return true;
    }

    public void addOption(Option option) {
        options.add(option);
    }
}
