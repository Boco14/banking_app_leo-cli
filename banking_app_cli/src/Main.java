import static display.UserDisplay.loginDisplay;

public class Main {
    public static void main(String[] args) {
        LocalDatabase localDatabase = new LocalDatabase();
        localDatabase.users(loginDisplay());
    }
}