/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;


/**
 *
 * @author Tien Dep Trai
 */
public class Product {
    private String productId;
    private String productName;
    private String categoryId;
    private double productPrice;
    private int productQuanity;

    public Product(String productId, String productName, double productPrice, int quanity, String categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuanity = quanity;
        this.categoryId = categoryId;
    }

    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuanity() {
        return productQuanity;
    }

    public void setProductQuanity(int quanity) {
        this.productQuanity = quanity;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Product) obj).getProductId().equals(this.productId);
    }

    @Override
    public String toString() {
        return productId + "," + productName + "," + productPrice + "," + productQuanity + "," + categoryId;
    }

}
