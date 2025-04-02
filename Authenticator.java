import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Authenticator {
    private static final String FILE_PATH = "users.txt";
    private final Map<String, String> credentials;

    public Authenticator() {
        credentials = new HashMap<>();
        loadUsers();
    }

    public boolean registerUser(String username, String password) {
        if(credentials.containsKey(username)) {
            System.out.println("User already exists.");
            return false;
        } 
        String hashedPassword = hashPassword(password);
        credentials.put(username, hashedPassword);
        saveUsers();
        return true;
    }

    public boolean authenticate(String username, String password) {
        return credentials.containsKey(username) && credentials.get(username).equals(hashPassword(password));
    }

    private void loadUsers() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    credentials.put(parts[0], parts[1]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("User file not found. A new one will be created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUsers() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Map.Entry<String, String> entry : credentials.entrySet()) {
                bw.write(entry.getKey() + ":" + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
}