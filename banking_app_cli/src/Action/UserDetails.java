package Action;

import org.jetbrains.annotations.NotNull;

// User details object
public class UserDetails implements Comparable<UserDetails>{
    private final String _NAME;
    private final String _EMAIL;
    private final int _PIN;
    private int _BALANCE;
    UserDetails(final String _NAME, final String _EMAIL, final int _PIN, int _BALANCE){
        this._NAME = _NAME;
        this._EMAIL = _EMAIL;
        this._PIN = _PIN;
        this._BALANCE = _BALANCE;
    }
    public String getNAME() { return _NAME; }
    public String getEMAIL() { return _EMAIL; }
    public int getPIN() { return _PIN; }
    public int get_BALANCE() { return _BALANCE; }

    public void deductBalance(int amount) {
        this._BALANCE -= amount;
    }

    public void addBalance(int amount) {
        this._BALANCE += amount;
    }


    public int compareTo(@NotNull UserDetails o) {
        return this.getNAME().compareTo(o.getNAME());
    }
}

