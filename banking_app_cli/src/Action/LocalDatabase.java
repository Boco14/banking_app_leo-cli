package Action;

import Action.pages.CheckBalancePage;
import Action.pages.DepositMoneyPage;
import Action.pages.WithdrawMoneyPage;
import Action.pages.UpdateProfilePage;

import java.util.*;

import static Action.pages.display.UserDisplay.*;

public class LocalDatabase {

    private static final Scanner _SCAN = new Scanner(System.in);

    public static void users(String userAction) {

        // ================= USERS DATA (PERSISTENT) =================
        ArrayList<UserType> users = new ArrayList<>();

        users.add(new UserType("Admin", new ArrayList<UserDetails>() {{
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

        // ================= LOGIN LOOP =================
        while (true) {

            LoginUser.userLoginPrompt();
            String inputEmail = LoginUser.getEmailLogin();
            int inputPin = LoginUser.getPassword();

            Optional<UserDetails> loggedInUser =
                    users.stream()
                            .flatMap(userType -> userType.getUSER_LIST().stream())
                            .filter(user ->
                                    user.getEMAIL().equals(inputEmail) &&
                                            user.getPIN() == inputPin
                            )
                            .findFirst();

            if (loggedInUser.isEmpty()) {
                System.out.println("Invalid email or PIN.\n");
                continue;
            }

            UserDetails user = loggedInUser.get();

            System.out.println("\nLogin successful!");
            System.out.println("Welcome, " + user.getNAME().toUpperCase());
            System.out.println("Current balance: " + user.get_BALANCE());
            System.out.println();

            // ================= AUTHENTICATED MENU =================
            boolean isLoggedIn = true;

            while (isLoggedIn) {
                authenticatedDisplay();

                try {
                    System.out.print("ENTER: ");
                    int userChoice = _SCAN.nextInt();

                    switch (userChoice) {

                        case 1:
                            // Check balance
                            lineBreakDisplay();
                            CheckBalancePage.checkBalance(user);
                            break;

                        case 2:
                            // Deposit
                            lineBreakDisplay();
                            int depositAmount = DepositMoneyPage.depositMoney();

                            if (depositAmount <= 0) {
                                System.out.println("Invalid deposit amount.");
                                break;
                            }

                            user.addBalance(depositAmount);
                            System.out.println("Deposited: " + depositAmount);
                            System.out.println("New balance: " + user.get_BALANCE());
                            break;

                        case 3:
                            // Withdraw
                            lineBreakDisplay();
                            int withdrawAmount = WithdrawMoneyPage.withdrawMoney();

                            if (withdrawAmount <= 0) {
                                System.out.println("Invalid withdraw amount.");
                                break;
                            }

                            if (withdrawAmount > user.get_BALANCE()) {
                                System.out.println("Insufficient balance.");
                                break;
                            }

                            user.deductBalance(withdrawAmount);
                            System.out.println("Withdrawn: " + withdrawAmount);
                            System.out.println("New balance: " + user.get_BALANCE());
                            break;

                        case 4:
                            // Transfer
                            lineBreakDisplay();
                            transferMoney(user, users);
                            break;

                        case 5:
                            // Update profile
                            lineBreakDisplay();
                            UpdateProfilePage.updateProfile(user);
                            break;

                        case 6:
                            // LOGOUT
                            logoutDisplay();
                            System.out.print("ENTER: ");
                            try{
                                int logout = _SCAN.nextInt();
                                switch (logout){
                                    case 1:
                                        System.out.println("You have been logged out.\n");
                                        isLoggedIn = false;
                                        break;

                                    case 2:
                                        System.out.println("Program terminated. Goodbye!");
                                        lineBreakDisplay();
                                        System.exit(0);

                                    default:
                                        isLoggedIn = true;
                                        break;
                                }
                            }catch (Exception InputMismatchException){
                                inputWarningDisplay();
                            }
                            break;

                        default:
                            System.out.println("Invalid option.");
                    }

                } catch (InputMismatchException e) {
                    inputWarningDisplay();
                    _SCAN.nextLine();
                }
            }
        }
    }

    // ================= TRANSFER METHOD =================
    public static void transferMoney(UserDetails sender, ArrayList<UserType> users) {

        System.out.print("Enter receiver email: ");
        String receiverEmail = _SCAN.next();

        if (sender.getEMAIL().equalsIgnoreCase(receiverEmail)) {
            System.out.println("You cannot send money to yourself.");
            return;
        }

        Optional<UserDetails> receiverOpt =
                users.stream()
                        .flatMap(userType -> userType.getUSER_LIST().stream())
                        .filter(u -> u.getEMAIL().equalsIgnoreCase(receiverEmail))
                        .findFirst();

        if (receiverOpt.isEmpty()) {
            System.out.println("Receiver not found.");
            return;
        }

        UserDetails receiver = receiverOpt.get();

        System.out.print("Enter amount to send: ");
        int amount = _SCAN.nextInt();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (sender.get_BALANCE() < amount) {
            System.out.println("Insufficient balance.");
            return;
        }

        sender.deductBalance(amount);
        receiver.addBalance(amount);

        System.out.println("Transfer successful!");
        System.out.println("Sent to: " + receiver.getNAME());
        System.out.println("New balance: " + sender.get_BALANCE());
    }
}
