package motorph.utils;

import java.util.List;
import motorph.model.EmployeeDetails;
import motorph.model.EmployeeTimeLogs;
import motorph.repository.DataHandler;


public class EmployeeDataUtil {

    // Get all employees from CSV
    public static List<EmployeeDetails> getAllEmployees() {
        return DataHandler.readEmployeeDetails();
    }

    // Get all time logs from CSV
    public static List<EmployeeTimeLogs> getAllTimeLogs() {
        return DataHandler.readEmployeeTimeLogs();
    }

    // Get a specific employee by ID
    public static EmployeeDetails getEmployeeById(String empId) {
        return getAllEmployees()
            .stream()
            .filter(emp -> emp.getEmployeeNumber().equals(empId))
            .findFirst()
            .orElse(null);
    }

    // Get time logs for a specific employee
    public static List<EmployeeTimeLogs> getTimeLogsForEmployee(String empId) {
        return getAllTimeLogs()
            .stream()
            .filter(log -> log.getEmployeeNumber().equals(empId))
            .toList();
    }
}
