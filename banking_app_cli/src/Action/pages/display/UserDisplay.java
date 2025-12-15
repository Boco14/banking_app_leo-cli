package Action.pages.display;

import java.util.Arrays;
import java.util.Scanner;

public class UserDisplay {
    private static final Scanner _SCAN = new Scanner(System.in);
    public static String loginDisplay(){
        String[] showDisplay = {
                "==========================================================================",
                "||                                  || Choose an action:                ||",
                "||        WELCOME TO LEO BANK       ||        [1] Admin Login           ||",
                "|| -- 10k mo gawin nating 10k ko -- ||        [2] Client Login          ||",
                "||                                  ||        [3] Exit                  ||",
                "==========================================================================",
        };
        Arrays.stream(showDisplay).forEach(System.out::println);
        try{
            System.out.print("ENTER: ");
            int userChoice = _SCAN.nextInt();
            lineBreakDisplay();
            return switch (userChoice) {
                case 1 -> "A";
                case 2 -> "C";
                default -> "";
            };
        }catch (Exception InputMismatchException){
            inputWarningDisplay();
            return "";
        }
    }
    public static void lineBreakDisplay(){
        System.out.println("==========================================================================");
    }
    public static void inputWarningDisplay(){
        System.out.println("-- WRONG INPUT -- Please try again --");
    }
    public static int authenticatedDisplay(){
        String[] showDisplay = {
                "==========================================================================",
                "|| Choose an action:                                                    ||",
                "||     [1] Check balance                                                ||",
                "||     [2] Deposit Money                                                ||",
                "||     [3] Withdraw Money                                               ||",
                "||     [4] Transfer Money                                               ||",
                "||     [5] Profile                                                      ||",
                "||     [6] Exit                                                         ||",
                "==========================================================================",
        };
        Arrays.stream(showDisplay).forEach(System.out::println);
        try{
            System.out.print("Enter: ");
            int userChoice = _SCAN.nextInt();
            lineBreakDisplay();
            return switch (userChoice) {
                case 1 -> 1;
                case 2 -> 2;
                case 3 -> 3;
                case 4 -> 4;
                case 5 -> 5;
                default -> 0;
            };
        } catch (Exception InputMismatchException) {
            inputWarningDisplay();
            return 0;
        }
    }
}
