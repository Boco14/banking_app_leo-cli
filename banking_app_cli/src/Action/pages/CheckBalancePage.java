package Action.pages;

public class CheckBalancePage {
    private static String name;
    private static int balance;
    public CheckBalancePage(String name, int balance){
        this.name = name;
        this.balance = balance;
    }
    public static void checkBalance(){
        System.out.println("Name: " + name.toUpperCase());
        System.out.println("Your current balance is: " + balance);
    }
}
