import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws Exception {
        EmployeeBook eo = new EmployeeBook();

        for (int i = 0; i < eo.getEmployees().length; i++) {
            eo.addEmployee(EmployeeBook.randomLastNameGeneration(eo.getManOrWomen()),
                    EmployeeBook.randomFirstNameGeneration(eo.getManOrWomen()),
                    EmployeeBook.randomMiddleNameGeneration(eo.getManOrWomen()),
                    EmployeeBook.randomNumGenerator(50_000) + 70_000,
                    EmployeeBook.randomNumGenerator(6));
        }



        System.out.println(eo.toString().toString());


        System.out.println("Месячная сумма затрат на зарплаты");
        System.out.println(new DecimalFormat("###,###").format(eo.monthSumSalary()) + " pублей");
        System.out.println();


        System.out.println("Сотрудник с минимальной зарплатой");
        eo.findAndPrintEmployeeById(eo.findEmployeesIdMinimalSalary());
        System.out.println();


        System.out.println("Сотрудник с максимальной зарплатой");
        eo.findAndPrintEmployeeById(eo.findEmployeesIdMaximalSalary());
        System.out.println();


        System.out.println("Среднее значение зарплат");
        System.out.println(new DecimalFormat("###,###.##").
                format(eo.monthMiddleSalary(eo.monthSumSalary())) + " pублей");
        System.out.println();


        System.out.println("ФИО всех сотрудников");
        eo.printAllEmployees();
        System.out.println();


        System.out.println("Индексация зарплаты на стандартную величину 3,5%");
        eo.salaryIndexing();
        eo.printAllEmployees();
        System.out.println();


        System.out.println("Индексация зарплаты на заданную величину");
        eo.salaryIndexingWithParam(12.6);
        eo.printAllEmployees();
        System.out.println();


        System.out.println("Средняя зарплата по отделу");
        if (eo.middleSalaryById(1) != -1) {
            System.out.println(new DecimalFormat("###,###.##").
                    format(eo.middleSalaryById(1)) + " рублей");
        }else {
            System.out.println("Отдела с таким номером не существует. Введите другой номер.");
        }
        System.out.println();


        System.out.println("Все сотрудники без отделов");
        eo.printAllEmployeesWithoutDept();
        System.out.println();


        System.out.println("Все сотрудники с зарплатой меньше определенного числа");
        eo.salaryLessThan(110_000);
        System.out.println();


        System.out.println("Все сотрудники с зарплатой выше определенного числа");
        eo.salaryMoreThan(110_000);
        System.out.println();


        System.out.println("Исходный список сотрудников");
        eo.printAllEmployees();
        eo.changeEmployee(1, 5, -1);
        System.out.println();
        System.out.println("Изменяем отдел");
        eo.printAllEmployees();
        System.out.println();
        System.out.println("Изменяем зарплату");
        eo.changeEmployee(1, -1, 60_000);
        eo.printAllEmployees();
        System.out.println();


        System.out.println("Список отделов и сотрудников принадлежащих этим отделам");
        eo.printEmployeeAccordingToDept();

    }
}