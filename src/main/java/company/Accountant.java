package company;

import java.util.List;

public class Accountant extends Worker {
    Accountant() {
        salaryForHour = 4;
        position = "Accountant";
    }

    @Override
    public void working() {
        hours = 1;
        if (hoursWeek > 0) {
            hoursWeek -= hours;
            workedHours += hours;
        }
        System.out.println("Counting");
    }

    public String createWeekReport(List<Worker> companyListWorkers) {
        int i = 0;
        String result = "";
        for (Worker item : companyListWorkers) {
            ++i;
            result += i + "worked_hours = " + item.workedHours + " / " + "Name: " + item.name
                    + " / " + "Position: " + item.position + " / " + "Salary per hour = "
                    + item.salaryForHour + " / " + "worker salary = " + item.workerSalary()
                    + " / hours week: " + item.hoursWeek + "\n";
        }
        return result;
    }

    public String createMonthlyReport(List<Worker> companyListWorkers) {
        int i = 0;
        int salaryAllWorkers = 0;
        int totalHoursAllWorkers = 0;
        String result = "";
        for (Worker item : companyListWorkers) {
            ++i;
            result += i + "worked hours = " + item.workedHours + " / " + "Name: "
                    + item.name + " / " + "Position: " + item.position + " / " + "Salary per hour = "
                    + item.salaryForHour + " / " + "worker salary = " + item.workerSalary() + "\n";
            salaryAllWorkers += item.workerSalary();
            totalHoursAllWorkers += item.workedHours;
        }
        result += "salary all workers: " + salaryAllWorkers + "\n";
        result += "total hours all workers: " + totalHoursAllWorkers + "\n";
        result += "Amount of workers and freelancers: " + companyListWorkers.size() + "\n";
        return result;
    }
}