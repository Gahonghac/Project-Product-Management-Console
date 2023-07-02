package List;

import data.Category;
import data.Product;
import data.Product;
import java.util.ArrayList;
import java.util.List;
import util.KeyBoardIO;

/**
 *
 * @author Tien Dep Trai
 */
public class ProductList {

    private List<Product> productList = new ArrayList();
    private CategoryList categoryList = new CategoryList();

    public ProductList(CategoryList categoryList) {
        this.categoryList = categoryList;
    }

    public ProductList(CategoryList categoryList, List<Product> productList) {
        this.categoryList = categoryList;
        this.productList = productList;
    }

    public ProductList() {
    }

    public List<Product> getProductList() {
        return this.productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public CategoryList getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(CategoryList categoryList) {
        this.categoryList = categoryList;
    }

    public int searchProductById(String id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public Product searchObjectProductById(String id) {
        if (productList.isEmpty()) {
            return null;
        }

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId().equals(id)) {
                return productList.get(i);
            }
        }
        return null;
    }

    public int searchCategoryIdById(String id) {
        return categoryList.searchCategoryById(id);
    }

    public boolean isEmpty() {
        return productList.isEmpty();
    }

    public int size() {
        return productList.size();
    }

    public Product get(int pos) {
        return productList.get(pos);
    }

    public boolean addNewProduct(String id, String name, double price,
            int quantity, String categoryId) {
        return productList.add(new Product(id, name, price, quantity, categoryId));
    }

    public boolean updateProduct(int pos, String name,
            double price, int quantity, String categoryId) {
        productList.get(pos).setProductName(name);
        productList.get(pos).setProductPrice(price);
        productList.get(pos).setProductQuanity(quantity);
        productList.get(pos).setCategoryId(categoryId);
        return true;
    }

    public boolean deleteProduct(String id) {
        int pos = searchCategoryIdById(id);
        if (pos == -1) {
            return false;
        }
        productList.remove(pos);
        return true;
    }

    public void showProductList() {
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            System.out.printf(
                    "|%-8d|%-10s|%-18s|%-11.2f|%-14d|\n", i + 1,product.getProductId(), 
                    product.getProductName(),product.getProductPrice(), 
                    product.getProductQuanity()
            );
        }
    }

    public void showOrder() {

        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            String name = product.getProductName();
            int quantity = product.getProductQuanity();
            double price = product.getProductPrice();
            double amount = quantity * price;

        }

    }

}
