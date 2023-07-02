/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import List.OrderList;
import manager.CategoryManager;
import List.ProductList;
import data.Product;
import util.KeyBoardIO;

/**
 *
 * @author Tien Dep Trai
 */
public class ProductManager {

    private ProductList productManager = new ProductList();
    private OrderList orderList = new OrderList();

    public ProductManager(ProductList productList) {
        this.productManager = productList;
    }

    public ProductManager() {
    }

    public ProductList getProductManager() {
        return productManager;
    }

    public void setProductManager(ProductList productManager) {
        this.productManager = productManager;
    }

    public OrderList getOrderList() {
        return orderList;
    }

    public void setOrderList(OrderList orderList) {
        this.orderList = orderList;
    }

    private String getDistinctAddProductId() {
        boolean choice;
        while (true) {
            String id = KeyBoardIO.getId(
                    "\nInput Id of Product (AA-DDDDD): ( A: any alphabet || D: any digit ) ",
                    "Wrong Format! ", "^[A-Za-z]{2}-\\d{5}$"
            );

            if (productManager.searchProductById(id) == -1) {
                return id;
            }
            choice = KeyBoardIO.getQuestion(
                    "\nThis Id is already exist! Do you want to try again?  Y/y(yes) or N/n(no)",
                    "Just input Y/y or N/n", "y", "n");
            if (!choice) {
                return null;
            }
        }
    }

    private String getDistinctCategoryId() {
        boolean choice;
        while (true) {
            String id = KeyBoardIO.getId(
                    "Input Id of Category (AA-DDDDD): ( A: any alphabet || D: any digit ) ",
                    "Wrong Format! ", "^[A-Za-z]{2}-\\d{5}$"
            );

            if (productManager.searchCategoryIdById(id) != -1) {
                return id;
            }
            choice = KeyBoardIO.getQuestion(
                    "\nThis Id is not already exist! Do you want to try again?  Y/y(yes) or N/n(no)",
                    "Just input Y/y or N/n", "y", "n");
            if (!choice) {
                return null;
            }
        }
    }

    private void conductAddProduct(String newId) {
        String categoryId;
        String newName;
        double newPrice;
        int newQuantity;
        boolean checkOption;

        //Input new Name
        newName = KeyBoardIO.getName(
                "\nInput Name of Product: ",
                "Product Name just cointains characters and space!"
        );
        //Input new Price
        newPrice = KeyBoardIO.getPositiveDouble(
                "\nInput Price of Product:\n( Price is a positive number ) ",
                "Wrong Format!"
        );
        //Input new Quantity
        newQuantity = KeyBoardIO.getPositiveInteger(
                "\nInput Quantity of Product: ",
                "Product Quantity is a positive integer !"
        );
        //Input CategoryId
        categoryId = getDistinctCategoryId();
        if (categoryId == null) {
            return;
        }
        // Check adding option
        checkOption = KeyBoardIO.getQuestion(
                "\nAre you sure adding this Product ?   Y/y(yes) - N/n(no)",
                "Input only Y/y(yes) or N/n(no)!", "y", "n"
        );
        if (checkOption) {
            productManager.addNewProduct(newId, newName, newPrice, newQuantity, categoryId);
            System.out.println("=> Adding a new Product successfully!\n");
            return;
        }

        System.out.println("=> Adding a new Product is canceled!\n");
    }

    public void addNewProduct() {

        boolean checkOption;
        String newId;

        do {
            newId = getDistinctAddProductId();
            if (newId != null) {
                conductAddProduct(newId);
            }

            //check to go back to the main menu
            checkOption = KeyBoardIO.getQuestion(
                    "Do you want to go back to the main Menu?  Y/y(yes) or N/n(no)!",
                    "Just input only Y/y(yes) or N/n(No)!", "y", "n"
            );
        } while (!checkOption);
    }

