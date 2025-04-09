import java.util.HashMap;
import java.util.Map;

public class Authenticator {
    private final Map<String, User> credentials;

    public Authenticator() {
        credentials = new HashMap<>();
    }

    //Authenticates the user by checking if the email and password are correct
    //Returns the user if authentication is successful, null otherwise
    public User authenticate(String email, String password) {
        User user = getUserByEmail(email);
        if (user == null) {
            return null; // User not found
        }
        if(verifyPassword(password, user.getHashedPassword())) {
            return user; // Authentication successful
        } else {
            return null; // Password mismatch
        }
    }

    //Checks if the user entered password equals the stored password
    private boolean verifyPassword(String password, String storedPassword) {
        String userInputHash = Integer.toHexString(password.hashCode());
        return userInputHash.equals(storedPassword);
    }
    
    //Returns a user from the credentials map using the email as the key
    private  User getUserByEmail(String email) {
        return credentials.get(email);
    }
}