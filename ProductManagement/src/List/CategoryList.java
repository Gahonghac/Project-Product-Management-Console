/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package List;

import data.Category;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import util.KeyBoardIO;

/**
 *
 * @author Tien Dep Trai
 */
public class CategoryList {


    private List<Category> categoryList = new ArrayList(); //use final here
    
    public void setCategoryList(List<Category> categoryList){
        this.categoryList = categoryList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }
    
    public boolean isEmpty(){
        return this.categoryList.isEmpty();
    }
    
    public int searchCategoryById(String id) {
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getCategoryId().compareToIgnoreCase(id) == 0) { //this is very bad code -> do not use dot for too many times
                return i;
            }
        }
        return -1;
    }

    public int searchCategoryByName(String name) {
        for (int i = 0; i < this.categoryList.size(); i++) {
            if (this.categoryList.get(i).getCategoryName().compareToIgnoreCase(name) == 0) {
                return i;
            }
        }
        return -1;
    }

    public boolean addNewCategory(String id, String name ) {
        return categoryList.add(new Category(id, name));
    }

    public boolean updateCategory(String searchId, String name) {
        int pos = searchCategoryById(searchId);     
        this.categoryList.get(pos).setCategoryName(name);
        return true;
    }


    public boolean deleteCategory(String searchId) {
        int pos = searchCategoryById(searchId);
        this.categoryList.remove(pos);
        return true;       
    }
    
    public void showCategoryList(){
        for (Category category : categoryList) {
            System.out.printf(
                    "|%-10s|%-19s|\n", category.getCategoryId(),
                    category.getCategoryName()
            );           
        }
    }

    
    
    
    
}
