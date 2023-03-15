package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> listProduct = new ArrayList<Product>();

		System.out.println("Enter a file path:  ");
		String path = sc.nextLine();

		File sourceFile = new File(path);
		String soucerFolder = sourceFile.getParent();

		boolean success = new File(soucerFolder + "\\out").mkdir();

		String targetFile = sourceFile.getParent() + "\\out\\sumarry.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				String[] vect = line.split(",");

				Product product = new Product(vect[0], Double.parseDouble(vect[1]), Integer.parseInt(vect[2]));

				listProduct.add(product);

				line = br.readLine();
			}

			System.out.println("PRODUCTS: ");
			for (Product p : listProduct) {
				System.out.println(p + "Total price " + p.totalPrice());
			}

		}

		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());

		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile))) {
			for (Product product : listProduct) {

				bw.write(product.getName());
				// bw.write(product.getPrice());
				bw.write(product.getQuantity());
				// bw.write(product.totalPrice());
				bw.newLine();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
