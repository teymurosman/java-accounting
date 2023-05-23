import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfMonths = 3;
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                for (int i = 1; i <= numOfMonths; i++) { // Считываем мес. отчёты методом, дополняя путь переменной итерирование i
                    monthlyReport.loadFile(i,"resources/m.20210" + i + ".csv");
                }
                System.out.println("Месячные отчёты успешно считаны");
            } else if (userInput == 2) {
                yearlyReport.loadFile("resources/y.2021.csv"); // Считываем годовой отчёт
                System.out.println("Годовой отчёт успешно считан");
            } else if (userInput == 3) {
                if (monthlyReport.itemsOfMonths.isEmpty() || yearlyReport.yearOfMonths.isEmpty()) {
                    System.out.println("Необходимо сначала считать месячные и годовой отчёты");
                } else {
                    Checker.findMistake(numOfMonths, monthlyReport, yearlyReport); // Сверка отчетов
                }
            } else if (userInput == 4) {
                if (monthlyReport.itemsOfMonths.isEmpty()) {
                    System.out.println("Необходимо сначала считать месячные отчёты");
                } else {
                    for (Integer i : monthlyReport.itemsOfMonths.keySet()) {
                        System.out.println(i + "-й месяц:");
                        monthlyReport.findMaxExpenseAndIncome(i); // Выводим макс расходы и доходы по месяцам
                    }
                }
            } else if (userInput == 5) {
                if (yearlyReport.yearOfMonths.isEmpty()) { // Проверка такая же, как для месячного
                    System.out.println("Необходимо сначала считать годовой отчёт");
                } else {
                    System.out.println("Рассматриваемый год: 2021");
                    yearlyReport.getProfitByMonths(); // Выводим прибыли по месяцам
                    System.out.println("Средний расход за все операции в году составил: " + yearlyReport.findAvgExpense());
                    System.out.println("Средний доход за все операции в году составил: " + yearlyReport.findAvgIncome());
                }
            } else if (userInput == 13579) { // Код для завершения программы
                break;
            } else {
                System.out.println("Извините, такой команды нет. Выберите команду из предложенного списка:");
            }
        }
    }

    static void printMenu() {
        System.out.println("------------------------------------------------");
        System.out.println("Что Вы хотите сделать?");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию обо всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("13579 - Завершить работу");
        System.out.println("------------------------------------------------");
    }
}

