/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package firwanaa;

/**
 *
 * @author QQ
 */
public enum Fields {
    /**
     * Enum Vales That used to Set Labels names
     */
    ITEM_ID("Inventory ID"),
    ITEM_NAME("Item Name"),
    QOH("Qty. On Hand"),
    ROP("Re-Order Point"),
    PRICE("Unit Price");

    /**
     * String Caption 
     */
    private String caption;
/**
 * Constructor that take a String 
 * @param caption 
 */
    private Fields(String caption) {
        this.caption = caption;
    }

    /**
     * @return the caption
     */
    public String getCaption() {
        return caption;
    }

}
