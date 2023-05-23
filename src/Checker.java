public class Checker {

    public static void findMistake(int numOfMonths, MonthlyReport monthlyReport, YearlyReport yearlyReport) {
        for (int m = 1; m <= numOfMonths; m++) {
            boolean isExpenseEqual = monthlyReport.findMonthExpense(m) == yearlyReport.yearOfMonths.get(m).expense;
            boolean isIncomeEqual = monthlyReport.findMonthIncome(m) == yearlyReport.yearOfMonths.get(m).income;
            if (isExpenseEqual && isIncomeEqual) {
                System.out.println("Несоответсвий не обнаружено. Месячный отчёт за месяц " + m + " сходится с годовым отчётом");
            } else {
                System.out.println("Обнаружено несоответствие за месяц " + m);
                System.out.println("Расход за месяц " + m + " из месячного отчёта: " + monthlyReport.findMonthExpense(m));
                System.out.println("Расход за месяц " + m + " из годового отчёта: " + yearlyReport.yearOfMonths.get(m).expense);
                System.out.println("Доход за месяц " + m + " из месячного отчёта: " + monthlyReport.findMonthIncome(m));
                System.out.println("Доход за месяц " + m + " из годового отчёта: " + yearlyReport.yearOfMonths.get(m).income);
            }
        }
    }
}
