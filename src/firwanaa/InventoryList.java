/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firwanaa;

import java.util.*;

/**
 *
 * @author QQ
 */
public class InventoryList {

    private ArrayList<Inventory> invList = new ArrayList<>();

    public InventoryList() {
    }

    public void add(Inventory inventory) {
        invList.add(inventory);
    }

    public Inventory get(int index) {
        return invList.get(index);
    }

    public int length() {
        return invList.size();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(Inventory i : invList){
        s.append(i.toString());
        s.append("\n");
        }
        return s.toString();
    }
}
