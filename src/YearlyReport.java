import java.util.HashMap;

public class YearlyReport {
    HashMap<Integer, MonthOfYear> yearOfMonths = new HashMap<>();

    public YearlyReport(String path) {
        String content = FileReader.readFileContentsOrNull(path);
        if (content == null) {
            return;
        }
        String[] lines = content.split("\r?\n");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");
            int month = Integer.parseInt(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);

            if (!(yearOfMonths.containsKey(month))) { // Кладём в yearOfMonths, если еще не добавляли месяц под номером month
                yearOfMonths.put(month, new MonthOfYear(month));
            }

            MonthOfYear oneMonth = yearOfMonths.get(month); // Распределяем на доход и расход
            if (isExpense) {
                oneMonth.expense += amount;
            } else {
                oneMonth.income += amount;
            }
        }
    }

    void getProfitByMonths() {
        for (Integer month : yearOfMonths.keySet()) {
            int profit = yearOfMonths.get(month).income - yearOfMonths.get(month).expense;
            System.out.println("Прибыль за " + month + "-й месяц составила: " + profit);
        }
    }

    double findAvgExpense() {
        double totalExpense = 0;
        for (MonthOfYear oneMonth : yearOfMonths.values()) {
            totalExpense += oneMonth.expense;
        }
        return totalExpense / yearOfMonths.size();
    }

    double findAvgIncome() {
        double totalIncome = 0;
        for (MonthOfYear oneMonth : yearOfMonths.values()) {
            totalIncome += oneMonth.income;
        }
        return totalIncome / yearOfMonths.size();
    }
}
