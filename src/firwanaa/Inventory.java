/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firwanaa;

/**
 * Represent a simple Inventory Management System can take,
 * validate and display user input in one string and tell the user the re-order
 * point.
 *
 * @author Alqassam Firwanaa
 */
public class Inventory {

    private String id = "ABC-1234";
    private String name = "New Item";
    private int qoh = 0;
    private int rop = 25;
    private double sellPrice = 0;

    /**
     * *
     * Constructor - No args.
     */
    public Inventory() {
    }

    /**
     * *
     * Constructor with params that can assign id, name and sellPrice to an object.
     *
     * @param id Item id
     * @param name Name
     * @param sellPrice Sell Price
     */
    public Inventory(String id, String name, double sellPrice) {
        setId(id);
        setName(name);
        setSellPrice(sellPrice);
    }

    /**
     * *
     *  Accessor method for id.
     *  @return id value.
     */
    public String getId() {
        return id;
    }

    /**
     * *
     * Mutator method for id that validate and store id in upper case form.
     * @param id Id Value.
     * @throws IllegalArgumentException if user input contain invalid values.
     */
    public void setId(String id) {
        if (id.matches("[a-zA-Z]{3}-[0-9]{4}")) {
            this.id = id.toUpperCase();
        } else {
            throw new IllegalArgumentException("Inventory ID must be in the "
                    + "form of ABC-1234");
        }
    }

    /**
     * Accessor method for name.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Mutator method for name.
     *
     * @param name name.
     * @throws IllegalArgumentException if user input contain invalid values.
     */
     public void setName(String name) {
        if (!name.trim().isEmpty()){
            this.name = name;
        }else {
            throw new IllegalArgumentException("Inventory name can not be empty value or spaces");
        }
    }

    /**
     * Accessor method for Quantity on hand.
     *
     * @return Quantity on hand value.
     */
    public int getQoh() {
        return qoh;
    }

    /**
     * Mutator method for Quantity on hand.
     *
     * @param qoh Quantity on hand.
     * @throws IllegalArgumentException if user input contain invalid values.
     */
    public void setQoh(int qoh) {
        if (qoh >= 0) {
            this.qoh = qoh;
        } else {
            throw new IllegalArgumentException("Invalid Quantity On Hand, it must be 0 or more");
        }

    }

    /**
     * Accessor method for Re-Order Point.
     *
     * @return Re-Order Point value.
     */
    public int getRop() {
        return rop;
    }

    /**
     * Mutator method for Re-Order Point.
     *
     * @param rop Re-Order Point.
     * @throws IllegalArgumentException if user input contain invalid values.
     */
    public void setRop(int rop) {
        if (rop > 0) {
            this.rop = rop;
        } 
        else {
            throw new IllegalArgumentException("Invalid Re-Order Point, it must be more than 0");
        }
    }

    /**
     * Accessor method for Sell Price
     *
     * @return sellPrice
     */
    public double getSellPrice() {
        return sellPrice;
    }

    /**
     * Mutator method for Sell Price.
     *
     * @param sellPrice Sell Price.
     * @throws IllegalArgumentException if user input contain invalid values.
     */
    public void setSellPrice(double sellPrice) {
        if (sellPrice >= 0) {
            this.sellPrice = sellPrice;
        } else {
            throw new IllegalArgumentException("Invalid Price, can not be negative value");
        }
    }

    /**
     * toString method to convert user input to one string,
     * and tell the user when needed to re-order items.
     *
     * @return a string contain user input.
     */
    @Override
    public String toString() {
        if (name.length() > 25) {
            name = name.substring(0, 17) + "...";
        }
        return id + " (" + name + ")" + ", QOH: " + qoh + ",Price: " + "$" +  sellPrice;
    }

}
