package de.nordakademie.orderlist.model.factory;

import de.nordakademie.orderlist.model.implementation.IProduct;
import de.nordakademie.orderlist.model.implementation.Service;

import java.util.Scanner;

public class ServiceFactory implements IProductFactory {
    private Scanner scanner = new Scanner(System.in);
    private Service[] products = new Service[5];

    public void orderService(int index) {
        System.out.println("Leistungsart?");
        this.scanner.nextLine(); // Needed to prevent the scanner from skipping the line
        String name = this.scanner.nextLine();

        System.out.println("Personenzahl?");
        int employees = this.scanner.nextInt();

        System.out.println("Stunden?");
        int hours = this.scanner.nextInt();

        this.products[index] = new Service(name, hours, employees);
    }

    @Override
    public void createIProduct() {
        
    }

    @Override
    public IProduct getProductType() {
        return null;
    }
}
