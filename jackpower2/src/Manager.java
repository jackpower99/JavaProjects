import java.util.ArrayList;

public class Manager extends Employee {

    //Had to create a no-args constructor for manager to solve error with xstream
    private Manager(){

    }


    private ArrayList<Employee> empInDepartment;

    public Manager(double hoursWorked, double hourlyRate, String firstName, String lastName, String email) {
        super(hoursWorked, hourlyRate, firstName, lastName, email);
        empInDepartment = new ArrayList<>();
    }

    public ArrayList<Employee> getEmpInDepartment() {
        return empInDepartment;
    }

    public void setEmpInDepartment(ArrayList<Employee> empInDepartment) {
        this.empInDepartment = empInDepartment;
    }

    @Override
    public double calculateSalary() {
        double total = 0;
       double managerSalary = super.getSalary();
       for( Employee employee : empInDepartment){
          double onePercent = employee.getSalary()*0.01;
           total = total+onePercent;
       }
       return managerSalary+total;
    }

    public void addEmpToDepartment(Employee employee){
        empInDepartment.add(employee);
    }

    public boolean removeEmpFromDepartment(int index){
        if(empInDepartment.size()>index&&Utilities.validIntNonNegative(index)){
            empInDepartment.remove(index);
            return true;
        }
        else {
            return false;
        }
    }

    public int empInDepartmentSize(){
        return empInDepartment.size();
    }

    @Override
    public String toString() {
        return "Manager{" +
                super.toString() +
                ", empInDepartment=" + empInDepartment +
                '}';
    }
}
