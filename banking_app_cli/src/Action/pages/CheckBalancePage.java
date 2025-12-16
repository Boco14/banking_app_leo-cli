package Action.pages;

import Action.UserDetails;

public class CheckBalancePage {

    public static void checkBalance(UserDetails user) {
        System.out.println("Name: " + user.getNAME().toUpperCase());
        System.out.println("Your current balance is: " + user.get_BALANCE());
    }
}
