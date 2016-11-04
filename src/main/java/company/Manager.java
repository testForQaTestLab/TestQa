package company;

public class Manager extends Worker {
    Manager() {
        salaryForHour = 4;
        position = "Manager";

    }

    @Override
    public void working() {
        hours = 1;
        if (hoursWeek > 0) {
            hoursWeek -= hours;
            workedHours += hours;
        }
        System.out.println("Managing");
    }
}
