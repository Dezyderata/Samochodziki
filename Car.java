import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.text.ParseException;

public class Car{
	private String title;
	private double price;
	private int yearProduced;
	private String dateAnnounced;
	private Date announced;

	DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

	public Car(String title, double price, int yearProduced, String dateAnnounced){
		this.title = title;
		this.price = price;
		this.yearProduced = yearProduced;
		this.dateAnnounced = dateAnnounced;
		try{
			this.announced = df.parse(dateAnnounced);
		}catch(ParseException e){
			e.printStackTrace();
		}

	}
	public String getTitle(){
		return title;
	}
	public double getPrice(){
		return price;
	}
	public int getYearProduced(){
		return yearProduced;
	}
	public String getDateAnnounced(){
		return dateAnnounced;
	}
	public Date getAnnounced(){
		return announced;
	}
	@Override
	public String toString(){
		return "Car: "+title+", year of production: " +yearProduced+", price: " +price+", announced: "+ dateAnnounced;
	}
}
