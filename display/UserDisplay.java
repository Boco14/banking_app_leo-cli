package programming_challenge.banking_app_leo.display;

import java.util.Arrays;
import java.util.Scanner;

public class UserDisplay {
    private static final Scanner _SCAN = new Scanner(System.in);
    public static String loginDisplay(){
        String[] showDisplay = {
                "==========================================================================",
                "||                                  || Choose an action:                ||",
                "||        WELCOME TO LEO BANK       ||            [1] Admin             ||",
                "|| -- 10k mo gawin nating 10k ko -- ||            [2] Client            ||",
                "||                                  ||            [3] Exit              ||",
                "==========================================================================",
        };
        Arrays.stream(showDisplay).forEach(System.out::println);
        try{
            System.out.print("Enter: ");
            int userChoice = _SCAN.nextInt();
            return switch (userChoice) {
                case 1 -> "A";
                case 2 -> "C";
                default -> "";
            };
        }catch (Exception InputMismatchException){
            System.out.println("-- WRONG INPUT -- Please try again --");
            return "";
        }
    }
}
