import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    private Scanner input = new Scanner(System.in);
    private EmployeeAPI employeeAPI;


    public Driver() {
        input = new Scanner(System.in);
        employeeAPI = new EmployeeAPI();
    }

    public static void main(String[] args) throws Exception {
        Driver app = new Driver();
        app.run();
    }

    public ArrayList<Employee> getEmployees() {
        return employeeAPI.getEmployees();
    }

    private int mainMenu() {
        System.out.println("1) Add an Employee (Manager)");
        System.out.println("2) List employees");
        System.out.println("3) Add an Employee (Sales worker)");
        System.out.println("4) Add an Employee (Admin worker)");
        System.out.println("5) Add an existing employee to a department");
        System.out.println("6) Delete an Employee");
        System.out.println("------------------------------------------------------");
        System.out.println("7) Find total salaries owed to all employee");
        System.out.println("8) Find average salaries owed to all employee");
        System.out.println("9) Print employee with highest pay");
        System.out.println("------------------------------------------------------");
        System.out.println("10) List all employees in ascending alphabetical order (first name)");
        System.out.println("11) List all employees in ascending alphabetical order (last name)");
        System.out.println("12) List all employees in ascending alphabetical order (hourly rate)");
        System.out.println("------------------------------------------------------");
        System.out.println("13) Search System for employee by second name ");
        System.out.println("14) Search system for employee within a given manager's department");
        System.out.println("------------------------------------------------------");
        System.out.println("15)  Save");
        System.out.println("16)  Load");
        System.out.println("------------------------------------------------------");
        System.out.println("0) Exit");
        return input.nextInt();
    }

    private void run() throws Exception {
        {
            int option = mainMenu();
            while (option != 0) {

                switch (option) {
                    case 1:
                        addManager();
                        break;
                    case 2:
                        System.out.println(listEmployees());
                        break;
                    case 3:
                        addSalesworker();
                        break;
                    case 4:
                        addAdminworker();
                        break;
                    case 5:
                        addEmpToManager();
                        break;
                    case 6:
                        deleteEmployee();
                        break;
                    case 7:
                        totalSalaries();
                        break;
                    case 8:
                        avgSalaries();
                        break;
                    case 9:
                        highestEarner();
                    case 10:
                        sortByFirstName();
                        break;
                    case 11:
                        sortByLastName();
                        break;
                    case 12:
                        sortByHourlyRate();
                        break;
                    case 13:
                        searchBySecondName();
                        break;
                    case 14:
                        searchByDepartment();
                        break;
                    case 15:
                        employeeAPI.save();
                        break;
                    case 16:
                        employeeAPI.load();
                }
                System.out.println("\nPress any key to continue...");
                input.nextLine();

                //display the main menu again
                option = mainMenu();
            }


        }
        //the user chose option 0, so exit the program
        System.out.println("Exiting... bye");
        System.exit(0);
    }

    private void sortByHourlyRate() {
        employeeAPI.sortEmployeesByHourlyRate();
        System.out.println(listEmployees());
    }

    private void sortByLastName() {
        employeeAPI.sortEmployeesByLastName();
        System.out.println(listEmployees());
    }

    private void sortByFirstName() {
        employeeAPI.sortEmployeesByFirstName();
        System.out.println(listEmployees());
    }

    private void highestEarner() {
        System.out.println(employeeAPI.employeeWithHighestPay().toString());
    }

    private void avgSalaries() {
        System.out.println(employeeAPI.avgSalariesOwed());
    }

    private void totalSalaries(){
        System.out.println(employeeAPI.totalSalariesOwed());
    }

    private void searchByDepartment() {
        ArrayList<Employee> returned = new ArrayList<>();

        System.out.println("Enter the department you wish to see the employees of: Manager/Salesworker/Adminworker: ");
        input.nextLine();
        String department = input.nextLine();


        if (department.equalsIgnoreCase("manager")) {

            for (Employee employee : employeeAPI.getEmployees()) {
                if (employee instanceof Manager) {
                    returned.add(employee);
                }
            }
            if (!returned.isEmpty()) {
                String returnedEmployees = "";
                for (int i = 0; i < returned.size(); i++) {
                    returnedEmployees = returnedEmployees + i + ": " + returned.get(i) + "\n";
                }
                System.out.println(returnedEmployees);
            } else {
                System.out.println("There are no employees in this department");
            }

        } else if (department.equalsIgnoreCase("salesworker")) {

            for (Employee employee : employeeAPI.getEmployees()) {
                if (employee instanceof Salesworker) {
                    returned.add(employee);
                }
            }
            if (!returned.isEmpty()) {
                String returnedEmployees = "";
                for (int i = 0; i < returned.size(); i++) {
                    returnedEmployees = returnedEmployees + i + ": " + returned.get(i) + "\n";
                }
                System.out.println(returnedEmployees);
            } else {
                System.out.println("There are no employees in this department");
            }

        } else if (department.equalsIgnoreCase("adminworker")) {
            for (Employee employee : employeeAPI.getEmployees()) {
                if (employee instanceof Adminworker) {
                    returned.add(employee);
                }
            }

            if (!returned.isEmpty()) {
                String returnedEmployees = "";
                for (int i = 0; i < returned.size(); i++) {
                    returnedEmployees = returnedEmployees + i + ": " + returned.get(i) + "\n";
                }
                System.out.println(returnedEmployees);
            } else {
                System.out.println("There are no employees in this department");
            }

        } else {
            System.out.println("Enter a valid department");
            searchByDepartment();
        }
    }

    private void searchBySecondName() {

        System.out.println("Enter the second name of employee your searching for: ");
        input.nextLine();
        String lastName = input.nextLine();

        ArrayList<Employee> temp = employeeAPI.searchEmployees(lastName);
        if (temp.isEmpty()) {
            System.out.println("There are no employees with this last name. ");
            searchBySecondName();
        } else {
            String returnedEmployees = "";
            for (int i = 0; i < temp.size(); i++) {
                returnedEmployees = returnedEmployees + i + ": " + temp.get(i) + "\n";
            }
            System.out.println(returnedEmployees);
        }
    }

    private void deleteEmployee() {
        System.out.println(listEmployees());
        System.out.println("Enter the first name of the employee you want to remove from the system: ");
        input.nextLine();
        String firstName = input.nextLine();
        input.nextLine();

        if(employeeAPI.removeEmployee(firstName) == null){
            System.out.println("Not a valid first name choose from list below. ");
            deleteEmployee();
        }
        else {
            employeeAPI.removeEmployee(firstName);
            System.out.println("Employee removed from the system");
        }

    }

    private void addEmpToManager() {

        System.out.println(employeeAPI.listManagerEmployees());
        System.out.println("Enter index of Manager you wish to add an employee to: ");
        int indexManager = input.nextInt();
        System.out.println(employeeAPI.listEmployees());
        System.out.println("Enter index of employee you wish to add to department: ");
        int indexEmployee = input.nextInt();

        //if (Utilities.validIndex(indexManager, employeeAPI.listManagerEmployeesList()) && Utilities.validIndex(indexEmployee, employeeAPI.getEmployees())) {
        if (employeeAPI.addEmployeeToDepartment(indexEmployee, indexManager)) {
            System.out.println("Employee Added to Department");
        } else {
            System.out.println("Error adding employee to department. Choose a valid index: ");
            addEmpToManager();
        }
    }

    private void addAdminworker() {
        double hoursWorked = 0;
        double payRate = 0;
        String first_Name = "";
        String last_Name = "";
        String email_ = "";
        double bonus_ = 0;


        System.out.println("Enter the Amount of Hours the Admin worker works: ");
        input.nextLine();
        String hours = input.nextLine();

        if(Utilities.validIntNonNegative(Integer.parseInt(hours))){
            hoursWorked = Double.parseDouble(hours);
        }
        else {
            System.out.println("Invalid number, number must be a positive number.");
        }
        System.out.println("Enter the hourly rate of the admin worker: (Minimum = 9.80) ");
        double rate = input.nextDouble();
        if(Utilities.validIntNonNegative((int)(rate)) && rate > 9.80){
            payRate = rate;
        }
        else {
            System.out.println("Enter a valid number which is above 9.80.");
        }
        System.out.println("Enter the First name of the Admin worker: ");
        input.nextLine();
        String firstName = input.nextLine();
        if(Utilities.isLetters(firstName)){
            first_Name = firstName;
        }
        else {
            System.out.println("Enter letters only for this field.");
        }
        System.out.println("Enter the Last name of the Admin worker: ");
        String lastName = input.nextLine();
        if(Utilities.isLetters(lastName)){
            last_Name = lastName;
        }
        else {
            System.out.println("Enter letters only for this field.");
        }
        System.out.println("Enter the Email address of the Admin worker: ");
        String email = input.nextLine();
        if(Utilities.validEmail(email)){
            email_ = email;
        }
        else {
            System.out.println("Enter valid email address.");
        }
        System.out.println("Enter Bonus amount: (Cannot be a negative) : ");
        double bonus = input.nextDouble();
        if(Utilities.validIntNonNegative((int) bonus)){
            bonus_ = bonus;
        }

        employeeAPI.addEmployee(new Adminworker(hoursWorked,payRate,first_Name,last_Name,email_,bonus_));

    }

    private void addSalesworker() {
        double hoursWorked = 0;
        double payRate = 0;
        String first_Name = "";
        String last_Name = "";
        String email_ = "";
        double bonus;


        System.out.println("Enter the Amount of Hours the Sales worker works: ");
        input.nextLine();
        String hours = input.nextLine();

        if(Utilities.validIntNonNegative(Integer.parseInt(hours))){
            hoursWorked = Double.parseDouble(hours);
        }
        else {
            System.out.println("Invalid number, number must be a positive number.");
        }
        System.out.println("Enter the hourly rate of the sales worker: (Minimum = 9.80) ");
        double rate = input.nextDouble();
        if(Utilities.validIntNonNegative((int)(rate)) && rate > 9.80){
            payRate = rate;
        }
        else {
            System.out.println("Enter a valid number which is above 9.80.");
        }
        System.out.println("Enter the First name of the Sales worker: ");
        input.nextLine();
        String firstName = input.nextLine();
        if(Utilities.isLetters(firstName)){
            first_Name = firstName;
        }
        else {
            System.out.println("Enter letters only for this field.");
        }
        System.out.println("Enter the Last name of the Sales worker: ");
        String lastName = input.nextLine();
        if(Utilities.isLetters(lastName)){
            last_Name = lastName;
        }
        else {
            System.out.println("Enter letters only for this field.");
        }
        System.out.println("Enter the Email address of the Sales worker: ");
        String email = input.nextLine();
        if(Utilities.validEmail(email)){
            email_ = email;
        }
        else {
            System.out.println("Enter valid email address.");
        }

        System.out.println("Enter Bonus amount: (between 0.00 and 0.20) : ");
        bonus = input.nextDouble();


        employeeAPI.addEmployee(new Salesworker(hoursWorked,payRate,first_Name,last_Name,email_,bonus));


    }


    public void addManager() {

        double hoursWorked = 0;
        double payRate = 0;
        String first_Name = "";
        String last_Name = "";
        String email_ = "";


        System.out.println("Enter the Amount of Hours the Manager works: ");
        input.nextLine();
        String hours = input.nextLine();

        if(Utilities.validIntNonNegative(Integer.parseInt(hours))){
             hoursWorked = Double.parseDouble(hours);
        }
        else {
            System.out.println("Invalid number, number must be a positive number.");
        }
        System.out.println("Enter the hourly rate of the manager: (Minimum = 9.80) ");
        double rate = input.nextDouble();
        if(Utilities.validIntNonNegative((int) rate) && (int) rate > 9.80){
             payRate = rate;
        }
        else {
            System.out.println("Enter a valid number which is above 9.80.");
        }
        System.out.println("Enter the First name of the Manager: ");
        input.nextLine();
        String firstName = input.nextLine();
        if(Utilities.isLetters(firstName)){
            first_Name = firstName;
        }
        else {
            System.out.println("Enter letters only for this field.");
        }
        System.out.println("Enter the Last name of the Manager: ");
        last_Name = input.nextLine();

        System.out.println("Enter the Email address of the Manager: ");
        String email = input.nextLine();
        if(Utilities.validEmail(email)){
            email_ = email;
        }
        else {
            System.out.println("Enter valid email address.");
        }

        employeeAPI.addEmployee(new Manager(hoursWorked,payRate,first_Name,last_Name,email_));



    }

    public String listEmployees(){
        if (employeeAPI.getEmployees().size() == 0) {
            return "No employees";
        } else {
            String listOfEmp = "";
            for (int i = 0; i < employeeAPI.getEmployees().size(); i++) {
                listOfEmp = listOfEmp + i + ": " + employeeAPI.getEmployees().get(i) + "\n";
            }
            return listOfEmp;
        }
    }

}
