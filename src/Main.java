import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws Exception {
        EmployeeBook a = new EmployeeBook();

        for (int i = 0; i < a.getEmployees().length; i++) {
            a.addEmployee(EmployeeBook.randomLastNameGeneration(a.getManOrWomen()),
                    EmployeeBook.randomFirstNameGeneration(a.getManOrWomen()),
                    EmployeeBook.randomMiddleNameGeneration(a.getManOrWomen()),
                    EmployeeBook.randomNumGenerator(50_000) + 70_000,
                    EmployeeBook.randomNumGenerator(6));
        }

        System.out.println(a.toString().toString());

        System.out.println("Месячная сумма затрат на зарплаты");
        System.out.println(new DecimalFormat("###,###").format(a.monthSumSalary()) + " pублей");
        System.out.println();

        System.out.println("Сотрудник с минимальной зарплатой");
        a.findAndPrintEmployeeById(a.findEmployeesIdMinimalSalary());
        System.out.println();


        System.out.println("Сотрудник с максимальной зарплатой");
        a.findAndPrintEmployeeById(a.findEmployeesIdMaximalSalary());
        System.out.println();


        System.out.println("Среднее значение зарплат");
        System.out.println(new DecimalFormat("###,###.##").
                format(a.monthMiddleSalary(a.monthSumSalary())) + " pублей");
        System.out.println();


        System.out.println("Ф.И.О всех сотрудников");
        a.printAllEmployees();
        System.out.println();


        System.out.println("Индексация зарплаты на стандартную величину 3,5%");
        a.salaryIndexing();
        a.printAllEmployees();
        System.out.println();


        System.out.println("Индексация зарплаты на заданную величину");
        a.salaryIndexingWithParam(12.6);
        a.printAllEmployees();
        System.out.println();


        System.out.println("Средняя зарплата по отделу");
        if (a.middleDepartSalary(1) != -1) {
            System.out.println(new DecimalFormat("###,###.##").
                    format(a.middleDepartSalary(1)) + " рублей");
        }else {
            System.out.println("Отдела с таким номером не существует. Введите другой номер.");
        }
        System.out.println();

        System.out.println("Все сотрудники без отделов");
        a.printAllEmployeesWithoutDept();
        System.out.println();

        System.out.println("Все сотрудники с зарплатой меньше определенного числа");
        a.salaryLessThan(110_000);
        System.out.println();

        System.out.println("Все сотрудники с зарплатой выше определенного числа");
        a.salaryMoreThan(110_000);
        System.out.println();

        System.out.println("Исходный список сотрудников");
        a.printAllEmployees();
        a.changeEmployee(1, 5, -1);
        System.out.println();
        System.out.println("Изменяем отдел");
        a.printAllEmployees();
        System.out.println();
        System.out.println("Изменяем зарплату");
        a.changeEmployee(1, -1, 60_000);
        a.printAllEmployees();
        System.out.println();

        System.out.println("Список отделов и сотрудников принадлежащих этим отделам");
        a.printEmployeeAccordingToDept();
    }
}