    private String getDistinctProductId() {
        boolean choice;
        while (true) {
            String id = KeyBoardIO.getId(
                    "\nInput Id of Product (AA-DDDDD): ( A: any alphabet || D: any digit ) ",
                    "Wrong Format! ", "^[A-Za-z]{2}-\\d{5}$"
            );

            if (productManager.searchProductById(id) != -1) {
                return id;
            }
            choice = KeyBoardIO.getQuestion(
                    "\nThis Id is not exist! Do you want to try again?  Y/y(yes) or N/n(no)",
                    "Just input Y/y or N/n", "y", "n");
            if (!choice) {
                return null;
            }
        }
    }

    private void conductUpdateProduct(String searchId) {
        String updatedCategoryId;
        String updatedName;
        double updatedPrice;
        int updatedQuantity;
        boolean checkOption;
        int pos;
        //Input updated Name
        updatedName = KeyBoardIO.getName(
                "\nInput updated Name of Product: ",
                "Product Name just cointains characters and space!"
        );
        //Input new Price
        updatedPrice = KeyBoardIO.getPositiveDouble(
                "\nInput updated Price of Product: (Price is a positive number)",
                "Wrong Format!"
        );
        //Input new Quantity
        updatedQuantity = KeyBoardIO.getPositiveInteger(
                "\nInput updated Quantity of Product: ",
                "Product Quantity is a positive integer number!"
        );
        //Input new CategoryId
        updatedCategoryId = getDistinctCategoryId();

        if (updatedCategoryId == null) {
            return;
        }
        // Check updated option
        checkOption = KeyBoardIO.getQuestion(
                "\nAre you sure updating this Product ?  Y/y(yes) - N/n(no)",
                "Input only Y/y(yes) or N/n(no)!", "y", "n"
        );
        if (checkOption) {
            pos = productManager.searchProductById(searchId);
            productManager.updateProduct(pos, updatedName, updatedPrice, updatedQuantity, updatedCategoryId);
            System.out.println("=> Updating a new Category successfully!\n");
            return;
        }

        System.out.println("=> Updating is canceled!\n");

    }

    private void conductDeleteProduct(String searchId) {
        boolean checkOption;
        // Check to deleted option
        checkOption = KeyBoardIO.getQuestion(
                "\nAre you sure deleting this Product ?   Y/y(yes) - N/n(no)",
                "Input only Y/y(yes) or N/n(no)!", "y", "n"
        );

        if (checkOption) {
            productManager.deleteProduct(searchId);
            System.out.println("=> Deleting a Product successfully!\n");
            return;
        }

        System.out.println("=> Deleting a Product Failly!\n");
    }

    public void updateProduct() {
        boolean checkOption;
        String searchId;

        do {
            if (productManager.isEmpty()) {
                System.err.println("The Product List is empty! Please adding a new Product!");
                return;
            } // end if Product is empty

            searchId = getDistinctProductId();

            if (searchId != null) {
                conductUpdateProduct(searchId);
            }

            //check to go back to the main menu
            checkOption = KeyBoardIO.getQuestion(
                    "\nDo you want to go back to the main Menu?  Y/y(yes) or N/n(no)",
                    "Just input only Y/y(yes) or N/n(No)!", "y", "n"
            );
        } while (!checkOption);
    }

    public void deleteProduct() {
        boolean checkOption;
        String searchId;

        do {
            //check any item is exist in List?
            if (this.productManager.isEmpty()) {
                System.err.println("The List Product is empty! Please adding a new Product!");
                return;
            }

            // Input Id to search and delete
            searchId = getDistinctProductId();
            if (searchId != null) {
                conductDeleteProduct(searchId);
            }

            //check to go back to the main menu
            checkOption = KeyBoardIO.getQuestion(
                    "\nDo you want to go back to the main Menu?  Y/y(yes) or N/n(no)",
                    "Just input only Y/y(yes) or N/n(No)!", "y", "n"
            );
        } while (!checkOption);
    }

