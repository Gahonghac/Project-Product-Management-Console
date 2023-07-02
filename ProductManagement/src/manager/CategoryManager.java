package manager;

import List.CategoryList;
import data.Category;
import util.KeyBoardIO;

public class CategoryManager {

    private CategoryList categoryManager = new CategoryList();

    public CategoryManager(CategoryList categoryList) {
        this.categoryManager = categoryList;
    }

    public CategoryManager() {
    }

    public void setCategoryManager(CategoryList categoryManager) {
        this.categoryManager = categoryManager;
    }

    public CategoryList getCategoryManager() {
        return categoryManager;
    }

    private String getDistinctAddId() {
        boolean choice;
        String id;
        while (true) {
            id = KeyBoardIO.getId(
                    "Input Id of Category (AA-DDDDD):  ( A: any alphabet || D: any digit ) ",
                    "Wrong Format! ", "^[A-Za-z]{2}-\\d{5}$"
            );
            if (categoryManager.searchCategoryById(id) == -1) {
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

    private void conductAddCategory(String newId) {
        String newName;
        boolean check;
        newName = KeyBoardIO.getName(
                "\nInput Name of category: ",
                "Category Name just catains characters and space!"
        );

        // Check updated option
        check = KeyBoardIO.getQuestion(
                "\nAre you sure adding this category ?   Y/y(yes) - N/n(no)",
                "Input only Y/y(yes) or N/n(no)!", "y", "n"
        );
        if (check) {
            categoryManager.addNewCategory(newId, newName);
            System.out.println("Adding successfully!\n");
            return;
        }
        System.out.println("=> Adding is canceled!\n");
    }

    public void addNewCategory() {
        boolean checkOption;
        String newId;
        //OPtion going to back to the main menu
        do {
            newId = getDistinctAddId();

            if (newId != null) {
                conductAddCategory(newId);
            }

            //check to go back to the main menu
            checkOption = KeyBoardIO.getQuestion(
                    "\nDo you want to go back to the main Menu?  Y/y(yes) or N/n(No)",
                    "Just input only Y/y(yes) or N/n(No)!", "y", "n"
            );
        } while (!checkOption);

    }

    private String getDistinctId() {
        boolean choice;
        String id;
        while (true) {
            id = KeyBoardIO.getId(
                    "\nInput Id of category (AA-DDDDD):  ( A: any alphabet || D: any digit ) ",
                    "Wrong Format! ", "^[A-Za-z]{2}-\\d{5}$"
            );
            if (categoryManager.searchCategoryById(id) != -1) {
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

    private void conductUpdateCategory(String searchId) {
        String newName;
        boolean checkOption;
        // Input updated Name
        newName = KeyBoardIO.getName(
                "\nInput Updated Name: ",
                "Category Name just catains characters and space!"
        );

        // Check updated option
        checkOption = KeyBoardIO.getQuestion(
                "\nAre you sure updating this Category ?   Y/y(yes) - N/n(no)",
                "Input only Y/y(yes) or N/n(no)!", "y", "n"
        );
        if (checkOption) {
            categoryManager.updateCategory(searchId, newName);
            System.out.println("=> Updating a new Category successfully!\n");
            return;
        }
        System.out.println("=> Updating is canceled\n");
    }

    public void updateCategory() {
        boolean checkOption;
        String searchId;

        do {
            if (this.categoryManager.isEmpty()) {
                System.err.println(
                        "The List of category is empty! Please adding a new category!"
                );
                return;
            }
            // Input Id to search
            searchId = getDistinctId();
            if (searchId != null) {
                conductUpdateCategory(searchId);
            }
            //check to go back to the main menu
            checkOption = KeyBoardIO.getQuestion(
                    "\nDo you want to go back to the main Menu? Y/y(yes) or N/n(No)",
                    "Just input only Y/y(yes) or N/n(No)!", "y", "n"
            );
        } while (!checkOption);
    }

    private void conductDeleteCategory(String searchId) {
        boolean checkOption;
        // Check to deleted option
        checkOption = KeyBoardIO.getQuestion(
                "Are you sure deleting this Category ?   Y/y(yes) - N/n(no)",
                "Input only Y/y(yes) or N/n(no)!", "y", "n"
        );
        if (checkOption) {
            categoryManager.deleteCategory(searchId);
            System.out.println("=> Deleting a Category successfully!\n");
            return;
        }

        System.out.println("=> Deleting a Category Failly!\n");

    }

    public void deleteCategory() {
        boolean checkOption;
        String searchId;
        int pos;

        do {
            if (this.categoryManager.isEmpty()) {
                System.err.println(
                        "The List of category is empty! Please adding a new Category!"
                );
                return;
            }
            // Input Id to search and delete
            searchId = getDistinctId();
            if (searchId != null) {
                conductDeleteCategory(searchId);
            }
            //check to go back to the main menu
            checkOption = KeyBoardIO.getQuestion(
                    "\nDo you want to go back to the main Menu?  Y/y(yes) or N/n(No)",
                    "Just input only Y/y(yes) or N/n(No)!", "y", "n"
            );
        } while (!checkOption);
    }

    public void showCategory() {
//        boolean checkOption;
//        do {
        //Check Category list rong?
        if (categoryManager.isEmpty()) {
            System.err.println("Category List is empty! Please adding a new category!");
            return;
        }

        //show Category List
        System.out.println("\nHere is the category list");
        System.out.println("________________________________");
        String title = "|  ++ID++  | ++Category Name++ |";
        System.out.println(title);

        categoryManager.showCategoryList();

//            //check to go back to the main menu
//            checkOption = KeyBoardIO.getQuestion(
//                    "\nDo you want to go back to the main Menu?  Y/y(yes) or N/n(No)",
//                    "Just input only Y/y(yes) or N/n(No)!", "y", "n"
//            );
//        } while (!checkOption);
    }

}
