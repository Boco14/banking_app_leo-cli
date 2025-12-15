package Action;

import static Action.pages.display.UserDisplay.loginDisplay;

public class Index {
    public static void index() {
        LocalDatabase localDatabase = new LocalDatabase();
        localDatabase.users(loginDisplay());
    }
}
