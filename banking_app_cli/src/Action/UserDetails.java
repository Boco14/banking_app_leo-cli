package Action;

public class UserDetails implements Comparable<UserDetails> {
    private String _NAME;
    private String _EMAIL;
    private int _PIN;
    private Integer _BALANCE;
    UserDetails(String name, String email, int pin, Integer balance) {
        this._NAME = name;
        this._EMAIL = email;
        this._PIN = pin;
        this._BALANCE = balance;
    }
    public String getNAME() { return _NAME; }
    public String getEMAIL() { return _EMAIL; }
    public int getPIN() { return _PIN; }
    public int get_BALANCE() { return _BALANCE; }
    // setters
    public void setNAME(String name) { this._NAME = name; }
    public void setEMAIL(String email) { this._EMAIL = email; }
    public void setPIN(int pin) { this._PIN = pin; }
    // balance operations
    public void addBalance(int amount) { this._BALANCE += amount; }
    public void deductBalance(int amount) { this._BALANCE -= amount; }
    @Override
    public int compareTo(UserDetails o) {
        return this.getNAME().compareTo(o.getNAME());
    }
}
