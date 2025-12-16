package Action.pages;

import java.util.Scanner;

public class DepositMoneyPage {
    private static final Scanner _SCAN = new Scanner(System.in);

    public static int depositMoney() {
        System.out.print("Enter amount: ");
        return _SCAN.nextInt();
    }
}
