/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Tien Dep Trai
 */
public class OrderDetail {

    private String nameCustomer;
    private Map<Product, Integer> mapOrderDetail = new HashMap();

    public OrderDetail() {
    }

    public OrderDetail(String nameCustomer, Product product, int quantity) {
        this.nameCustomer = nameCustomer;
        this.mapOrderDetail.put(product, quantity);
    }

    public OrderDetail(String nameCustomer, Map<Product, Integer> mapOrder) {
        this.nameCustomer = nameCustomer;
        this.mapOrderDetail = mapOrder;
    }

    public boolean isEmpty() {
        return mapOrderDetail.isEmpty();
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public Map<Product, Integer> getMapOrderDetail() {
        return mapOrderDetail;
    }

    public void setMapOrderDetail(Map<Product, Integer> mapOrderDetail) {
        this.mapOrderDetail = mapOrderDetail;
    }

    public void showProfile() {
        Set<Product> setKey = mapOrderDetail.keySet();
        int rollNumber = 1;
        double total = 0;
        for (Product key : setKey) {
            String name = key.getProductName();
            int quantity = mapOrderDetail.get(key);
            double price = key.getProductPrice();
            double amount = quantity * price;
            System.out.printf(
                    "|%d.%-15s|%-14d|%-11.2f|%-12.2f|\n", rollNumber, name, quantity,
                    price, amount
            );
            total += amount;
            rollNumber++;
        }
        System.out.printf("$Total: %.2f\n", total);
    }

//    @Override
//    public String toString() {
//        String string = nameCustomer + ",";
//        StringBuffer stringbuffer = new StringBuffer();
//        stringbuffer.append(nameCustomer);
//        stringbuffer.append(nameCustomer);
//        Set<Product> keySet = this.mapOrderDetail.keySet();
//        for (Product key : keySet) {
//            string += (key.getProductId() + "," + mapOrderDetail.get(key) + ","); 
//        }
//        return string;
//    }
}
