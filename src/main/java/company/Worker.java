package company;

abstract class Worker {
    int hoursWeek;
    String name;
    String position;
    int hours;
    int salaryForHour;
    int workedHours;
    int fixedSalary;
    boolean available;

    Worker() {
        name = "Worker";
        hours = 160;
        salaryForHour = 1;
        workedHours = 0;
        hoursWeek = 40;
        fixedSalary = 0;
        available = true;
    }

    int workingHours() {
        return 160 - hours;
    }

    int workerSalary() {
        return workedHours * salaryForHour + fixedSalary;
    }

    public void working() {
    }

    //When working hours are finished the employee becomes unavailable
    boolean available() {
        boolean result = true;
        if (0 == hoursWeek || available == false) {
            result = false;
        }
        return result;
    }
}