    public void ShowProductList() {
//        boolean checkOption;
//        do {
        //Check product list rong?
        if (productManager.isEmpty()) {
            System.err.println("Product List is empty! Please adding a new product!");
            return;
        }

        //show Product List
        System.out.println("\nHere is the product list");
        System.out.println("___________________________________________");
        String title = "| ++No++ |  ++ID++  | ++Product Name++ | ++Price++ | ++Quantity++ |";
        System.out.println(title);

        productManager.showProductList();

//            //check to go back to the main menu
//            checkOption = KeyBoardIO.getQuestion(
//                    "Do you want to go back to the main Menu?  Y/y(yes) or N/n(No)",
//                    "Just input only Y/y(yes) or N/n(No)!", "y", "n"
//            );
//        } while (!checkOption);
    }

    public void orderProduct() {
        boolean checkOption;
        do {
            //Check product list rong?
            if (productManager.isEmpty()) {
                System.err.println("Product List is empty!!!");
                return;
            }

            //Carry on 
            ShowProductList();
            System.out.println("\n");
            int rollNumberProduct = KeyBoardIO.getInteger(
                    "\nInput STT Product to order: ", "Just input STT Product in list! ",
                    1, productManager.size()
            );

            rollNumberProduct--;
            Product productCustomer = productManager.get(rollNumberProduct);

            System.out.println("\nYour selection: " + productCustomer.getProductName());

            int quantityOrder = KeyBoardIO.getInteger(
                    "Please input quantity: ",
                    "Quantity is a positive integer or not enough quantity of Product to order!",
                    0, productCustomer.getProductQuanity()
            );
            boolean choice = KeyBoardIO.getQuestion(
                    "\nDo you want to order now?  Y/y(yes) or N/n(no)",
                    "Just input Y/y(yes) or N/n(no)", "y", "n"
            );

            if (choice) {
                //xuat don
                String title = "| ++Product Name++ | ++Quantity++ | ++Price++ | ++Amount++ |";
                System.out.println(title);
                System.out.printf(
                        "|%-18s|%-14d|%-11.2f|%-12.2f|\n", productCustomer.getProductName(),
                        quantityOrder, productCustomer.getProductPrice(),
                        quantityOrder * productCustomer.getProductPrice()
                );

                String nameCustomer = KeyBoardIO.getName(
                        "\nInput your name: ",
                        "Name just contains characters and spaces"
                );

                //Cap nhat lai so luong Product Quantity:
                int quantityProduct = productCustomer.getProductQuanity() - quantityOrder;
                productCustomer.setProductQuanity(quantityProduct);
                // add Customer:
                orderList.addNewOrder(nameCustomer, productCustomer, quantityOrder);
                System.out.println("Ordering successfully!");
            } else {
                //Check product list rong?
                if (productManager.isEmpty()) {
                    System.err.println("Product List is empty! Please adding a new product!");
                    return;
                }
                //show Product List
                System.out.println("\n Ordering is canceld - Here is the product list");
                System.out.println("___________________________________________");
                String title = "| ++No++ | ++Product Name++ | ++Price++ |";
                System.out.println(title);

                productManager.showProductList();
            }

            checkOption = KeyBoardIO.getQuestion(
                    "Do you want to go back to the main Menu?  Y/y(yes) or N/n(No)",
                    "Just input only Y/y(yes) or N/n(No)!", "y", "n"
            );
        } while (!checkOption);
    }

    public void showOrderListCustomer() {
        boolean checkOption;
        do {
            //Check product list rong?
            if (orderList.isEmpty()) {
                System.err.println("Order List is empty! There is no any customer!");
                return;
            }

            //show Product List
            System.out.println("\n*Order List ");
            String title = "|   ++Product++   | ++Quantity++ | ++Price++ | ++Amount++ |";
            orderList.showOrderListCustomer(title);

            //check to go back to the main menu
            checkOption = KeyBoardIO.getQuestion(
                    "Do you want to go back to the main Menu?  Y/y(yes) or N/n(No)",
                    "Just input only Y/y(yes) or N/n(No)!", "y", "n"
            );
        } while (!checkOption);
    }
}
