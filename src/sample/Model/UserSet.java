package sample.Model;

import java.util.HashSet;
import java.util.Set;

public class UserSet {
    /** Singleton instance */
    private static final UserSet _instance = new UserSet();
    public static UserSet getInstance() { return _instance; }

    private Set<User> users;

    /**
     * make a new model
     */
    private UserSet() {
        users = new HashSet<>();
    }

    /**
     *
     * @return the set of users stored in our app
     */
    public Set<User> getUsers() { return users; }

    /**
     * add a user to the app.  checks if the user is already entered
     *
     * uses O(n) linear search for user
     *
     * @param user  the user to be added
     * @return true if added, false if a duplicate
     */
    public boolean addUser(User user) {
        if (users.contains(user)) {
            return false;
        }
        users.add(user);
        return true;
    }
}
