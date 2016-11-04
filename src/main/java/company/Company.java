package company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private int totalTasks = 0;
    private int counterFreelancers = 0;

    //Generate number workers in company (min 10, max 100)
    public int generateNumberWorkers(int number1, int number2) {
        int result = 0;
        RandomNumber object = RandomNumber.getInstance(number1, number2);
        result = object.number;

        return result;
    }

    //Create workers
    public List<Worker> createWorkers(int numberWorkers) {
        List<Worker> listWorkersCompany = new ArrayList<Worker>();
        Fabrica fabWorkers = new Fabrica();
        listWorkersCompany = fabWorkers.createListWorkers(numberWorkers);

        return listWorkersCompany;
    }

    // The company does all the work
    public List<Worker> doWork(List<Worker> companyListWorkers) {
        List<Worker> listTasks = new ArrayList<Worker>();
        int tasksPerHour = 0;
        Director director = new Director();
        // Cycle for 4 weeks
        for (int i = 1; i <= 4; i++) {
            System.out.println("Oleg print:" + " --Week--" + i + "--");
            System.out.println("Oleg print: " + "  List of completed tasks 1 week");
            for (int j = 0; j < companyListWorkers.size(); j++) {
                companyListWorkers.get(j).hoursWeek = 40;
            }

            // Cycle for 40 hours (one week)
            for (int j = 1; j <= 40; j++) {
                // Director creates new task
                listTasks = director.createNewTask();
                tasksPerHour = listTasks.size();

                System.out.println("--Director creates new task per hour--");

                //Take task and give out to employees
                for (int t = 0, clw = 0, counter = 0; t < listTasks.size(); t++, clw++, counter++) {
                    // if list task > company list workers do this
                    if (companyListWorkers.size() == counter) {
                        clw = 0;
                        counter = 0;
                    }
                    //looking a free employee
                    if (listTasks.get(t).available()) {
                        if (companyListWorkers.get(clw).getClass().equals(listTasks.get(t).getClass())) {
                            companyListWorkers.get(clw).working();
                            --tasksPerHour;
                            ++totalTasks;
                            companyListWorkers.get(clw).available = false;
                        }
                    }
                }

            }
            //create freelancers and give work
            if (tasksPerHour > 0) {
                List<Worker> listFreelancersCompany = new ArrayList<Worker>();

                int numberFreelancers = 3;
                counterFreelancers += numberFreelancers;
                //create freelancers
                Fabrica fabFreelancers = new Fabrica();
                listFreelancersCompany = fabFreelancers.createListFreelancers(numberFreelancers);
                companyListWorkers.addAll(listFreelancersCompany);
                for (int j = 0, t = 0; j < tasksPerHour; j++, t++) {
                    if (t == listFreelancersCompany.size()) {
                        t = 0;
                    }
                    listFreelancersCompany.get(t).working();

                }
            }
            Accountant acc = new Accountant();
            System.out.println(acc.createWeekReport(companyListWorkers));
            System.out.println("_______");
        }
        System.out.println("total tasks: " + totalTasks);

        return companyListWorkers;
    }

    //Generate report per month
    public String report(List<Worker> companyListWorkers) throws IOException {
        String report = "";
        Accountant accountant = new Accountant();
        report = accountant.createMonthlyReport(companyListWorkers);
        report += "Quantity of freelancers in the company: " + counterFreelancers + "\n";
        report += "Number of the completed tasks " + totalTasks + "\n";

        // write report in file
        FileWriter writer = null;
        try {
            writer = new FileWriter("report.txt", false);
            String text = report;
            writer.write(text);
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            writer.close();
        }
        return report;
    }

}
