package company;

import java.util.ArrayList;
import java.util.List;

public class Fabrica {
    public List<Worker> createListWorkers(int numberWorkers) {
        ArrayList<Worker> listWorkers = new ArrayList<Worker>();

        // create the required staff (Manager, Director and Accountant)
        Worker director = new Director();
        Worker mainManager = new Manager();
        Worker mainAccountant = new Accountant();

        // add to list
        listWorkers.add(director);
        director.name = "Director";
        director.fixedSalary = 300;// fixed salary

        listWorkers.add(mainAccountant);
        mainAccountant.name = "Main accountant";
        mainAccountant.fixedSalary = 300;// fixed salary

        listWorkers.add(mainManager);
        mainManager.name = "Main manager";
        mainManager.fixedSalary = 300;// fixed salary

        for (int i = 3; i < numberWorkers; i++) {
            RandomNumber object = RandomNumber.getInstance(0, 4);

            switch (object.number) {
                case 0:
                    listWorkers.add(new Programmer());
                    listWorkers.get(i).name = "Worker " + i;
                    break;
                case 1:
                    listWorkers.add(new Tester());
                    listWorkers.get(i).name = "Worker " + i;
                    break;
                case 2:
                    listWorkers.add(new Designer());
                    listWorkers.get(i).name = "Worker " + i;
                    break;
                case 3:
                    listWorkers.add(new Manager());
                    listWorkers.get(i).name = "Worker " + i;
                    break;
                case 4:
                    listWorkers.add(new Accountant());
                    listWorkers.get(i).name = "Worker " + i;
                    break;
            }
        }
        return listWorkers;
    }

    public List<Worker> createTasksList(int numberWorkers) {
        ArrayList<Worker> listWorkers = new ArrayList<Worker>();

        for (int i = 0; i < numberWorkers; i++) {
            RandomNumber object = RandomNumber.getInstance(0, 4);
            switch (object.number) {
                case 0:
                    listWorkers.add(new Programmer());
                    listWorkers.get(i).name = "Worker " + i;
                    break;
                case 1:
                    listWorkers.add(new Tester());
                    listWorkers.get(i).name = "Worker " + i;
                    break;
                case 2:
                    listWorkers.add(new Designer());
                    listWorkers.get(i).name = "Worker " + i;
                    break;
                case 3:
                    listWorkers.add(new Manager());
                    listWorkers.get(i).name = "Worker " + i;
                    break;
                case 4:
                    listWorkers.add(new Accountant());
                    listWorkers.get(i).name = "Worker " + i;
                    break;
            }
        }

        return listWorkers;
    }

    public List<Worker> createListFreelancers(int numberWorkers) {
        ArrayList<Worker> listWorkers = new ArrayList<Worker>();
        for (int i = 0; i < numberWorkers; i++) {
            listWorkers.add(new Freelancer());
            listWorkers.get(i).name = "Freelancer ";
        }
        return listWorkers;
    }

}
