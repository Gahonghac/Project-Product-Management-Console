/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import List.ProductList;
import data.Category;
import data.OrderDetail;
import data.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tien Dep Trai
 */
public class FileIO {

    public static void writeFileProduct(String title, String fileName, List<Product> data) throws IOException {
        try (PrintWriter myWriter = new PrintWriter(fileName)) {//FileNotFoundException
            myWriter.println(title);   // IOException
            for (Product object : data) {
                myWriter.println(object);
            }
        }
    }

    public static void writeFileCategory(String title, String fileName, List<Category> data) throws IOException {
        try (PrintWriter myWriter = new PrintWriter(fileName)) {//FileNotFoundException
            myWriter.println(title);  // IOException
            for (Category object : data) {
                myWriter.println(object);
            }
        }
    }

    public static List<Product> readFileProduct(String fileName) throws IOException, IllegalArgumentException {
        try (FileReader filereader = new FileReader(fileName); //FileNotFoundException
                BufferedReader buffer = new BufferedReader(filereader)) {//IllegalArgumentException

            ArrayList<Product> list = new ArrayList<>();

            while (buffer.ready()) {//Luong da san sang duoc Read? ->IOException
                String s = buffer.readLine(); //Read 1 dong van ban ->IOException
                String[] tmp = s.split(",");

                if (tmp.length == 5) {
                    Product d = new Product(tmp[0], KeyBoardIO.getName(tmp[1]),
                            Double.parseDouble(tmp[2]), Integer.parseInt(tmp[3]), tmp[4]);
                    list.add(d);
                }
            }
            return list;
        }
    }

    public static List<Category> readFileCategory(String fileName) throws IOException, IllegalArgumentException {
        try (FileReader fileReader = new FileReader(fileName);//FileNotFoundException
                BufferedReader buffer = new BufferedReader(fileReader)) {//IllegalArgumentException

            ArrayList<Category> list = new ArrayList<>();
            while (buffer.ready()) {//Luong da san sang duoc Read? ->IOException
                String s = buffer.readLine();//Read 1 dong van ban ->IOException
                String[] tmp = s.split(",");
                if (tmp.length == 2) {
                    Category category = new Category(KeyBoardIO.getName(tmp[0]), tmp[1]);
                    list.add(category);
                }
            }
            return list;
        }
    }

    public static List<OrderDetail> readFileCustomer(String fileName, ProductList productList) throws IOException, IllegalArgumentException {
        try (FileReader fileReader = new FileReader(fileName);//FileNotFoundException
                BufferedReader buffer = new BufferedReader(fileReader)) {//IllegalArgumentException
            ArrayList<OrderDetail> list = new ArrayList<>();
            while (buffer.ready()) {//Luong da san sang duoc Read? ->IOException
                String s = buffer.readLine();//Read 1 dong van ban ->IOException
                String[] tmp = s.split(",");
                if (tmp.length >= 3) {
                    Map<Product, Integer> mapOrder = new HashMap<Product, Integer>();
                    Product product;

                    for (int i = 1; i < tmp.length - 1; i += 2) {
                        product = productList.searchObjectProductById(tmp[i]);
                        mapOrder.put(product, Integer.parseInt(tmp[i + 1]));
                    }
                    OrderDetail orderDetail = new OrderDetail(tmp[0], mapOrder);
                    list.add(orderDetail);
                }
            }
            return list;
        }
    }

}
