package company;

public class Tester extends Worker {
    Tester() {
        salaryForHour = 3;
        position = "Tester";

    }

    @Override
    public void working() {
        hours = 1;
        if (hoursWeek > 0) {
            hoursWeek -= hours;
            workedHours += hours;
        }
        System.out.println("Testing");
    }
}
