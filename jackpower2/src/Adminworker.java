public class Adminworker extends Employee  {


    private double fixedBonus;

    public Adminworker(double hoursWorked, double hourlyRate, String firstName, String lastName, String email, double fixedBonus) {
        super(hoursWorked, hourlyRate, firstName, lastName, email);

        if(Utilities.validIntNonNegative((int)fixedBonus)) {
            this.fixedBonus = fixedBonus;
        }
    }

    public double getFixedBonus() {
        return fixedBonus;
    }

    public void setFixedBonus(double fixedBonus) {
        if (Utilities.validIntNonNegative((int) fixedBonus)) {
            this.fixedBonus = fixedBonus;
        }
    }

    @Override
    public double calculateSalary() {
        double salary = super.getSalary();
        return salary + fixedBonus;
    }

    @Override
    public String toString() {
        return "Adminworker{" +
                super.toString() +
                "fixedBonus=" + fixedBonus +
                '}';
    }
}
