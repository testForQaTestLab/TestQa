package company;

public class Freelancer extends Worker {
	Freelancer() {
		salaryForHour = 3;
		position = "Freelancer";
	}

	@Override
	public void working() {
		hours = 1;
		if (hoursWeek > 0) {
			hoursWeek -= hours;
			workedHours += hours;
		}
		System.out.println("Freelancing");
	}
}
