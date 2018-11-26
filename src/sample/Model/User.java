package sample.Model;

public class User {

    //user's email
    private String email;

    //user's password
    private String password;

    //user's type (Admin, User, Location Employee)
    private String type;

    //Is user account locked?
    private boolean locked;


    /**
     * Gets user's password
     * @return password user's password
     */
    public String getPassword() {return password; }

    /**
     * Sets user's password
     * @param password user's password
     */
    public void setPassword(String password) { this.password = password; }

    /**
     * Gets user's email
     * @return user's email
     */
    public String getEmail() { return email; }
    /**
     * Sets user's email
     * @param email user's email
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * Gets user's account type
     * @return user's account type
     */
    public String getType() { return type; }
    /**
     * Sets user's account type
     * @param type user's account type
     */
    public void setType(String type) { this.type = type; }

    /**
     * Gets boolean checking if account is locked or not
     * @return true if account is locked
     */
    public boolean isAccountLocked() { return locked; }
    /**
     * Sets if locked or not
     * @param locked if locked
     */
    public void setAccountLocked(boolean locked) { this.locked = locked; }

    /**
     * Constructor for user provided with only email and password
     * @param email user's email
     * @param password user's password
     */
    public User(String email, String password) {
        this(email, password, "");
    }

    /**
     * User construct for user given email, password, type, and locked
     * @param email user's email
     * @param password user's password
     * @param type user's type
     */
    public User(String email, String password, String type) {
        this.email = email;
        this.password = password;
        this.type = type;
        this.locked = false;
    }

    /**
     * Equals method for checking if two users are equal
     * @return if equals
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return this.email.equals(user.getEmail()) && this.password.equals(user.getPassword());
    }

    /**
     * Hashing for user based on email and password
     * @return user's hashcode
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = (37 * result) + ((email == null) ? 0 : email.hashCode());
        result = (37 * result) + (((password == null) ? 0 : password.hashCode()));
        return result;
    }
}
