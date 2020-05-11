public abstract class Employee {

    private double hoursWorked;
    private double hourlyRate;
    private static double NORMAL_WORKWEEK= 35;
    private static double MIN_WAGE = 9.80;
    private String firstName;
    private String lastName;
    private String email;

    public Employee(double hoursWorked, double hourlyRate, String firstName, String lastName, String email) {
        if (Utilities.validIntNonNegative((int) hoursWorked)) {
            this.hoursWorked = hoursWorked;
        }
        if (Utilities.validIntRange((int) 9.80, 1000, (int) hourlyRate)) {
            this.hourlyRate = hourlyRate;
        }
        this.firstName = Utilities.max30Chars(firstName);

        this.lastName = Utilities.max30Chars(lastName);

        if (Utilities.validEmail(email)) {
            this.email = email;
        }
    }

    protected Employee() {
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public static double getNormalWorkweek() {
        return NORMAL_WORKWEEK;
    }

    public static double getMinWage() {
        return MIN_WAGE;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setHoursWorked(double hoursWorked) {
        if (Utilities.validIntNonNegative((int) hoursWorked)) {
            this.hoursWorked = hoursWorked;
        }
    }

    public void setHourlyRate(double hourlyRate) {
        if (Utilities.validIntRange((int) 9.80, 1000, (int) hourlyRate)) {
            this.hourlyRate = hourlyRate;
        }
    }

    public static void setNormalWorkweek(double normalWorkweek) {
        if (Utilities.validIntNonNegative((int) normalWorkweek))
            NORMAL_WORKWEEK = normalWorkweek;
    }

    public static void setMinWage(double minWage) {
        MIN_WAGE = minWage;
    }

    public void setFirstName(String firstName) {
        this.firstName = Utilities.max30Chars(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = Utilities.max30Chars(lastName);
    }

    public void setEmail(String email) {
        if (Utilities.validEmail(email)) {
            this.email = email;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "hoursWorked=" + hoursWorked +
                ", hourlyRate=" + hourlyRate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public double getOverTime() {
        if (hoursWorked <= NORMAL_WORKWEEK) {
            return 0;
        } else {
            double hours = hoursWorked - NORMAL_WORKWEEK;
            return hours * hourlyRate * 2;
        }
    }

    public double getSalary() {
        double hoursUnder;
        if (hoursWorked >= NORMAL_WORKWEEK) {
            hoursUnder = NORMAL_WORKWEEK;
        } else {
            hoursUnder = hoursWorked;
        }
         return hoursUnder*hourlyRate + getOverTime();
    }

    public abstract double calculateSalary();
}
