package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entitites.ImportedProducts;
import Entitites.Product;
import Entitites.UsedProducts;

public class ProgramProduct {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> list = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i) ? ");
			char type = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();

			if (type == 'i') {
				System.out.print("Customs free: ");
				double customsFree = sc.nextDouble();
				list.add(new ImportedProducts(name, price, customsFree));
			} else if (type == 'u') {
				System.out.print("Manufacture date (DD/MM/YYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				list.add(new UsedProducts(name, price, manufactureDate));
			} else {
				list.add(new Product(name, price));
			}
		}

		System.out.println();
		System.out.println("Price tags: ");
		for (Product product : list) {
			System.out.println(product.priceTag());
		}

		sc.close();
	}
}
