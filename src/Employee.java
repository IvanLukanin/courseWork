public class Employee {
    private String firstName;
    private String middleName;
    private String lastName;
    private int salary;
    private int department;
    private int id;
    private static int idCounter;

    public Employee(String lastName, String middleName, String firstName, int salary, int department) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
        this.id = idCounter;
        idCounter++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDept() {
        return department;
    }

    public int getId() {
        return id;
    }

    public static int getIdCounter() {
        return idCounter;
    }


    public static void setIdCounter(int idCounter) {
        Employee.idCounter = idCounter;
    }

    public int getCounter() {
        return idCounter;
    }

    public int getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDept(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Имя: " + firstName + '\'' +
                " Отчество: " + middleName + '\'' +
                " Фамилия: " + lastName + '\'' +
                ", зарплата=" + salary +
                ", отдел=" + department +
                ", id=" + id +
                ", idCounter=" + idCounter +
                '}';
    }
}
