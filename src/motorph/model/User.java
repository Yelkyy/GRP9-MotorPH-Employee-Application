package motorph.model;

public class User {
    private String username;
    private String firstName;
    private String lastName;
    private String role;
    private String employeeId;

    public User(String username, String firstName, String lastName, String role, String employeeId) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getRole() {
        return role;
    }
    
    public String getEmployeeId() {
        return employeeId;
    }

    public boolean isHR() {
        return "HR".equalsIgnoreCase(role);
    }

    public boolean isEmployee() {
        return "Employee".equalsIgnoreCase(role);
    }
    
    public boolean isAdmin() {
        return "Admin".equalsIgnoreCase(this.role);
    }

}
