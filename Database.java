import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Predicate;
import java.util.regex.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.text.ParseException;

public class Database{
	private List<Car> cars = new ArrayList<>();
	private Date Announc;
	public void addCar(Car car){
		cars.add(car);
	}
	public void getByTitle(String name){
		//Filtrowanie i sortowanie po tytule
		cars.stream()
			.filter(s -> s.getTitle().matches(".*"+name+".*"))
			.sorted(Comparator.comparing(Car::getTitle))
			.forEach(System.out::println);
	}
	public void getByPrice(int i, double low, double high){
		//Po cenie: 1-od najtanszych, 2-od najdrozszych
		switch(i){
			case 1:
				cars.stream()
					.filter(d -> d.getPrice()>=low && d.getPrice()<=high)
					.sorted(Comparator.comparing(Car::getPrice))
					.forEach(System.out::println);
				break;
			case 2:
				cars.stream()
					.filter(d -> d.getPrice()>=low && d.getPrice()<=high)
					.sorted(Comparator.comparing(Car::getPrice).reversed())
					.forEach(System.out::println);
		}
	}
	public void getByYearProduced(int i, int low, int high){
		//Po roku produkcji: 1-od najstarszych, 2-od najmlodszych
		switch(i){
			case 1:
				cars.stream()
					.filter(d -> d.getYearProduced()>=low && d.getYearProduced()<=high)
					.sorted(Comparator.comparing(Car::getYearProduced))
					.forEach(System.out::println);
				break;
			case 2:
				cars.stream()
					.filter(d -> d.getYearProduced()>=low && d.getYearProduced()<=high)
					.sorted(Comparator.comparing(Car::getYearProduced).reversed())
					.forEach(System.out::println);
		}
	}
	public void getByAnnounced(int i, String date){
		//Filtrowanie i sortowanie po dacie dodania: 1-daty po podanej dacie, 2-daty przed
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		try{
			Announc = df.parse(date);
		}catch(ParseException e){
			e.printStackTrace();
		}
		switch(i){
			case 1:
				cars.stream()
					.filter(s -> s.getAnnounced().after(Announc))
					.sorted(Comparator.comparing(Car::getAnnounced).reversed())
					.forEach(System.out::println);
				break;
			case 2:
				cars.stream()
					.filter(s -> s.getAnnounced().before(Announc))
					.sorted(Comparator.comparing(Car::getAnnounced).reversed())
					.forEach(System.out::println);
		}
	}
	public void printDatabase(){
		for(Car car:cars){
			System.out.println(car);
		}
	}
}
