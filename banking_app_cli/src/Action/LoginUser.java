package Action;

import static Action.pages.display.UserDisplay.inputWarningDisplay;
import static Action.pages.display.UserDisplay.lineBreakDisplay;

import java.util.Scanner;

public class LoginUser {
    private static final Scanner _SCAN = new Scanner(System.in);
    private static  String email;
    private static int password;
    public static void userLoginPrompt(){
        System.out.println("Enter correct credentials");
        System.out.print("Enter email: ");
        email = _SCAN.nextLine();
        try{
            System.out.print("Enter pin: ");
            password = _SCAN.nextInt();
            lineBreakDisplay();
        }catch (Exception InputMismatchException){
            inputWarningDisplay();
            lineBreakDisplay();
        }
    }
    public static String getEmailLogin(){
        return email;
    }
    public static int getPassword() {
        return password;
    }
}
