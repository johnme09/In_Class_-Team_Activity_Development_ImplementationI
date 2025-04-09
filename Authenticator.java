import java.util.HashMap;
import java.util.Map;

public class Authenticator {
    private final Map<String, String> credentials;

    public Authenticator() {
        credentials = new HashMap<>();
    }

    public User getUserByEmail(String email) {
        return null;
    }

    public boolean authenticate(String email, String password) {
        return false;
    }

    public boolean hasAccess(User user) {
        return false;
    }

    private boolean verifyPassword(String password, String storedPassword) {
        return false;
    }
}