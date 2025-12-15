package Action;

import static Action.display.UserDisplay.loginDisplay;

public class Index {
    public static void index() {
        LocalDatabase localDatabase = new LocalDatabase();
        localDatabase.users(loginDisplay());
    }
}
