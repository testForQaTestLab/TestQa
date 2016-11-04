package company;

public class Programmer extends Worker {
    Programmer() {
        salaryForHour = 4;
        position = "Programmer";

    }

    @Override
    public void working() {
        hours = 1;
        if (hoursWeek > 0) {
            hoursWeek -= hours;
            workedHours += hours;
        }
        System.out.println("Programming");
    }
}
