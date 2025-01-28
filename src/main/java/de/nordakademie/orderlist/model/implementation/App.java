package de.nordakademie.orderlist.model.implementation;

import de.nordakademie.orderlist.frontent.OrderList;

public class App {
    public static void main(String[] args) {
        OrderList orderList = new OrderList();
        orderList.menuLoop();
    }
}
