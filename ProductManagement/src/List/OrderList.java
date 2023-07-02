/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package List;

import data.OrderDetail;
import data.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Tien Dep Trai
 */
public class OrderList {
    
    private List<OrderDetail> orderList =  new ArrayList();
    
    public boolean isEmpty(){
        return orderList.isEmpty();
    }
    
    public void addOldCustomer(int pos, String nameCustomer,Product product, int quantity){
        Map<Product, Integer> mapOldCustomer = orderList.get(pos).getMapOrderDetail();
        
        if(mapOldCustomer.containsKey(product)){
            quantity +=  mapOldCustomer.get(product);
            mapOldCustomer.put(product, quantity);
            return;
        }
        mapOldCustomer.put(product, quantity);
    }
    
    public boolean addNewOrder(String nameCustomer, Product product, int quantity){
        for (int pos = 0; pos<orderList.size(); pos++) {
            if(orderList.get(pos).getNameCustomer().equals(nameCustomer)){
                addOldCustomer(pos, nameCustomer, product, quantity);
                return true;
            }
        }
        return orderList.add( new OrderDetail(nameCustomer, product, quantity) );
    }
    
    public void showOrderListCustomer(String title){ 
        for (OrderDetail orderDetail : orderList) {
            System.out.println("\n\nCustomer: "+orderDetail.getNameCustomer());
            System.out.println(title);
            orderDetail.showProfile();
            System.out.println("________________________________________________"
                    + "__________________________________________\n");
        }
    }
    
    
    
}
