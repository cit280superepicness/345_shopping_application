package javaBeans;

public class InventoryLine extends Line {
    
    private int inventoryLineInventoryID, 
            inventoryLineProductID,
            inventoryLineNum,
            inventoryLineQuantity;
    
    public InventoryLine() {
        this.inventoryLineInventoryID = 0;
        this.inventoryLineProductID = 0;
        this.inventoryLineNum = 0;
        this.inventoryLineQuantity = 0;
    }
    
    public InventoryLine(int invLineInvID, int invLineProdID, int invLineNum,
            int invLineQty) {
        
        super.setLineID1(invLineInvID);
        super.setLineID2(invLineProdID);
        setInventoryLineNum(invLineNum);
        super.setLineQuantity(invLineQty);
        
    }
    
    public int getInventoryLineInventoryID() {
        return super.getLineID1();
    }
    
    public int getInventoryLineProductID() {
        return super.getLineID2();
    }
    
    public final void setInventoryLineNum(int invLiNum) {
        this.inventoryLineNum = invLiNum;
    }
    
    public int getInventoryLineQuantity() {
        return super.getLineQuantity();
    }

    public int getInventoryLineNum() {
        return(inventoryLineNum);
    }
}
