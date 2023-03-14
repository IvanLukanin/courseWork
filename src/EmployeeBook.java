import java.text.DecimalFormat;
import java.util.Arrays;

public class EmployeeBook {
    private final Employee[] employees;
    private static int idCounter;
    private int manOrWomen = randomNumGenerator(2);

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    @Override
    public String toString() {
        return "EmployeeOperaions{" +
                "employees=" + Arrays.toString(employees) + "\n" +
                ", idCounter=" + idCounter +
                '}';
    }

    public void addEmployee(String lastName, String middleName, String firstName, int salary, int department) {
        if (idCounter >= employees.length) {
            System.out.println("Нельзя добавить работника, закончилось место");
        }
        Employee newEmployee = new Employee(lastName, middleName, firstName, salary, department);
        employees[idCounter++] = newEmployee;
    }

    public void deleteEmployee(int id) throws Exception {
        for (int i = 0; i < idCounter; i++) {
            if (employees[i] == null) {
                throw new Exception("Чтобы кого-то удалить, сначала кого-то нужно добавить. Удалять некого.");
            }
            if (employees[i].getId() == id) {
                System.out.println(employees[i].getFirstName() + " " + employees[i].getMiddleName() + " " +
                        employees[i].getLastName() + " удален");
                System.arraycopy(employees, i + 1, employees, i, idCounter - i - 1);
                employees[idCounter - 1] = null;
                idCounter--;
                return;
            }
        }
    }

    public void changeEmployee(int idEmployee, int deptChanging, int salary) throws Exception {
        if (deptChanging > 5) {
            throw new Exception("Номер департамента не может быть больше 5");
        }
        for (int i = 0; i < idCounter; i++) {
            if (employees[i].getId() == idEmployee && deptChanging != -1 && salary != -1) {
                employees[i].setDept(deptChanging);
                employees[i].setSalary(salary);
            } else if (employees[i].getId() == idEmployee && deptChanging != -1) {
                employees[i].setDept(deptChanging);
            } else if (employees[i].getId() == idEmployee && salary != -1) {
                employees[i].setSalary(salary);
            }
        }
    }

    public void printAllEmployees() {
        for (int i = 0; i < idCounter; i++) {
            Employee employee = employees[i];
            printEmployeeInfo(employees[i]);
        }
    }

    public void printAllEmployeesWithoutDept() {
        for (int i = 0; i < idCounter; i++) {
            Employee employee = employees[i];
            System.out.println(employee.getLastName() + " " + employee.getMiddleName() + " " +
                    employee.getFirstName() + ": " + employee.getSalary() + ", id: " + employee.getId());
        }
    }

    public void printEmployeeAccordingToDept() {
        int[] arrDept = new int[idCounter];

        for (int i = 0; i < idCounter; i++) {
            arrDept[i] = employees[i].getDept();
        }
        System.out.println("Несортированный массив arrDept: " + Arrays.toString(arrDept));
        Arrays.sort(arrDept);
        System.out.println("Сортированный массив arrDept: " + Arrays.toString(arrDept));
        int arrElCounter = 1;

        for (int i = 0; i < idCounter - 1; i++) {
            if (arrDept[i] != arrDept[i + 1]) {
                arrElCounter++;
            }
        }

        int[] arrDeptUnic = new int[arrElCounter];

        arrElCounter = 0;
        System.out.println("Пустой массив arrDeptUnic: " + Arrays.toString(arrDeptUnic));
        for (int i = 0; i < idCounter - 1; i++) {
            if (arrDept[i] != arrDept[i + 1]) {
//                arrDeptUnic[arrElCounter]=arrDept[i];
                System.arraycopy(arrDept, i, arrDeptUnic, arrElCounter, 1);
                arrElCounter++;
            }
        }
        arrDeptUnic[arrElCounter] = arrDept[arrDept.length - 1];
        System.out.println("Заполненный массив arrDeptUnic: " + Arrays.toString(arrDeptUnic));

        for (int i = 0; i < arrDeptUnic.length; i++) {
            System.out.println();
            System.out.println("Отдел № " + arrDeptUnic[i] + ":");
            for (int j = 0; j < arrDept.length; j++) {
                if (employees[j].getDept() == arrDeptUnic[i]) {
                    System.out.println(" " + employees[j].getLastName() + " " +
                            employees[j].getMiddleName() + " " +
                            employees[j].getFirstName());
                }
            }
        }
    }

    public void salaryIndexing() {
        double percentOfIndexing = 3.5;
        for (int i = 0; i < idCounter; i++) {
            double increasedSalary = employees[i].getSalary() * (1 + percentOfIndexing / 100);
            employees[i].setSalary((int) increasedSalary);
        }
    }

    public static void printEmployeeInfo(Employee employee) {
        System.out.println("id: " + employee.getId() + ", полное имя: " +
                employee.getLastName() + " " + employee.getMiddleName() + " " +
                employee.getFirstName() + ", зарплата: " +
                new DecimalFormat("###,###.##").format(employee.getSalary()) +
                " рублей, " + " отдел: " + employee.getDept());
    }

