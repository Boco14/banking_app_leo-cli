package Action.pages;
import java.util.Scanner;
import static Action.pages.CheckBalancePage.checkBalance;
import static Action.pages.display.UserDisplay.inputWarningDisplay;

public class PageController {
    private static final Scanner _SCAN = new Scanner(System.in);
    public static int pageController(){
        try{
            System.out.print("ENTER: ");
            int userChoice = _SCAN.nextInt();
            switch (userChoice) {
                case 1: checkBalance(); return 1;
                case 2: return 2;
                case 3: return 3;
                case 4: return 4;
                case 5: return 5;
                default:
                    System.out.print("CONFIRM, EXIT \nEnter y/n: ");
                    String repeat = _SCAN.next();
                    if(!repeat.equalsIgnoreCase("y")) return 1;
                    else return 0;
            }
        } catch (Exception InputMismatchException) {
            inputWarningDisplay();
            return 0;
        }
    }
}
