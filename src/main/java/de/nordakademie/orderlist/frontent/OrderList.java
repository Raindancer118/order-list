package de.nordakademie.orderlist.frontent;

import de.nordakademie.orderlist.model.factory.MaterialFactory;
import de.nordakademie.orderlist.model.factory.ServiceFactory;
import de.nordakademie.orderlist.model.implementation.IProduct;
import de.nordakademie.orderlist.model.implementation.Material;
import de.nordakademie.orderlist.model.implementation.Product;
import de.nordakademie.orderlist.model.implementation.Service;

import java.util.Scanner;

/**
 * Keeps track of all ordered Products.
 *
 * @author Christopher Karow
 */
public class OrderList {

    private Scanner scanner = new Scanner(System.in);

    private IProduct[] products = new Product[5];
    private MaterialFactory materialFactory = new MaterialFactory();
    private ServiceFactory serviceFactory = new ServiceFactory();
    private int index = 0;

    public void menuLoop() {
        int selection;

        do {
            printDialog();
            selection = scanner.nextInt();
            switch (selection) {
                case 0:
                    break;
                case 1:
                    materialFactory.orderMaterial(this.index++);
                    break;
                case 2:
                    serviceFactory.orderService(this.index++);
                    break;
                default:
                    System.out.println("ungültig");
                    break;
            }
        } while (selection != 0 && this.index < products.length);

        sortOrderList();
        printOrderList();
    }

    private void printDialog() {
        System.out.println("(0) Bestellung beenden\n" +
                "(1) Material bestellen\n" +
                "(2) Dienstleistung bestellen");
    }

    private void printOrderList() {
        int sum = 0;
        for (int i = 0; i < this.index; i++) {
            this.products[i].print();
            sum += this.products[i].getPrice();
        }

        System.out.println(String.format("Gesamtsumme: %01d,%02d€", sum / 100, sum % 100));
    }

    private void sortOrderList() {
        for (int i = 0; i < this.products.length - 1; i++) {
            for (int j = 0; j < this.products.length - 1; j++) {

                if (this.products[j + 1] != null &&
                        this.products[j + 1].getPrice() < this.products[j].getPrice()) {
                    IProduct temp = this.products[j + 1];
                    this.products[j + 1] = this.products[j];
                    this.products[j] = temp;
                }
            }
        }
    }
}
