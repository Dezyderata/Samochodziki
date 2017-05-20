import java.util.List;

public class Main{
	public static void main(String[] args){
		Car car1 = new Car("Seat", 10000.00, 2009, "2017/01/20");
		Car car2 = new Car("VW Polo", 3000.00, 2004, "2017/01/17");
		Car car3 = new Car("Audi A6", 14500.00, 2005, "2017/02/1");
		Car car4 = new Car("Renault Megane", 5000.00, 2008, "2017/03/7");
		Car car5 = new Car("Ford Fiesta", 2500.00, 2004, "2017/03/27");
		Car car6 = new Car("Seat Ibiza", 15250.00, 2012, "2017/01/31");
		Database database1 = new Database();
		List list1;
		database1.addCar(car1);
		database1.addCar(car2);
		database1.addCar(car3);
		database1.addCar(car4);
		database1.addCar(car5);
		database1.addCar(car6);
		System.out.println("\nDatabase:");
		database1.printDatabase();
		System.out.println("\nBy pattern in title:");
		database1.getByTitle("Seat");
		System.out.println("\nBy price(lowest):");
		database1.getByPrice(1, 5000.0, 20000.0);
		System.out.println("\nBy price(highest):");
		database1.getByPrice(2, 1000.0, 5000.0);
		System.out.println("\nBy year of production(from oldest):");
		database1.getByYearProduced(1, 2005, 2010);
		System.out.println("\nBy year of production(from youngest):");
		database1.getByYearProduced(2, 2007, 2012);
		System.out.println("\nBy announcement date(after):");
		database1.getByAnnounced(1, "2017/02/1");
		System.out.println("\nBy announcement date(before):");
		database1.getByAnnounced(2, "2017/02/1");
	}
}
