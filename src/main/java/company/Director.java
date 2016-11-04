package company;

import java.util.ArrayList;
import java.util.List;

public class Director extends Worker 
{
	Director()
	{
		salaryForHour = 5;
		position = "Director";
		workedHours = 160;
		name = "Boss";
	}

	// create new task
	public List<Worker> createNewTask()
	{
		int numberTasks = 0;

		//Get the only object available
		RandomNumber object = RandomNumber.getInstance(50, 100);
		numberTasks = object.number;

		//Generate type of tasks	
		List<Worker> listTasks = new ArrayList<Worker>();
		Fabrica fabTasks = new Fabrica();
		listTasks = fabTasks.createTasksList(numberTasks);
		return listTasks;
	}

	// fixed salary
	int workerSalary()
	{
		return workedHours * salaryForHour;
	}
	@Override
	public void working()
	{
		hours = 1;
		if(hoursWeek > 0) {
			hoursWeek -= hours;
			workedHours += hours;
		}
		System.out.println("Director working");
	}	
}
