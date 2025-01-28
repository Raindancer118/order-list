package de.nordakademie.orderlist.model.implementation;

/**
 * A generic product to be ordered.
 *
 * @author Christopher Karow
 */
public abstract class Product implements IProduct {

    private static int productNo = 0;
    private String name;
    private int id = productNo++;

    public static int productCount() {
        return productNo;
    }

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}