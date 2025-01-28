package de.nordakademie.orderlist.model.factory;

import de.nordakademie.orderlist.model.implementation.IProduct;
import de.nordakademie.orderlist.model.implementation.Material;
import de.nordakademie.orderlist.model.implementation.Service;

import java.util.Scanner;

public class MaterialFactory implements IProductFactory {
    private Scanner scanner;
    private Material[] products = new Material[5];

    @Override
    public void createIProduct() {

    }

    @Override
    public IProduct getProductType() {
        return null;
    }

    public void orderMaterial(int index) {
        System.out.println("Materialname?");
        this.scanner.nextLine(); // Needed to prevent the scanner from skipping the line
        String name = this.scanner.nextLine();

        System.out.println("Stückpreis in Cent?");
        int pricePerUnit = this.scanner.nextInt();

        System.out.println("Stückzahl?");
        int amount = this.scanner.nextInt();

        this.products[index] = new Material(name, pricePerUnit, amount);
    }
}
