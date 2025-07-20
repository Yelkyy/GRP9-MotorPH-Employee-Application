package motorph.utils;

import motorph.model.User;
import java.io.*;
import java.nio.file.*;

public class UserAuthentication {

    public static User authenticate(String email, String password) {
        Path filePath = Paths.get("resources", "MotorPH Users.csv");

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            reader.readLine(); // skip header

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 5) {
                    String csvUsername = parts[0].trim();
                    String csvPassword = parts[1].replaceAll("[\\r\\n]+", "").trim();
                    String firstName = parts[2].trim();
                    String lastName = parts[3].trim();
                    String role = parts[4].trim();
                    String employeeId = parts[5].trim();


                    boolean usernameMatch = csvUsername.equalsIgnoreCase(email.trim());
                    boolean passwordMatch = csvPassword.equals(password.trim());

                    if (usernameMatch && passwordMatch) {
                        System.out.println("MATCH FOUND: " + firstName);
                        return new User(csvUsername, firstName, lastName, role, employeeId);
                    }
                } 
            }

        } catch (IOException e) {
            System.err.println("❌ Error reading users.csv: " + e.getMessage());
        }

        System.out.println("❌ No match found.");
        return null;
    }
}

