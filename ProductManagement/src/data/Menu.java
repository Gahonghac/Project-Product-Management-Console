package data;

import java.util.*;
import util.KeyBoardIO;

public class Menu {

    private List<String> listMenu = new ArrayList();
    private String name;

    public Menu(String name) {
        this.name = name;
    }

    public Menu() {
    }


    public List<String> getListMenu() {
        return listMenu;
    }

    public void setListMenu(List<String> listMenu) {
        this.listMenu = listMenu;
    }

    public boolean addNewItem(String item) {
        return listMenu.add(item);
    } 

    public void showMenu() {

        if (listMenu.isEmpty()) {
            System.out.println("There is no item!");
            return;
        }

        System.out.println("__________________________________"
                + "_________________________________________________________\n");
        System.out.println(name);

        for (String option : listMenu) {
            System.out.println(option);
        }

        System.out.println("\n");

    }

    public int getOption() {
        return KeyBoardIO.getInteger("Your choice: ", "Wrong Input!\n", 1, listMenu.size());
    }

}
