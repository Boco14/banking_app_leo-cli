package Action;

import Action.pages.CheckBalancePage;
import org.jetbrains.annotations.NotNull;

import java.util.*;

import static Action.pages.CheckBalancePage.checkBalance;
import static Action.pages.PageController.pageController;
import static Action.pages.display.UserDisplay.*;

public class LocalDatabase {
    private static final Scanner _SCAN = new Scanner(System.in);
    public static void users(String userAction) {
    // Data sets of type users
    ArrayList<UserType> users = new ArrayList<>();
        users.add(new UserType("Admin", new ArrayList<UserDetails>(){{
            add(new UserDetails("Admin1", "admin1@gmail.com", 432432, 0));
            add(new UserDetails("Admin2", "admin2@gmail.com", 432432, 0));
        }}));
        users.add(new UserType("Client", new ArrayList<UserDetails>() {{
            add(new UserDetails("Leo", "leo@gmail.com", 12345, 100_000));
            add(new UserDetails("John", "john@gmail.com", 657856, 1_300_000));
            add(new UserDetails("Jane", "jane@gmail.com", 657234, 900_000));
            add(new UserDetails("Doe", "doe@gmail.com", 987654, 750_000));
            add(new UserDetails("Alice", "alice@gmail.com", 112233, 500_000));
            add(new UserDetails("Bob", "bob@gmail.com", 223344, 1_100_000));
            add(new UserDetails("Charlie", "charlie@gmail.com", 334455, 650_000));
            add(new UserDetails("Diana", "diana@gmail.com", 445566, 1_450_000));
            add(new UserDetails("Eve", "eve@gmail.com", 556677, 300_000));
            add(new UserDetails("Frank", "frank@gmail.com", 667788, 850_000));
        }}));

        // User input assignment
        LoginUser.userLoginPrompt();
        String inputEmail = LoginUser.getEmailLogin();
        int inputPin = LoginUser.getPassword();

        // This the login validator
        Optional<UserDetails> loggedInUser =
                users.stream()
                        .flatMap(userType -> userType.getUSER_LIST().stream())
                        .filter(user ->
                                user.getEMAIL().equals(inputEmail) &&
                                        user.getPIN() == inputPin
                        )
                        .findFirst();

        // This the page controller
        if (loggedInUser.isPresent()) {
            UserDetails user = loggedInUser.get();
            System.out.println("Login successful!");
            System.out.println("Welcome, " + user.getNAME().toUpperCase());
            System.out.println("Current balance: " + user.get_BALANCE());
            boolean repeat = true;
            while (repeat){
                authenticatedDisplay();
                try{
                    System.out.print("ENTER: ");
                    int userChoice = _SCAN.nextInt();
                    switch (userChoice) {
                        case 1:
                            lineBreakDisplay();
                            CheckBalancePage checkBalancePage = new CheckBalancePage(user.getNAME(), user.get_BALANCE());
                            checkBalance();
                            break;
                        case 2:
                            lineBreakDisplay();
                            System.out.println("Option 2");
                            break;
                        case 3:
                            lineBreakDisplay();
                            System.out.println("Option 3");
                            break;
                        case 4:
                            lineBreakDisplay();
                            System.out.println("Option 4");
                            break;
                        case 5:
                            lineBreakDisplay();
                            System.out.println("Option 5");
                            break;
                        default:
                            lineBreakDisplay();
                            System.out.print("CONFIRM, EXIT \nEnter y/n: ");
                            String askRepeat = _SCAN.next();
                            if(!askRepeat.equalsIgnoreCase("y")) repeat = true;
                            else repeat = false;
                    }
                } catch (Exception InputMismatchException) {
                    inputWarningDisplay();
                }
            }
        } else {
            System.out.println("Invalid email or PIN");
        }

        /*String u = users.stream()
                .filter(userType -> userType.getUSER_TYPE().startsWith(userAction))
                .flatMap(userType -> userType.getUSER_LIST().stream())
                .sorted()
                .map(Action.UserDetails::getNAME)
                .collect(Collectors.joining(", "));
        System.out.println(u);*/
    }
}

// User details object
class UserDetails implements Comparable<UserDetails>{
    private final String _NAME;
    private final String _EMAIL;
    private final int _PIN;
    private final Integer _BALANCE;
    UserDetails(final String _NAME, final String _EMAIL, final int _PIN, final Integer _BALANCE){
        this._NAME = _NAME;
        this._EMAIL = _EMAIL;
        this._PIN = _PIN;
        this._BALANCE = _BALANCE;
    }
    public String getNAME() { return _NAME; }
    public String getEMAIL() { return _EMAIL; }
    public int getPIN() { return _PIN; }
    public int get_BALANCE() { return _BALANCE; }

    public int compareTo(@NotNull UserDetails o) {
        return this.getNAME().compareTo(o.getNAME());
    }
}

// User type object
class UserType{
    private final String _USER_TYPE;
    private final ArrayList<UserDetails> _USER_LIST;
    UserType(final String _USER_TYPE, final ArrayList<UserDetails> _USER_LIST){
        this._USER_TYPE = _USER_TYPE;
        this._USER_LIST = _USER_LIST;
    }
    public String getUSER_TYPE() { return _USER_TYPE; }
    public ArrayList<UserDetails> getUSER_LIST() { return _USER_LIST; }
}


