package Action;

import static Action.pages.display.UserDisplay.inputWarningDisplay;
import static Action.pages.display.UserDisplay.lineBreakDisplay;

import java.util.Scanner;

public class LoginUser {
    private static final Scanner _SCAN = new Scanner(System.in);
    private static  String email = "leo@gmail.com";
    private static int password = 12345;
    public static void userLoginPrompt(){
        System.out.println("Enter your credentials");
        System.out.println("Enter email: leo@gmail.com");
        /*email = _SCAN.nextLine();*/
        try{
            System.out.println("Enter pin: 12345");
            /*password = _SCAN.nextInt();*/
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
