package Entitites;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProducts extends Product {

	private Date manufactureDate;
	
	public UsedProducts() {
	}

	public UsedProducts(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public String priceTag() {
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		return getName() + " (Used) $ " + String.format("%.2f", getPrice()) + " (Manufacture date: " + sdf.format(manufactureDate) + ")";
	}
}
