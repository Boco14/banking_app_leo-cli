package programming_challenge.banking_app_leo;

import static programming_challenge.banking_app_leo.display.UserDisplay.loginDisplay;

public class Main {
    public static void main(String[] args) {
        LocalDatabase localDatabase = new LocalDatabase();
        localDatabase.users(loginDisplay());
    }
}
