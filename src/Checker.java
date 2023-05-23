public class Checker {

    public static void findMistake(int numOfMonths, MonthlyReport monthlyReport, YearlyReport yearlyReport) {
        for (int m = 1; m <= numOfMonths; m++) {
            boolean isExpenseEqual = monthlyReport.findMonthTotal(m, true) == yearlyReport.yearOfMonths.get(m).expense;
            boolean isIncomeEqual = monthlyReport.findMonthTotal(m, false) == yearlyReport.yearOfMonths.get(m).income;
            if (isExpenseEqual && isIncomeEqual) {
                System.out.println("Несоответсвий не обнаружено. Месячный отчёт за месяц " + m + " сходится с годовым отчётом");
            } else {
                System.out.println("Обнаружено несоответствие за месяц " + m);
                System.out.println("Расход за месяц " + m + " из месячного отчёта: " + monthlyReport.findMonthTotal(m, true));
                System.out.println("Расход за месяц " + m + " из годового отчёта: " + yearlyReport.yearOfMonths.get(m).expense);
                System.out.println("Доход за месяц " + m + " из месячного отчёта: " + monthlyReport.findMonthTotal(m, false));
                System.out.println("Доход за месяц " + m + " из годового отчёта: " + yearlyReport.yearOfMonths.get(m).income);
            }
        }
    }
}
