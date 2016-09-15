package javaBeans;
import java.util.*;

public class Inventory extends ArrayList implements java.io.Serializable {
    private int inventoryID;
    private int inventoryUserID;
    private InventoryLine inventoryLine;
    private ArrayList inventoryList;
    
    public Inventory() {
        this.inventoryID = 0;
        this.inventoryUserID = 0;
        inventoryList = new ArrayList();
    }

    public Inventory(int invID, int invUserID) {
        inventoryList = new ArrayList();
        setInventoryID(invID);
        setInventoryUserID(invUserID);
    }
    
    public int getInventoryID() {
        return(inventoryID);
    }

    public final void setInventoryID(int invID) {
        inventoryID = invID;
    }

    public int getInventoryUserID() {
        return(inventoryUserID);
    }

    public final void setInventoryUserID(int invUserID) {
        inventoryUserID = invUserID;
    }
    
    public final void setInventoryLine(int indx, InventoryLine invLn) {
        this.inventoryList.add(indx, invLn);
    }
    
    public InventoryLine getInventoryLine(int indx) {
        inventoryLine = (InventoryLine) inventoryList.get(indx);
        return(inventoryLine);
    }
  
    public InventoryLine getInventoryLine(int indx, Inventory il) {
        inventoryLine = (InventoryLine) il.get(indx);
        return(inventoryLine);
    }

    public void setInventoryList(ProductList iList) {
        this.inventoryList = iList;
    }
        
    public List getInventoryList() {
        return(inventoryList);
    }
}
