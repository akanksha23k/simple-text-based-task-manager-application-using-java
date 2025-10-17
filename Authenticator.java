package com.jap.task;

import java.util.ArrayList;
import java.util.List;

public class Authenticator {
    private List<User> users;
    private User authenticatedUser;

    public Authenticator() {
        users = new ArrayList<User>();
        // Predefined users (must match test cases!)
        users.add(new User("John", "pass1"));
        users.add(new User("Alice", "abcd"));
        users.add(new User("Bob", "pass2"));
    }

    public boolean authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                authenticatedUser = user;
                return true;
            }
        }
        return false;
    }

    public User getAuthenticatedUser() {
        return authenticatedUser;
    }
}
