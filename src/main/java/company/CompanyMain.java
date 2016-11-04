package company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompanyMain {
    public static void main(String[] args) throws IOException {
        Company myCompany = new Company();

        //Generate number workers in company (min 10, max 100)
        int numberWorkers = myCompany.generateNumberWorkers(10, 100);

        //Create workers
        List<Worker> listWorkers = new ArrayList<Worker>();
        listWorkers = myCompany.createWorkers(numberWorkers);

        //Do all the work and generate report per month
        System.out.println("Oleg print: Generate report per month" + "\n"
                + myCompany.report(myCompany.doWork(listWorkers)));
    }
}
