package Action;

import static Action.pages.display.UserDisplay.inputWarningDisplay;
import static Action.pages.display.UserDisplay.lineBreakDisplay;
import java.util.Scanner;
public class LoginUser {
    private static final Scanner _SCAN = new Scanner(System.in);
    private static String email;
    private static int password;
    public static void userLoginPrompt() {
        System.out.println("Enter your credentials");
        System.out.print("Enter email: ");
        email = _SCAN.nextLine();
        while (true) {
            System.out.print("Enter pin: ");
            String pinInput = _SCAN.nextLine();
            try {
                password = Integer.parseInt(pinInput);
                break;
            } catch (NumberFormatException e) {
                inputWarningDisplay();
                System.out.println("-- Please enter a numeric PIN --");
            }
        }
        lineBreakDisplay();
    }
    public static String getEmailLogin() {
        return email;
    }
    public static int getPassword() {
        return password;
    }
}
