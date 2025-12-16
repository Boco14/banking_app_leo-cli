package Action.pages;

import java.util.Scanner;

public class WithdrawMoney {
    private static final Scanner SCAN = new Scanner(System.in);

    public static int withdrawMoney() {
        System.out.print("Enter amount to withdraw: ");
        return SCAN.nextInt();
    }
}
