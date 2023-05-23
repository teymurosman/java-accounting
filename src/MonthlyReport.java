import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    HashMap<Integer, ArrayList<ItemsOfMonth>> itemsOfMonths = new HashMap<>();
    public void loadFile(int m, String path) {
        ArrayList<ItemsOfMonth> monthItems = new ArrayList<>();
        String content = FileReader.readFileContentsOrNull(path);
        if (content == null) {
            return;
        }
        String[] lines = content.split("\r?\n"); // Разбиваем по строкам
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(","); // Разбиваем на массив по запятой
            String itemName = parts[0];
            boolean isExpense = Boolean.parseBoolean(parts[1]);
            int quantity = Integer.parseInt(parts[2]);
            int price = Integer.parseInt(parts[3]);

            monthItems.add(new ItemsOfMonth(itemName, isExpense, quantity, price));
        }
        itemsOfMonths.put(m, monthItems); // Кладём в хэщ-таблицу по месяцу, содержащему список операций
    }

    void findMaxExpenseAndIncome(int m) {
        int maxExpense = 0;
        int maxIncome = 0;
        String maxExpItem = null;
        String maxIncItem = null;
        for (ItemsOfMonth month : itemsOfMonths.get(m)) {
            if (month.isExpense) {
                if ((month.quantity * month.price) > maxExpense) {
                    maxExpense = month.quantity * month.price;
                    maxExpItem = month.itemName;
                }
            } else {
                if ((month.quantity * month.price) > maxIncome) {
                    maxIncome = month.quantity * month.price;
                    maxIncItem = month.itemName;
                }
            }
        }
        System.out.println("Самый прибыльный товар: " + maxIncItem + ". Прибыль по нему составила: " + maxIncome);
        System.out.println("Самая большая трата: " + maxExpItem + ". Расход по ней составил: " + maxExpense);
    }

    int findMonthTotal(int m, boolean isExpense) { // Объединил 2 метода в 1, добавив аргумент isExpense
        int total = 0;
        for (ItemsOfMonth month : itemsOfMonths.get(m)) {
            if (isExpense) {
                if (month.isExpense) {
                    total += month.price * month.quantity;
                }
            } else {
                if (!month.isExpense) {
                    total += month.price * month.quantity;
                }
            }
        }
        return total;
    }
}
