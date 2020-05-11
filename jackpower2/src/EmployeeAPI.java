import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeAPI {

    private ArrayList<Employee> employees;

    private Manager manager;

    public EmployeeAPI() {
        employees = new ArrayList<Employee>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public ArrayList<Employee> listManagerEmployeesList() {
        ArrayList<Employee> temp = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                temp.add(employee);
            }
        }
        return temp;
    }

    public Employee removeEmployee(String nameFirst) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(nameFirst)) {
                employees.remove(employee);
                return employee;
            }
        }
        return null;
    }

    public boolean addEmployeeToDepartment(int employeeIndex, int managerIndex) {
        if (Utilities.validIndex(employeeIndex, employees) && Utilities.validIntNonNegative(employeeIndex) && Utilities.validIndex(managerIndex, listManagerEmployeesList()) && Utilities.validIntNonNegative(managerIndex)) {
            Employee employee = employees.get(employeeIndex);

            ArrayList<Employee> managers = listManagerEmployeesList();
            Manager manager = (Manager) managers.get(managerIndex);

            manager.addEmpToDepartment(employee);

            return true;
        } else return false;
    }

    public Employee getEmployee(int index) {
        if (Utilities.validIndex(index, employees) && Utilities.validIntNonNegative(index)) {
            return employees.get(index);
        } else return null;
    }

    public Employee removeEmployee(int index) {
        if (Utilities.validIndex(index, employees) && Utilities.validIntNonNegative(index)) {
            return employees.remove(index);
        } else return null;
    }

    public int numberOfEmployees() {
        return employees.size();
    }

    public String listEmployees() {
        String listEmployees = "";
        for (int i = 0; i < employees.size(); i++) {
            listEmployees = listEmployees + i + ": " + employees.get(i) + "\n";
        }
        return listEmployees;
    }

    public String listManagerEmployees() {
        ArrayList<Employee> temp = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                temp.add(employee);
            }
        }
        String listOfManagers = "";
        for (int i = 0; i < temp.size(); i++) {
            listOfManagers = listOfManagers + i + ": " + temp.get(i) + "\n";
        }
        return listOfManagers;
    }

    public String listManagerEmployees(Manager manager) {
        ArrayList<Employee> temp = new ArrayList<>();

        temp = manager.getEmpInDepartment();

        String listOfEmployeesInDepartment = "";
        for (int i = 0; i < temp.size(); i++) {
            listOfEmployeesInDepartment = listOfEmployeesInDepartment + i + ": " + temp.get(i) + "\n";
        }
        return listOfEmployeesInDepartment;
    }

    public ArrayList<Employee> searchEmployees(String string) {

        ArrayList<Employee> temp = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getLastName().equalsIgnoreCase(string)) {
                temp.add(employee);
            }
        }
        return temp;
    }

    public double totalSalariesOwed() {
        double total = 0;

        for (Employee employee : employees) {
            total = total + employee.calculateSalary();
        }
//            if (employee instanceof Manager) {
//                total = total +  employee.calculateSalary();
//            }
//            else if(employee instanceof Salesworker){
//                total = total +  employee.calculateSalary();
//            }
//            else if(employee instanceof Adminworker){
//                total = total +  employee.calculateSalary();
//            }
//        }
        return total;
    }

    public double avgSalariesOwed() {
        double totalSalaries = totalSalariesOwed();

        return totalSalaries / employees.size();
    }

    public Employee employeeWithHighestPay() {
        ArrayList<Double> salaries = new ArrayList<>();


        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                salaries.add(employee.calculateSalary());
            } else if (employee instanceof Salesworker) {
                salaries.add(employee.calculateSalary());
            } else if (employee instanceof Adminworker) {
                salaries.add(employee.calculateSalary());
            }
        }
        double highestPay = Collections.max(salaries);

        for (Employee employee : employees) {
            if (employee.calculateSalary() == highestPay) {
                return employee;
            }
        }
        return null;
    }

    public void sortEmployeesByFirstName() {
        employees.sort(Comparator.comparing(Employee::getFirstName));
    }

    public void sortEmployeesByLastName() {
        employees.sort(Comparator.comparing(Employee::getLastName));
    }

    public void sortEmployeesByHourlyRate() {
        employees.sort(Comparator.comparingDouble(Employee::getHourlyRate));
    }

    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("employees.xml"));
        employees = (ArrayList<Employee>) is.readObject();
        is.close();
    }

    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("employees.xml"));
        out.writeObject(employees);
        out.close();
    }
}











