package mainprogram;

import util.FileIO;
import data.*;
import List.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import manager.CategoryManager;
import manager.ProductManager;
import util.KeyBoardIO;

/**
 *
 * @author Tien Dep Trai
 */
public class MainProgram {

    public static void main(String[] args) throws FileNotFoundException, ParseException {

        CategoryList categoryList = new CategoryList();
        ProductList productList = new ProductList();
        ProductManager productManager = new ProductManager();
        CategoryManager categoryManager = new CategoryManager();
        List<Product> list;
        
        //File Input       
        try {
            categoryList.setCategoryList(FileIO.readFileCategory("Category.txt"));

            //list = FileIO.readFileProduct("Product.txt");
            productList.setCategoryList(categoryList);
            productList.setProductList(FileIO.readFileProduct("Product.txt"));

            categoryManager.setCategoryManager(categoryList);
            productManager.setProductManager(productList);
        } catch (FileNotFoundException ex) {
            System.err.println("File Not Found!");
        } catch (IllegalArgumentException ex){
            ex.printStackTrace();//In loi "Tran file" >8192
        }  catch (IOException ex) {
            System.err.println("File error! Can not read!");
        } 

        //separate menu initialization to a different method
        Menu menu = new Menu("*** Welcome to Big City Product ***\n");

        menu.addNewItem("1. Add new category");
        menu.addNewItem(
                "2. Update category\n   2.1. Update category (1)\n"
                + "   2.2. Delete category (2)\n   2.3. Show category (3)"
        );
        menu.addNewItem("3. Add new product");
        menu.addNewItem(
                "4. Update product\n   4.1. Update product (1)\n"
                + "   4.2. Delete product (2)"
        );
        menu.addNewItem("5. Order product\n   5.1 Display all products(1)\n"
                + "   5.2 Order product(2)");
        menu.addNewItem("6. Show order list report");
        menu.addNewItem("7. Quiz program");

        int choice, input;

        do {
            menu.showMenu();
            choice = menu.getOption();

            switch (choice) {

                case 1:
                    categoryManager.addNewCategory();
                    break;
                case 2:
                    input = KeyBoardIO.getInteger(
                            "(1): Update category - (2): Delete category - (3)Show catgory List"
                            + "\nInput your choice: ",
                            "Just input only (1):Update or (2):Delete or (3):Show Program", 1, 3);
                    if (input == 1) {
                        categoryManager.updateCategory();
                    } else if (input == 2) {
                        categoryManager.deleteCategory();
                    } else {
                        categoryManager.showCategory();
                    }
                    break;
                case 3:
                    productManager.addNewProduct();
                    break;
                case 4:
                    input = KeyBoardIO.getInteger(
                            "(1): Update product - (2): Delete product"
                            + "Input your choice: ", "Just input only (1):Update or (2):Order",
                            1, 2);
                    if (input == 1) {
                        productManager.updateProduct();
                    } else {
                        productManager.deleteProduct();
                    }
                    break;
                case 5:
                    input = KeyBoardIO.getInteger(
                            "(1): Display all product - (2): Order product"
                            + " Input your choice: ",
                            "Just input only (1):Display or (2):Order", 1, 2
                    );
                    if (input == 1) {
                        productManager.ShowProductList();
                    } else {
                        productManager.orderProduct();
                    }
                    break;
                case 6:
                    productManager.showOrderListCustomer();
                    break;
                default:
                    System.out.println("\nThanks for your using!\n Have a nice day!");
                    //File output
                    try {
                        //Output File product 
                        String title = "Product: ID - Name - Price - Quantity - Category ID";
                        FileIO.writeFileProduct(
                                title, "Product.txt", productList.getProductList()
                        );
                        //Output File Category
                        title = "Category: ID - Name";
                        FileIO.writeFileCategory(
                                title, "Category.txt", categoryList.getCategoryList()
                        );

                    } catch (FileNotFoundException ex){
                        System.out.println("File Not Found!");
                    } catch (IOException ex) {
                        System.err.println("File Error! Can Not Write File!");
                    }
                    break;
            }

        } while (choice != 7);
    }

}
