package Entitites;

public class ImportedProducts extends Product {
	
	private Double customsFree;
	
	public ImportedProducts() {
		super();
	}

	public ImportedProducts(String name, Double price, Double customsFree) {
		super(name, price);
		this.customsFree = customsFree;
	}

	public Double getCustomsFree() {
		return customsFree;
	}

	public void setCustomsFree(Double customsFree) {
		this.customsFree = customsFree;
	}
	
	@Override
	public String priceTag() {
		return getName() + " $ " + String.format("%.2f", totalPrice()) + " (Customs free: $ " + String.format("%.2f", customsFree) + ")";
	}
	
	public double totalPrice() {
		return getPrice() + customsFree;
	}
}
