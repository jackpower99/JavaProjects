public class Salesworker extends Employee {

    private double percentageOfSalaryBonus;

    public Salesworker(double hoursWorked, double hourlyRate, String firstName, String lastName, String email, double percentageOfSalaryBonus) {
        super(hoursWorked, hourlyRate, firstName, lastName, email);

        if(Utilities.validIntRange((int).00,(int).20,(int)percentageOfSalaryBonus)) {
            this.percentageOfSalaryBonus = percentageOfSalaryBonus;
        }

    }

    public double getPercentageOfSalaryBonus() {
        return percentageOfSalaryBonus;
    }

    public void setPercentageOfSalaryBonus(double percentageOfSalaryBonus) {
        if(Utilities.validIntRange((int).00,(int).20,(int)percentageOfSalaryBonus)) {
            this.percentageOfSalaryBonus = percentageOfSalaryBonus;
        }
    }

    @Override
    public double calculateSalary() {
        double salary = super.getSalary();
        double percentageBonus = salary*percentageOfSalaryBonus;
        return salary + percentageBonus;
    }

    @Override
    public String toString() {
        return "Salesworker{" +
                super.toString() +
                "percentageOfSalaryBonus=" + percentageOfSalaryBonus +
                '}';
    }
}
