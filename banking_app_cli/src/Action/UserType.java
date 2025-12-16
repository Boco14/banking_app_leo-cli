package Action;

import java.util.ArrayList;

// User type object
public class UserType{
    private final String _USER_TYPE;
    private final ArrayList<UserDetails> _USER_LIST;
    UserType(final String _USER_TYPE, final ArrayList<UserDetails> _USER_LIST){
        this._USER_TYPE = _USER_TYPE;
        this._USER_LIST = _USER_LIST;
    }
    public String getUSER_TYPE() { return _USER_TYPE; }
    public ArrayList<UserDetails> getUSER_LIST() { return _USER_LIST; }
}