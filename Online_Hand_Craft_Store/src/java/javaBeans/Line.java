package javaBeans;

// NOTE TO SELF: MAKE PRODUCT EXTEND CATEGORY CLASS NAME, ID, DESCRIPTION AFTER GET WORKING WITHOUT INHEIRTANCE
public class Line extends Object implements java.io.Serializable {
    
    protected int lineID1 = 0,
                lineID2 = 0,
                lineNum = 0,
                lineQuantity = 0;
    private Product lineProduct;
   
    public Line() {
        this.lineID1 = 0;
        this.lineID2 = 0;
        this.lineNum = 0;
        this.lineQuantity = 0;
        this.lineProduct = null;
    }

    public Line(int liID1, int liID2, int liNum, int liQty, Product p) {
        setLineID1(liID1);
        setLineID2(liID2);
        setLineNum(liNum);
        setLineQuantity(liQty);
        setLineProduct(p);
    }
    
    public Line(int liID1, int liID2, int liNum, int liQty) {
        setLineID1(liID1);
        setLineID2(liID2);
        setLineNum(liNum);
        setLineQuantity(liQty);
    }

    public int getLineID1() {
        return(lineID1);
    }

    public final void setLineID1(int lnID1) {
        lineID1 = lnID1;
    }

    public int getLineID2() {
        return(lineID2);
    }

    public final void setLineID2(int lnID2) {
        lineID2 = lnID2;
    }

    public int getLineNum() {
        return(lineNum);
    }

    public final void setLineNum(int lnNum) {
        lineNum = lnNum;
    }

    public int getLineQuantity() {
        return(lineQuantity);
    }

    public final void setLineQuantity(int lnQty) {
        lineQuantity = lnQty;
    }
    public Product getLineProduct() {
        return(lineProduct);
    }

    public final void setLineProduct(Product lnP) {
        lineProduct = lnP;
    }
}
