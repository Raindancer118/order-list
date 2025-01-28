package de.nordakademie.orderlist.model.factory;

import de.nordakademie.orderlist.model.implementation.IProduct;
import de.nordakademie.orderlist.model.implementation.Product;

public interface IProductFactory {
    void createIProduct();
    IProduct getProductType();
}
