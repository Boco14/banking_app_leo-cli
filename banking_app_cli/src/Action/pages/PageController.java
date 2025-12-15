package Action.pages;

import static Action.pages.CheckBalancePage.checkBalance;
public class PageController {
    public static void pageController(int userChoice){
        switch (userChoice){
            case 1:
                checkBalance();
                break;
            case 2:
                System.out.println("Deposit Money");
                break;
            default:
                System.out.println("Exit page");
                break;
        }
    }
}
