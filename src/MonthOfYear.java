public class MonthOfYear {
    int month;
    int income;
    int expense;

    public MonthOfYear(int month) { // Конструтор только по month, чтобы далее amount распрделить на income и expense
        this.month = month;
    }
}
