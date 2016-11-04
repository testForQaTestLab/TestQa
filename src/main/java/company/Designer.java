package company;

public class Designer extends Worker {
    Designer() {
        salaryForHour = 3;
        position = "Designer";

    }

    @Override
    public void working() {
        hours = 1;
        if (hoursWeek > 0) {
            hoursWeek -= hours;
            workedHours += hours;
        }
        System.out.println("Create Designe");
    }
}