    public void salaryLessThan(int lessThanThisNum) {
        int lessSalariesCounter = 0;
        for (int i = 0; i < idCounter; i++) {
            if (employees[i].getSalary() < lessThanThisNum) {
                printEmployeeInfo(employees[i]);
                lessSalariesCounter++;
            }
        }
        if (lessSalariesCounter == 0) {
            System.out.println("Сотрудников с зарплатой ниже " + lessThanThisNum + " рублей " + " - нет");
        }
    }

    public void salaryMoreThan(int moreThanThisNum) {
        int moreSalariesCounter = 0;
        for (int i = 0; i < idCounter; i++) {
            if (employees[i].getSalary() >= moreThanThisNum) {
                printEmployeeInfo(employees[i]);
                moreSalariesCounter++;
            }
        }
        if (moreSalariesCounter == 0) {
            System.out.println("Сотрудников с зарплатой выше " + moreThanThisNum + " рублей " + " - нет");
        }
    }

    public void salaryIndexingWithParam(double percentOfIndexing) {
        for (int i = 0; i < idCounter; i++) {
            double increasedSalary = employees[i].getSalary() * (1 + percentOfIndexing / 100);
            employees[i].setSalary((int) increasedSalary);
        }
    }

    public static int randomNumGenerator(int limitGeneration) {
        java.util.Random random = new java.util.Random();
        int randomNum = random.nextInt(limitGeneration);
        return randomNum;
    }

    public static String randomFirstNameGeneration(int manOrWomen) {
        String firstName = "";

        String[] firstMaleName = {"Евгений", "Иван", "Аркадий", "Никита", "Александр", "Пётр", "Михаил"};
        String[] firstFemaleName = {"Екатерина", "Марина", "Мария", "Дарья", "Мийя", "Ангелина", "Олеся"};


        if (manOrWomen == 0) {
            firstName = firstMaleName[randomNumGenerator(firstMaleName.length)];
        } else {
            firstName = firstFemaleName[randomNumGenerator(firstFemaleName.length)];
        }
        return firstName;
    }

    public static String randomMiddleNameGeneration(int manOrWomen) {
        String middleName = "";


        String[] middleMaleName = {"Сергеевич", "Иванович", "Александрович", "Дмитриевич", "Батькович", "Петрович",
                "Анатольевич"};
        String[] middleFemaleName = {"Сергеевна", "Иванова", "Александровна", "Дмитриевна", "Батькова", "Петровна",
                "Анатольевна"};


        if (manOrWomen == 0) {
            middleName = middleMaleName[randomNumGenerator(middleMaleName.length)];
        } else {
            middleName = middleFemaleName[randomNumGenerator(middleFemaleName.length)];
        }
        return middleName;
    }

    public static String randomLastNameGeneration(int manOrWomen) {
        String LastName = "";

        String[] lastMaleName = {"Высоцкий", "Васильев", "Фролов", "Альтергот", "Максимович", "Стрекаловский", "Казначеев"};
        String[] lastFemaleName = {"Высоцкая", "Васильева", "Фролова", "Альтергот", "Максимова", "Стрекаловская", "Казначеева"};

        if (manOrWomen == 0) {
            LastName = lastMaleName[randomNumGenerator(lastMaleName.length)];
        } else {
            LastName = lastFemaleName[randomNumGenerator(lastFemaleName.length)];
        }
        return LastName;
    }

    public int getManOrWomen() {
        return manOrWomen;
    }

    public int findEmployeesIdMinimalSalary() throws Exception {
        if (employees == null) {
            throw new Exception ("В базе отсутствуют сотрудники");
        }
        int min = employees[0].getSalary();
        int idEmployee = 0;
        for (int i = 0; i < idCounter; i++) {
            if (employees[i].getSalary() <= min) {
                min = employees[i].getSalary();
                idEmployee = employees[i].getId();
            }
        }
        return idEmployee;
    }

    public int findEmployeesIdMaximalSalary() {
        int max = employees[0].getSalary();
        int idEmployee = 0;
        for (int i = 0; i < idCounter; i++) {
            if (employees[i].getSalary() > max) {
                max = employees[i].getSalary();
                idEmployee = employees[i].getId();
            }
        }
        return idEmployee;
    }

    public void findAndPrintEmployeeById(int id) {
        for (int i = 0; i < idCounter; i++) {
            if (id == employees[i].getId()) {
                printEmployeeInfo(employees[i]);
            }
        }
    }

    public int monthSumSalary() {
        int sum = 0;
        for (int i = 0; i < idCounter; i++) {
            sum = employees[i].getSalary() + sum;
        }
        return sum;
    }

    public double monthMiddleSalary(int sum) {
        return (double) sum / idCounter;
    }

    public double middleSalaryById(int idOfEmployee) {
        int sumSalaries = 0;
        int deptsCounter = 0;
        for (int i = 0; i < idCounter; i++) {
            if (employees[i].getDept() == idOfEmployee) {
                sumSalaries = employees[i].getSalary() + sumSalaries;
                deptsCounter++;
            }
            if (sumSalaries == 0) {
                return -1;
            }
        }
        return (double) sumSalaries / deptsCounter;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public Employee[] getEmployees() {
        return employees;
    }
}
